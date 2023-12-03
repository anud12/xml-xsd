import {Unit} from "../../middleware/_type";
import {Cell} from "./locationGrid";
import {Transition} from "../markovNext";

export const getTransitionFromNeighbours = (json: Unit, cell: Cell): Transition<string> => {
  const x = Number(cell.$x)
  const y = Number(cell.$y)
  const grid = json.util.location.grid();
  let transition = undefined;

  let element = grid?.[x]?.[y + 1];
  if (element) {
    const type = element.$location_ref;
    transition = json.util.location.markovChainMatrix("bottom")[type] ?? []
  }

  element = grid?.[x + 1]?.[y];
  if (element) {
    const type = element.$location_ref;
    const typeList = json.util.location.markovChainMatrix("left")[type]
    if (transition) {
      transition = transition.filter(e => typeList.includes(e))
    } else {
      transition = typeList
    }

  }

  element = grid?.[x]?.[y - 1];
  if (element) {
    const type = element.$location_ref;
    const typeList = json.util.location.markovChainMatrix("top")[type]
    if (transition) {
      transition = transition.filter(e => typeList.includes(e))
    } else {
      transition = typeList
    }
  }

  element = grid?.[x - 1]?.[y];
  if (element) {
    const type = element.$location_ref;
    const typeList = json.util.location.markovChainMatrix("right")[type]
    if (transition) {
      transition = transition.filter(e => typeList.includes(e))
    } else {
      transition = typeList
    }
  }
  if (!transition) {
    transition = json.util.location.markovChainMatrix("all")[cell.$location_ref]
  }
  return transition;
}