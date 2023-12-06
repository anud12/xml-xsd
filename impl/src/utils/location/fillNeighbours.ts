import {markovNext} from "../markovNext";
import {Cell} from "./locationGrid";
import {nodeAttributes} from "../../JSONQuery";
import {getTransitionFromNeighbours} from "./getTransitionFromNeighbours";
import {JsonUtil} from "../util";

export const fillNeighbours = (readJson: JsonUtil, writeJson: JsonUtil, originalCell: Cell, radius = 1) => {
  try {
    const grid = writeJson.location.grid();
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
          const type = markovNext(transition, readJson.random);
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
          writeJson.invalidate()
        }
      }
    }
  } catch (e:any)  {
    const newError = new Error(`fillNeighbours of type: ${originalCell.$location_ref}, x:${originalCell.$x}, y:${originalCell.$y}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }


}