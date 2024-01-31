import React from "react";
import {JsonUtil} from "demo/src/utils/util";
import {Grid} from "../terminal/Grid";
import {Cell} from "../terminal/Cell";
import {useContextMenu} from "../terminal/useContextMenu";
import {Button} from "../terminal/Button";
import {ContextMenu} from "../terminal/ContextMenu";
import {frame} from "../frame/frame";
import {statusFrameUrl} from "../frame/StatusFrame";
import {ActionOptions} from "./ActionOptions";
import {addAction} from "../action/addAction";
import {JsonQueryType} from "demo/src/JsonQueryType";
import "./MapView.css";
import {runAction} from "../action/runAction";


const playerSymbol  = `<svg width="800px" height="800px" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
<path d="M15.8571 12C15.8571 14.1302 14.1302 15.8571 12 15.8571C9.86976 15.8571 8.14286 14.1302 8.14286 12C8.14286 9.86972 9.86976 8.14282 12 8.14282C14.1302 8.14282 15.8571 9.86972 15.8571 12ZM15.8571 12L15.8571 13.2857C15.8571 14.7059 17.0084 15.8571 18.4286 15.8571C19.3408 15.8571 20.1422 15.3821 20.5986 14.6658C20.8528 14.2671 21 13.7936 21 13.2857V12C21 7.02944 16.9706 3 12 3C7.02944 3 3 7.02944 3 12C3 16.9706 7.02944 21 12 21C13.9122 21 15.6851 20.4037 17.1429 19.3868" stroke="#000000" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
</svg>
`

const extractLocationByCoords = (world: JsonUtil, x: number, y: number) => {
  const metadata = world.json.queryAll("rule_group")
    .flatMap(rule_group => rule_group.queryAll("locations_markov_chain"))
    .flatMap(locationMarkovChain => locationMarkovChain.queryAll("location_markov_link"));

  const cell = world.json.queryAll("location_layer")
    .flatMap(world => world.queryAll("cell"))
    .find(cell => {
      return Number(cell.attributeMap.x) === x && Number(cell.attributeMap.y) === y;
    });

  if (!cell) return undefined;
  const display = metadata.find(value => value.attributeMap.type === cell.attributeMap.location_rule_ref)
    .query("icon")
    .query("svg");
  return {
    display: display.serializeRaw(),
    className: "cellQueryType",
    cell,
  };
}
const extractPersonByCoords = (world: JsonUtil, x: number, y: number) => {
  const metadata = world.json.queryAll("rule_group")
    .flatMap(rule_group => rule_group.queryAll("race_rule"))
    .flatMap(locationMarkovChain => locationMarkovChain.queryAll("entry"));
  const person = world.json.queryAll("people")
    .flatMap(people => people.queryAll("person"))
    .find(person => {
      const location = person.query("location");
      return Number(location.attributeMap.x) === x && Number(location.attributeMap.y) === y;
    });


  if (!person) return undefined;


  let displayData = person?.queryOptional("icon")?.queryOptional("svg")?.serializeRaw()

  if(!displayData) {
    displayData = metadata.find(value => value.attributeMap.id === person.query("race").attributeMap.race_rule_ref)
      .query("icon")
      .query("svg")
      .serializeRaw();
  }

  return {
    display: displayData,
    className: "personQueryType",
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
      const y = Number(cell.attributeMap.y) ?? 0;
      maxY = Math.max(maxY, y);
      minY = Math.min(minY, y);
      const yArray = acc.get(y) ?? new Map();
      acc.set(y, yArray);

      const x = Number(cell.attributeMap.x) ?? 0;
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
        if (person.cell.attributeMap.id === mainPersonId) {
          xArray.push({
            display: playerSymbol,
            className: `mainPerson ${person.className}`,
            cell: person.cell,
          });
          return acc;
        }
        xArray.push({
          display: person.display,
          className: person.className,
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

  const globalState = frame.useGlobalState();

  const grid = worldToGrid(props.world, props.mainPersonId ?? "");
  const myHook = useContextMenu();
  return <Grid
    className={"mapView"}
    max={{
    x: grid.maxX,
    y: grid.maxY
  }} min={{
    x: grid.minX,
    y: grid.minY,
  }} getNode={(x, y) => {
    const cell = grid.locations.get(y)?.get(x);
    const cellElements = cell?.map((element) => element.cell);
    const person = cell?.map(cell => cell.cell)
      ?.find(cell => {
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
            <ActionOptions onClick={async actionName => {
              addAction(props.world, props.mainPersonId, person.attributeMap.id, actionName);
              myHook.close();
              runAction(props.world, jsonUtil => {
                globalState.set({
                  jsonUtil: jsonUtil
                })
              })

            }}/>
            <Button spawnsNew={true} onClick={() => {
              frame.open(statusFrameUrl, {personId: person.attributeMap.id ?? ""})
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
      {cell?.map((element, index) => {
        if (element.className.includes("mainPerson")) {
          return <span ref={props.onMainPersonRef} key={index}
                       style={{
                         ...element.style,
                         display:'100%',
                       }}
                       className={element.className} dangerouslySetInnerHTML={{
            __html: element.display
          }}>
                          </span>
        }
        return <span key={index}
                     className={element.className}
                     style={{
                       ...element.style,
                       display:"flex",
                       maxWidth:'100%'
                     }}
                     dangerouslySetInnerHTML={{
                       __html: element.display
                     }}>
                        </span>
      })}
    </Cell>
  }}>

  </Grid>
}