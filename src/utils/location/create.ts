import {JsonSchema} from "../JsonSchema";
import {Middleware} from "../middleware";
import {JsonUtil} from "../index";
import {findClosestPoint} from "../findClosestPoint";
import {fillNeighbours} from "./fillNeighbours";

export const create = (x: number, y: number): Middleware => {
  return () => async (writeJson) => {
    const utils = new JsonUtil(writeJson);
    let grid = utils.location.grid()
    let cell = findClosestPoint(grid, x, y);
    do  {
      const utils = new JsonUtil(writeJson);
      cell = findClosestPoint(utils.location.grid(), x, y);
      fillNeighbours(utils, cell);
    } while(Number(cell.$.y) !== y || Number(cell.$.x) !== x)


  }
}