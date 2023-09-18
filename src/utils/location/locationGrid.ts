import {JsonSchema} from "../JsonSchema";
import {JsonUtil} from "../index";

export type Cell = JsonSchema["world_step"][number]["locations"][number]["cell"][number]
export type LocationGrid = Record<number, Record<number, Cell>> & {
  maxX: number,
  maxY: number
}
export const locationGrid = (json: JsonUtil): LocationGrid => {
  const location = json.jsonSchema.world_step[0].locations[0].cell;
  let maxX = 0;
  let maxY = 0;
  const xLocation = location.reduce((acc, e) => {
    const xObj = acc[Number(e.$.x)] ?? {};

    maxX = Math.abs(Number(e.$.x)) > maxX ? Math.abs(Number(e.$.x)) : maxX

    maxY = Math.abs(Number(e.$.y)) > maxY ? Math.abs(Number(e.$.y)) : maxY

    acc[Number(e.$.x)] = {
      ...xObj,
      [Number(e.$.y)]: e
    }
    return acc;
  }, {});

  return {
    ...xLocation,
    maxX,
    maxY
  };
}