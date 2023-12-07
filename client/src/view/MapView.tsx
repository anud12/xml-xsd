import {worldUtilContext} from "../App";
import React from "react";
import {JsonUtil} from "demo/dist/utils/util";
import {JsonQueryType} from "demo/dist/JSONQuery";
import {Cell} from "../terminal/Cell";

const extractLocationByCoords = (world: JsonUtil, x: number, y: number) => {
  const cell = world.json.queryAll("location_layer")
    .flatMap(world => world.queryAll("cell"))
    .find(cell => {
      return Number(cell.$x) === x && Number(cell.$y) === y;
    });

  if (!cell) return undefined;

  return {
    display: cell?.$location_ref?.split("")?.[0] ?? "0",
    cell,
  };
}
const extractPersonByCoords = (world: JsonUtil, x: number, y: number) => {
  const person = world.json.queryAll("people")
    .flatMap(people => people.queryAll("person"))
    .find(person => {
      const location = person.query("location");
      return Number(location.$x) === x && Number(location.$y) === y;
    });

  if (!person) return undefined;

  return {
    display: person?.$name?.split("")?.[0] ?? "P",
    cell: person,
  };

}


const worldToGrid = (world: JsonUtil) => {
  let maxX = 0;
  let minX = 0;
  let maxY = 0;
  let minY = 0;
  const locations = world.json.queryAll("location_layer")
    .flatMap(world => world.queryAll("cell"))
    .reduce((acc, cell) => {
      const y = Number(cell.$y) ?? 0;
      maxY = Math.max(maxY, y);
      minY = Math.min(minY, y);
      const yArray = acc.get(y) ?? new Map<number, Array<{ display: string, cell: JsonQueryType<any, any> }>>();
      acc.set(y, yArray);

      const x = Number(cell.$x) ?? 0;
      maxX = Math.max(maxX, x);
      minX = Math.min(minX, x);
      const xArray = yArray.get(x) ?? [];
      yArray.set(x, xArray);

      const loc = extractLocationByCoords(world, x, y);
      if (loc) {
        xArray.push(loc)
      }
      const person = extractPersonByCoords(world, x, y);
      if (person) {
        xArray.push({
          display: person.display,
          cell: person.cell,
        });
      }
      return acc;

    }, new Map() as Map<number, Map<number, Array<{ display: string, cell: JsonQueryType<any, any> }>>>);

  return {
    locations,
    maxX,
    minX,
    maxY,
    minY,
  };
}


export const MapView = () => {

  const world = React.useContext(worldUtilContext);

  if (!world) return <div>Map</div>;

  const grid = worldToGrid(world);

  const maxY = Math.max(grid.maxY, Math.abs(grid.minY)) * 2;
  const maxX = Math.max(grid.maxX, Math.abs(grid.minX)) * 2;

  return <div className={"MapView"}>
    {new Array(maxY).fill(0)
      .map((_, y) => y - Math.floor(maxY / 2))
      .map((y) => {
        return <div key={y} className={"column"}>
          {new Array(maxX).fill(0)
            .map((_, x) => x - Math.floor(maxX / 2))
            .map((x) => {
              const cell = grid.locations.get(y)?.get(x)?.map(element => {
                return element.display
              });
              return <Cell key={y}>
                {!cell && "?"}
                {cell?.map((element, index) =>
                    <span key={index}>
                {element ?? ")"}
              </span>
                )}
              </Cell>
            })}
        </div>
      })}
  </div>;
}