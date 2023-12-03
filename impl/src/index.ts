import * as fs from "fs";
import {execute} from "./execute";
import {validate} from "./validate";

(async () => {
  const filePath = process.argv[2];
  console.log("Reading from " + filePath);
  const data = fs.readFileSync(filePath)
  const dataString = data.toString();
  const errors = await validate(dataString, console.log);
  if(errors) {
    throw new Error(errors.map(e => e.message).join("\n"));
  }
  const outJson = await execute(data.toString(), console.log);
  fs.writeFileSync(outJson.query("world_metadata").query("next_world_step").body + ".xml", outJson.serialize());

})()
