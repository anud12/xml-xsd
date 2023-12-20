import {JsonUtil} from "../utils/util";

// export type Unit = {
//   json: JsonSchema,
//   util: JsonUtil,
// }

export type Middleware = (readUnit: JsonUtil) => (writeUnit: JsonUtil) => Promise<void>