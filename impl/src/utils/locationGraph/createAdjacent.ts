import {JsonUtil} from "../util";
import {createNode} from "./createNode";

export const createAdjacent = (jsonUtil: JsonUtil, locationGraphRef: string, nodeRef: string): (writeUnit: JsonUtil) => Promise<void> => {

  const locationGraphElement = jsonUtil.json.queryAllOptional("location_graph").find(locationGraphElement => locationGraphElement.attributeMap.id === locationGraphRef);
  const nodeGraphElement = locationGraphElement?.queryAllOptional("node").find(nodeElement => nodeElement.attributeMap.id === nodeRef);
  const nodeRuleElement = jsonUtil.getRuleGroups().flatMap(element => element.queryAllOptional("location_graph_rule"))
    .flatMap(element => element.queryAllOptional("node_rule"))
    .find(element => element.attributeMap.id === nodeGraphElement?.attributeMap?.node_rule_ref)

  const linkGroupElementList = nodeRuleElement?.queryAllOptional("link_group")
  const linkGroupElement = jsonUtil.randomFromArray(linkGroupElementList);

  return async (writeUnit: JsonUtil) => {
    if (!locationGraphElement || !nodeGraphElement || !linkGroupElement) {
      return
    }

    let angle = Number(linkGroupElement.attributeMap.angle);
    if(linkGroupElement.attributeMap.angleMax) {
      angle = Number(linkGroupElement.attributeMap.angle) + (jsonUtil.random() * Number(linkGroupElement.attributeMap.angleMax));
    }

    const toOptionElement = jsonUtil.randomFromArray(linkGroupElement.queryAllOptional("to_option"))
    const nodeRuleRef = toOptionElement.attributeMap.node_rule_ref;
    let distance = Number(toOptionElement.attributeMap.distance);
    if(toOptionElement.attributeMap.maxDistance) {
      distance = Number(toOptionElement.attributeMap.distance) + (jsonUtil.random() * Number(toOptionElement.attributeMap.maxDistance));
    }

    const linkNode = await createNode(jsonUtil, locationGraphElement, nodeRuleRef)(writeUnit);

    nodeGraphElement.appendChild("link", undefined, {
      angle: String(angle),
      distance: String(Math.floor(distance)),
      to: linkNode.attributeMap.id,
    })
  }
}