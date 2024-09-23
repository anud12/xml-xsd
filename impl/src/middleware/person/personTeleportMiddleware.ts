import {MutationMiddleware} from "../_type";
import {JsonUtil} from "../../utils/util";
import {JsonSchema} from "../../utils/JsonSchema";

type PersonTeleportQueryType = JsonSchema["children"]["actions"]["children"]["person.teleport"];

const locationGraph = (readJson: JsonUtil, action: PersonTeleportQueryType) => {
  const personIdRef = action.attributeMap.person_id_ref;
  const targetLocationGraphId = action.queryOptional("location_graph")?.attributeMap.location_graph_id_ref;
  if (targetLocationGraphId === undefined) {
    return undefined;
  }
  return async (writeJson: JsonUtil) => {
    action.removeFromParent();


    const locationGraphList = writeJson.json.queryAllOptional("location_graph");
    const locationGraph = locationGraphList
      .find(locationGraph => locationGraph.attributeMap.id === targetLocationGraphId)

    if (!locationGraph) {
      return;
    }
    writeJson.locationGraph.removePerson(personIdRef);

    const targetNodeId = action.queryOptional("location_graph")?.attributeMap.node_id_ref;
    const node = locationGraph.queryAllOptional("node").find(node => node.attributeMap.id === targetNodeId);
    if (!node) {
      return;
    }
    const people = node.queryOptional("people") ?? node.appendChild("people");
    people.appendChild("person", undefined, {
      person_id_ref: personIdRef
    })
  }
}

const linkToNode = (readJson: JsonUtil, action: PersonTeleportQueryType) => {
  const personIdRef = action.attributeMap.person_id_ref;

  const linkToAction = action.queryOptional("link_to");
  return async (writeJson: JsonUtil) => {
    action.removeFromParent();
    const linkQueryType = writeJson.locationGraph.selectLinkTo(linkToAction.queryOptional("selection"))
    if (linkQueryType.length === 0) {
      return;
    }
    writeJson.locationGraph.removePerson(personIdRef);
    const linkTo = writeJson.randomFromArray(linkQueryType);

    const people = linkTo.queryOptional("people") ?? linkTo.appendChild("people");

    people.appendChild("person", undefined, {
      person_id_ref: personIdRef,
      accumulated_progress: linkToAction.attributeMap.accumulated_progress
    })
  }
}

export const personTeleportMiddleware: MutationMiddleware = (readJson) => {

  const actionList = readJson.json.queryAllOptional("actions")
    .flatMap(actionsElement => actionsElement.queryAllOptional("person.teleport"));


  const actions = actionList.map(action => {
    let locationGraphAction = locationGraph(readJson, action);
    if (locationGraphAction) {
      return locationGraphAction;
    }
    const linkToNodeResult = linkToNode(readJson, action);
    if(linkToNodeResult){
      return linkToNodeResult;
    }
    return async () => {
      action.removeFromParent();
    }
  })

  return async (writeJson) => {
    await Promise.all(actions.map(action => action(writeJson)));
    return;
  }
}