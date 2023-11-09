import * as inquirer from "inquirer";
import {Command} from "./command/commandType";
import {select} from "./select";
import {Render} from "./printer/createRender";

export const promptMenu = async <T extends Array<any>>(render:Render, message: () => string, t: T, commandList: Array<Command<T>>): Promise<void> => {
  while (true) {
    const commandKey = commandList.flatMap(e => e.key(...t));
    const command = await select(render, message, [...commandKey, 'exit']);
    await commandList.find(e => e.key(...t).includes(command))?.action(render, ...t, command)
    render.focus();
    if (command === "exit") {
      return;
    }
  }

}