const attributes = Symbol("atributes")
const children = Symbol("children");

export type JsonQueryChildren<T extends Record<string, JsonQueryType<any, any, any>>> = {
  [P in keyof T]: P extends string
    ? T[P] extends JsonQueryType<infer A, infer B, infer _>
      ? JsonQueryType<A, B, P>
      : never
    : never
}

export type JsonQueryType<
  Attribute extends Partial<Record<string, any>> = Record<string, string>,
  Children extends Record<string, JsonQueryType<any, any, any>> = any,
  Tag extends any | never = never,
> = {
  tag: Tag,
  body?: string,
  attributeMap: Attribute,
  children: Children,
  childrenList: Array<JsonQueryChildren<Children>[keyof JsonQueryChildren<Children>]>,
  setAttribute: <T extends keyof Attribute>(name: T, value: Attribute[T] | ((value: Attribute[T]) => Attribute[T])) => JsonQueryType<Attribute, Children, Tag>,
  query: <P extends keyof Children> (p: P) => Children[P],
  queryOptional: <P extends keyof Children> (p: P) => Children[P] | undefined,
  queryAll: <P extends keyof Children> (p: P) => Array<Children[P]>,
  queryAllOptional: <P extends keyof Children> (p: P) => Array<Children[P]>,
  queryAllRecursiveWithAttributeFrom: <
    P extends JsonQueryType<any>,
  >(attribute: keyof P["attributeMap"]) => Array<P>,
  appendChild: <U extends keyof Children>(key: U, element?: string, attributes?: Partial<Children[U]["attributeMap"]>) => Children[U]
  removeFromParent: () => void,
  getPath: () => string,
  serializeRaw: () => string,
  serialize: () => string
}

export type JsonQueryTypeList<
  Elements extends JsonQueryType<Attribute, Children, Tag>,
  Attribute extends Record<string, any> = any,
  Children extends Record<string, JsonQueryType<any, any, any>> = any,
  Tag extends any | never = any
> = {
  elements: Elements,
  query: <P extends keyof Children> (p: P) => Children[P],
  queryOptional: <P extends keyof Children> (p: P) => Children[P] | undefined,
  queryAll: <P extends keyof Children> (p: P) => Array<Children[P]>,
  queryAllOptional: <P extends keyof Children> (p: P) => Array<Children[P]>,
  queryAllRecursiveWithAttributeFrom: <P extends JsonQueryType<any, any>>(attribute: keyof Attribute) => Array<P>,
}