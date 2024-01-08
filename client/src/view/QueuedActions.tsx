import {mainPersonIdContext, worldUtilContext} from "../App";
import {useContext} from "react";
import {JsonSchema} from "demo/src/utils/JsonSchema";
import "./QueuedActions.css"

type MoveTowardsQueryType = JsonSchema["children"]["actions"]["children"]["by"]["children"]["move_towards"]
type DoQueryType = JsonSchema["children"]["actions"]["children"]["by"]["children"]["do"]

export const QueuedActions = () => {

  const mainPersonId = useContext(mainPersonIdContext)
  const world = useContext(worldUtilContext);

  const actions = world?.json.queryAll("actions")
    .flatMap(queued_actions => queued_actions.queryAllOptional("by"))
    .filter(by => by.attributeMap.person_ref === mainPersonId)
    .flatMap(by => {
      return by.childrenList.map(action => {
        if (action.tag === "move_towards") {
          const moveTowards = action as MoveTowardsQueryType;
          return `Move towards x:${moveTowards.attributeMap.x}, y:${moveTowards.attributeMap.y}`;
        }
        if (action.tag === "do") {
          const doAction = action as DoQueryType;
          return `Do ${doAction.attributeMap.action_ref} to ${doAction.attributeMap.person_ref}`
        }
        return "Unknown action";
      })
    })

  return (
    <div className={"QueuedActions"}>
      <div>Queued actions</div>
      <div>
        {actions?.map((action, index) => {
          return <div key={index}>{action}</div>
        })}
      </div>
    </div>
  )
}