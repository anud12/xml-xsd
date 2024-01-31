import * as jsdom from "jsdom";
import {JsonQueryChildren, JsonQueryType} from "./JsonQueryType";

const prettier = require("prettier")

const CommentJsonTag = "CommentJsonTag"
const UnknownJsonTag = "UnknownJsonTag"

const innerSerialize = (dom: jsdom.JSDOM, query: JsonQueryType<Record<string, any>, any, string>): Element | Comment | undefined => {
  try {
    if (query.tag === CommentJsonTag) {
      const element = dom.window.document.createElementNS("", "COMMENT_TO_BE_REPLACED");
      element.innerHTML = query.body ?? ""
      return element;
    }
    if (query.tag === UnknownJsonTag) {
      return undefined
    }
    const rootElement = dom.window.document.createElementNS("", query.tag);
    Object.entries(query.attributeMap).forEach(([key, value]) => {
      const attributeKey = key.replace(":", "__namespace__");
      rootElement.setAttribute(attributeKey, value)
    })
    rootElement.innerHTML += query.body ?? "";
    query.childrenList
      .map(value => innerSerialize(dom, value))
      .filter(value => value)
      .forEach(value => {
        rootElement.appendChild(value);
      })
    rootElement.outerHTML;
    return rootElement
  } catch (e: any) {
    const newError = new Error(`serialize failed for ${query.getPath()}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }
}


// @ts-ignore TS2420
export class JsonQuery<A extends JsonQueryType<Attribute, Children, Tag>,
  Attribute extends Record<string, any> = Record<string, any>,
  Children extends Record<string, JsonQueryType<any, any, any>> = any,
  Tag extends any | never = any,
> implements A {
  static fromText = <A>(file: string): A => {
    let documentList: NodeListOf<ChildNode>;
    let root;
    if (global.window) {
      const parser = new DOMParser();
      const document = parser.parseFromString(file, "application/xml")
      root = global
      documentList = document.childNodes
    }
    if (!global.window) {
      root = new jsdom.JSDOM(file, {
        contentType: "text/xml",
      })
      documentList = root.window.document.childNodes;
    }


    return new JsonQuery(root, documentList[0], undefined) as unknown as A
  }
  static canCreate = (childNode: ChildNode) => {
    if (childNode.nodeType === childNode.COMMENT_NODE) {
      return true;
    }
    if (childNode.nodeType === childNode.ELEMENT_NODE) {
      return true;
    }
    return false
  }

  tag: any;
  body: string;
  attributeMap: Attribute;
  childrenList: Array<JsonQueryChildren<Children>[keyof JsonQueryChildren<Children>]>;
  children: any;
  parent?: JsonQuery<any>;

  constructor(private root: jsdom.JSDOM, element: Node, parent: JsonQuery<any> | undefined) {
    this.childrenList = []
    this.attributeMap = {} as Attribute;
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
    const index = this.parent.childrenList.filter(e => e.tag === this.tag).findIndex(e => e === this as any);
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
    this.childrenList = children as any;
    [...element.getAttributeNames()].forEach((currentValue) => {
      (this.attributeMap as any)[currentValue] = element.getAttribute(currentValue)
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

  getAttribute = <T extends keyof Attribute>(name: T): Attribute[T] => {
    return this.attributeMap[name];
  }
  setAttribute = <T extends keyof Attribute>(name: T, value: Attribute[T] | ((value: Attribute[T]) => Attribute[T])): JsonQueryType<Attribute, Children, Tag> => {
    if (typeof value === "function") {
      const valueFunc = value as unknown as ((value: Attribute[T]) => Attribute[T]);
      this.attributeMap[name] = valueFunc(this.attributeMap[name]);
      return this as unknown as JsonQueryType<Attribute, Children, Tag>;
    }
    this.attributeMap[name] = value;
    return this as unknown as JsonQueryType<Attribute, Children, Tag>;
  }

  appendChild = (key: any, body?: string, attributesArg?: Attribute): any => {
    if (key === UnknownJsonTag) {
      return;
    }
    let attributes = attributesArg || {};

    let element = key === CommentJsonTag
      ? this.root.window.document.createComment("") as unknown as Element
      : this.root.window.document.createElementNS("", key);

    element.textContent = body;

    Object.entries(attributes).forEach(([key, value]: [string, string]) => {
      element.setAttribute(key.replace("", ""), value);
    })
    const jsonQuery = new JsonQuery(this.root, element, this);
    this.childrenList.push(jsonQuery as any);
    return jsonQuery;
  }

  queryAllOptional = <P extends any>(p: P): any[] => {
    return this.childrenList.filter(e => e.tag === p);
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
    } catch (e: any) {
      return undefined;
    }
  }

  queryAllRecursiveWithAttributeFrom = (attribute: string | number | symbol): any[] => {
    const childrenResult = this.childrenList
      .map(e => e.queryAllRecursiveWithAttributeFrom(attribute))
      .flat();
    const result = this.childrenList.filter(e => e.attributeMap[`${String(attribute)}`] !== undefined);
    return [...result, ...childrenResult];
  }

  removeFromParent = () => {
    if (!this.parent) {
      return;
    }
    this.parent.childrenList = this.parent.childrenList.filter(e => e !== this as any);
  }

  serializeRaw = () => {
    const element = innerSerialize(this.root, this as unknown as JsonQueryType) as Element
    return element.outerHTML.replaceAll("__namespace__", ":")
      .replaceAll("<COMMENT_TO_BE_REPLACED>", "<!--")
      .replaceAll("</COMMENT_TO_BE_REPLACED>", "-->")
      .replaceAll("<COMMENT_TO_BE_REPLACED\>", "")
      .split(";")[0] + "\n";
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