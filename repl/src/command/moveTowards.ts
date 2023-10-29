import {Command} from "./commandType";
import {jsonSchema} from "../";
import * as inquirer from 'inquirer';

export const moveTowards: Command<[string]> = {
  key: "move towards",
  action: async (personName: string) => {

    const {x} = await inquirer.prompt([{
      type: "number",
      name: "x",
      message: "Destination X:"
    }])

    const {y} = await inquirer.prompt([{
      type: "number",
      name: "y",
      message: "Destination Y:"
    }])
    jsonSchema.query("actions")
      .appendChild("by", {
        $name: personName,
      })
      .appendChild("move_towards", {
        $x: x,
        $y: y,
      })
  }
}