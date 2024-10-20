import {JsonUtil} from "../util";
import {LocationGraphNodeQueryType, LocationGraphQueryType} from "./createGraphNode";
import {LinkToQueryType} from "./selectLinkTo";


const insertValueToSortedArray = <T>(array: T[], value: T, compare: (first: T, second: T) => boolean) => {
  const index = array.findIndex(e => compare(e, value));
  if (index === -1) {
    array.push(value);
  } else {
    array.splice(index, 0, value);
  }
  return array;
}


const insertValueInPlaceToSortedArray = <T>(array: T[], value: T, compare: (first: T, second: T) => boolean):void => {
  const index = array.findIndex(e => compare(e, value));
  if (index === -1) {
    array.push(value);
  } else {
    array.splice(index, 0, value);
  }
}


const getPathsToDestinationOrdered = (nodeMapById: Map<string, LocationGraphNodeQueryType>, startNode: LocationGraphNodeQueryType, destinationNode: LocationGraphNodeQueryType, numberOfPaths: number) => {

  if (numberOfPaths <= 0) {
    return [];
  }

  const queue: Array<{ path: Array<LocationGraphNodeQueryType>, foundPaths: number, totalCost: number }> = [{
    path: [startNode],
    foundPaths: 0,
    totalCost: 0
  }];
  const resultList: Array<Array<LocationGraphNodeQueryType>> = [];

  while (queue.length > 0 && resultList.length < numberOfPaths) {
    const {path, foundPaths, totalCost} = queue.shift();
    const currentNode = path[path.length - 1];
    if (!currentNode) {
      continue;
    }
    if (currentNode.attributeMap.id === destinationNode.attributeMap.id) {
      resultList.push(path);
      continue;
    }


    const adjacentNodesAndLinks: Array<{
      node: LocationGraphNodeQueryType,
      link: LinkToQueryType
    }> = currentNode.queryAllOptional("links").flatMap(linksElement => linksElement.queryAllOptional("link_to"))
      .reduce((acc, link) => {
        const entry = {
          node: nodeMapById.get(link.attributeMap.node_id_ref),
          link
        }
        return insertValueToSortedArray(acc, entry, (first, second) => {
          return Number(first.link.attributeMap.total_progress) < Number(second.link.attributeMap.total_progress);
        });
      }, [] as Array<{ node: LocationGraphNodeQueryType, link: LinkToQueryType }>)

    adjacentNodesAndLinks.forEach(nodeAndLinks => {
      if (resultList.length < numberOfPaths) {
        const linkTotalCost = Number(nodeAndLinks.link.attributeMap.total_progress);
        const element = {
          path: [...path, nodeAndLinks.node],
          foundPaths: foundPaths + 1,
          totalCost: totalCost + linkTotalCost
        };
        insertValueInPlaceToSortedArray(queue, element, (first, second) => {
          return second.totalCost < first.totalCost
        })
      }
    });
  }
  return resultList;
}


export const shortestPathsInGraph = (readJson: JsonUtil, locationGraph: LocationGraphQueryType, startNode: LocationGraphNodeQueryType, destinationNode: LocationGraphNodeQueryType, numberOfPaths: number): Array<Array<LocationGraphNodeQueryType>> => {
  const nodes = locationGraph.queryAll("node");

  const startNodeExists = nodes.find(e => e.attributeMap.id === startNode.attributeMap.id);
  if (!startNodeExists) {
    throw new Error(`Start node ${startNode.attributeMap.id} does not exist in location graph`);
  }
  const destinationNodeExists = nodes.find(e => e.attributeMap.id === destinationNode.attributeMap.id);
  if (!destinationNodeExists) {
    throw new Error(`Destination node ${destinationNode.attributeMap.id} does not exist in location graph`);
  }

  const paths = getPathsToDestinationOrdered(new Map(nodes.map(e => [e.attributeMap.id, e])), startNode, destinationNode, numberOfPaths);
  if (paths.length === 0) {
    throw new Error(`No path found between ${startNode.attributeMap.id} and ${destinationNode.attributeMap.id}`);
  }
  return paths.slice(0, numberOfPaths);
}

export const shortestPathsInGraphExcludeStart = (readJson: JsonUtil, locationGraph: LocationGraphQueryType, startNode: LocationGraphNodeQueryType, destinationNode: LocationGraphNodeQueryType, numberOfPaths: number): Array<Array<LocationGraphNodeQueryType>> => {
  return shortestPathsInGraph(readJson, locationGraph, startNode, destinationNode, numberOfPaths).map(list => {
    list.shift();
    return list;
  })
}