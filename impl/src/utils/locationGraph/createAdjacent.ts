import {JsonUtil} from "../util";
import {createGraphNode, LocationGraphQueryType, PositionQueryType} from "./createGraphNode";
import {JsonSchema} from "../JsonSchema";
import {mergeError} from "../../mergeError";

type LinkGroupQueryType = JsonSchema["children"]["rule_group"]["children"]["location_graph_rule"]["children"]["node_rule"]["children"]["link_group"];
type NodeQueryType = LocationGraphQueryType["children"]["node"];
type LinkQueryType = LocationGraphQueryType["children"]["node"]["children"]["link"];

const getAdjacentNodes = (jsonUtil: JsonUtil, locationGraph: LocationGraphQueryType, originNode: NodeQueryType, maxDepth: number, excludeNodes: Array<NodeQueryType> = []): Array<NodeQueryType> => {
  try {
    if (maxDepth === 0) {
      return [];
    }
    excludeNodes.push(originNode);
    const allNodes = locationGraph.queryAllOptional("node")
      .filter(node => !excludeNodes.find(element => element.attributeMap.id === node.attributeMap.id));

    const linkedNodes = originNode.queryAllOptional("link")
      .map(linkElement => allNodes.find(value => value.attributeMap.id === linkElement.attributeMap.to))
      .filter(e => e);

    excludeNodes.push(...linkedNodes)
    const childrenNode = linkedNodes.flatMap(node => {
      return getAdjacentNodes(jsonUtil, locationGraph, node, maxDepth - 1, excludeNodes)
    });
    return [...linkedNodes, ...childrenNode];
  } catch (e) {
    throw mergeError(e, new Error(`Error in getAdjacentNodes failed for locationGraph:${locationGraph?.getPath()} and originNode:${originNode?.getPath()} and maxDepth:${maxDepth}`));
  }
}

const isDistanceBetweenPoints = (firstNode: NodeQueryType, secondNode: NodeQueryType, minDistance: number, maxDistance = minDistance): boolean => {
  const firstPosition = firstNode.queryOptional("position");
  const secondPosition = secondNode.queryOptional("position");

  //compute distance between firstPosition and secondPosition

  const positionDistanceSquared = Math.pow(Number(firstPosition.attributeMap.x) - Number(secondPosition.attributeMap.x), 2) + Math.pow(Number(firstPosition.attributeMap.y) - Number(secondPosition.attributeMap.y), 2);

  return Math.pow(minDistance, 2) <= positionDistanceSquared
    && positionDistanceSquared <= Math.pow(maxDistance, 2);
}

const createLinkTo = (jsonUtil: JsonUtil, linkGroupElement: LinkGroupQueryType, locationGraphElement: LocationGraphQueryType, nodeGraphElement: NodeQueryType, targetNodeGraphElement: NodeQueryType): (writeUnit: JsonUtil) => Promise<LinkQueryType> => {
  try {

    return async writeUnit => {
      return nodeGraphElement.appendChild("link", undefined, {
        to: targetNodeGraphElement.attributeMap.id,
      })
    }
  } catch (e) {
    throw mergeError(e, new Error(`Error in createLinkTo failed for linkGroupElement:${linkGroupElement?.getPath()} and locationGraphElement:${locationGraphElement?.getPath()} and nodeGraphElement:${nodeGraphElement?.getPath()} and targetNodeGraphElement:${targetNodeGraphElement?.getPath()}`));
  }
}

const positionBasedOnLink = (jsonUtil: JsonUtil, linkGroupElement: LinkGroupQueryType, originNode: NodeQueryType): PositionQueryType["attributeMap"] => {
  try {
    let angle = Number(linkGroupElement.attributeMap.angle);
    if (linkGroupElement.attributeMap.angleMax) {
      angle = Number(linkGroupElement.attributeMap.angle) + (jsonUtil.random() * Number(linkGroupElement.attributeMap.angleMax));
    }

    const toOptionElement = jsonUtil.randomFromArray(linkGroupElement.queryAllOptional("to_option"))
    let distance = Number(toOptionElement.attributeMap.distance);
    if (toOptionElement.attributeMap.maxDistance) {
      const random = jsonUtil.random();
      const maxDistance = random * Number(toOptionElement.attributeMap.maxDistance)
      distance = Number(toOptionElement.attributeMap.distance) + maxDistance;
    }
    const originPosition = originNode.queryOptional("position").attributeMap;
    const newX = Number(originPosition.x) + (distance * precomputeTrig[angle].cos);
    const newY = Number(originPosition.y) + (distance * precomputeTrig[angle].sin);
    return {
      x: String(Math.trunc(newX)),
      y: String(Math.trunc(newY)),
    }

  } catch (e) {
    throw mergeError(e, new Error(`Error in positionBasedOnLink failed for linkGroupElement:${linkGroupElement?.getPath()} and originNode:${originNode?.getPath()}`));
  }
}

export const createAdjacent = (jsonUtil: JsonUtil, locationGraphRef: string, nodeRef: string): (writeUnit: JsonUtil) => Promise<void> => {
  try {
    const locationGraphElement = jsonUtil.json.queryAllOptional("location_graph").find(locationGraphElement => locationGraphElement.attributeMap.id === locationGraphRef);
    const nodeGraphElement = locationGraphElement?.queryAllOptional("node").find(nodeElement => nodeElement.attributeMap.id === nodeRef);
    const nodeRuleElement = jsonUtil.getRuleGroups().flatMap(element => element.queryAllOptional("location_graph_rule"))
      .flatMap(element => element.queryAllOptional("node_rule"))
      .find(element => element.attributeMap.id === nodeGraphElement?.attributeMap?.node_rule_ref)

    const linkGroupElementList = nodeRuleElement?.queryAllOptional("link_group")
    const linkGroupElement = jsonUtil.randomFromArray(linkGroupElementList);

    const position = positionBasedOnLink(jsonUtil, linkGroupElement, nodeGraphElement);

    const toOptionElement = jsonUtil.randomFromArray(linkGroupElement.queryAllOptional("to_option"))
    const nodeRuleRef = toOptionElement.attributeMap.node_rule_ref;
    const createGraphNodeResult = createGraphNode(jsonUtil, locationGraphElement, nodeRuleRef, position);

    let distance = Number(toOptionElement.attributeMap.distance);
    let maxDistance = distance;
    if (toOptionElement.attributeMap.maxDistance) {
      const random = jsonUtil.random();
      const maxDistanceDelta = random * Number(toOptionElement.attributeMap.maxDistance)
      maxDistance = Number(toOptionElement.attributeMap.distance) + maxDistanceDelta;
    }
    const adjacentNodes = getAdjacentNodes(jsonUtil, locationGraphElement, nodeGraphElement, Number(toOptionElement.attributeMap.adjacent_depth_limit) || 0);


    return async (writeUnit: JsonUtil) => {
      if (!locationGraphElement || !nodeGraphElement || !linkGroupElement) {
        return
      }

      const newGraphNode = await createGraphNodeResult(writeUnit);

      let link = await createLinkTo(writeUnit, linkGroupElement, locationGraphElement, nodeGraphElement, newGraphNode)(writeUnit);

      const adjacentLinkList = adjacentNodes.filter(node => isDistanceBetweenPoints(node, newGraphNode, distance, maxDistance))
        .map(node => createLinkTo(writeUnit, linkGroupElement, locationGraphElement, node, newGraphNode)(writeUnit))
      await Promise.all(adjacentLinkList)
    }
  } catch (e) {
    throw mergeError(e, new Error(`Error in createAdjacent failed for locationGraphRef:${locationGraphRef} and nodeRef:${nodeRef}`));
  }
}


const precomputeTrig: { [key: number]: { sin: number, cos: number } } = {
  0: {sin: 0, cos: 1},
  1: {sin: 0.0175, cos: 0.9998},
  2: {sin: 0.0349, cos: 0.9994},
  3: {sin: 0.0523, cos: 0.9986},
  4: {sin: 0.0698, cos: 0.9976},
  5: {sin: 0.0872, cos: 0.9962},
  6: {sin: 0.1045, cos: 0.9945},
  7: {sin: 0.1219, cos: 0.9925},
  8: {sin: 0.1392, cos: 0.9903},
  9: {sin: 0.1564, cos: 0.9877},
  10: {sin: 0.1736, cos: 0.9848},
  11: {sin: 0.1908, cos: 0.9816},
  12: {sin: 0.2079, cos: 0.9781},
  13: {sin: 0.225, cos: 0.9744},
  14: {sin: 0.2419, cos: 0.9703},
  15: {sin: 0.2588, cos: 0.9659},
  16: {sin: 0.2756, cos: 0.9613},
  17: {sin: 0.2924, cos: 0.9563},
  18: {sin: 0.309, cos: 0.9511},
  19: {sin: 0.3256, cos: 0.9455},
  20: {sin: 0.342, cos: 0.9397},
  21: {sin: 0.3584, cos: 0.9336},
  22: {sin: 0.3746, cos: 0.9272},
  23: {sin: 0.3907, cos: 0.9205},
  24: {sin: 0.4067, cos: 0.9135},
  25: {sin: 0.4226, cos: 0.9063},
  26: {sin: 0.4384, cos: 0.8988},
  27: {sin: 0.454, cos: 0.891},
  28: {sin: 0.4695, cos: 0.8829},
  29: {sin: 0.4848, cos: 0.8746},
  30: {sin: 0.5, cos: 0.866},
  31: {sin: 0.515, cos: 0.8572},
  32: {sin: 0.5299, cos: 0.848},
  33: {sin: 0.5446, cos: 0.8387},
  34: {sin: 0.5592, cos: 0.829},
  35: {sin: 0.5736, cos: 0.8192},
  36: {sin: 0.5878, cos: 0.809},
  37: {sin: 0.6018, cos: 0.7986},
  38: {sin: 0.6157, cos: 0.788},
  39: {sin: 0.6293, cos: 0.7771},
  40: {sin: 0.6428, cos: 0.766},
  41: {sin: 0.6561, cos: 0.7547},
  42: {sin: 0.6691, cos: 0.7431},
  43: {sin: 0.682, cos: 0.7314},
  44: {sin: 0.6947, cos: 0.7193},
  45: {sin: 0.7071, cos: 0.7071},
  46: {sin: 0.7193, cos: 0.6947},
  47: {sin: 0.7314, cos: 0.682},
  48: {sin: 0.7431, cos: 0.6691},
  49: {sin: 0.7547, cos: 0.6561},
  50: {sin: 0.766, cos: 0.6428},
  51: {sin: 0.7771, cos: 0.6293},
  52: {sin: 0.788, cos: 0.6157},
  53: {sin: 0.7986, cos: 0.6018},
  54: {sin: 0.809, cos: 0.5878},
  55: {sin: 0.8192, cos: 0.5736},
  56: {sin: 0.829, cos: 0.5592},
  57: {sin: 0.8387, cos: 0.5446},
  58: {sin: 0.848, cos: 0.5299},
  59: {sin: 0.8572, cos: 0.515},
  60: {sin: 0.866, cos: 0.5},
  61: {sin: 0.8746, cos: 0.4848},
  62: {sin: 0.8829, cos: 0.4695},
  63: {sin: 0.891, cos: 0.454},
  64: {sin: 0.8988, cos: 0.4384},
  65: {sin: 0.9063, cos: 0.4226},
  66: {sin: 0.9135, cos: 0.4067},
  67: {sin: 0.9205, cos: 0.3907},
  68: {sin: 0.9272, cos: 0.3746},
  69: {sin: 0.9336, cos: 0.3584},
  70: {sin: 0.9397, cos: 0.342},
  71: {sin: 0.9455, cos: 0.3256},
  72: {sin: 0.9511, cos: 0.309},
  73: {sin: 0.9563, cos: 0.2924},
  74: {sin: 0.9613, cos: 0.2756},
  75: {sin: 0.9659, cos: 0.2588},
  76: {sin: 0.9703, cos: 0.2419},
  77: {sin: 0.9744, cos: 0.225},
  78: {sin: 0.9781, cos: 0.2079},
  79: {sin: 0.9816, cos: 0.1908},
  80: {sin: 0.9848, cos: 0.1736},
  81: {sin: 0.9877, cos: 0.1564},
  82: {sin: 0.9903, cos: 0.1392},
  83: {sin: 0.9925, cos: 0.1219},
  84: {sin: 0.9945, cos: 0.1045},
  85: {sin: 0.9962, cos: 0.0872},
  86: {sin: 0.9976, cos: 0.0698},
  87: {sin: 0.9986, cos: 0.0523},
  88: {sin: 0.9994, cos: 0.0349},
  89: {sin: 0.9998, cos: 0.0175},
  90: {sin: 1, cos: 0},
  91: {sin: 0.9998, cos: -0.0175},
  92: {sin: 0.9994, cos: -0.0349},
  93: {sin: 0.9986, cos: -0.0523},
  94: {sin: 0.9976, cos: -0.0698},
  95: {sin: 0.9962, cos: -0.0872},
  96: {sin: 0.9945, cos: -0.1045},
  97: {sin: 0.9925, cos: -0.1219},
  98: {sin: 0.9903, cos: -0.1392},
  99: {sin: 0.9877, cos: -0.1564},
  100: {sin: 0.9848, cos: -0.1736},
  101: {sin: 0.9816, cos: -0.1908},
  102: {sin: 0.9781, cos: -0.2079},
  103: {sin: 0.9744, cos: -0.2250},
  104: {sin: 0.9703, cos: -0.2419},
  105: {sin: 0.9659, cos: -0.2588},
  106: {sin: 0.9613, cos: -0.2756},
  107: {sin: 0.9563, cos: -0.2924},
  108: {sin: 0.9511, cos: -0.3090},
  109: {sin: 0.9455, cos: -0.3256},
  110: {sin: 0.9397, cos: -0.3420},
  111: {sin: 0.9336, cos: -0.3584},
  112: {sin: 0.9272, cos: -0.3746},
  113: {sin: 0.9205, cos: -0.3907},
  114: {sin: 0.9135, cos: -0.4067},
  115: {sin: 0.9063, cos: -0.4226},
  116: {sin: 0.8988, cos: -0.4384},
  117: {sin: 0.891, cos: -0.4540},
  118: {sin: 0.8829, cos: -0.4695},
  119: {sin: 0.8746, cos: -0.4848},
  120: {sin: 0.866, cos: -0.5000},
  121: {sin: 0.8572, cos: -0.5150},
  122: {sin: 0.848, cos: -0.5299},
  123: {sin: 0.8387, cos: -0.5446},
  124: {sin: 0.829, cos: -0.5592},
  125: {sin: 0.8192, cos: -0.5736},
  126: {sin: 0.809, cos: -0.5878},
  127: {sin: 0.7986, cos: -0.6018},
  128: {sin: 0.788, cos: -0.6157},
  129: {sin: 0.7771, cos: -0.6293},
  130: {sin: 0.766, cos: -0.6428},
  131: {sin: 0.7547, cos: -0.6561},
  132: {sin: 0.7431, cos: -0.6691},
  133: {sin: 0.7314, cos: -0.6820},
  134: {sin: 0.7193, cos: -0.6947},
  135: {sin: 0.7071, cos: -0.7071},
  136: {sin: 0.6947, cos: -0.7193},
  137: {sin: 0.682, cos: -0.7314},
  138: {sin: 0.6691, cos: -0.7431},
  139: {sin: 0.6561, cos: -0.7547},
  140: {sin: 0.6428, cos: -0.7660},
  141: {sin: 0.6293, cos: -0.7771},
  142: {sin: 0.6157, cos: -0.7880},
  143: {sin: 0.6018, cos: -0.7986},
  144: {sin: 0.5878, cos: -0.8090},
  145: {sin: 0.5736, cos: -0.8192},
  146: {sin: 0.5592, cos: -0.8290},
  147: {sin: 0.5446, cos: -0.8387},
  148: {sin: 0.5299, cos: -0.8480},
  149: {sin: 0.515, cos: -0.8572},
  150: {sin: 0.5, cos: -0.8660},
  151: {sin: 0.4848, cos: -0.8746},
  152: {sin: 0.4695, cos: -0.8829},
  153: {sin: 0.454, cos: -0.8910},
  154: {sin: 0.4384, cos: -0.8988},
  155: {sin: 0.4226, cos: -0.9063},
  156: {sin: 0.4067, cos: -0.9135},
  157: {sin: 0.3907, cos: -0.9205},
  158: {sin: 0.3746, cos: -0.9272},
  159: {sin: 0.3584, cos: -0.9336},
  160: {sin: 0.342, cos: -0.9397},
  161: {sin: 0.3256, cos: -0.9455},
  162: {sin: 0.309, cos: -0.9511},
  163: {sin: 0.2924, cos: -0.9563},
  164: {sin: 0.2756, cos: -0.9613},
  165: {sin: 0.2588, cos: -0.9659},
  166: {sin: 0.2419, cos: -0.9703},
  167: {sin: 0.225, cos: -0.9744},
  168: {sin: 0.2079, cos: -0.9781},
  169: {sin: 0.1908, cos: -0.9816},
  170: {sin: 0.1736, cos: -0.9848},
  171: {sin: 0.1564, cos: -0.9877},
  172: {sin: 0.1392, cos: -0.9903},
  173: {sin: 0.1219, cos: -0.9925},
  174: {sin: 0.1045, cos: -0.9945},
  175: {sin: 0.0872, cos: -0.9962},
  176: {sin: 0.0698, cos: -0.9976},
  177: {sin: 0.0523, cos: -0.9986},
  178: {sin: 0.0349, cos: -0.9994},
  179: {sin: 0.0175, cos: -0.9998},
  180: {sin: 0 - 1, cos: .0000},
  181: {sin: -0.0175, cos: -0.9998},
  182: {sin: -0.0349, cos: -0.9994},
  183: {sin: -0.0523, cos: -0.9986},
  184: {sin: -0.0698, cos: -0.9976},
  185: {sin: -0.0872, cos: -0.9962},
  186: {sin: -0.1045, cos: -0.9945},
  187: {sin: -0.1219, cos: -0.9925},
  188: {sin: -0.1392, cos: -0.9903},
  189: {sin: -0.1564, cos: -0.9877},
  190: {sin: -0.1736, cos: -0.9848},
  191: {sin: -0.1908, cos: -0.9816},
  192: {sin: -0.2079, cos: -0.9781},
  193: {sin: -0.2250, cos: -0.9744},
  194: {sin: -0.2419, cos: -0.9703},
  195: {sin: -0.2588, cos: -0.9659},
  196: {sin: -0.2756, cos: -0.9613},
  197: {sin: -0.2924, cos: -0.9563},
  198: {sin: -0.3090, cos: -0.9511},
  199: {sin: -0.3256, cos: -0.9455},
  200: {sin: -0.3420, cos: -0.9397},
  201: {sin: -0.3584, cos: -0.9336},
  202: {sin: -0.3746, cos: -0.9272},
  203: {sin: -0.3907, cos: -0.9205},
  204: {sin: -0.4067, cos: -0.9135},
  205: {sin: -0.4226, cos: -0.9063},
  206: {sin: -0.4384, cos: -0.8988},
  207: {sin: -0.4540, cos: -0.8910},
  208: {sin: -0.4695, cos: -0.8829},
  209: {sin: -0.4848, cos: -0.8746},
  210: {sin: -0.5000, cos: -0.8660},
  211: {sin: -0.5150, cos: -0.8572},
  212: {sin: -0.5299, cos: -0.8480},
  213: {sin: -0.5446, cos: -0.8387},
  214: {sin: -0.5592, cos: -0.8290},
  215: {sin: -0.5736, cos: -0.8192},
  216: {sin: -0.5878, cos: -0.8090},
  217: {sin: -0.6018, cos: -0.7986},
  218: {sin: -0.6157, cos: -0.7880},
  219: {sin: -0.6293, cos: -0.7771},
  220: {sin: -0.6428, cos: -0.7660},
  221: {sin: -0.6561, cos: -0.7547},
  222: {sin: -0.6691, cos: -0.7431},
  223: {sin: -0.6820, cos: -0.7314},
  224: {sin: -0.6947, cos: -0.7193},
  225: {sin: -0.7071, cos: -0.7071},
  226: {sin: -0.7193, cos: -0.6947},
  227: {sin: -0.7314, cos: -0.6820},
  228: {sin: -0.7431, cos: -0.6691},
  229: {sin: -0.7547, cos: -0.6561},
  230: {sin: -0.7660, cos: -0.6428},
  231: {sin: -0.7771, cos: -0.6293},
  232: {sin: -0.7880, cos: -0.6157},
  233: {sin: -0.7986, cos: -0.6018},
  234: {sin: -0.8090, cos: -0.5878},
  235: {sin: -0.8192, cos: -0.5736},
  236: {sin: -0.8290, cos: -0.5592},
  237: {sin: -0.8387, cos: -0.5446},
  238: {sin: -0.8480, cos: -0.5299},
  239: {sin: -0.8572, cos: -0.5150},
  240: {sin: -0.8660, cos: -0.5000},
  241: {sin: -0.8746, cos: -0.4848},
  242: {sin: -0.8829, cos: -0.4695},
  243: {sin: -0.8910, cos: -0.4540},
  244: {sin: -0.8988, cos: -0.4384},
  245: {sin: -0.9063, cos: -0.4226},
  246: {sin: -0.9135, cos: -0.4067},
  247: {sin: -0.9205, cos: -0.3907},
  248: {sin: -0.9272, cos: -0.3746},
  249: {sin: -0.9336, cos: -0.3584},
  250: {sin: -0.9397, cos: -0.3420},
  251: {sin: -0.9455, cos: -0.3256},
  252: {sin: -0.9511, cos: -0.3090},
  253: {sin: -0.9563, cos: -0.2924},
  254: {sin: -0.9613, cos: -0.2756},
  255: {sin: -0.9659, cos: -0.2588},
  256: {sin: -0.9703, cos: -0.2419},
  257: {sin: -0.9744, cos: -0.2250},
  258: {sin: -0.9781, cos: -0.2079},
  259: {sin: -0.9816, cos: -0.1908},
  260: {sin: -0.9848, cos: -0.1736},
  261: {sin: -0.9877, cos: -0.1564},
  262: {sin: -0.9903, cos: -0.1392},
  263: {sin: -0.9925, cos: -0.1219},
  264: {sin: -0.9945, cos: -0.1045},
  265: {sin: -0.9962, cos: -0.0872},
  266: {sin: -0.9976, cos: -0.0698},
  267: {sin: -0.9986, cos: -0.0523},
  268: {sin: -0.9994, cos: -0.0349},
  269: {sin: -0.9998, cos: -0.0175},
  270: {sin: -1.0000, cos: 0},
  271: {sin: -0.9998, cos: 0.0175},
  272: {sin: -0.9994, cos: 0.0349},
  273: {sin: -0.9986, cos: 0.0523},
  274: {sin: -0.9976, cos: 0.0698},
  275: {sin: -0.9962, cos: 0.0872},
  276: {sin: -0.9945, cos: 0.1045},
  277: {sin: -0.9925, cos: 0.1219},
  278: {sin: -0.9903, cos: 0.1392},
  279: {sin: -0.9877, cos: 0.1564},
  280: {sin: -0.9848, cos: 0.1736},
  281: {sin: -0.9816, cos: 0.1908},
  282: {sin: -0.9781, cos: 0.2079},
  283: {sin: -0.9744, cos: 0.225},
  284: {sin: -0.9703, cos: 0.2419},
  285: {sin: -0.9659, cos: 0.2588},
  286: {sin: -0.9613, cos: 0.2756},
  287: {sin: -0.9563, cos: 0.2924},
  288: {sin: -0.9511, cos: 0.309},
  289: {sin: -0.9455, cos: 0.3256},
  290: {sin: -0.9397, cos: 0.342},
  291: {sin: -0.9336, cos: 0.3584},
  292: {sin: -0.9272, cos: 0.3746},
  293: {sin: -0.9205, cos: 0.3907},
  294: {sin: -0.9135, cos: 0.4067},
  295: {sin: -0.9063, cos: 0.4226},
  296: {sin: -0.8988, cos: 0.4384},
  297: {sin: -0.8910, cos: 0.454},
  298: {sin: -0.8829, cos: 0.4695},
  299: {sin: -0.8746, cos: 0.4848},
  300: {sin: -0.8660, cos: 0.5},
  301: {sin: -0.8572, cos: 0.515},
  302: {sin: -0.8480, cos: 0.5299},
  303: {sin: -0.8387, cos: 0.5446},
  304: {sin: -0.8290, cos: 0.5592},
  305: {sin: -0.8192, cos: 0.5736},
  306: {sin: -0.8090, cos: 0.5878},
  307: {sin: -0.7986, cos: 0.6018},
  308: {sin: -0.7880, cos: 0.6157},
  309: {sin: -0.7771, cos: 0.6293},
  310: {sin: -0.7660, cos: 0.6428},
  311: {sin: -0.7547, cos: 0.6561},
  312: {sin: -0.7431, cos: 0.6691},
  313: {sin: -0.7314, cos: 0.682},
  314: {sin: -0.7193, cos: 0.6947},
  315: {sin: -0.7071, cos: 0.7071},
  316: {sin: -0.6947, cos: 0.7193},
  317: {sin: -0.6820, cos: 0.7314},
  318: {sin: -0.6691, cos: 0.7431},
  319: {sin: -0.6561, cos: 0.7547},
  320: {sin: -0.6428, cos: 0.766},
  321: {sin: -0.6293, cos: 0.7771},
  322: {sin: -0.6157, cos: 0.788},
  323: {sin: -0.6018, cos: 0.7986},
  324: {sin: -0.5878, cos: 0.809},
  325: {sin: -0.5736, cos: 0.8192},
  326: {sin: -0.5592, cos: 0.829},
  327: {sin: -0.5446, cos: 0.8387},
  328: {sin: -0.5299, cos: 0.848},
  329: {sin: -0.5150, cos: 0.8572},
  330: {sin: -0.5000, cos: 0.866},
  331: {sin: -0.4848, cos: 0.8746},
  332: {sin: -0.4695, cos: 0.8829},
  333: {sin: -0.4540, cos: 0.891},
  334: {sin: -0.4384, cos: 0.8988},
  335: {sin: -0.4226, cos: 0.9063},
  336: {sin: -0.4067, cos: 0.9135},
  337: {sin: -0.3907, cos: 0.9205},
  338: {sin: -0.3746, cos: 0.9272},
  339: {sin: -0.3584, cos: 0.9336},
  340: {sin: -0.3420, cos: 0.9397},
  341: {sin: -0.3256, cos: 0.9455},
  342: {sin: -0.3090, cos: 0.9511},
  343: {sin: -0.2924, cos: 0.9563},
  344: {sin: -0.2756, cos: 0.9613},
  345: {sin: -0.2588, cos: 0.9659},
  346: {sin: -0.2419, cos: 0.9703},
  347: {sin: -0.2250, cos: 0.9744},
  348: {sin: -0.2079, cos: 0.9781},
  349: {sin: -0.1908, cos: 0.9816},
  350: {sin: -0.1736, cos: 0.9848},
  351: {sin: -0.1564, cos: 0.9877},
  352: {sin: -0.1392, cos: 0.9903},
  353: {sin: -0.1219, cos: 0.9925},
  354: {sin: -0.1045, cos: 0.9945},
  355: {sin: -0.0872, cos: 0.9962},
  356: {sin: -0.0698, cos: 0.9976},
  357: {sin: -0.0523, cos: 0.9986},
  358: {sin: -0.0349, cos: 0.9994},
  359: {sin: -0.0175, cos: 0.9998},
  360: {sin: 0, cos: 1},
}
