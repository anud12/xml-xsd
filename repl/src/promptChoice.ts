import * as inquirer from "inquirer";

export const promptChoice = async <U>(message:string, commandList: Array<U>, mapper?: (element: U) => string): Promise<U | undefined> => {

  const {command} = await inquirer.prompt([
    {
      type: 'list',
      name: 'command',
      message: message + ':',
      choices: [...commandList.map(e => mapper?.(e) ?? e), 'exit'],
    },
  ]);
  if (command === "exit") {
    return undefined;
  }
  return commandList.find(e => mapper(e) === command)

}