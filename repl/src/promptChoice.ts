import {Render} from "./printer/createRender";
import {select} from "./select";

export const promptChoice = async <U>(render:Render, message:string, commandList: Array<U>, mapper?: (element: U) => string): Promise<U | undefined> => {
  const command = await select(render, () => message, [...commandList.map(e => mapper(e)), 'exit']);
  if (command === "exit") {
    return undefined;
  }
  return commandList.find(e => mapper(e) === command)

}