import * as jsdom from "jsdom";

const prettier = require("prettier")

const CommentJsonTag = "CommentJsonTag"
const UnknownJsonTag = "UnknownJsonTag"

export type JsonNodeTag<U = string> = U | typeof CommentJsonTag | typeof UnknownJsonTag
export type JsonNode = {
  body: string
  tag: JsonNodeTag
}

export type InferJsonNodeBody<T> = T extends JsonQueryType<infer A, infer B>
  ? { [P in keyof B]: InferJsonNodeBody<B[P]> & JsonNodeAttribute<A> }
  : never;
export type InferJsonNodeAttribute<T> = T extends JsonQueryType<infer A> ? JsonNodeAttribute<A> : never;

export type JsonElement<A extends string> = JsonNode & JsonNodeAttribute<A>

export type JsonNodeAttribute<A extends string> = {
  [P in A as `$${P}`]?: string
}
export const nodeBodyType = Symbol()
export const nodeAttributes = Symbol()
export type JsonQueryType<
  A extends string = never,
  B extends Record<string, JsonQueryType<string, any>> = never
> = JsonElement<A>
  & {
  children: Array<B[keyof B]>;
  appendChild: <U extends keyof B>(key: U, element: string | B[U][typeof nodeAttributes], attributes?: B[U][typeof nodeAttributes]) => B[U]
  query: <P extends keyof B> (p: P) => B[P],
  queryOptional: <P extends keyof B> (p: P) => B[P] | undefined,
  queryAll: <P extends keyof B> (p: P) => Array<B[P]>
  queryAllOptional: <P extends keyof B> (p: P) => Array<B[P]>
  removeFromParent: () => void,
  getPath: () => string,
  serialize: () => string
} & {
  [nodeBodyType]: {
    [P in keyof B]: B[P] extends JsonQueryType<any, any> ? B[P] : never
  }
}
  & {
  [nodeAttributes]: {
    [P in A as `$${P}`]?: string
  }
}

const innerSerialize = (dom: jsdom.JSDOM, query: JsonQueryType<any, any>): Element | Comment | undefined => {
  if (query.tag === CommentJsonTag) {
    const element = dom.window.document.createElementNS("", "COMMENT_TO_BE_REPLACED");
    element.innerHTML = query.body ?? ""
    return element;
  }
  if (query.tag === UnknownJsonTag) {
    return undefined
  }
  const rootElement = dom.window.document.createElementNS("", query.tag);
  Object.keys(query).forEach((key) => {
    if (key?.startsWith("$")) {
      const attributeKey = key.replace("$", "").replace(":", "__namespace__");
      rootElement.setAttribute(attributeKey, query[key])
    }
  })
  rootElement.innerHTML += query.body ?? "";
  query.children
    .map(value => innerSerialize(dom, value))
    .filter(value => value)
    .forEach(value => {
      rootElement.appendChild(value);
    })
  return rootElement
}

// @ts-ignore TS2420
export class JsonQuery<A extends JsonQueryType> implements A {
  static fromText = <A>(file: string): A => {
    const root = new jsdom.JSDOM(file, {
      contentType: "text/xml",
    })
    const d = root.window.document.childNodes;
    return new JsonQuery(root, d[0], undefined) as unknown as A
  }
  static canCreate = (childNode:ChildNode) => {
    if (childNode.nodeType === childNode.COMMENT_NODE) {
      return true;
    }
    if (childNode.nodeType === childNode.ELEMENT_NODE) {
      return true;
    }
    return false
  }
  [nodeBodyType]: never;
  [nodeAttributes]: never;

  body: string;
  children: any;
  tag: JsonNodeTag;
  parent?: JsonQuery<any>;

  constructor(private root: jsdom.JSDOM, element: Node, parent: JsonQuery<any> | undefined) {
    this.children = []
    this.parent = parent;
    this.tag = UnknownJsonTag;

    if (element.nodeType === element.ELEMENT_NODE) {
      this.initElement(root, element as Element)
      return;
    }
    if (element.nodeType === element.COMMENT_NODE) {
      this.tag = CommentJsonTag;
      this.body = element.nodeValue;
      return;
    }
    throw new Error(`failed to create JSONQuery unknown nodeType ${element.nodeType}`);
  }

  private getPath() {
    if (!this.parent) {
      return "/"
    }
    const index = this.parent.children.filter(e => e.tag === this.tag).findIndex(e => e === this);
    return `${this.parent.getPath()}/${this.tag}[${index}]`
  }

  private initElement(root: jsdom.JSDOM, element: Element) {
    this.tag = element.tagName;
    const children = [...element.childNodes ?? []]
      .filter(childNode => JsonQuery.canCreate(childNode))
      .map((childNode) => {
      const childElement: Element = childNode as any;
      const jsonQuery = new JsonQuery(root, childElement, this);
      return jsonQuery;
    })
      .filter(e => e)
      .filter(e => e.tag !== UnknownJsonTag);
    this.children = children as any;
    [...element.getAttributeNames()].forEach((currentValue) => {
      this[`$${currentValue}`] = element.getAttribute(currentValue)
    })

    let cloneElement = element.cloneNode(true);
    [...cloneElement.childNodes]
      .filter(e => e.parentElement === cloneElement)
      .filter(e => e.nodeType !== element.TEXT_NODE)
      .map((element: ChildNode) => {
        cloneElement.removeChild(element)
      })
    this.body = cloneElement.textContent.trim();
  }

  appendChild = (key: any, body: string | JsonNodeAttribute<string>, attributesArg?: JsonNodeAttribute<string>): any => {
    if (key === UnknownJsonTag) {
      return;
    }
    let attributes = attributesArg;

    let element = key === CommentJsonTag
      ? this.root.window.document.createComment("") as unknown as Element
      : this.root.window.document.createElementNS("", key);

    if (typeof body !== "string") {
      attributes = body;
    } else {
      element.textContent = body;
    }
    Object.entries(attributes).forEach(([key, value]) => {
      element.setAttribute(key.replace("$", ""), value);
    })
    const jsonQuery = new JsonQuery(this.root, element, this);
    this.children.push(jsonQuery);
    return jsonQuery;
  }

  queryAllOptional = <P extends any>(p: P): any[] => {
    return this.children.filter(e => e.tag === p);
  }

  queryAll = <P extends any>(p: P): any[] => {
    const result = this.queryAllOptional(p);
    if (result.length !== 0) {
      return result;
    }
    throw new Error(`query '${this.getPath()}/${p}' returned undefined`)
  }

  query = <P extends any>(p: P): any => {
    return this.queryAll(p)?.[0];
  }
  queryOptional = <P extends any>(p: P): any => {
    try {
      return this.queryAll(p)?.[0];
    } catch (e) {
      return undefined;
    }
  }

  removeFromParent = () => {
    if (!this.parent) {
      return;
    }
    this.parent.children = this.parent.children.filter(e => e !== this);
  }

  serialize = () => {
    const element = innerSerialize(this.root, this as unknown as JsonQueryType) as Element
    const result: string = prettier.format(element.outerHTML, {
      parser: "babel",
    })
    return result.replaceAll("__namespace__", ":")
      .replaceAll("<COMMENT_TO_BE_REPLACED>", "<!--")
      .replaceAll("</COMMENT_TO_BE_REPLACED>", "-->")
      .replaceAll("<COMMENT_TO_BE_REPLACED\>", "")
      .split(";")[0] + "\n";
  }
}