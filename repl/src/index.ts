import * as inquirer from 'inquirer';
import {JsonQuery} from "demo/src/JSONQuery";
import {JsonSchema} from "demo/src/utils/JsonSchema";
import * as fs from "fs";
import {status} from "./command/status";
import {moveTowards} from "./command/moveTowards";
import {writeToDiskCommand} from "./command/writeToDiskCommand";
import {promptMenu} from "./promptMenu";
import {action} from "./command/action";
import {run} from "./command/run";
import {sideBySide} from "./sideBySide";
import {personMapView} from "./view/personMapView";
import {personNameToSymbol, personStatusView} from "./view/personStatusView";

export const state = {
  argPath: process.argv[2],
  jsonSchema: JsonQuery.fromText<JsonSchema>(fs.readFileSync(process.argv[2]).toString())
}

async function main() {
  const personList = state.jsonSchema.queryAll("people").flatMap(e => e.queryAll("person"));
  const {people: selectedPerson} = await inquirer.prompt([{
    type: "list",
    name: "people",
    message: "Choose person:",
    choices: personList.map(e => e.$name)
  }]);
  // Now that the schema is loaded, start the command loop
  const message = () => {
    return sideBySide(personMapView(selectedPerson), personStatusView(selectedPerson))
  }
  await promptMenu(message, [selectedPerson], [
    run,
    moveTowards,
    action,
    status,
    writeToDiskCommand,
  ]);
}

main();
