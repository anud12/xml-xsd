import {locationGrid} from "./locationGrid";
import {locationMarkovChainMatrix} from "./locationMarkovChainMatrix";
import {markovNext} from "./markov";

export const newLocation = (json, x, y) => {
  const grid = locationGrid(json)
  if (grid?.[x]?.[y]) {
    return grid?.[x]?.[y];
  }

  let transition = [];

  const topElement = grid?.[x]?.[y + 1];
  if (topElement) {
    const type = topElement[0].$type;
    transition = locationMarkovChainMatrix(json, "bottom")[type]
  }

  const rightElement = grid?.[x + 1]?.[y];
  if (rightElement) {
    const type = rightElement[0].$type[0];
    const typeList = locationMarkovChainMatrix(json, "left")[type]
    transition = transition.filter(e => typeList.includes(e))
  }

  const bottomElement = grid?.[x]?.[y - 1];
  if (bottomElement) {
    const type = bottomElement[0].$type[0];
    const typeList = locationMarkovChainMatrix(json, "top")[type]
    transition = transition.filter(e => typeList.includes(e))
  }

  const leftElement = grid?.[x - 1]?.[y];
  if (leftElement) {
    const type = leftElement[0].$type[0];
    const typeList = locationMarkovChainMatrix(json, "right")[type]
    transition = transition.filter(e => typeList.includes(e))
  }

  return markovNext(transition);
}