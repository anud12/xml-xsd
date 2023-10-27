import {Command} from "./commandType";
import {jsonSchema} from "../src";
import inquirer from "inquirer";
import * as fs from "fs";

export const writeToDisk: Command<[string]> = {
  key: "write to disk",
  action: async (personName: string) => {
    fs.writeFileSync("out.xml", jsonSchema.serialize())
  }
}