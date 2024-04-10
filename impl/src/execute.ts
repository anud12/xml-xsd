import {JsonQuery} from "./JSONQuery";
import {JsonSchema} from "./utils/JsonSchema";
import {JsonUtil} from "./utils/util";
import {personVision} from "./middleware/personVision";
import {personMoveTowards} from "./middleware/personMoveTowards";
import {personAction} from "./middleware/personAction";
import {personAssignClassification} from "./middleware/personAssignClassification";
import {eventsMetadata} from "./middleware/eventsMetadata";
import {offsetRandomisationTable} from "./middleware/offsetRandomisationTable";
import {propertyRefValidator} from "./validators/propertyRef.validator";
import {raceRefValidator} from "./validators/raceRef.validator";
import {Dispatcher} from "./utils/triggerDispatcher/dispatcher";

export const executeFromString = async(xmlString:string, log: (...string:any[]) => void) => {
  const oldLog = console.log;
  console.log = log;
  const readJson = JsonQuery.fromText<JsonSchema>(xmlString.toString());
  const result = execute(readJson, log)
  console.log = oldLog;
  return result;
}


export const execute = async (readJson:JsonSchema, log: (...string:any[]) => void) => {
  const oldLog = console.log;
  console.log = log;

  const dispatcher = new Dispatcher();
  const readJsonUtil = new JsonUtil(readJson);

  await propertyRefValidator(readJsonUtil);
  await raceRefValidator(readJsonUtil);

  const personMoveTowardsResult = personMoveTowards(readJsonUtil);
  const personActionResult = personAction(readJsonUtil);
  const eventsMetadataResult = eventsMetadata(readJsonUtil);

  await personMoveTowardsResult(readJsonUtil);
  await personActionResult(readJsonUtil);

  await eventsMetadataResult(dispatcher);

  await personVision(readJsonUtil)(readJsonUtil);
  await personAssignClassification(readJsonUtil)(readJsonUtil);
  await offsetRandomisationTable(readJsonUtil)(readJsonUtil)

  const writeWorldMetadata = readJson.query("world_metadata");
  const iter = Number(writeWorldMetadata.query("next_world_step").body.split("_")?.[1] ?? 0);
  const writeNextWorldStep = readJson.query("world_metadata").query("next_world_step")
  writeNextWorldStep.body = `world_${iter + 1}`
  console.log = oldLog;
  return readJson;
}
