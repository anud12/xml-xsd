import {XMLBuilder, XMLParser} from "fast-xml-parser";
import {newLocation} from "./newLocation";
import * as fs from "fs";

(async () => {
  const data = await new Promise<string>((res) => {
    process.stdin.setEncoding('utf8');
    process.stdin.on('data', function (data) {
      res(String(data));
    });
  })
  const json = new XMLParser({
    attributeNamePrefix: "",
    attributesGroupName: "$",
    ignoreAttributes: false,
    isArray: (tagName, jPath, isLeafNode, isAttribute) => !isAttribute

  }).parse(data, {})

  const next_world_step = json.world_step[0].world_metadata[0].next_world_step[0];
  const iter = Number(next_world_step.split("_")?.[1] ?? 0)
  json.world_step[0].world_metadata[0].next_world_step[0] = `world_${iter + 1}`
  const location = newLocation(json, 0, 0);

  json.world_step[0].locations[0].location.push(location);

  const xmlBuilder = new XMLBuilder({
    attributeNamePrefix: "",
    attributesGroupName: "$",
    format: true,
    ignoreAttributes: false,
    suppressEmptyNode: true,
  })

  const result = xmlBuilder.build(json);
  fs.writeFileSync(`${next_world_step}.xml`, result)

})()
