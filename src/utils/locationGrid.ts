import {JsonSchema} from "./JsonSchema";

type Cell = JsonSchema["world_step"][number]["locations"][number]["cell"][number]
export type LocationGrid = Record<number, Record<number, Cell>>
export const locationGrid = (json: JsonSchema):LocationGrid => {
  const location = json.world_step[0].locations[0].cell;

  const xLocation = location.reduce((acc, e) => {
    const xObj = acc[Number(e.$.x)] ?? {};
    acc[Number(e.$.x)] = {
      ...xObj,
      [Number(e.$.y)]: e
    }
    return acc;
  }, {});

  return xLocation;
}