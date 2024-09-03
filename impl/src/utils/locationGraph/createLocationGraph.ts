import {JsonUtil} from "../util";
import {mergeError} from "../../mergeError";
import {LocationGraphNodeQueryType, LocationGraphQueryType} from "./createGraphNode";
import {JsonSchema} from "../JsonSchema";

type LocationGraphRuleQueryType = JsonSchema["children"]["rule_group"]["children"]["location_graph_rule"];


const initializeLocationGraph = (writeJson: JsonUtil, ref: string) => {
  try {
    let locationGraphElement = writeJson.json.appendChild("location_graph", "", {
      id: writeJson.getNextId()
    });
    locationGraphElement.appendChild("rule", undefined, {
      location_graph_rule_ref: ref
    })
    return locationGraphElement;
  } catch (e) {
    throw mergeError(e, new Error(`Error in initializeLocationGraph failed for ref:${ref}`));
  }

}

const isNecessaryNodeSatisfied = (rule: LocationGraphRuleQueryType, nodeList: LocationGraphNodeQueryType[]): boolean => {
  try {
    const necessaryNodeList = rule.queryAllOptional("setup")
      .flatMap(setupElement => setupElement.queryAllOptional("necessary_node"));

    const nodeRuleIdToNumberMap = new Map<string, number>();
    nodeList.forEach(node => {
      const value = nodeRuleIdToNumberMap.get(node.attributeMap.node_rule_ref) ?? 0;
      nodeRuleIdToNumberMap.set(node.attributeMap.node_rule_ref, value + 1);
    });

    const unsatisfiedRules = necessaryNodeList.filter(necessaryNode => {
      const nodeRuleId = necessaryNode.attributeMap.node_rule_ref;
      const minCount = Number(necessaryNode.attributeMap.min);
      const nodeCount = nodeRuleIdToNumberMap.get(nodeRuleId) ?? 0;
      if (nodeCount < minCount) {
        nodeRuleIdToNumberMap.set(nodeRuleId, nodeCount - minCount);
        return true;
      }
      return false;
    });
    return unsatisfiedRules.length === 0;
  } catch (e) {
    throw mergeError(e, new Error(`Error in isNecessaryNodeSatisfied failed for rule:${rule.attributeMap.id}`));
  }

}


export const createLocationGraph = (readJson: JsonUtil, ref: string): (writeUnit: JsonUtil) => Promise<LocationGraphQueryType | undefined> => {
  try {
    const rule = readJson.getRuleGroups()
      .flatMap(groupElement => groupElement.queryAll("location_graph_rule"))
      .find(ruleElement => ruleElement.attributeMap.id === ref);

    return async (writeJson) => {
      let setupElement = rule.queryOptional("setup");
      if (!setupElement) {
        return;
      }
      const startNodeRef = setupElement.queryOptional("starting_node")?.attributeMap?.node_rule_ref;
      if (!startNodeRef) {
        return;
      }


      let locationGraphElement = initializeLocationGraph(writeJson, ref);
      const startNode = await writeJson.locationGraph.createGraphNode(locationGraphElement, startNodeRef)(writeJson);

      let createdNodes: Array<LocationGraphNodeQueryType> = [startNode];

      if(createdNodes.length === 0) {
        return;
      }

      while (!isNecessaryNodeSatisfied(rule, createdNodes)) {
        if(createdNodes.length === 0) {
          break;
        }
        const node = await writeJson.locationGraph.createAdjacent(locationGraphElement.attributeMap.id, createdNodes[0].attributeMap.id)(writeJson);
        if (!node) {
          createdNodes.shift();
          continue;
        }
        createdNodes = [...createdNodes, node];
      }

      return locationGraphElement;
    }
  } catch (e) {
    throw mergeError(e, new Error(`Error in createLocationGraph failed for ref:${ref}`));
  }
}