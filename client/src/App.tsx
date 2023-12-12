import React, {createContext} from 'react';
import './App.css';
import {JsonUtil} from "demo/dist/utils/util";
import hot from "react-hot-loader/root";
import {Prompt} from "./terminal/Prompt";
import {Nano} from "./terminal/Nano";
import {Cursor} from "./terminal/Cursor";
import {Button} from "./terminal/Button";
import {useGlobalState} from "./globalState";
import {frame} from "./frame/frame";

export const worldUtilContext = createContext<JsonUtil | undefined>(undefined)
export const mainPersonIdContext = createContext<string | undefined>(undefined)

function App() {
  const [world, setWorld] = React.useState<JsonUtil | undefined>(undefined);
  const [mainPersonId, setMainPersonId] = React.useState<string | undefined>(undefined);

  const globalState = frame.useGlobalState();
  return (
    <>
      <div style={{height:"100vh"}}>
        <Nano
          fileName={"map"}
          alert={"Move to"}
          menu={[{
            key: "None",
            label: <Button onClick={() => frame.open("http://localhost:3000")}>
              Settings
            </Button>
          }, {
            key: "None",
            label: <Button onClick={() => {
              window.location.reload()
            }}>
              Reload
            </Button>
          }, {
            key: "None",
            label: <Button onClick={() => {
              globalState.set({name:"data"})
            }}>
              Global state set data
            </Button>
          }, {
            key: "None",
            label: <Button onClick={() => {
              globalState.set({name:"name"})
            }}>
              Global state set name
            </Button>
          }]}>
          <div>
            <Prompt/>
            <span style={{"whiteSpace": "pre-wrap"}}>
          {`lorem ipsum long test that keeps going and may overflow if it keeps going \\
and is preformated \\
with multiple lines`}
            </span>
          </div>
          <div>
            <Prompt/> {globalState.name} <Cursor/>
          </div>
        </Nano>
      </div>
    </>
  );
}

export default hot.hot(App);
