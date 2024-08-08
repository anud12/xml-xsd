import {MutationMiddleware} from "../_type";
import {JsonUtil} from "../../utils/util";


export const personTeleport: MutationMiddleware = (readJson) => {

  const actionList = readJson.json.queryAllOptional("actions")
    .flatMap(actionsElement => actionsElement.queryAllOptional("person.teleport"));



  const actions = actionList.map(action => {
    const personIdRef = action.attributeMap.person_id_ref;
    const targetLocationGraphId = action.queryOptional("location_graph")?.attributeMap.location_graph_id;
    return async (writeJson:JsonUtil) => {
      action.removeFromParent();

      readJson.json.queryAllOptional("location_graph").find(locationGraphElement => {
        return locationGraphElement.queryAllOptional("node").find(nodeElement => {
          nodeElement.queryAllOptional("people").find(peopleElement => {
            const personElement = peopleElement.queryAllOptional("person").find(personElement => personElement.attributeMap.person_id_ref === personIdRef);
            personElement?.removeFromParent();
          })
        })
      })

      const locationGraphList = writeJson.json.queryAllOptional("location_graph");
      const locationGraph = locationGraphList
        .find(locationGraph => locationGraph.attributeMap.id === targetLocationGraphId)

      if(!locationGraph) {
        return;
      }

      const targetNodeId = action.queryOptional("location_graph")?.attributeMap.node_id;
      const node = locationGraph.queryAllOptional("node").find(node => node.attributeMap.id === targetNodeId);
      if(!node) {
        return;
      }
      const people = node.queryOptional("people") ?? node.appendChild("people");
      people.appendChild("person", undefined, {
        person_id_ref: personIdRef
      })
    }
  })

  return async (writeJson) => {
    await Promise.all(actions.map(action => action(writeJson)));
    return;
  }
}