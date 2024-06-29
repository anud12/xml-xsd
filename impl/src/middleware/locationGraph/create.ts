import {MutationMiddleware} from "../_type";

export const locationGraphCreate: MutationMiddleware = (readJson) => {
  const actionList = readJson.json.queryAllOptional("actions")
    .flatMap(actionsElement => actionsElement.queryAllOptional("location_graph.create"))
    .flatMap(createElement => readJson.locationGraph.createLocationGraph(createElement.attributeMap.location_graph_rule_ref))
  return async (writeJson) => {
    if(actionList.length === 0) {
      return
    }
    writeJson.json.queryAllOptional("actions")
      .flatMap(actionsElement => actionsElement.removeFromParent())
    await Promise.all(actionList.map(actionList => actionList(writeJson)));
  }
}