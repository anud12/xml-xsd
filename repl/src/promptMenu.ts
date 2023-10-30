import * as inquirer from "inquirer";
import {Command} from "./command/commandType";

export const promptMenu = async <T extends Array<any>>(t: T, commandList: Array<Command<T>>): Promise<void> => {
  while (true) {
    const commandKey = commandList.flatMap(e => e.key(...t));
    const {command} = await inquirer.prompt([
      {
        type: 'list',
        name: 'command',
        message: 'Choose a command:',
        choices: [...commandKey, 'exit'],
      },
    ]);
    await commandList.find(e => e.key(...t).includes(command))?.action(...t, command)

    if (command === "exit") {
      return;
    }
  }

}