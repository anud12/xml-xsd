import {Unit} from "../../middleware/_type";
import {findClosestPoint} from "../findClosestPoint";
import {fillNeighbours} from "./fillNeighbours";

export const create = (readJson:Unit, x: number, y: number): void => {
  const utils = readJson.util;
  let grid = utils.location.grid()
  let cell = findClosestPoint(grid, x, y);
  do {
    cell = findClosestPoint(utils.location.grid(), x, y);
    fillNeighbours(readJson, readJson, cell);
  } while (Number(cell.$y) !== y || Number(cell.$x) !== x)
}