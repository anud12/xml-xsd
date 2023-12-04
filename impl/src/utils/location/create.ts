import {findClosestPoint} from "./findClosestPoint";
import {fillNeighbours} from "./fillNeighbours";
import {JsonUtil} from "../index";

export const create = (readJson:JsonUtil, x: number, y: number): void => {
  let grid = readJson.location.grid()
  let cell = findClosestPoint(grid, x, y);
  do {
    cell = findClosestPoint(readJson.location.grid(), x, y);
    fillNeighbours(readJson, readJson, cell);
  } while (Number(cell.$y) !== y || Number(cell.$x) !== x)
}