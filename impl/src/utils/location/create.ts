import {Middleware} from "../middleware";
import {findClosestPoint} from "../findClosestPoint";
import {fillNeighbours} from "./fillNeighbours";

export const create = (x: number, y: number): Middleware => {
  return (readJson) => async (writeJson) => {
    const utils = readJson.util;
    let grid = utils.location.grid()
    let cell = findClosestPoint(grid, x, y);
    do {
      utils.invalidate();
      cell = findClosestPoint(utils.location.grid(), x, y);
      fillNeighbours(readJson, writeJson, cell);
    } while (Number(cell.$y) !== y || Number(cell.$x) !== x)
  }
}