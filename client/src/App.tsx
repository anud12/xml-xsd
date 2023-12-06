import React from 'react';
import './App.css';
import {Cell} from "./terminal/Cell";
import {JsonUtil} from "demo/dist/utils/util";
import {JsonQuery} from "demo/dist/JSONQuery";


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

function App() {
  const [world, setWorld] = React.useState<JsonUtil | undefined>(undefined);
  return (
    <>
      <form>
        <label>
          Upload world xml:
          <input type="file" name="file" onChange={async event => {
            const text = await event.target.files?.[0].text();
            const world = new JsonUtil(JsonQuery.fromText(text ?? ""))
            setWorld(world);
          }}/>
        </label>
      </form>
      <div className="App">
        {LoremIpsum.split("").map((char, index) => {
          return <Cell key={index}>{char}</Cell>
        })}
      </div>
    </>

  );
}

export default App;
