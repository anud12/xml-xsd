import {mainPersonIdContext, worldUtilContext} from "../App";
import React, {useEffect, useRef} from "react";
import {JsonUtil} from "demo/dist/utils/util";
import {JsonQueryType} from "demo/dist/JSONQuery";
import {Cell} from "../terminal/Cell";
import "./MapView.css";

const extractLocationByCoords = (world: JsonUtil, x: number, y: number) => {
  const cell = world.json.queryAll("location_layer")
    .flatMap(world => world.queryAll("cell"))
    .find(cell => {
      return Number(cell.$x) === x && Number(cell.$y) === y;
    });

  if (!cell) return undefined;

  let display = cell?.$location_ref?.split("")?.[0] ?? "0";

  if(cell.$location_ref === "plains") {
    display = " ";
  }
  if(cell.$location_ref === "forest") {
    display = "T";
  }
  if(cell.$location_ref === "mountains") {
    display = "^";
  }

  return {
    display: display,
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
    style: {
      color: "red",
    },
    cell: person,
  };

}


const worldToGrid = (world: JsonUtil, mainPersonId: string) => {
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
      const yArray = acc.get(y) ?? new Map();
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
        if (person.cell.$id === mainPersonId) {
          xArray.push({
            display: "@",
            className: "mainPerson interactible-font_color",
            cell: person.cell,
          });
          return acc;
        }
        xArray.push({
          display: person.display,
          className: "interactible-font_color",
          cell: person.cell,
        });
      }
      return acc;

    }, new Map() as Map<number, Map<number, Array<{ display: string, cell: JsonQueryType<any, any>, style?: any, className?:string }>>>);

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
  const mainPersonId = React.useContext(mainPersonIdContext);

  const mainPersonRef = useRef<HTMLSpanElement>(null);

  useEffect(() => {
    if(!mainPersonRef.current) return;
    mainPersonRef.current.scrollIntoView({
      behavior: "smooth",
      block: "center",
      inline: "center",
    });
  }, [mainPersonRef.current]);

  if (!world) return <div>Map</div>;

  const grid = worldToGrid(world, mainPersonId ?? "");

  const maxY = Math.max(grid.maxY, Math.abs(grid.minY)) * 2;
  const maxX = Math.max(grid.maxX, Math.abs(grid.minX)) * 2;

  return <div className={"MapView"}>
    <div>
      <div>
        {new Array(maxY).fill(0)
          .map((_, y) => y - Math.floor(maxY / 2))
          .map((y) => {
            return <div key={y} className={"column"}>
              {new Array(maxX).fill(0)
                .map((_, x) => x - Math.floor(maxX / 2))
                .map((x) => {
                  const cell = grid.locations.get(y)?.get(x);
                  return <Cell key={y}>
                    {!cell && "?"}
                    {cell?.map((element, index) => {
                      if (element.display === "@") {
                        return <span ref={mainPersonRef} key={index}
                                      style={element.style}
                                     className={element.className}>
                          {element.display}
                        </span>
                      }
                      return <span key={index}
                                   className={element.className}
                                   style={element.style}>
                        {element.display ?? ")"}
                      </span>
                    })}
                  </Cell>
                })}
            </div>
          })}
      </div>
      <div/>
    </div>
  </div>
}