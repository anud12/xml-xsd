import {Cell} from "./locationGrid";
import {Transition} from "../markovNext";
import {JsonUtil} from "../util";

export const getTransitionFromNeighbours = (json: JsonUtil, cell: Cell): Transition<string> => {
  const x = Number(cell.attributeMap.x)
  const y = Number(cell.attributeMap.y)
  const grid = json.location.grid();
  let transition = undefined;

  let element = grid?.[x]?.[y + 1];
  if (element) {
    const type = element.attributeMap.location_ref;
    transition = json.location.markovChainMatrix("bottom")[type] ?? []
  }

  element = grid?.[x + 1]?.[y];
  if (element) {
    const type = element.attributeMap.location_ref;
    const typeList = json.location.markovChainMatrix("left")[type]
    if (transition) {
      transition = transition.filter(e => typeList.includes(e))
    } else {
      transition = typeList
    }

  }

  element = grid?.[x]?.[y - 1];
  if (element) {
    const type = element.attributeMap.location_ref;
    const typeList = json.location.markovChainMatrix("top")[type]
    if (transition) {
      transition = transition.filter(e => typeList.includes(e))
    } else {
      transition = typeList
    }
  }

  element = grid?.[x - 1]?.[y];
  if (element) {
    const type = element.attributeMap.location_ref;
    const typeList = json.location.markovChainMatrix("right")[type]
    if (transition) {
      transition = transition.filter(e => typeList.includes(e))
    } else {
      transition = typeList
    }
  }
  if (!transition) {
    transition = json.location.markovChainMatrix("all")[cell.attributeMap.location_ref]
  }
  return transition;
}