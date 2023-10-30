import * as fs from "fs";
import {execute} from "./execute";

(async () => {
  const filePath = process.argv[2];
  console.log("Reading from " + filePath);
  const data = fs.readFileSync(filePath)
  const outJson = await execute(data.toString());
  fs.writeFileSync(outJson.query("world_metadata").query("next_world_step").body + ".xml", outJson.serialize());

})()
