import {MutationMiddleware} from "./_type";

export const createLocationGraph: MutationMiddleware = (readJson) => {
  const actionList = readJson.json.queryAllOptional("actions")
    .flatMap(actionsElement => actionsElement.queryAllOptional("create_location_graph"))
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