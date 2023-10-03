import {JsonSchema} from "./JsonSchema";
import {JsonUtil} from "./index";

export type Middleware = (readJson: JsonUtil) => (writeJson: JsonSchema) => Promise<void>

export type JsonAttribute<T extends string> = {
  $?: Partial<Record<T, string>>,
}
export type JsonBody<T> = {
  [P in keyof T]?: Array<T[P] | undefined>
}
