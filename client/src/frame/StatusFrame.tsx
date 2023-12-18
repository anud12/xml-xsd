import {frame} from "./frame";
import React from "react";
import {Prompt} from "../terminal/Prompt";
import {JsonUtil} from "demo/dist/utils/util";
import {Cursor} from "../terminal/Cursor";

const getPerson = (world?: JsonUtil, personId?: string) => {
  return world?.json?.queryAll("people")
    .flatMap(people => people.queryAll("person"))
    .find(person => person.$id === personId);
}

export const statusFrameUrl = "#statusFrameUrl";
export const StatusFrame = () => {
  const globalState = frame.useGlobalState();
  const worldName = globalState.jsonUtil?.json.queryOptional("world_metadata")?.queryOptional("next_world_step")?.body
  const newUrl = new URL(window.location.href);
  const personId = newUrl.searchParams.get("personId") ?? "";
  const person = getPerson(globalState.jsonUtil!, personId);
  return (
    <div>
      <div>
        <Prompt
          machine={person?.$name}
          user={worldName}
          location={window.location.href
            .replace(window.location.host, "")
            .replace(window.location.protocol + "//", "")}
        />
        <span>ls ~/clasifications</span>
      </div>
      {person?.query("classifications")?.children.map(e => {
        return <div key={e.$classification_ref}>
          <span>{e.$classification_ref}</span>
        </div>
      })
      }
      <div>
        <Prompt
          machine={person?.$name}
          user={worldName}
          location={window.location.href
            .replace(window.location.host, "")
            .replace(window.location.protocol + "//", "")}
        />
        <span>cd ~/properties</span>
      </div>
      {person?.query("properties")?.children.map(e => {
        return <div key={e.$property_ref}>
          <span>{e.$value}</span>
        </div>
      })
      }
      <div>
        <Prompt
          machine={person?.$name}
          user={worldName}
          location={window.location.href
            .replace(window.location.host, "")
            .replace(window.location.protocol + "//", "")}
        />
        <span>ls ~/inventory</span>
      </div>
      {person?.queryOptional("inventory")?.children.map(e => {
        return <div key={e.$item_ref}>
          <span>{e.$item_ref}</span>
        </div>
      })
      }
      <div>
        <Prompt
          machine={person?.$name}
          user={worldName}
          location={window.location.href
            .replace(window.location.host, "")
            .replace(window.location.protocol + "//", "")}
        />
        <Cursor/>
      </div>

      <div/>
    </div>
  )
}