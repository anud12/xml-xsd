import {LocationGraphNodeQueryType, LocationGraphQueryType} from "./createGraphNode";
import {
  isDistanceBetweenPointsGreaterThan,
  isDistanceBetweenPointsLessThan,
  LinkGroupQueryType,
  NodeQueryType
} from "./createAdjacent";
import {mergeError} from "../../mergeError";


function angleBetweenPoints(firstNode: NodeQueryType, secondNode: NodeQueryType) {
  const firstPosition = firstNode.queryOptional("position");
  const secondPosition = secondNode.queryOptional("position");
  // Calculate vectors A and B
  const firstCoord = {
    x: Number(firstPosition.attributeMap.x),
    y: Number(firstPosition.attributeMap.y)
  };
  const secondCoord = {
    x: Number(secondPosition.attributeMap.x),
    y: Number(secondPosition.attributeMap.y)
  };
  // Calculate the differences in the coordinates
  const deltaX = secondCoord.x - firstCoord.x;
  const deltaY = secondCoord.y - firstCoord.y;

  // Calculate the angle in radians
  const angleInRadians = Math.atan2(deltaY, deltaX);

  // Convert the angle to degrees
  const angleInDegrees = angleInRadians * (180 / Math.PI);

  // Return the angle in degrees
  if (angleInDegrees < 0) {
    return angleInDegrees + 360;
  }
  return angleInDegrees;
}


const filterLinkGroupElementsAngle = (locationGraph: LocationGraphQueryType, originNode: LocationGraphNodeQueryType, linkGroupList: LinkGroupQueryType[]) => {
  try {
    const nodeMap: Map<string, LocationGraphNodeQueryType> = locationGraph.queryAllOptional("node").reduce((acc, node) => {
      acc.set(node.attributeMap.id, node)
      return acc;
    }, new Map<string, LocationGraphNodeQueryType>)

    return linkGroupList.filter(linkGroup => {

      const limit = Number(linkGroup.attributeMap.limit || "0")
      if (limit <= 0) {
        return true;
      }

      // Check if any of the adjacent nodes are allowed
      const minAngle = Number(linkGroup.attributeMap.angle);
      let maxAngle = Number(linkGroup.attributeMap.angleMax);
      if (isNaN((maxAngle))) {
        maxAngle = minAngle;
      }
      const allowedRuleList = linkGroupList.flatMap(element => element.queryAllOptional("to_option"))
        .flatMap(element => element.attributeMap.node_rule_ref);
      const adjacentNodeList = originNode.queryAllOptional("link_to")
        .map(linkToElement => nodeMap.get(linkToElement.attributeMap.node_id_ref))
        .filter(linkToElement => {
          return allowedRuleList?.includes(linkToElement?.attributeMap.node_rule_ref);
        })

        .filter(e => e);
      if (adjacentNodeList.length === 0) {
        return true;
      }

      // Filter out the nodes with invalid angles
      const validAngleNodes = adjacentNodeList.filter(adjacentNode => {
        const angle = angleBetweenPoints(originNode, adjacentNode);
        if (angle > maxAngle) {
          return false;
        }
        if (angle < minAngle) {
          return false;
        }

        return true;
      })
      validAngleNodes.forEach(node => nodeMap.delete(node.attributeMap.id));
      return validAngleNodes.length < (limit);
    })
  } catch (e) {
    throw mergeError(e, new Error(`Error in filterLinkGroupElementsAngle for ${originNode.attributeMap.id}`));
  }

}

const filterLinkGroupElementsDistance = (locationGraph: LocationGraphQueryType, originNode: LocationGraphNodeQueryType, linkGroupList: LinkGroupQueryType[]) => {
  try {
    const nodeMap: Map<string, LocationGraphNodeQueryType> = locationGraph.queryAllOptional("node").reduce((acc, node) => {
      acc.set(node.attributeMap.id, node)
      return acc;
    }, new Map<string, LocationGraphNodeQueryType>)

    return linkGroupList.filter(linkGroup => {
      const limit = Number(linkGroup.attributeMap.limit || "0")
      if (limit <= 0) {
        return true;
      }

      const allowedRuleList = linkGroupList.flatMap(element => element.queryAllOptional("to_option"))
        .flatMap(element => element.attributeMap.node_rule_ref);
      const adjacentNodeList = originNode.queryAllOptional("link_to")
        .map(linkToElement => nodeMap.get(linkToElement.attributeMap.node_id_ref))
        .filter(linkToElement => {
          return allowedRuleList?.includes(linkToElement?.attributeMap.node_rule_ref);
        })

        .filter(e => e);
      if (adjacentNodeList.length === 0) {
        return true;
      }

      // Filter out the nodes with invalid distances
      const toOptionList = linkGroup.queryAllOptional("to_option");
      const validDistanceNodes = adjacentNodeList.filter(adjacentNode => {
        toOptionList.filter(toOption => toOption.attributeMap.node_rule_ref === adjacentNode.attributeMap.node_rule_ref)
          .filter(toOption => {
            const distance = Number(toOption.attributeMap.distance);
            if (isDistanceBetweenPointsLessThan(originNode, adjacentNode, distance)) {
              return false;
            }
            let maxDistance = Number(toOption.attributeMap.maxDistance);
            if (isNaN(maxDistance)) {
              maxDistance = distance;
            }
            if (isDistanceBetweenPointsGreaterThan(originNode, adjacentNode, maxDistance)) {
              return false;
            }
            return true;
          });
        if (!toOptionList.length) {
          return false;
        }

      })
      validDistanceNodes.forEach(node => nodeMap.delete(node.attributeMap.id));
      return validDistanceNodes.length < (limit);
    })
  } catch (e) {
    throw mergeError(e, new Error(`Error in filterLinkGroupElementsDistance for ${originNode.attributeMap.id}`));
  }

}



export const keepNotFullLinkGroupElements = (locationGraph: LocationGraphQueryType, originNode: LocationGraphNodeQueryType, linkGroupList: LinkGroupQueryType[], isAdjacent: "adjacent" | "normal") => {

  try {
    const validAngleList = filterLinkGroupElementsAngle(locationGraph, originNode, linkGroupList);
    const validDistanceList = filterLinkGroupElementsDistance(locationGraph, originNode, validAngleList, isAdjacent);
    return validDistanceList;
  } catch (e) {
    throw mergeError(e, new Error(`Error in keepNotFullLinkGroupElements for ${originNode.attributeMap.id}`));
  }

}
