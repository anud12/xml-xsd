import * as jsdom from "jsdom";

export type JsonNode<A extends string> = {
  _serialize?: () => string,
  _getTagName?: () => string;
  _addSibling?: (body: string, attributes?: { [P in A as `${P}`]?: string }) => void,
} & {
  [P in A as `$${P}`]?: string
}

export type JsonQueryType<
  A extends string = string,
  B extends Record<string, JsonNode<string> | JsonQueryType<any, any>> | JsonNode<string> = JsonNode<string>
> = JsonNode<A> & {
  getChildren?: () => Array<B[keyof B]>;
  _all?: Array<JsonQueryType<A, B>>
} & {
  [P in keyof B]?: B[P];
}

const customInspectSymbol = Symbol.for('nodejs.util.inspect.custom');

export const newJsonQuery = <T>(
  root: jsdom.JSDOM,
  element: Element | undefined = root.window.document.documentElement,
): T => {
  return new Proxy({}, {
    set(target: {}, p: string | symbol, newValue: any, receiver: any): boolean {
      if (typeof p !== "string") {
        return false;
      }
      if (p.startsWith("$")) {
        element.setAttribute(p.replace("$", ""), newValue);
        return true;
      }
      let child = element.querySelector(p);
      if (!child) {
        child = root.window.document.createElementNS("",p);
        [...child.getAttributeNames()].map(e => child.setAttribute(e, ""))
        element.appendChild(child)
      }
      child.innerHTML = newValue;
      return true;
    },
    get(_: {}, p: string | symbol, __: any): any {
      if (p === customInspectSymbol || p === "toString" || p === "valueOf" || p === "inspect") {
        return () => {
          let cloneElement = element.cloneNode(true);
          [...cloneElement.childNodes]
            .filter(e => e.parentElement === cloneElement)
            .filter(e => e.nodeType !== element.TEXT_NODE)
            .map((element: ChildNode) => {
              cloneElement.removeChild(element)
            })
          return cloneElement.textContent;
        }
      }
      if (typeof p !== "string") {
        return (element?.textContent ?? "")?.[p];
      }

      const functions: keyof JsonQueryType = p as any;

      if (functions === "_serialize") {
        return () => element?.outerHTML
      }
      if (functions === "_addSibling") {
        return (body: string, attributes: Record<string, string>) => {
          const child = root.window.document.createElementNS("",element.tagName);
          element.parentElement.appendChild(child)
          child.textContent = body;
          Object.entries(attributes ?? {}).forEach(([key, value]) => child.setAttribute(key, value))
        }
      }

      if (functions === "getChildren") {
        return () => [...(element?.children ?? [])].map(element => newJsonQuery(root, element ?? null))
      }
      if (functions === "_getTagName") {
        return () => element?.tagName
      }
      if (functions === "_all") {
        const elementList = element?.parentElement.querySelectorAll(element.tagName)
        return [...elementList].map(element => newJsonQuery(root, element ?? null));
      }
      if (p.startsWith("$")) {
        return element.getAttribute(p.replace("$", ""))
      }
      try {
        const childElement = element?.querySelector(p as string) ?? undefined
        return newJsonQuery(root, childElement ?? null);
      } catch (e) {
        return newJsonQuery(root, null);
      }

    },

  }) as T
}