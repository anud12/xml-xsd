import * as inquirer from 'inquirer';
import {JsonQuery} from "demo/src/JSONQuery";
import {JsonSchema} from "demo/src/utils/JsonSchema";
import * as fs from "fs";
import {status} from "../command/status";
import {moveTowards} from "../command/moveTowards";
import {writeToDisk} from "../command/writeToDisk";

export const jsonSchema = JsonQuery.fromText<JsonSchema>(fs.readFileSync(process.argv[2]).toString())

async function main() {
  const personList = jsonSchema.queryAll("people").flatMap(e => e.queryAll("person"));
  const {people: selectedPerson} = await inquirer.prompt([{
    type: "list",
    name: "people",
    message: "Choose person:",
    choices: personList.map(e => e.$name)
  }]);
  // Now that the schema is loaded, start the command loop
  await commandLoop(selectedPerson);
}

async function commandLoop(personName: string) {
  while (true) {
    const commandLists = [
      status,
      moveTowards,
      writeToDisk,
    ];
    const {command} = await inquirer.prompt([
      {
        type: 'list',
        name: 'command',
        message: 'Choose a command:',
        choices: [...commandLists.map(e => e.key), 'exit'],
      },
    ]);
    await commandLists.find(e => e.key === command)?.action(personName)

    if(command === "exit") {
      return;
    }
  }
}

main();
