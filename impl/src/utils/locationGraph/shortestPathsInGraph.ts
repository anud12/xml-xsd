import {JsonUtil} from "../util";
import {LocationGraphQueryType} from "./createGraphNode";
import {NodeGraphQueryType} from "../JsonSchema";
import {LinkToQueryType} from "./selectLinkTo";


const insertValueToSortedArray = <T>(array: T[], value: T, compare: (a: T, b: T) => boolean) => {
  const index = array.findIndex(e => compare(e, value));
  if (index === -1) {
    array.push(value);
  } else {
    array.splice(index, 0, value);
  }
  return array;
}


const getPathsToDestinationOrdered = (nodeMapById: Map<string, NodeGraphQueryType>, startNode: NodeGraphQueryType, destinationNode: NodeGraphQueryType, numberOfPaths: number) => {

  if (numberOfPaths <= 0) {
    return [];
  }

  const queue: Array<{ path: Array<NodeGraphQueryType>, foundPaths: number }> = [{path: [startNode], foundPaths: 0}];
  const resultList: Array<Array<NodeGraphQueryType>> = [];

  while (queue.length > 0 && resultList.length < numberOfPaths) {
    const {path, foundPaths} = queue.shift();
    const currentNode = path[path.length - 1];
    if(!currentNode) {
      continue;
    }
    if (currentNode.attributeMap.id === destinationNode.attributeMap.id) {
      resultList.push(path);
      continue;
    }


    const adjacentNodesAndLinks: Array<{ node: NodeGraphQueryType, link: LinkToQueryType }> = currentNode.queryAllOptional("link_to")
      .reduce((acc, link) => {
        const entry = {
          node: nodeMapById.get(link.attributeMap.node_id_ref),
          link
        }
        return insertValueToSortedArray(acc, entry, (a, b) => {
          return a.link.attributeMap.total_progress < b.link.attributeMap.total_progress;
        });
      }, [] as Array<{ node: NodeGraphQueryType, link: LinkToQueryType }>)

    adjacentNodesAndLinks.flatMap(e => [e.node]).forEach(node => {
      if (resultList.length < numberOfPaths) {
        queue.push({path: [...path, node], foundPaths: foundPaths + 1});
      }
    });
  }
  return resultList;
}


export const shortestPathsInGraph = (readJson: JsonUtil, locationGraph: LocationGraphQueryType, startNode: NodeGraphQueryType, destinationNode: NodeGraphQueryType, numberOfPaths: number): Array<Array<NodeGraphQueryType>> => {
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

export const shortestPathsInGraphExcludeStart = (readJson: JsonUtil, locationGraph: LocationGraphQueryType, startNode: NodeGraphQueryType, destinationNode: NodeGraphQueryType, numberOfPaths: number): Array<Array<NodeGraphQueryType>> => {
  return shortestPathsInGraph(readJson, locationGraph, startNode, destinationNode, numberOfPaths).map(list => {
    list.shift();
    return list;
  })
}