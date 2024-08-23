import {JsonUtil} from "../util";
import {LocationGraphNodeQueryType, LocationGraphQueryType} from "./createGraphNode";
import {isDistanceBetweenPointsGreaterThan, LinkGroupQueryType, NodeQueryType} from "./createAdjacent";
import {mergeError} from "../../mergeError";

function isAngleBetweenPointsLessThanGivenAngle(firstNode: NodeQueryType, secondNode: NodeQueryType, givenAngle) {
  const firstPosition = firstNode.queryOptional("position");
  const secondPosition = secondNode.queryOptional("position");
  // Calculate vectors A and B
  const vectorA = {
    x: Number(firstPosition.attributeMap.x),
    y: Number(firstPosition.attributeMap.y)
  };
  const vectorB = {
    x: Number(secondPosition.attributeMap.x),
    y: Number(secondPosition.attributeMap.y)
  };

  // Calculate dot product of vectors A and B
  const dotProduct = vectorA.x * vectorB.x + vectorA.y * vectorB.y;

  // Calculate magnitudes of vectors A and B
  const magnitudeA = Math.sqrt(vectorA.x * vectorA.x + vectorA.y * vectorA.y);
  const magnitudeB = Math.sqrt(vectorB.x * vectorB.x + vectorB.y * vectorB.y);

  // Calculate the cosine of the angle between A and B
  const cosAngle = dotProduct / (magnitudeA * magnitudeB);

  // Calculate the angle in radians between vectors A and B
  const angleBetweenPoints = Math.acos(cosAngle);

  // Convert the given angle from degrees to radians
  const givenAngleInRadians = givenAngle * (Math.PI / 180);

  // Compare the calculated angle with the given angle
  return angleBetweenPoints < givenAngleInRadians;
}
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
  return angleInDegrees;
}
export const keepNotFullLinkGroupElements = (locationGraph:LocationGraphQueryType, originNode: LocationGraphNodeQueryType, linkGroupList: LinkGroupQueryType[]) => {

  try {

    const nodeMap: Map<string,LocationGraphNodeQueryType> = locationGraph.queryAllOptional("node").reduce((acc, node) => {
      acc.set(node.attributeMap.id, node)
      return acc;
    }, new Map<string, LocationGraphNodeQueryType>)

    return linkGroupList.filter(linkGroup => {

      const limit = Number(linkGroup.attributeMap.limit || "0")
      if(limit <= 0) {
        return true;
      }

      // Check if any of the adjacent nodes are allowed
      const minAngle = Number(linkGroup.attributeMap.angle);
      const maxAngle = Number(linkGroup.attributeMap.angleMax) ?? minAngle;
      const allowedRuleList = linkGroupList.flatMap(element => element.queryAllOptional("to_option"))
        .flatMap(element => element.attributeMap.node_rule_ref);
      const adjacentNodeList = originNode.queryAllOptional("link_to")
        .map(linkToElement => nodeMap.get(linkToElement.attributeMap.node_id_ref))
        .filter(linkToElement => {
          return allowedRuleList?.includes(linkToElement?.attributeMap.node_rule_ref);
        })

      .filter(e => e);
      if(adjacentNodeList.length === 0) {
        return true;
      }

      // Filter out the nodes with invalid angles
      const validAngleNodes = adjacentNodeList.filter(adjacentNode => {
        const angle = angleBetweenPoints(originNode, adjacentNode);
        if(angle > maxAngle) {
          return false;
        }
        if(angle < minAngle) {
          return false;
        }

        return true;
      })
      validAngleNodes.forEach(node => nodeMap.delete(node.attributeMap.id));

      // Filter out the nodes with invalid distances
      const toOptionList = linkGroup.queryAllOptional("to_option");
      const validDistanceNodes = adjacentNodeList.filter(adjacentNode => {
        toOptionList.filter(toOption => toOption.attributeMap.node_rule_ref === adjacentNode.attributeMap.node_rule_ref);
        if(!toOptionList.length) {
          return false;
        }
        const distance = Number(toOptionList[0].attributeMap.distance);
        if(isDistanceBetweenPointsGreaterThan(originNode, adjacentNode, distance)) {
          return false;
        }
        const maxDistance = Number(toOptionList[0].attributeMap.maxDistance) ?? distance;
        if(!isDistanceBetweenPointsGreaterThan(originNode, adjacentNode, maxDistance)) {
          return false;
        }
        return true;
      })
      validDistanceNodes.forEach(node => nodeMap.delete(node.attributeMap.id));

      const validNodes = [...validAngleNodes, ...validDistanceNodes];
      return validNodes.length < limit;
    })

  } catch (e) {
    throw mergeError(e, new Error(`Error in keepNotFullLinkGroupElements for ${originNode.attributeMap.id}`));
  }

}