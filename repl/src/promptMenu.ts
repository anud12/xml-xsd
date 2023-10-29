import * as inquirer from "inquirer";
import {Command} from "./command/commandType";

export const promptMenu = async <T extends Array<any>>(t: T, commandList: Array<Command<T>>): Promise<void> => {
  while (true) {
    const {command} = await inquirer.prompt([
      {
        type: 'list',
        name: 'command',
        message: 'Choose a command:',
        choices: [...commandList.map(e => e.key), 'exit'],
      },
    ]);
    await commandList.find(e => e.key === command)?.action(...t)

    if (command === "exit") {
      return;
    }
  }

}