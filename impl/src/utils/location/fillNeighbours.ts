import {markovNext, Transition} from "../markovNext";
import {Cell} from "./locationGrid";
import {Unit} from "../../middleware/_type";
import {nodeAttributes} from "../../JSONQuery";

const getTransitionFromNeighbours = (json: Unit, cell: Cell): Transition<string> => {
  const x = Number(cell.$x)
  const y = Number(cell.$y)
  const grid = json.util.location.grid();
  let transition = undefined;

  let element = grid?.[x]?.[y + 1];
  if (element) {
    const type = element.$type;
    transition = json.util.location.markovChainMatrix("bottom")[type] ?? []
  }

  element = grid?.[x + 1]?.[y];
  if (element) {
    const type = element.$type;
    const typeList = json.util.location.markovChainMatrix("left")[type]
    if (transition) {
      transition = transition.filter(e => typeList.includes(e))
    } else {
      transition = typeList
    }

  }

  element = grid?.[x]?.[y - 1];
  if (element) {
    const type = element.$type;
    const typeList = json.util.location.markovChainMatrix("top")[type]
    if (transition) {
      transition = transition.filter(e => typeList.includes(e))
    } else {
      transition = typeList
    }
  }

  element = grid?.[x - 1]?.[y];
  if (element) {
    const type = element.$type;
    const typeList = json.util.location.markovChainMatrix("right")[type]
    if (transition) {
      transition = transition.filter(e => typeList.includes(e))
    } else {
      transition = typeList
    }
  }
  if (!transition) {
    transition = json.util.location.markovChainMatrix("all")[cell.$type]
  }
  return transition;
}
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
          if(transition.length === 0) {
            throw new Error("transition length is 0");
          }
          const type = markovNext(transition, readJson.util.random);
          if(!type) {
            throw new Error("resulted type is undefined");
          }
          const cell: Cell[typeof nodeAttributes] = {
            $type: type,
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
    const newError = new Error(`fillNeighbours of type: ${originalCell.$type}, x:${originalCell.$x}, y:${originalCell.$y}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }


}