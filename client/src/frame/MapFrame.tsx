import {Nano} from "../terminal/Nano";
import {Button} from "../terminal/Button";
import {frame} from "./frame";
import React from "react";
import {FileUpload} from "../terminal/FileUpload";
import {JsonUtil} from "demo/dist/utils/util";
import {JsonQuery} from "demo/dist/JSONQuery";
import {selectActivePersonUrl} from "./SelectActivePersonFrame";
import {MapView} from "../view/MapView";
import {runAction} from "../action/runAction";
import {moveToAction} from "../action/moveToAction";

export const MapFrame = () => {
  const globalState = frame.useGlobalState();
  const worldName = globalState.jsonUtil?.json.queryOptional("world_metadata")?.queryOptional("next_world_step")?.body
  return (
    <div style={{height: "100vh"}}>
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
        }, {
          key: "None",
          label: <Button spawnsNew={true} onClick={() => {
            frame.open(selectActivePersonUrl)
          }}>
            Select active person
          </Button>
        }, {
          key: "None",
          label: <Button spawnsNew={true} onClick={() => frame.open("")}>
            Settings
          </Button>
        },{
          key:"None",
          label: <Button onClick={async () => {
            globalState.set({
              jsonUtil: await runAction(globalState.jsonUtil)
            })
          }}>
            Run
          </Button>
        },{
          key:"None",
          label: <Button onClick={async () => {
            const text = globalState.jsonUtil?.json.serializeRaw();
            var link = document.createElement('a');
            link.download = worldName ?? "";
            link.href = "data:application/octet-stream;base64," + btoa(text ?? "");
            document.body.appendChild(link); // Needed for Firefox
            link.click();
            document.body.removeChild(link);
          }}>
            Download
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
          <MapView
            world={globalState.jsonUtil}
            mainPersonId={globalState.activePersonId}
            onClick={async (cell, position) => {
              moveToAction(globalState.jsonUtil, globalState.activePersonId, position.x, position.y);
              globalState.set({
                jsonUtil: await runAction(globalState.jsonUtil)
              })
            }}
          />

        </div>
      </Nano>
    </div>
  )
}