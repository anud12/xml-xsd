import React, {createContext, useEffect} from 'react';
import './App.css';
import {JsonUtil} from "demo/dist/utils/util";
import {JsonQuery} from "demo/dist/JSONQuery";
import {MapView} from "./view/MapView";
import {PersonSelect} from "./terminal/PersonSelect";
import { QueuedActions } from './view/QueuedActions';
import {MenuLine} from "./terminal/MenuLine";
import hot from "react-hot-loader/root";

const LoremIpsum = `
╭Status-------------╮╭Map------------------------------╮╭Selected Target----╮
┆Name: Billy (λ)    ┆┆ T  ○  T  T  T  T  T  ○  T  T  ○ ┆┆Name: Bobu (ν)     ┆
┆Race: human        ┆┆ T  T  ○  T  T  T  T  T  T  T  T ┆┆Race: human        ┆
┆Location:          ┆┆ T  T  ○  T  T  ○  T  T  T  T  T ┆┆Location:          ┆
┆ - X: 1            ┆┆ T  T  ○  ν  ○  ○  T  ○  T  T  T ┆┆ - X: -1           ┆
┆ - Y: 1            ┆┆ ○  T  T  ○  ○  ○  T  T  T  T  T ┆┆ - Y: -1           ┆
┆Movement: 2        ┆┆ T  T  T  ○  ○  @  T  ○  ○  T  T ┆┆Movement: 2        ┆
┆Relations:         ┆┆ T  T  T  T  ○  T  T  T  ○  ○  T ┆┆Relations:         ┆
┆Inventory:         ┆┆ T  T  ○  T  ○  ○  T  T  T  T  T ┆┆Inventory:         ┆
┆ - Long sword      ┆┆ T  T  T  ○  T  T  T  T  T  T  ○ ┆┆Classifications:   ┆
┆Classifications:   ┆┆ ○  T  T  T  T  T  ○  T  T  ○  T ┆┆ - alive           ┆
┆ - alive           ┆┆ T  T  T  T  T  T  T  T  T  T  T ┆┆Properties:        ┆
┆Properties:        ┆╰---------------------------------╯┆ - constitution: 20┆
┆ - strength: 13    ┆╭World Name╮                       ┆ - health: 24      ┆
┆ - constitution: 16┆┆world_2   ┆                       ╰-------------------╯
┆ - health: 16      ┆╰----------╯
╰-------------------╯
╔Select Action══╗
║> run          ║
║move towards   ║
║action         ║
║set target     ║
║write to disk  ║
║exit           ║
╚═══════════════╝
`

export const worldUtilContext = createContext<JsonUtil | undefined>(undefined)
export const mainPersonIdContext = createContext<string | undefined>(undefined)

function App() {
  const [world, setWorld] = React.useState<JsonUtil | undefined>(undefined);
  const [mainPersonId, setMainPersonId] = React.useState<string | undefined>(undefined);
  return (
    <>
      {!world && <form>
          <label>
              Upload world xml:
              <input type="file" name="file" onChange={async event => {
                const text = await event.target.files?.[0].text();
                const world = new JsonUtil(JsonQuery.fromText(text ?? ""));
                console.log(world);
                setWorld(world);
              }}/>
          </label>
      </form>}
      <worldUtilContext.Provider value={world}>
        {world && !mainPersonId &&
            <PersonSelect onChange={setMainPersonId}/>
        }
        <mainPersonIdContext.Provider value={mainPersonId}>
          {world && mainPersonId && <>
              <MapView onClick={(cell, coord) => {
                console.log(cell, coord);
                const windowRef = window.open("http://localhost:3000","", "popup=1");
                console.log(windowRef);
              }}/>
              <QueuedActions/>
              <MenuLine options={{
                "Move To": () => {

                }
              }}/>
          </>
          }
        </mainPersonIdContext.Provider>
      </worldUtilContext.Provider>
    </>
  );
}

export default hot.hot(App);
