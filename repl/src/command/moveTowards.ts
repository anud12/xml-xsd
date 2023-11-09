import {Command} from "./commandType";
import {constRenderer, state} from "../";
import {personMapView} from "../view/personMapView";
import {select2d} from "../select2d";

export const moveTowards: Command<[string]> = {
  key: () => ["move towards"],
  action: async (render, personName: string) => {
    const mapString = personMapView(personName);
    const personLocation = state.jsonSchema.query("people")
      .queryAllOptional("person")
      .find(e => e.$name === personName)
      ?.queryOptional("location");

    const cells = mapString.split("\n").map((line, y) => {
      return line.split("  ").map((cell, x) => {
        return {
          x: x - Math.floor(line.split("  ").length / 2),
          y: y - Math.floor(mapString.split("\n").length / 2),
          cell,
        }
      })
    });
    const selectedCell = await select2d(constRenderer.map.focus(), () => undefined, cells, e => e.cell, {
      x: Math.floor(Number(mapString.split("\n").length / 2)),
      y: Math.floor(Number(mapString.split("\n").length / 2)),
    });
    state.jsonSchema.query("actions")
      .appendChild("by", {
        $name: personName,
      })
      .appendChild("move_towards", {
        $x: String(selectedCell.x + Number(personLocation.$x)),
        $y: String(selectedCell.y + Number(personLocation.$y)),
      })
  }
}