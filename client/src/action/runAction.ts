import {JsonUtil} from "demo/src/utils/util";
import {execute} from "demo/src/execute";

export const runAction = async (jsonUtil: JsonUtil | undefined) => {
  if (!jsonUtil) {
    return;
  }
  const response = await execute(jsonUtil.json.serializeRaw(), console.log)
  return new JsonUtil(response);
}