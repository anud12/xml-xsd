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
import {consoleRenderer} from "./printer/print";
import {setTarget} from "./command/setTarget";


export const state = {
  argPath: process.argv[2],
  targetId: undefined as undefined | string,
  jsonSchema: JsonQuery.fromText<JsonSchema>(fs.readFileSync(process.argv[2]).toString())
}

const baseRenderer = consoleRenderer();
export const constRenderer = {
  map: baseRenderer.addRight("Map"),
  worldName: baseRenderer.getRight().addBottom("World Name"),
  status: baseRenderer.addLeft("Status"),
  target: baseRenderer.getRight().addRight("Selected Target"),
  log: baseRenderer.addTop(),
}

// readline.createInterface({input: process.stdin, output: process.stdout})
async function main() {
  const renderer = baseRenderer.addBottom()
  const personList = state.jsonSchema.queryAll("people").flatMap(e => e.queryAll("person"));
  const selectedPerson = await select(renderer.addBottom(), () => "Select person:", personList, e => e.$name);
  renderer.unsubscribeBottom();

  const message = () => {
    constRenderer.worldName.update(state.jsonSchema.query("world_metadata").query("next_world_step").body);
    constRenderer.map.update(personMapView(selectedPerson.$id));
    constRenderer.status.update(personStatusView(selectedPerson.$id));
    constRenderer.target.update(state.targetId ? personStatusView(state.targetId) : "No target selected");
    return "";

  }
  await promptMenu(constRenderer.status.addBottom("Select Action"), message, [selectedPerson.$id], [
    run,
    moveTowards,
    action,
    setTarget,
    writeToDiskCommand,
  ]);
  process.exit(0);
}

main();
