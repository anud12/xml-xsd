import {PersonActionUsedDispatcher} from "./PersonActionUsedDispatcher";
import {JsonUtil} from "../util";

export class Dispatcher {
  constructor(
    public personActionUsedDispatcher = new PersonActionUsedDispatcher(),
  ) {
  }

  public middleware = (readJson: JsonUtil) => {
    const personResult =  this.personActionUsedDispatcher.middleware(readJson)
    return async (writeJson: JsonUtil) => {
      const value = await personResult(writeJson);
      return value
    }
  }
}