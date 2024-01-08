import React, {createContext} from 'react';
import './App.css';
import {JsonUtil} from "demo/src/utils/util";
import {MapFrame} from "./frame/MapFrame";
import {SelectActivePerson, selectActivePersonUrl} from "./frame/SelectActivePersonFrame";
import {StatusFrame, statusFrameUrl} from "./frame/StatusFrame";

export const worldUtilContext = createContext<JsonUtil | undefined>(undefined)
export const mainPersonIdContext = createContext<string | undefined>(undefined)

function App() {

  switch (window.location.hash) {
    case statusFrameUrl:
      return <StatusFrame/>
    case selectActivePersonUrl:
      return <SelectActivePerson/>
    default:
      return <MapFrame/>
  }
}

export default App;
