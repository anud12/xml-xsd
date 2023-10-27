import {Command} from "./commandType";
import {jsonSchema} from "../src";
import inquirer from "inquirer";

export const moveTowards:Command<[string]> = {
  key: "move towards",
  action: (personName:string) => {

    inquirer.prompt({
      type:"number",
      message:""
    })

    jsonSchema.query("actions").appendChild("by", "").appendChild("move_towards", "", {})

  }
}