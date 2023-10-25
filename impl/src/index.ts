import * as fs from "fs";
import {JsonUtil} from "./utils";
import {JsonSchema} from "./utils/JsonSchema";
import {personVision} from "./middleware/personVision";
import {personMoveTowards} from "./middleware/personMoveTowards";
import {Unit} from "./utils/middleware";
import {personAction} from "./middleware/personAction";
import {JsonQuery} from "./JSONQuery";


(async () => {
  const data = fs.readFileSync("../world.xml")
  const readJson = JsonQuery.fromText<JsonSchema>(data.toString());

  fs.writeFileSync(`world.xml`, readJson.serialize())

  const readJsonUtil = new JsonUtil(readJson);
  const unit:Unit = {
    json: readJson,
    util: readJsonUtil
  }

  const personVisionResult = personVision(unit);
  const personMoveTowardsResult = personMoveTowards(unit);
  const personActionResult = personAction(unit);

  await personVisionResult(readJson);
  await personMoveTowardsResult(readJson);
  await personActionResult(readJson);

  const writeWorldMetadata = readJson.query("world_metadata");
  const iter = Number(writeWorldMetadata.query("next_world_step").body.split("_")?.[1] ?? 0);
  const writeNextWorldStep = readJson.query("world_metadata").query("next_world_step")
  writeNextWorldStep.body = `world_${iter + 1}`

  fs.writeFileSync(`${writeNextWorldStep.body}.xml`, readJson.serialize())

})()
