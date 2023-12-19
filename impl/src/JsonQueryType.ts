const attributes = Symbol("atributes")
const children = Symbol("children");

type JsonQueryChildren<T extends Record<string, JsonQueryType<any, any, any>>> = {
  [P in keyof T]: P extends string
    ? T[P] extends JsonQueryType<infer A, infer B, infer _>
      ? JsonQueryType<A, B, P>
      : never
    : never
}

export type JsonQueryType<
  Attribute extends Partial<Record<string, any>> = never,
  Children extends Record<string, JsonQueryType<any, any, any>> = any,
  Tag extends any | never = never,
> = {
  tag: Tag,
  body?: string,
  attributeMap: Attribute,
  getAttribute: <T extends keyof Attribute>(name: T) => Attribute[T],
  setAttribute: <T extends keyof Attribute>(name: T, value: Attribute[T] | ((value: Attribute[T]) => Attribute[T])) => JsonQueryType<Attribute, Children, Tag>,
  children: Children,
  query: <P extends keyof Children> (p: P) => Children[P],
  queryOptional: <P extends keyof Children> (p: P) => Children[P] | undefined,
  queryAll: <P extends keyof Children> (p: P) => Array<Children[P]>,
  queryAllOptional: <P extends keyof Children> (p: P) => Array<Children[P]>,
  queryAllRecursiveWithAttributeFrom: <
    P extends JsonQueryType<any>,
  >(attribute: keyof P["attributeMap"]) => Array<P>,
  childrenList: Array<JsonQueryChildren<Children>[keyof JsonQueryChildren<Children>]>,
    appendChild: <U extends keyof Children>(key: U, element: string | Children[U]["children"][number], attributes?: Children[U]["attributeMap"]) => Children[U]
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

export type OperationQueryType = JsonQueryType<{}, {
  add_property_value: JsonQueryType<{ property_ref: string }>,
  add: JsonQueryType<{ value: string }>,
  add_dice: JsonQueryType<{ value: string }>,
  multiply_dice: JsonQueryType<{ value: string }>,
  multiply: JsonQueryType<{ value: string }>,
  divide_dice: JsonQueryType<{ value: string }>,
  divide: JsonQueryType<{ value: string }>,
  modulo_dice: JsonQueryType<{ value: string }>,
  modulo: JsonQueryType<{ value: string }>,
}> & {
  group: OperationQueryType,
}

type Schema = JsonQueryType<never, {
  person_to_person: JsonQueryType<{ name: string }, {
    max_range: JsonQueryType<never, {
      operation: OperationQueryType,
    }>,
    min_range: JsonQueryType<never, {
      operation: OperationQueryType,
    }>,
    test: JsonQueryType<never, {
      value: JsonQueryType<{ target: string }, {
        operation: OperationQueryType,
      }>,
      expected: JsonQueryType<{ target: string }, {
        operation: OperationQueryType,
      }>
    }>,
    property_mutation: JsonQueryType<{ property_ref: string, on: string }, {
      from: JsonQueryType<{ participant: string }, {
        operation: OperationQueryType
      }>
    }>
  }>
}>

const schema: Schema = {} as any;


schema.query("person_to_person")
  .setAttribute("name", "")
  .query("max_range")
  .query("operation")
  .childrenList.map(value => {
  value.tag === "divide"
})