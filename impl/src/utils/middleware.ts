import {JsonSchema} from "./JsonSchema";
import {JsonUtil} from "./index";

export type Unit = {
  json: JsonSchema,
  util: JsonUtil,
}

export type Middleware = (readUnit: Unit) => (writeUnit: JsonSchema) => Promise<void>

