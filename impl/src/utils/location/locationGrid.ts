import {JsonSchema} from "../JsonSchema";
import {JsonUtil} from "../util";

export type Cell = JsonSchema["children"]["location_layer"]["children"]["cell"]

export type LocationGrid = Record<number, Record<number, Cell>> & {
  maxX: number,
  maxY: number
}
export const locationGrid = (json: JsonUtil): LocationGrid => {

  const location = json.json.query("location_layer").queryAll("cell");
  let maxX = 0;
  let maxY = 0;
  const xLocation = location.reduce((acc, e) => {
    const xObj = acc[Number(e.getAttribute("x"))] ?? {};

    maxX = Math.abs(Number(e.getAttribute("x"))) > maxX ? Math.abs(Number(e.getAttribute("x"))) : maxX

    maxY = Math.abs(Number(e.getAttribute("y"))) > maxY ? Math.abs(Number(e.getAttribute("y"))) : maxY

    acc[Number(e.getAttribute("x"))] = {
      ...xObj,
      [Number(e.getAttribute("y"))]: e
    }
    return acc;
  }, {});

  return {
    ...xLocation,
    maxX,
    maxY
  };
}