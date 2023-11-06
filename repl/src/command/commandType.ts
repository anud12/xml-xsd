import {Render} from "../printer/render";

export type Command<T extends Array<any>, ActionArg extends Array<string> = [...T, string]> = {
  key:(...t) => string[],
  action: (render:Render, ...t: ActionArg) => Promise<void>
}