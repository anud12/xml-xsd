import React, {createContext} from 'react';
import './App.css';
import {JsonUtil} from "demo/dist/utils/util";
import hot from "react-hot-loader/root";
import {MapFrame} from "./frame/MapFrame";
import {SelectActivePerson, selectActivePersonUrl} from "./frame/SelectActivePersonFrame";

export const worldUtilContext = createContext<JsonUtil | undefined>(undefined)
export const mainPersonIdContext = createContext<string | undefined>(undefined)

function App() {

  switch (window.location.hash) {
    case selectActivePersonUrl:
      return <SelectActivePerson/>
    default:
      return <MapFrame/>
  }
}

export default hot.hot(App);