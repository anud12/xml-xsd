import {JsonSchema} from "../JsonSchema";
import {JsonUtil} from "../util";
import {nodeBodyType} from "../../JSONQuery";

export type Cell = JsonSchema[typeof nodeBodyType]["location_layer"][typeof nodeBodyType]["cell"]

export type LocationGrid = Record<number, Record<number, Cell>> & {
  maxX: number,
  maxY: number
}
export const locationGrid = (json: JsonUtil): LocationGrid => {

  const location = json.json.query("location_layer").queryAll("cell");
  let maxX = 0;
  let maxY = 0;
  const xLocation = location.reduce((acc, e) => {
    const xObj = acc[Number(e.$x)] ?? {};

    maxX = Math.abs(Number(e.$x)) > maxX ? Math.abs(Number(e.$x)) : maxX

    maxY = Math.abs(Number(e.$y)) > maxY ? Math.abs(Number(e.$y)) : maxY

    acc[Number(e.$x)] = {
      ...xObj,
      [Number(e.$y)]: e
    }
    return acc;
  }, {});

  return {
    ...xLocation,
    maxX,
    maxY
  };
}