import {JsonSchema} from "./JsonSchema";
import {JsonUtil} from "./index";

export type Middleware = (writeJson: JsonUtil) => (writeJson: JsonSchema) => Promise<void>

export type Attribute<T> = {
  $?: Partial<Record<keyof T, string>>,
}
export type Body<T> = {
  [P in keyof T]?: Array<T[P] | undefined>
}
