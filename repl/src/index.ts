import * as inquirer from 'inquirer';
import {JsonQuery} from "demo/src/JSONQuery";
import {JsonSchema} from "demo/src/utils/JsonSchema";
import * as fs from "fs";
import {status} from "./command/status";
import {moveTowards} from "./command/moveTowards";
import {writeToDisk} from "./command/writeToDisk";
import {promptMenu} from "./promptMenu";
import {map} from "./command/map";
import {action} from "./command/action";

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
  await promptMenu([selectedPerson], [
    status,
    map,
    moveTowards,
    action,
    writeToDisk
  ]);
}

main();
