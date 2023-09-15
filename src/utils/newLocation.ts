import {locationGrid} from "./locationGrid";
import {locationMarkovChainMatrix} from "./locationMarkovChainMatrix";
import {markovNext, Transition} from "./markovNext";
import {JsonSchema} from "./JsonSchema";
import {Middleware} from "./middleware";
import {type} from "os";

type Cell = JsonSchema["world_step"][number]["locations"][number]["cell"][number];

const findClosestFrom = (json: JsonSchema, x: number, y: number): Cell => {
  const grid = locationGrid(json);
  let range = 0;
  let element = undefined;
  let tempElement = grid?.[x]?.[y];
  // origin
  if (tempElement) {
    element = tempElement;
    return element;
  }
  while (true) {
    range = range + 1;
    // top
    tempElement = grid?.[x]?.[y - range];
    if (tempElement) {
      element = tempElement;
      break;
    }

    // right
    tempElement = grid?.[x + range]?.[y];
    if (tempElement) {
      element = tempElement;
      break;
    }

    // bottom
    tempElement = grid?.[x]?.[y + range];
    if (tempElement) {
      element = tempElement;
      break;
    }

    // left
    tempElement = grid?.[x - range]?.[y];
    if (tempElement) {
      element = tempElement;
      break;
    }

    // top-right
    tempElement = grid?.[x + range]?.[y - range];
    if (tempElement) {
      element = tempElement;
      break;
    }

    // bottom-right
    tempElement = grid?.[x + range]?.[y + range];
    if (tempElement) {
      element = tempElement;
      break;
    }

    // bottom-left
    tempElement = grid?.[x - range]?.[y + range];
    if (tempElement) {
      element = tempElement;
      break;
    }

    // top-left
    tempElement = grid?.[x - range]?.[y - range];
    if (tempElement) {
      element = tempElement;
      break;
    }
  }
  return element;
}

const getTransitionFromNeighbours = (json: JsonSchema, cell: Cell):Transition<string> => {
  const x = Number(cell.$.x)
  const y = Number(cell.$.y)
  const grid = locationGrid(json);
  let transition = undefined;

  let element = grid?.[x]?.[y + 1];
  if (element) {
    const type = element.$.type;
    transition = locationMarkovChainMatrix(json, "bottom")[type] ?? []
  }

  element = grid?.[x + 1]?.[y];
  if (element) {
    const type = element.$.type;
    const typeList = locationMarkovChainMatrix(json, "left")[type]
    if(transition) {
      transition = transition.filter(e => typeList.includes(e))
    } else {
      transition = typeList
    }

  }

  element = grid?.[x]?.[y - 1];
  if (element) {
    const type = element.$.type;
    const typeList = locationMarkovChainMatrix(json, "top")[type]
    if(transition) {
      transition = transition.filter(e => typeList.includes(e))
    } else {
      transition = typeList
    }
  }

  element = grid?.[x - 1]?.[y];
  if (element) {
    const type = element.$.type;
    const typeList = locationMarkovChainMatrix(json, "right")[type]
    if(transition) {
      transition = transition.filter(e => typeList.includes(e))
    } else {
      transition = typeList
    }
  }
  if(!transition) {
    transition = locationMarkovChainMatrix(json, "all")[cell.$.type]
  }
  return transition;
}

const fillNeighbours = (writeJson: JsonSchema, originalCell: Cell) => {
  const grid = locationGrid(writeJson);
  const newCells = writeJson.world_step[0].locations[0].cell;
  const x = Number(originalCell.$.x);
  const y = Number(originalCell.$.y);
  let cell = grid?.[x + 1]?.[y];
  if (!cell) {
    const transition = getTransitionFromNeighbours(writeJson, originalCell)
    const type = markovNext(transition);
    newCells.push({
      $: {
        type: type,
        y: String(y),
        x: String(x + 1)
      }
    })
  }

  cell = grid?.[x - 1]?.[y];
  if (!cell) {
    const transition = getTransitionFromNeighbours(writeJson, originalCell)
    const type = markovNext(transition);
    newCells.push({
      $: {
        type: type,
        y: String(y),
        x: String(x - 1)
      }
    })
  }

  cell = grid?.[x + 1]?.[y + 1];
  if (!cell) {
    const transition = getTransitionFromNeighbours(writeJson, originalCell)
    const type = markovNext(transition);
    newCells.push({
      $: {
        type: type,
        y: String(y + 1),
        x: String(x + 1)
      }
    })
  }

  cell = grid?.[x - 1]?.[y + 1];
  if (!cell) {
    const transition = getTransitionFromNeighbours(writeJson, originalCell)
    const type = markovNext(transition);
    newCells.push({
      $: {
        type: type,
        y: String(y + 1),
        x: String(x - 1)
      }
    })
  }


  cell = grid?.[x]?.[y + 1];
  if (!cell) {
    const transition = getTransitionFromNeighbours(writeJson, originalCell)
    const type = markovNext(transition);
    newCells.push({
      $: {
        type: type,
        y: String(y + 1),
        x: String(x)
      }
    })
  }

  cell = grid?.[x]?.[y + 1];
  if (!cell) {
    const transition = getTransitionFromNeighbours(writeJson, originalCell)
    const type = markovNext(transition);
    newCells.push({
      $: {
        type: type,
        y: String(y + 1),
        x: String(x)
      }
    })
  }

}

export const newLocation = (x: number, y: number): Middleware => {
  return async (readJson, writeJson) => {
    let grid = locationGrid(readJson)
    if (grid?.[x]?.[y]) {
      return;
    }
    let cell = findClosestFrom(writeJson, x, y);
    while (cell.$.x !== `${x}` && cell.$.y !== `${y}`) {
      cell = findClosestFrom(writeJson, x, y)
      fillNeighbours(writeJson, cell);

    }

  }
}