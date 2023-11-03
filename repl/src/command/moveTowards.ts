import {Command} from "./commandType";
import {state} from "../";
import * as inquirer from 'inquirer';
import {personMapView} from "../view/personMapView";
import {select2d} from "../select2d";
import {log} from "../print";
import {select} from "../select";

export const moveTowards: Command<[string]> = {
  key: () => ["move towards"],
  action: async (personName: string) => {
    const mapString = personMapView(personName);
    const cells = mapString.split("\n").map((line, y) => {
      return line.split(" ").map((cell, x) => {
        return {
          x: x - Math.floor(line.split(" ").length / 2),
          y: y - Math.floor(mapString.split("\n").length / 2),
          cell,
        }
      })
    });
    const selectedCell = await select2d(() => "Select destination:", cells, e => e.cell);
    state.jsonSchema.query("actions")
      .appendChild("by", {
        $name: personName,
      })
      .appendChild("move_towards", {
        $x: String(selectedCell.y),
        $y: String(selectedCell.x),
      })
  }
}