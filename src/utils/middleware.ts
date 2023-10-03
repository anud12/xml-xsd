import {JsonSchema} from "./JsonSchema";
import {JsonUtil} from "./index";

export type Middleware = (readJson: JsonUtil) => (writeJson: JsonSchema) => Promise<void>

export type JsonAttribute<T extends string> = {
  $?: Partial<Record<T, string>>,
}
export type JsonBody<T> = {
  [P in keyof T]?: Array<T[P] | undefined>
}


export type Temp<T> = keyof T extends string ? {
  [P in keyof T as `${P}_other`]?: () => T[P]
} : never

const D: Temp<{
  demo: "3",
  value: "1"
}> = {
  demo_other: () => "3",
  value_other: () => "1"
}