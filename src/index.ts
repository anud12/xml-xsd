import {XMLBuilder, XMLParser} from "fast-xml-parser";
import {newLocation} from "./newLocation";

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

  const location = newLocation(json, 0, 0);

  json.world_step[0].locations[0].location.push(location);

  const xmlBuilder = new XMLBuilder({
    attributeNamePrefix: "",
    attributesGroupName: "$",
    format: true,
    ignoreAttributes: false,
  })

  const result = xmlBuilder.build(json);
  console.log(result);

})()
