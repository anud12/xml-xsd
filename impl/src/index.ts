import * as fs from "fs";
import {execute, executeFromString} from "./execute";
import {validate} from "./validate";

(async () => {
  const filePath = process.argv[2];
  console.log("Reading from " + filePath);
  const data = fs.readFileSync(filePath)
  const dataString = data.toString();
  const errors = await validate(dataString, console.log);
  if(errors?.length) {
    throw new Error(errors.map(e => e.message).join("\n"));
  }
  const outJson = await executeFromString(data.toString(), console.log);
  fs.writeFileSync(outJson.query("world_metadata").query("next_world_step").body + ".xml", outJson.serialize());

})()
