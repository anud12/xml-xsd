import {XMLParser} from "fast-xml-parser";
import {newLocation} from "./newLocation";

(async () => {
  const data = await new Promise<string>((res) => {
    process.stdin.setEncoding('utf8');
    process.stdin.on('data', function (data) {
      res(String(data));
    });
  })
  const json = new XMLParser({
    attributeNamePrefix: "$",
    ignoreAttributes: false,
    attributesGroupName: false,
    isArray: () => true

  }).parse(data, {})

  console.log(newLocation(json, 0, 0));

})()
