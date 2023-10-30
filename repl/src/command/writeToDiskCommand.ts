import {Command} from "./commandType";
import {state} from "../";
import * as fs from "fs";
import * as path from "path";

export const writeToDisk = () => {
  const outputFileName = state.jsonSchema.query("world_metadata").query("next_world_step").body;
  const outputPath = path.parse(state.argPath).dir;
  fs.writeFileSync(`${outputPath}/${outputFileName}.xml`, state.jsonSchema.serialize());
}

export const writeToDiskCommand: Command<[string]> = {
  key: () => ["write to disk"],
  action: async (personName: string) => {
    const outputFileName = state.jsonSchema.query("world_metadata").query("next_world_step").body;
    const outputPath = path.parse(state.argPath).dir;
    fs.writeFileSync(`${outputPath}/${outputFileName}.xml`, state.jsonSchema.serialize());
  }
}