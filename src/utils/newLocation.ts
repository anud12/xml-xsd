import {locationGrid} from "./locationGrid";
import {markovNext, Transition} from "./markovNext";
import {JsonSchema} from "./JsonSchema";
import {Middleware} from "./middleware";
import {JsonUtil} from "./index";

type Cell = JsonSchema["world_step"][number]["locations"][number]["cell"][number];

const findClosestFrom = (json: JsonUtil, x: number, y: number): Cell => {
  const grid = json.locationGrid();
  let range = 0;
  let element = undefined;
  let tempElement = grid?.[x]?.[y];
  // origin
  if (tempElement) {
    element = tempElement;
    return element;
  }
  while (true) {
    console.log(`Range ${range}`)
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

const getTransitionFromNeighbours = (json: JsonUtil, cell: Cell): Transition<string> => {
  const x = Number(cell.$.x)
  const y = Number(cell.$.y)
  const grid = json.locationGrid();
  let transition = undefined;

  let element = grid?.[x]?.[y + 1];
  if (element) {
    const type = element.$.type;
    transition = json.locationMarkovChainMatrix("bottom")[type] ?? []
  }

  element = grid?.[x + 1]?.[y];
  if (element) {
    const type = element.$.type;
    const typeList = json.locationMarkovChainMatrix("left")[type]
    if (transition) {
      transition = transition.filter(e => typeList.includes(e))
    } else {
      transition = typeList
    }

  }

  element = grid?.[x]?.[y - 1];
  if (element) {
    const type = element.$.type;
    const typeList = json.locationMarkovChainMatrix("top")[type]
    if (transition) {
      transition = transition.filter(e => typeList.includes(e))
    } else {
      transition = typeList
    }
  }

  element = grid?.[x - 1]?.[y];
  if (element) {
    const type = element.$.type;
    const typeList = json.locationMarkovChainMatrix("right")[type]
    if (transition) {
      transition = transition.filter(e => typeList.includes(e))
    } else {
      transition = typeList
    }
  }
  if (!transition) {
    transition = json.locationMarkovChainMatrix("all")[cell.$.type]
  }
  return transition;
}

const fillNeighbours = (writeJson: JsonUtil, originalCell: Cell) => {
  const grid = locationGrid(writeJson);
  const newCells = writeJson.jsonSchema.world_step[0].locations[0].cell;
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
  return readJson => async (writeJson) => {
    let grid = locationGrid(readJson)
    if (grid?.[x]?.[y]) {
      return;
    }
    let cell = findClosestFrom(new JsonUtil(writeJson), x, y);
    while (cell.$.x !== `${x}` && cell.$.y !== `${y}`) {
      console.log("newLocation", cell.$)
      cell = findClosestFrom(new JsonUtil(writeJson), x, y)
      fillNeighbours(new JsonUtil(writeJson), cell);

    }

  }
}