import * as jsdom from "jsdom";

export type JsonNode<A extends string | never = string> = {
  getBody: () => string,
  setBody: (string: string) => void;
  serialize: () => string,
  getAttribute: (attr: A) => string,
  setAttribute: (key: A, value: string) => void;
  getTagName: () => string;
}

export type JsonQueryType<
  A extends string | never = never,
  B extends Record<string, JsonNode | JsonQueryType<any, any>> | JsonNode = JsonNode
> = JsonNode<A> & {
  getChildren: () => Array<B[keyof B]>;
  _all: Array<B>
} & {
  [P in keyof B]: B[P];
}


export const newJsonQuery = <T>(
  root: jsdom.JSDOM,
  element: Element | undefined = root.window.document.documentElement,
): T => {
  return new Proxy({}, {
    get(_: {}, p: string | symbol, __: any): any {

      if (p === "getBody") {
        return () => element?.textContent;
      }
      if (p === "setBody") {
        return (string: string) => {
          if (!element) {
            return
          }
          element.textContent = string
        };
      }
      if (p === "serialize") {
        return () => element?.outerHTML
      }
      if (p === "getAttribute") {
        return (key: string) => element?.getAttribute(key)
      }
      if (p === "setAttribute") {
        return (key: string, value: string) => element?.setAttribute(key, value)
      }

      if (p === "getChildren") {
        return () => [...(element?.children ?? [])].map(element => newJsonQuery(root, element ?? null))
      }
      if (p === "getTagName") {
        return () => element?.tagName
      }
      if (p === "_all") {
        const elementList = element?.parentElement.querySelectorAll(element.tagName)
        return [...elementList].map(element => newJsonQuery(root, element ?? null));
      }
      const childElement = element?.querySelector(p as string) ?? undefined
      return newJsonQuery(root, childElement ?? null);
    },

  }) as T
}