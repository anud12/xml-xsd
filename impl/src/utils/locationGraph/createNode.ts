import {JsonUtil} from "../util";
import {JsonSchema} from "../JsonSchema";

export type LocationGraphQueryType = JsonSchema["children"]["location_graph"]
export type LocationGraphNodeQueryType = LocationGraphQueryType["children"]["node"];

export const createNode = (readJson: JsonUtil, locationQueryGraph: LocationGraphQueryType, ref: string): (writeUnit: JsonUtil) => Promise<LocationGraphNodeQueryType> => {
  return async (writeUnit) => {
    const nodeElement = locationQueryGraph.appendChild("node", undefined, {
      node_rule_ref: ref,
      id: writeUnit.getNextId()
    })
    return nodeElement;
  }
}