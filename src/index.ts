import {XMLBuilder, XMLParser} from "fast-xml-parser";
import * as fs from "fs";
import {utils} from "./utils";
import {JsonSchema} from "./utils/JsonSchema";


(async () => {
  const data = fs.readFileSync("../world.xml")
  const readJson: JsonSchema = new XMLParser({
    attributeNamePrefix: "",
    attributesGroupName: "$",
    ignoreAttributes: false,
    isArray: (tagName, jPath, isLeafNode, isAttribute) => !isAttribute

  }).parse(data, {})
  fs.writeFileSync(`world.json`, JSON.stringify(readJson))


  const writeJson = JSON.parse(JSON.stringify(readJson));
  await utils.newLocation(1000,1000)(readJson, writeJson);

  const xmlBuilder = new XMLBuilder({
    attributeNamePrefix: "",
    attributesGroupName: "$",
    format: true,
    ignoreAttributes: false,
    suppressEmptyNode: true,
  })

  const result = xmlBuilder.build(writeJson);

  const next_world_step = readJson.world_step[0].world_metadata[0].next_world_step[0];
  const iter = Number(next_world_step.split("_")?.[1] ?? 0)
  readJson.world_step[0].world_metadata[0].next_world_step[0] = `world_${iter + 1}`

  fs.writeFileSync(`${next_world_step}.xml`, result)

})()
