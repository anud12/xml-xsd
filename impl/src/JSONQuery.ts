import * as jsdom from "jsdom";

const prettier = require("prettier");

export const nodeToString = Symbol("nodeToString");
export const nodeType = Symbol("nodeType");
export const nodeAddSibling = Symbol("nodeAddSibling")
export const nodeAddChild = Symbol("nodeAddChild")
export type JsonNode = {
  body: string
  tag: string
}

export type JsonElement<A extends string> = JsonNode & JsonNodeAttribute<A> & {
}

export type JsonNodeAttribute<A extends string> = {
  [P in A as `$${P}`]?: JsonNode
}

export type JsonQueryType<
  A extends string = string,
  B extends Record<string, JsonElement<string> | JsonQueryType<string, any>> = Record<string, JsonQueryType<string, any>>
> = JsonElement<A> & {
  children: Array<B[keyof B]>;
  [nodeAddChild]: (key: keyof B, element: string | JsonNodeAttribute<A>, attributes: JsonNodeAttribute<A>) => void
  query: <P extends keyof B> (p: P) => B[P] | undefined
  queryAll: <P extends keyof B> (p: P) => Array<B[P]>
}

const innerSerialize = (dom: jsdom.JSDOM, query: JsonQueryType<any, any>): Element => {
  const rootElement = dom.window.document.createElementNS("", query.tag);
  Object.keys(query).forEach((key) => {
    if (key?.startsWith("$")) {
      const attributeKey = key.replace("$", "").replace(":", "__namespace__");
      rootElement.setAttribute(attributeKey, query[key])
    }
  })
  rootElement.innerHTML += query.body ?? "";
  query.children.forEach(value => {
    rootElement.appendChild(innerSerialize(dom, value));
  })
  return rootElement
}
export const serialize = (dom: jsdom.JSDOM, query: JsonQueryType<any, any>): string => {
  return prettier.format(innerSerialize(dom, query).outerHTML, {
    parser: "babel"
  }).replaceAll("__namespace__", ":").split(";")[0] + "\n";
}


export const newJsonQuery = <T extends JsonQueryType>(
  root: jsdom.JSDOM,
  element: Element | undefined = root.window.document.querySelector("*"),
): T => {
  const tagName = element.tagName;

  const children = [...element.children ?? []].map((e) => {
    const jsonQuery = newJsonQuery(root, e);
    jsonQuery.children = [...e.children].map(value => newJsonQuery(root, value))
    return jsonQuery;
  })

  const attributes = [...element.getAttributeNames()].reduce((previousValue, currentValue) => ({
    ...previousValue,
    [`$${currentValue}`]: element.getAttribute(currentValue)
  }), {})

  let cloneElement = element.cloneNode(true);
  [...cloneElement.childNodes]
    .filter(e => e.parentElement === cloneElement)
    .filter(e => e.nodeType !== element.TEXT_NODE)
    .map((element: ChildNode) => {
      cloneElement.removeChild(element)
    })
  const textContent = cloneElement.textContent.trim();

  return {
    ...attributes,
    children,
    queryAll(key: string) {
      return this.children.filter(e => e.type === key)
    },
    query(key: string) {
      return this.queryAll(key)?.[0]
    },
    value: textContent,
    type: tagName,
    [nodeAddSibling](body, attributes) {
      parent?.[nodeAddChild]?.(this.type, body, attributes)
    },
    [nodeAddChild](key, body, attributes) {
      let node;

      if (typeof body !== "string") {
        node = {
          ...body,
          type: key,
          value: "",
          children: [],
        };
      } else {
        node = {
          ...attributes,
          type: key,
          value: body,
          children: [],
        }
      }
      this.children.push(node);
    },
  } as unknown as T;

  // return new Proxy(Object.assign(object, {
  //   ...children,
  //   ...attributes,
  // }), {
  //   set: (target: {}, p: string | symbol, newValue: any, receiver: any): boolean => {
  //     if (typeof p !== "string") {
  //       return false;
  //     }
  //     if (p.startsWith("$")) {
  //       element.setAttribute(p.replace("$", ""), newValue);
  //       return true;
  //     }
  //     let child = element.querySelector(p);
  //     if (!child) {
  //       child = root.window.document.createElementNS("", p);
  //       [...child.getAttributeNames()].map(e => child.setAttribute(e, ""))
  //       element.appendChild(child)
  //     }
  //     child.innerHTML = newValue;
  //     return true;
  //   },
  //   get: (_: {}, p: string | symbol, __: any): any => {
  //
  //     if (p === customInspectSymbol || p === "toString" || p === "valueOf" || p === "inspect") {
  //       return () => {
  //         let cloneElement = element.cloneNode(true);
  //         [...cloneElement.childNodes]
  //           .filter(e => e.parentElement === cloneElement)
  //           .filter(e => e.nodeType !== element.TEXT_NODE)
  //           .map((element: ChildNode) => {
  //             cloneElement.removeChild(element)
  //           })
  //         return cloneElement.textContent;
  //       }
  //     }
  //     if (typeof p !== "string") {
  //       return (element?.textContent ?? "")?.[p];
  //     }
  //
  //     const functions: keyof JsonQueryType = p as any;
  //
  //     if (functions === "_serialize") {
  //       return () => element?.outerHTML
  //     }
  //     if (functions === "_addSibling") {
  //       return (body: string | JsonNodeAttribute<string>, attributes: JsonNodeAttribute<string>) => {
  //         const child = root.window.document.createElementNS("", element.tagName);
  //         element.parentElement.appendChild(child)
  //         if (typeof body === "string") {
  //           child.textContent = body;
  //           Object.entries(attributes ?? {}).forEach(([key, value]) => child.setAttribute(key.replace("$", ""), value))
  //           return
  //         }
  //         Object.entries(body ?? {}).forEach(([key, value]) => child.setAttribute(key.replace("$", ""), value));
  //       }
  //     }
  //
  //     if (functions === "getChildren") {
  //       return () => [...(element?.children ?? [])].map(element => newJsonQuery(root, element ?? null))
  //     }
  //     if (functions === "_getTagName") {
  //       return () => element?.tagName
  //     }
  //     if (functions === "_all") {
  //       const elementList = element?.parentElement.querySelectorAll(element.tagName);
  //       return [...(elementList ?? [])].map(element => newJsonQuery(root, element ?? null));
  //     }
  //     if (p.startsWith("$")) {
  //       return element.getAttribute(p.replace("$", ""))
  //     }
  //     try {
  //       const childElement = element?.querySelector(p as string) ?? undefined
  //       return newJsonQuery(root, childElement ?? null);
  //     } catch (e) {
  //       return newJsonQuery(root, null);
  //     }
  //
  //   },
  //
  // }) as T
}