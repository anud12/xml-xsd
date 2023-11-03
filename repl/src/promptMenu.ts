import * as inquirer from "inquirer";
import {Command} from "./command/commandType";
import {select} from "./select";

export const promptMenu = async <T extends Array<any>>(message: () => string, t: T, commandList: Array<Command<T>>): Promise<void> => {
  while (true) {
    const commandKey = commandList.flatMap(e => e.key(...t));
    const command = await select(message, [...commandKey, 'exit']);
    await commandList.find(e => e.key(...t).includes(command))?.action(...t, command)
    if (command === "exit") {
      return;
    }
  }

}