import {Nano} from "../terminal/Nano";
import {Button} from "../terminal/Button";
import {frame} from "./frame";
import React from "react";
import {FileUpload} from "../terminal/FileUpload";
import {JsonUtil} from "demo/dist/utils/util";
import {JsonQuery} from "demo/dist/JSONQuery";
import {selectActivePersonUrl} from "./SelectActivePersonFrame";

export const MapFrame = () => {
  const globalState = frame.useGlobalState();
  const worldName = globalState.jsonUtil?.json.queryOptional("world_metadata")?.queryOptional("next_world_step")?.body
  return (
    <div style={{height:"100vh"}}>
      <Nano
        appName={worldName}
        fileName={window.location.href}
        alert={"Move to"}
        menu={[{
          key: "None",
          label: <FileUpload label={worldName} onChange={async file => {
            globalState.set({
              jsonUtil: new JsonUtil(JsonQuery.fromText(await file.text()))
            })
          }}/>
        },{
          key: "None",
          label: <Button onClick={() => {
            frame.open(selectActivePersonUrl)
          }}>
            Select active person
          </Button>
        }, {
          key: "None",
          label: <Button onClick={() => frame.open("")}>
            Settings
          </Button>
        }, {
          key: "None",
          label: <Button onClick={() => {
            window.location.reload()
          }}>
            Reload
          </Button>
        }]}>
        <div>

          {globalState.activePersonId}

        </div>
      </Nano>
    </div>
  )
}