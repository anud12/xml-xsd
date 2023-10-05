import * as jsdom from "jsdom";

export type JsonNode<A extends string | never = string> = {
  getBody: () => string,
  setBody: (string: string) => void;
  serialize: () => string,
  getAttribute: (attr: A) => string,
  setAttribute: (key: A, value: string) => void;
}

export type JsonQueryType<
  A extends string | never,
  B extends Record<string, string | JsonQueryType<any, any>> | never = never,
> = JsonNode<A> & {
  query: <U extends keyof B>(key: U) => B[U] extends string ? JsonNode : B[U] | undefined,
  queryAll: <U extends keyof B>(key: U) => Array<B[U]>,
  children: () => Array<B[keyof B]>
}


export class JSONQuery<
  A extends string | never,
  B extends Record<string, string | JsonQueryType<any, any>> | never
> implements JsonQueryType<A, B> {
  constructor(
    private root: jsdom.JSDOM,
    private element: Element = root.window.document.documentElement) {
  }


  private mapElement = <R>(element: Element): R | undefined => {
    if (!element) {
      return undefined;
    }
    return new JSONQuery(this.root, element) as R;
  }

  queryAll = <U extends keyof B>(key: U): Array<B[U]> => {
    const elementList = this.element.querySelectorAll(key as string)
    return [...elementList].map(element => this.mapElement<B[U]>(element));
  }

  query = <U extends keyof B>(key: U): B[U] extends string ? JsonNode : B[U] | undefined => {
    const element = this.element.querySelector(key as string);
    return this.mapElement<B[U] extends string ? JsonNode : B[U] | undefined>(element);
  }

  children = () => {
    const elementList = this.element.children
    return [...elementList].map(element => this.mapElement<B[keyof B]>(element));
  };

  getAttribute = (attr: A): string => {
    return this.element.getAttribute(attr);
  }

  serialize = () => this.element.outerHTML;

  getBody(): string {
    return this.element.textContent;
  }

  setAttribute(key: A, value: string): void {
    this.element.setAttribute(key, value)
  }

  setBody(string: string): void {
    this.element.textContent = string;
  }
}
