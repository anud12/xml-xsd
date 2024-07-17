import {MutationMiddleware} from "../_type";

export const locationGraphCreateAdjacent: MutationMiddleware = (readJson) => {
  const actionList = readJson.json.queryAllOptional("actions")
    .flatMap(actionsElement => actionsElement.queryAllOptional("location_graph.node.create_adjacent"))
    .flatMap(createElement => readJson.locationGraph.createAdjacent(createElement.attributeMap.location_graph_id_ref, createElement.attributeMap.node_id_ref))
  return async (writeJson) => {
    if(actionList.length === 0) {
      return
    }
    writeJson.json.queryAllOptional("actions")
      .flatMap(actionsElement => actionsElement.removeFromParent())
    await Promise.all(actionList.map(actionList => actionList(writeJson)));
  }
}