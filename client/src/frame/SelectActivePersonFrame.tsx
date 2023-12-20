import {frame} from "./frame";
import React from "react";
import {Prompt} from "../terminal/Prompt";
import {Cursor} from "../terminal/Cursor";
import {Button} from "../terminal/Button";

export const selectActivePersonUrl = "#selectActivePerson";

export const SelectActivePerson = () => {
  const globalState = frame.useGlobalState();


  const worldName = globalState.jsonUtil?.json.queryOptional("world_metadata")?.queryOptional("next_world_step")?.body

  const personList = globalState.jsonUtil?.json.queryAll("people").flatMap(people => people.queryAll("person"))

  return (
    <div style={{height:"100vh"}}>
      <Prompt location={`~/${worldName}`}/> Select person
      {personList?.map(value => (
        <div key={value.attributeMap.id}>
          <Button  onClick={() => {
            globalState.set({
              activePersonId: value.attributeMap.id
            })
            window.close();
          }}>
            {value.attributeMap.name}
          </Button>
        </div>

      ))}
      <Cursor/>
    </div>
  )
}