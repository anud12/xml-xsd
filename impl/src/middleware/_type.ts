import {JsonUtil} from "../utils/util";
import {Dispatcher} from "../utils/triggerDispatcher/dispatcher";

// export type Unit = {
//   json: JsonSchema,
//   util: JsonUtil,
// }

export type MutationMiddleware = (readUnit: JsonUtil) => MutationResult;
export type MutationResult = (writeUnit:JsonUtil) => Promise<void>
export type EventMiddleware = (readUnit: JsonUtil) => (dispatcher:Dispatcher) => Promise<void>;