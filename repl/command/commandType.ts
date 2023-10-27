export type Command<T extends Array<any>> = {
  key:string,
  action: (...t:T) => void
}