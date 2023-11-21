import {JsonQuery} from "./JSONQuery";
import {JsonSchema} from "./utils/JsonSchema";
import {JsonUtil} from "./utils";
import {Unit} from "./utils/middleware";
import {personVision} from "./middleware/personVision";
import {personMoveTowards} from "./middleware/personMoveTowards";
import {personAction} from "./middleware/personAction";
import {personAssignClassification} from "./middleware/personAssignClassification";
import {eventsMetadata} from "./middleware/eventsMetadata";
import {offsetRandomisationTable} from "./middleware/offsetRandomisationTable";

export const execute = async (xmlString:string, log: (...string:any[]) => void) => {
  const oldLog = console.log;
  console.log = log;
  const readJson = JsonQuery.fromText<JsonSchema>(xmlString.toString());

  const readJsonUtil = new JsonUtil(readJson);
  const unit:Unit = {
    json: readJson,
    util: readJsonUtil
  }

  const personMoveTowardsResult = personMoveTowards(unit);
  const personActionResult = personAction(unit);
  const eventsMetadataResult = eventsMetadata(unit);

  await personMoveTowardsResult(readJson);
  await personActionResult(readJson);
  await eventsMetadataResult(readJson);
  await personVision(unit)(readJson);
  await personAssignClassification(unit)(readJson);
  await offsetRandomisationTable(unit)(readJson)

  const writeWorldMetadata = readJson.query("world_metadata");
  const iter = Number(writeWorldMetadata.query("next_world_step").body.split("_")?.[1] ?? 0);
  const writeNextWorldStep = readJson.query("world_metadata").query("next_world_step")
  writeNextWorldStep.body = `world_${iter + 1}`
  console.log = oldLog;
  return readJson;
}
