import {JsonUtil} from "../util";
import {mergeError} from "../../mergeError";

export const createLocationGraph = (readJson: JsonUtil, ref: string): (writeUnit: JsonUtil) => Promise<void> => {
  try {
    const rule = readJson.getRuleGroups()
      .flatMap(groupElement => groupElement.queryAll("location_graph_rule"))
      .find(ruleElement => ruleElement.attributeMap.id === ref);

    return async (writeJson) => {
      let setupElement = rule.queryOptional("setup");
      if(!setupElement) {
        return
      }
      const startNodeRef = setupElement.queryOptional("starting_node")?.attributeMap?.node_rule_ref;
      if(!startNodeRef) {
        return
      }


      let locationGraphElement = writeJson.json.appendChild("location_graph", "", {
        id: writeJson.getNextId()
      });
      locationGraphElement.appendChild("rule", undefined, {
        location_graph_rule_ref: ref
      })
      const startNode = await writeJson.locationGraph.createGraphNode(locationGraphElement, startNodeRef)(writeJson);

    }
  } catch (e) {
    throw mergeError(e, new Error(`Error in createLocationGraph failed for ref:${ref}`));
  }
}