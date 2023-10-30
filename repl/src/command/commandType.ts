export type Command<T extends Array<any>, ActionArg extends Array<string> = [...T, string]> = {
  key:(...t) => string[],
  action: (...t: ActionArg) => Promise<void>
}