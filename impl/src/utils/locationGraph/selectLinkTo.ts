import {JsonUtil} from "../util";
import {JsonSchema, NodeGraphQueryType, SelectNodeGraphQueryType} from "../JsonSchema";
import {mergeError} from "../../mergeError";

export type LinkToQueryType = JsonSchema["children"]["location_graph"]["children"]["node"]["children"]["link_to"];
export type SelectLinkToQueryType = JsonSchema["children"]["actions"]["children"]["person.teleport"]["children"]["link_to"]["children"]["selection"];

export const selectLinkTo = (jsonUtil: JsonUtil, selectLinkToQueryType?: SelectLinkToQueryType): Array<LinkToQueryType> => {
  try {
    if (!selectLinkToQueryType) {
      return [];
    }
    const originNode = jsonUtil.locationGraph.selectNodeGraph(selectLinkToQueryType.queryOptional("origin__node_graph__selection"));
    const destinationNode = jsonUtil.locationGraph.selectNodeGraph(selectLinkToQueryType.queryOptional("destination__node_graph__selection"));

    if (originNode.length > 0 && destinationNode.length === 0) {
      return originNode.flatMap(nodeGraph => nodeGraph.queryAllOptional("link_to"));
    }
    if (destinationNode.length > 0 && originNode.length === 0) {
      return destinationNode.flatMap(nodeGraph => nodeGraph.queryAllOptional("link_to"));
    }
    const destinationNodeIds = destinationNode.map(e => e?.attributeMap.id);

    const result = originNode.flatMap(nodeGraph => nodeGraph.queryAllOptional("link_to"))
      .filter(linkTo => destinationNodeIds.includes(linkTo?.attributeMap.node_id_ref));
    return result;
  } catch (e) {
    throw mergeError(e, new Error(`Error in selectLinkTo`));
  }
}