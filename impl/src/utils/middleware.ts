import {JsonSchema} from "./JsonSchema";
import {JsonUtil} from "./index";

export type Middleware = (readJson: JsonUtil) => (writeJson: JsonSchema) => Promise<void>

type InnerAttr<T extends string> = {
  $?: Partial<Record<T, string>>,
}
type InnerBody<T> = {
  [P in keyof T]?: Array<T[P] | undefined>
}


export type JsonAttribute<T extends string> = {
  $?: Partial<Record<T, string>>,
}
export type JsonBody<T> = {
  [P in keyof T]?: Array<T[P] | undefined>
}

