import {PersonActionUsedDispatcher} from "./PersonActionUsedDispatcher";

export class Dispatcher {
  constructor(
    public personActionUsedDispatcher = new PersonActionUsedDispatcher(),
  ) {
  }

  public middleware = (readJson: any) => {
    return async (writeJson: any) => {
      await this.personActionUsedDispatcher.middleware(readJson)(writeJson);
    }
  }
}