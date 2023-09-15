import {JsonSchema} from "./JsonSchema";

export type Middleware = (readJson: JsonSchema, writeJson: JsonSchema) => Promise<void>

export type Attribute<T> = {
  $?: Partial<Record<keyof T, string>>,
}
export type Body<T> = {
  [P in keyof T]?: Array<T[P] | undefined>
}
