import {JsonQuery} from "demo/src/JSONQuery";
import {JsonSchema} from "demo/src/utils/JsonSchema";
import * as fs from "fs";
import {select} from "./select";
import {promptMenu} from "./promptMenu";
import {personStatusView} from "./view/personStatusView";
import {personMapView} from "./view/personMapView";
import {run} from "./command/run";
import {moveTowards} from "./command/moveTowards";
import {action} from "./command/action";
import {writeToDiskCommand} from "./command/writeToDiskCommand";
import {sideBySide} from "./printer/sideBySide";
import {consoleRenderer} from "./printer/print";


export const state = {
  argPath: process.argv[2],
  jsonSchema: JsonQuery.fromText<JsonSchema>(fs.readFileSync(process.argv[2]).toString())
}

const baseRenderer = consoleRenderer();

export const constRenderer = {
  map: baseRenderer.addRight(),
  status: baseRenderer.getRight().addRight(),
  log: baseRenderer.addTop(),
}
// readline.createInterface({input: process.stdin, output: process.stdout})
async function main() {
  const renderer = baseRenderer.addBottom()
  const personList = state.jsonSchema.queryAll("people").flatMap(e => e.queryAll("person"));
  const selectedPerson = await select(renderer.addBottom(), () => "Select person:", personList, e => e.$name);

  const message = () => {
    constRenderer.map.update(personMapView(selectedPerson.$name));
    constRenderer.status.update(personStatusView(selectedPerson.$name));
    return "Select action:";

  }
  await promptMenu(renderer.addBottom(), message, [selectedPerson.$name], [
    run,
    moveTowards,
    action,
    writeToDiskCommand,
  ]);
  process.exit(0);
}
main();
