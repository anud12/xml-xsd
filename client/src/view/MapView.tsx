import React from "react";
import {JsonUtil} from "demo/dist/utils/util";
import {JsonQueryType} from "demo/dist/JSONQuery";
import {Grid} from "../terminal/Grid";
import {Cell} from "../terminal/Cell";
import {useContextMenu} from "../terminal/useContextMenu";
import {Button} from "../terminal/Button";
import {ContextMenu} from "../terminal/ContextMenu";
import {frame} from "../frame/frame";
import {statusFrameUrl} from "../frame/StatusFrame";

const extractLocationByCoords = (world: JsonUtil, x: number, y: number) => {
  const cell = world.json.queryAll("location_layer")
    .flatMap(world => world.queryAll("cell"))
    .find(cell => {
      return Number(cell.$x) === x && Number(cell.$y) === y;
    });

  if (!cell) return undefined;

  let display = cell?.$location_ref?.split("")?.[0] ?? "0";

  if (cell.$location_ref === "plains") {
    display = "\u00A0";
  }
  if (cell.$location_ref === "forest") {
    display = "T";
  }
  if (cell.$location_ref === "mountains") {
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
            className: "mainPerson",
            cell: person.cell,
          });
          return acc;
        }
        xArray.push({
          display: person.display,
          className: "",
          cell: person.cell,
        });
      }
      return acc;

    }, new Map() as Map<number, Map<number, Array<{
      display: string,
      cell: JsonQueryType<any, any>,
      style?: any,
      className?: string
    }>>>);

  return {
    locations,
    maxX,
    minX,
    maxY,
    minY,
  };
}


type Props = {
  world?: JsonUtil,
  mainPersonId?: string,
  onMainPersonRef?: React.LegacyRef<HTMLElement>
  onClick?: (cell: JsonQueryType<any, any>[], position: {
    x: number,
    y: number,
  }) => void;
}

export const MapView = (props: Props) => {

  if (!props.world) return <div>Map</div>;
  if (!props.mainPersonId) return <div>Map</div>

  const grid = worldToGrid(props.world, props.mainPersonId ?? "");
  const myHook = useContextMenu();
  return <Grid max={{
    x: grid.maxX,
    y: grid.maxY
  }} min={{
    x: grid.minX,
    y: grid.minY,
  }} getNode={(x, y) => {
    const cell = grid.locations.get(y)?.get(x);
    const cellElements = cell?.map((element) => element.cell);
    const person = cell?.map(cell => cell.cell)?.find(cell => {
      return cell.tag === "person"
    })
    return <Cell
      onClick={!cell ? undefined : () => {
        props.onClick?.(cellElements ?? [], {
          x, y,
        })
      }}
      onContextMenu={!person ? undefined : (evt) => {
        myHook.openAtCursor(evt, <ContextMenu>
            <Button onClick={() => {
              frame.open(statusFrameUrl, {personId: person.$id ?? ""})
              myHook.close();
            }}>
              Status
            </Button>
            <Button onClick={() => {
              myHook.close();
            }}>
              Close
            </Button>
          </ContextMenu>
        )
      }}>
      {!cell && " "}
      {cell?.map((element, index) => {
        if (element.display === "@") {
          return <span ref={props.onMainPersonRef} key={index}
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
  }}>

  </Grid>
}