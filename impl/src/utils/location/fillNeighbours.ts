import {markovNext} from "../markovNext";
import {Cell} from "./locationGrid";
import {Unit} from "../../middleware/_type";
import {nodeAttributes} from "../../JSONQuery";
import {getTransitionFromNeighbours} from "./getTransitionFromNeighbours";

export const fillNeighbours = (readJson: Unit, writeJson: Unit, originalCell: Cell, radius = 1) => {
  try {
    const grid = writeJson.util.location.grid();
    const locationLayer = writeJson.json.query("location_layer");
    const x = Number(originalCell.$x);
    const y = Number(originalCell.$y);

    for (let i = -radius; i <= radius; i++) {
      for (let j = -radius; j <= radius; j++) {
        const cell = grid?.[x + i]?.[y + j];
        if (!cell) {
          const transition = getTransitionFromNeighbours(writeJson, originalCell);

          if(!transition) {
            throw new Error("transition is undefined");
          }
          if(transition.length === 0) {
            throw new Error("transition length is 0");
          }
          const type = markovNext(transition, readJson.util.random);
          if(!type) {
            throw new Error("resulted type is undefined");
          }
          const cell: Cell[typeof nodeAttributes] = {
            $location_ref: type,
            $x: String(x + i),
            $y: String(y + j),
          };
          console.log(`Created cell: ${JSON.stringify(cell)}`)
          locationLayer.appendChild("cell", cell)
          writeJson.util.invalidate()
        }
      }
    }
  } catch (e) {
    const newError = new Error(`fillNeighbours of type: ${originalCell.$location_ref}, x:${originalCell.$x}, y:${originalCell.$y}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }


}