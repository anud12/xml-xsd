import {JsonSchema} from "../JsonSchema";
import {JsonUtil} from "../util";

export type CellQueryType = JsonSchema["children"]["location_layer"]["children"]["cell"]

export type LocationGrid = Record<number, Record<number, CellQueryType>> & {
  maxX: number,
  maxY: number
}
export const locationGrid = (json: JsonUtil): LocationGrid => {

  const location = json.json.query("location_layer").queryAll("cell");
  let maxX = 0;
  let maxY = 0;
  const xLocation = location.reduce((acc, e) => {
    const xObj = acc[Number(e.attributeMap.x)] ?? {};

    maxX = Math.abs(Number(e.attributeMap.x)) > maxX ? Math.abs(Number(e.attributeMap.x)) : maxX

    maxY = Math.abs(Number(e.attributeMap.y)) > maxY ? Math.abs(Number(e.attributeMap.y)) : maxY

    acc[Number(e.attributeMap.x)] = {
      ...xObj,
      [Number(e.attributeMap.y)]: e
    }
    return acc;
  }, {});

  return {
    ...xLocation,
    maxX,
    maxY
  };
}