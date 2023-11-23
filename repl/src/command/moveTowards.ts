import {Command} from "./commandType";
import {constRenderer, state} from "../";
import {personMap, personMapView} from "../view/personMapView";
import {select2d} from "../select2d";

export const moveTowards: Command<[string]> = {
  key: () => ["move towards"],
  action: async (render, personId: string) => {
    const mapString = personMap(personId);
    const personLocation = state.jsonSchema.query("people")
      .queryAllOptional("person")
      .find(e => e.$id === personId)
      ?.queryOptional("location");

    const cells = mapString.map((lineList, y,column) => {
      return lineList.map((cell, x, line) => {
        return {
          x: x - Math.floor(line.length / 2),
          y: y - Math.floor(column.length / 2),
          cell,
        }
      })
    });
    const selectedCell = await select2d(constRenderer.map, () => undefined, cells, e => e.cell, {
      x: Math.floor(Number(mapString.length / 2)),
      y: Math.floor(Number(mapString.length / 2)),
    });
    if(!selectedCell){
      return;
    }
    state.jsonSchema.query("actions")
      .appendChild("by", {
        $person: personId,
      })
      .appendChild("move_towards", {
        $x: String(selectedCell.x + Number(personLocation.$x)),
        $y: String(selectedCell.y + Number(personLocation.$y)),
      })
  }
}