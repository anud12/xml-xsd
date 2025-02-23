import {JsonUtil} from "../util";
import {SelectNodeGraphQueryType} from "../JsonSchema";
import {LocationGraphNodeQueryType, LocationGraphQueryType} from "./createGraphNode";
import {mergeError} from "../../mergeError";


const filterLocationGraph = (selectNodeGraphQueryType: SelectNodeGraphQueryType, locationGraph: LocationGraphQueryType): boolean => {
  try {
    const inLocationGraphList = selectNodeGraphQueryType.queryAllOptional("in__location_graph");

    if (inLocationGraphList.length === 0) {
      return true;
    }

    //find rule that is applicable to locationGraph
    const applicableLocationGraphList = inLocationGraphList.filter(inLocationGraph => {
      const hasLocationIdResult = inLocationGraph.queryAllOptional("has__location_graph_id")
        .map(hasLocationGraphId => {
          return hasLocationGraphId.attributeMap.location_graph_id_ref
        })
        .includes(locationGraph?.attributeMap.id)

      return hasLocationIdResult;

    })

    return applicableLocationGraphList.length > 0;
  } catch (e) {
    throw mergeError(e, new Error(`Error in filterLocationGraph failed for selectNodeGraphQueryType:${selectNodeGraphQueryType?.getPath()} and locationGraph:${locationGraph?.getPath()}`));
  }
}

const filterNodeGraph = (selectNodeGraphQueryType: SelectNodeGraphQueryType, nodeGraph: LocationGraphNodeQueryType): boolean => {
  try {

    const hasNodeGraphIdList = selectNodeGraphQueryType.queryAllOptional("has__node_graph_id");
    if (hasNodeGraphIdList.length === 0) {
      return true;
    }
    const hasNodeGraphIdResult = hasNodeGraphIdList
      .map(hasNodeGraphId => {
        return hasNodeGraphId.attributeMap.node_graph_id_ref
      })
      .includes(nodeGraph?.attributeMap.id)

    if (!hasNodeGraphIdResult) {
      return false;
    }

    return true;
  } catch (e) {
    throw mergeError(e, new Error(`Error in filterNodeGraph failed for selectNodeGraphQueryType:${selectNodeGraphQueryType?.getPath()} and nodeGraph:${nodeGraph?.getPath()}`));
  }

}

export const selectNodeGraph = (jsonUtil: JsonUtil, selectNodeGraphQueryType?: SelectNodeGraphQueryType): Array<LocationGraphNodeQueryType> => {

  try {
    if (!selectNodeGraphQueryType) {
      return [];
    }
    const locationGraphList = jsonUtil.json
      .queryOptional("data")
      ?.queryOptional("location")
      ?.queryAllOptional("location_graph")
      .filter(locationGraph => filterLocationGraph(selectNodeGraphQueryType, locationGraph)) ?? [];


    return locationGraphList.flatMap(locationGraph => {
      return locationGraph.queryAllOptional("node")
        .filter(nodeGraph => filterNodeGraph(selectNodeGraphQueryType, nodeGraph));
    });
  } catch (e) {
    throw mergeError(e, new Error(`Error in selectNodeGraph failed for selectNodeGraphQueryType:${selectNodeGraphQueryType?.getPath()}`));
  }

}