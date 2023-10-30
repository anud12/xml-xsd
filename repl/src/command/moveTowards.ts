import {Command} from "./commandType";
import {state} from "../";
import * as inquirer from 'inquirer';

export const moveTowards: Command<[string]> = {
  key: () => ["move towards"],
  action: async (personName: string) => {
    const location = state.jsonSchema.query("people").queryAll("person").find(e => e.$name === personName).query("location");
    let {x} = await inquirer.prompt([{
      type: "number",
      name: "x",
      message: `Destination X (current = ${location.$x}):`
    }])
    let {y} = await inquirer.prompt([{
      type: "number",
      name: "y",
      message: `Destination Y (current = ${location.$y}):`
    }])
    if(isNaN(x) && isNaN(y)) {
      return
    }
    if(isNaN(x)) {
      x = location.$x;
    }
    if(isNaN(y)) {
      y = location.$y;
    }
    state.jsonSchema.query("actions")
      .appendChild("by", {
        $name: personName,
      })
      .appendChild("move_towards", {
        $x: x,
        $y: y,
      })
  }
}