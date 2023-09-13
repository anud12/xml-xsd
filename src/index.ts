import {XMLParser} from "fast-xml-parser";
import {locationMarkov} from "./locationMarkov";

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

  locationMarkov(json, "left");

})()
