import {JsonQuery} from "demo/src/JSONQuery";
import {JsonSchema} from "demo/src/utils/JsonSchema";
import * as fs from "fs";
import {select} from "./select";
import {promptMenu} from "./promptMenu";
import {sideBySide} from "./sideBySide";
import {personStatusView} from "./view/personStatusView";
import {personMapView} from "./view/personMapView";
import {run} from "./command/run";
import {moveTowards} from "./command/moveTowards";
import {action} from "./command/action";
import {writeToDiskCommand} from "./command/writeToDiskCommand";
import {status} from "./command/status";


export const state = {
  argPath: process.argv[2],
  jsonSchema: JsonQuery.fromText<JsonSchema>(fs.readFileSync(process.argv[2]).toString())
}
// readline.createInterface({input: process.stdin, output: process.stdout})
async function main() {
  const personList = state.jsonSchema.queryAll("people").flatMap(e => e.queryAll("person"));
  const selectedPerson = await select(() => "Select person:", personList, e => e.$name);

  const message = () => {
    return "\n" + sideBySide(personMapView(selectedPerson.$name), personStatusView(selectedPerson.$name))
  }
  await promptMenu(message, [selectedPerson.$name], [
    run,
    moveTowards,
    action,
    status,
    writeToDiskCommand,
  ]);
  process.exit(0);
}
main();
