import {JsonUtil} from "../util";
import {JsonSchema} from "../JsonSchema";
import {mergeError} from "../../mergeError";

export type LocationGraphQueryType = JsonSchema["children"]["location_graph"]
export type LocationGraphNodeQueryType = LocationGraphQueryType["children"]["node"];
export type PositionQueryType = LocationGraphNodeQueryType["children"]["position"];

export const createGraphNode = (readJson: JsonUtil, locationQueryGraph: LocationGraphQueryType, ref: string,position: PositionQueryType["attributeMap"] = {x: "0", y: "0"}): (writeUnit: JsonUtil) => Promise<LocationGraphNodeQueryType> => {
  try {
    return async (writeUnit) => {
      const nodeElement = locationQueryGraph.appendChild("node", undefined, {
        node_rule_ref: ref,
        id: writeUnit.getNextId(),
      })
      nodeElement.appendChild("position", undefined, position)
      return nodeElement;
    }
  } catch (e) {
    throw mergeError(e, new Error(`Error in createGraphNode failed for locationQueryGraph:${locationQueryGraph?.getPath()} and ref:${ref}`));
  }
}