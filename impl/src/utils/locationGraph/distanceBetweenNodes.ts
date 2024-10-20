import {LocationGraphNodeQueryType} from "./createGraphNode";


export const distanceBetweenNodes = (node1: LocationGraphNodeQueryType, node2: LocationGraphNodeQueryType) => {
  const node1Position = node1.query("position");
  const node2Position = node2.query("position");


  return Math.sqrt(Math.pow(Number(node1Position.attributeMap.x) - Number(node2Position.attributeMap.x), 2) + Math.pow(Number(node1Position.attributeMap.y) - Number(node2Position.attributeMap.y), 2));
}
