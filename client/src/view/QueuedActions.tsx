import {mainPersonIdContext, worldUtilContext} from "../App";
import {useContext} from "react";
import {JsonSchema} from "demo/dist/utils/JsonSchema";
import {nodeBodyType} from "demo/dist/JSONQuery";
import "./QueuedActions.css"

type MoveTowardsQueryType = JsonSchema[typeof nodeBodyType]["actions"][typeof nodeBodyType]["by"][typeof nodeBodyType]["move_towards"]
type DoQueryType = JsonSchema[typeof nodeBodyType]["actions"][typeof nodeBodyType]["by"][typeof nodeBodyType]["do"]

export const QueuedActions = () => {

  const mainPersonId = useContext(mainPersonIdContext)
  const world = useContext(worldUtilContext);

  const actions = world?.json.queryAll("actions")
    .flatMap(queued_actions => queued_actions.queryAllOptional("by"))
    .filter(by => by.$person_ref === mainPersonId)
    .flatMap(by => {
      return by.children.map(action => {
        if (action.tag === "move_towards") {
          const moveTowards = action as MoveTowardsQueryType;
          return `Move towards x:${moveTowards.$x}, y:${moveTowards.$y}`;
        }
        if (action.tag === "do") {
          const doAction = action as DoQueryType;
          return `Do ${doAction.$action_ref} to ${doAction.$person_ref}`
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