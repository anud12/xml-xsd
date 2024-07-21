import * as fs from "fs";
import {executeFromString} from "./execute";
import {validateString} from "./validate";
import {JsonSchema} from "./utils/JsonSchema";

(async () => {
  const filePath = process.argv[2];
  console.log("Reading from " + filePath);
  const data = fs.readFileSync(filePath)
  const dataString = data.toString();
  const errors = await validateString(dataString, console.log);
  if(errors?.length) {
    throw new Error(errors.map(e => e.message).join("\n"));
  }
  const outJson = await executeFromString(data.toString(), console.log) as JsonSchema;
  const outPath = outJson.query("world_metadata").query("next_world_step")
  const outFileName = outPath.body + ".xml";
  console.log("Writing output to " + outFileName);
  fs.writeFileSync(outFileName, outJson.serialize());

})()
