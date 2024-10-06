import {JsonQuery} from "./JSONQuery";
import {JsonSchema} from "./utils/JsonSchema";
import {JsonUtil} from "./utils/util";
import {personVision} from "./middleware/personVision";
import {personMoveTowards} from "./middleware/personMoveTowards";
import {personAssignClassification} from "./middleware/personAssignClassification";
import {eventsMetadata} from "./middleware/eventsMetadata";
import {offsetRandomisationTable} from "./middleware/offsetRandomisationTable";
import {propertyRefValidator} from "./validators/propertyRef.validator";
import {raceRefValidator} from "./validators/raceRef.validator";
import {Dispatcher} from "./utils/triggerDispatcher/dispatcher";
import {calculateNameFromRefString} from "./utils/calculateName";
import {validate} from "./validate";
import {globalAction} from "./middleware/globalAction";
import {locationGraphCreate} from "./middleware/locationGraph/create";
import {locationGraphCreateAdjacent} from "./middleware/locationGraph/createAdjacent";
import {personTeleportMiddleware} from "./middleware/person/personTeleportMiddleware";
import {personOnPersonPropertyMutation} from "./middleware/action/personOnPersonPropertyMutation";
import {personAction} from "./middleware/personAction";
import {personCreateAction} from "./middleware/action/personCreateAction";
import {locationGraphAddClassification} from "./middleware/locationGraph/addClassificationt";
import {personMoveTo} from "./middleware/person/personMoveTo";

type StringParameter<Param extends string> = `${Param} ${string}`

export type StringArguments = StringParameter<"--name_rule">;


export const executeFromString = async (xmlString: string, log: (...string: any[]) => void, stringArguments: StringArguments[] = []) => {
  const oldLog = console.log;
  console.log = log;

  const argumentResult = await parseArguments(xmlString, log, stringArguments)

  if(argumentResult) {
    return argumentResult;
  }

  const readJson = JsonQuery.fromText<JsonSchema>(xmlString.toString());
  const result = await execute(readJson, log)
  console.log = oldLog;
  return result;
}

export const executeFromStringToString = async (xmlString: string, log: (...string: any[]) => void, stringArguments: StringArguments[] = []) => {
  const oldLog = console.log;
  console.log = log;

  const argumentResult = await parseArguments(xmlString, log, stringArguments)

  if(argumentResult) {
    return argumentResult;
  }

  const readJson = JsonQuery.fromText<JsonSchema>(xmlString.toString());
  const result = execute(readJson, log)
  console.log = oldLog;
  return (await result).serializeRaw();
}

const parseArguments = async (xmlString: string, log: (...string: any[]) => void, stringArguments: StringArguments[]): Promise<string | undefined> => {

  if(stringArguments.length === 0) {
    return;
  }
  const readJson = JsonQuery.fromText<JsonSchema>(xmlString.toString());

  if (stringArguments.length > 1) {
    throw new Error("Only one argument is allowed")
  }
  const argument = stringArguments[0];
  if (argument.startsWith("--name_rule")) {
    const readJsonUtil = new JsonUtil(readJson);
    return calculateNameFromRefString(readJsonUtil, argument.replace("--name_rule", "").trim())
  }

  return;
}

export const execute = async (readJson: JsonSchema, log: (...string: any[]) => void):Promise<JsonSchema> => {
  const oldLog = console.log;
  console.log = log;

  const dispatcher = new Dispatcher();
  const readJsonUtil = new JsonUtil(readJson);

  const errors = await validate(readJsonUtil, log);
  if(errors?.length) {
    throw new Error(errors.map(e => e.message).join("\n"));
  }
  await propertyRefValidator(readJsonUtil);
  await raceRefValidator(readJsonUtil);


  const dispatcherResult = dispatcher.middleware(readJsonUtil);
  const personMoveTowardsResult = personMoveTowards(readJsonUtil);
  const personOnPersonPropertyMutationResult = personOnPersonPropertyMutation(readJsonUtil);
  const personCreateActionResult = personCreateAction(readJsonUtil);
  const locationGraphAddClassificationResult = locationGraphAddClassification(readJsonUtil);
  const personActionResult = personAction(readJsonUtil);
  const globalActionResult = globalAction(readJsonUtil);
  const personMoveToResult = personMoveTo(readJsonUtil);
  const eventsMetadataResult = eventsMetadata(readJsonUtil);
  const locationGraphCreateResult = locationGraphCreate(readJsonUtil);

  const locationGraphCreateAdjacentResult = locationGraphCreateAdjacent(readJsonUtil);
  const personTeleportResult = personTeleportMiddleware(readJsonUtil);


  await personMoveTowardsResult(readJsonUtil);
  await personOnPersonPropertyMutationResult(readJsonUtil);
  await locationGraphAddClassificationResult(readJsonUtil);
  await personCreateActionResult(readJsonUtil);
  await personActionResult(readJsonUtil);
  await personMoveToResult(readJsonUtil);
  await globalActionResult(readJsonUtil);

  await eventsMetadataResult(dispatcher);
  await dispatcherResult(readJsonUtil);
  await locationGraphCreateResult(readJsonUtil);
  await locationGraphCreateAdjacentResult(readJsonUtil);
  await personTeleportResult(readJsonUtil);
  await personVision(readJsonUtil)(readJsonUtil);
  await personAssignClassification(readJsonUtil)(readJsonUtil);
  await offsetRandomisationTable(readJsonUtil)(readJsonUtil);

  console.log = oldLog;
  return readJsonUtil.json;
}
