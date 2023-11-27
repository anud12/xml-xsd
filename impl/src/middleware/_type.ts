import {JsonSchema} from "../utils/JsonSchema";
import {JsonUtil} from "../utils/index";

export type Unit = {
  json: JsonSchema,
  util: JsonUtil,
}

export type Middleware = (readUnit: Unit) => (writeUnit: JsonSchema) => Promise<void>