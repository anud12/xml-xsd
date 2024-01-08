import {frame} from "./frame";
import React from "react";
import {Prompt} from "../terminal/Prompt";
import {JsonUtil} from "demo/src/utils/util";
import {Cursor} from "../terminal/Cursor";

const getPerson = (world?: JsonUtil, personId?: string) => {
  return world?.json?.queryAll("people")
    .flatMap(people => people.queryAll("person"))
    .find(person => person.attributeMap.id === personId);
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
          machine={person?.attributeMap.name}
          user={worldName}
          location={window.location.href
            .replace(window.location.host, "")
            .replace(window.location.protocol + "//", "")}
        />
        <span>cd ~/properties</span>
      </div>
      {person?.query("properties")?.childrenList.map(e => {
        return <div>
          <Prompt
            key={e.attributeMap.property_ref}
            machine={person?.attributeMap.name}
            user={worldName}
            location={`~/properties/${e.attributeMap.property_ref}`}
          />
          <span>{e.attributeMap.value}</span>
        </div>
      })
      }
      <div>
        <Prompt
          machine={person?.attributeMap.name}
          user={worldName}
          location={window.location.href
            .replace(window.location.host, "")
            .replace(window.location.protocol + "//", "")}
        />
        <span>cd ~/inventory</span>
      </div>
      {person?.queryOptional("inventory")?.childrenList.map(e => {
        return <div>
          <Prompt
            key={e.attributeMap.item_ref}
            machine={person?.attributeMap.name}
            user={worldName}
            location={`~/inventory/${e.attributeMap.item_ref}`}
          />
          <span>{e.attributeMap.equipped}</span>
        </div>
      })
      }
      <Cursor/>
      <div/>
    </div>
  )
}