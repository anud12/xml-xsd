import {MutationMiddleware, MutationResult} from "../_type";
import {JsonUtil} from "../../utils/util";
import {JsonSchema, NodeGraphQueryType} from "../../utils/JsonSchema";
import {LinkToQueryType} from "../../utils/locationGraph/selectLinkTo";
import {NodeQueryType} from "../../utils/locationGraph/createAdjacent";
import e from "express";
import {mergeError} from "../../mergeError";

type PersonMoveToQueryElement = JsonSchema["children"]["actions"]["children"]["person.move_to"]
type PathQueryElement = PersonMoveToQueryElement["children"]["path"]
type PathNodeQueryElement = PathQueryElement["children"]["node"];

type LinkToPersonQueryElement = LinkToQueryType["children"]["people"]["children"]["person"];

const applyFindPath = (readJson: JsonUtil, personMoveToElement: PersonMoveToQueryElement): MutationResult | undefined => {
  const findPathTowardsElement = personMoveToElement.queryOptional("find_path_towards");
  if (!findPathTowardsElement) {
    return;
  }

  const person_id_ref = personMoveToElement.attributeMap.person_id_ref;

  let originNodeList = readJson.json.queryAllOptional("location_graph")
    .flatMap(locationGraphElement => {
      return locationGraphElement.queryAllOptional("node").find(nodeElement => {
        return nodeElement.queryAllOptional("people").find(peopleElement => {
          return peopleElement.queryAllOptional("person")
            .find(personElement => personElement.attributeMap.person_id_ref === person_id_ref)
        })
      });
    })
  let originNode = originNodeList[0];
  if (!originNode) {

    originNode = readJson.json.queryAllOptional("location_graph")
      .flatMap(locationGraphElement =>
        locationGraphElement.queryAllOptional("node")
          )
      .find(nodeElement => {
        return nodeElement.queryAllOptional("link_to")
          .flatMap(linkToELement => linkToELement.queryAllOptional("people"))
          .flatMap(peopleElement => peopleElement.queryAllOptional("person"))
          .find(personElement => personElement.attributeMap.person_id_ref === person_id_ref)
      })
    if(!originNode){
      return
    }

  }
  const locationGraph = readJson.json.queryAllOptional("location_graph").find(locationGraphElement => {
    return locationGraphElement.queryAllOptional("node")
      .find(nodeElement => nodeElement.attributeMap.id === originNode.attributeMap.id)
  })

  const destinationNode = readJson.locationGraph.selectNodeGraph(findPathTowardsElement)

  const nodePath = readJson.locationGraph.shortestPathsInGraphExcludeStart(locationGraph,
    originNode,
    readJson.randomFromArray(destinationNode),
    1
  );

  return async (writeUnit: JsonUtil) => {
    personMoveToElement.removeFromParent();
    let actionElement = writeUnit.json.queryOptional("actions")
    if (!actionElement) {
      actionElement = writeUnit.json.appendChild("actions");
    }
    if (!nodePath.length) {
      return;
    }
    const personMoveTo = actionElement.appendChild("person.move_to", undefined, {
      person_id_ref: person_id_ref
    })

    const path = personMoveTo.appendChild("path")
    nodePath[0].forEach(nodeElement => {
      path.appendChild("node", undefined, {
        node_id_ref: nodeElement.attributeMap.id
      })
    })
  }
}


const applyPathRecursiveFromLink = (readJson: JsonUtil, pathElement: PathQueryElement, destinationNodeList: Array<PathNodeQueryElement>, person_id_ref: string): MutationResult | undefined => {

  let personLinkElement: LinkToPersonQueryElement;
  let linkElement = readJson.json.queryAllOptional("location_graph").flatMap(locationGraphElement => locationGraphElement.queryAllOptional("node"))
    .flatMap(nodeElement => nodeElement.queryAllOptional("link_to"))
    .find(linkToElement => {
        const person = linkToElement.queryAllOptional("people")
          .flatMap(peopleElement => peopleElement.queryAllOptional("person"))
          .find(personElement => personElement.attributeMap.person_id_ref === person_id_ref)
        personLinkElement = person;
        return person;
      }
    )
  if (!linkElement) {
    return;
  }

  console.log("applyPathRecursiveFromLink Link element", linkElement.attributeMap.node_id_ref);

  const progressProperty = linkElement.queryOptional("person_progress_property");
  if (!progressProperty) {
    return;
  }
  const accumulatedProgress = Number(personLinkElement.attributeMap.accumulated_progress ?? "0")
  const progressValue = Number(readJson.computeOperationFromParent(progressProperty)) + accumulatedProgress;
  const totalProgress = Number(linkElement.attributeMap.total_progress);

  console.log("applyPathRecursiveFromLink Progress value", progressValue, totalProgress);

  if (progressValue >= totalProgress) {
    const nextRemainingProgressFraction = (progressValue - totalProgress) / progressValue;
    console.log("applyPathRecursiveFromLink Next remaining progress fraction", nextRemainingProgressFraction);
    return applyPathRecursive(readJson, pathElement, linkElement.attributeMap.node_id_ref, destinationNodeList, person_id_ref, nextRemainingProgressFraction);
  }
  return async writeJson => {
    writeJson.locationGraph.removePerson(person_id_ref);
    const peopleElement = linkElement.queryOrAppend("people");
    peopleElement.appendChild("person", null, {
      person_id_ref: person_id_ref,
      accumulated_progress: Math.trunc(progressValue)
    })

  }
}

const applyPathRecursive = (readJson: JsonUtil, pathElement: PathQueryElement, currentNodeId: string, destinationNodeList: Array<PathNodeQueryElement>, person_id_ref: string, remainingProgressFraction: number) => {

  try {
    console.log("applyPathRecursive", currentNodeId, destinationNodeList.map(e => e.attributeMap.node_id_ref), person_id_ref, remainingProgressFraction);
    const destinationNode = destinationNodeList.shift();

    const originNode = readJson.json.queryAllOptional("location_graph").flatMap(locationGraphElement => locationGraphElement.queryAllOptional("node"))
      .find(nodeElement => nodeElement.attributeMap.id === currentNodeId);

    const linkElement = originNode.queryAllOptional("link_to").find(linkToElement => {
      return linkToElement.attributeMap.node_id_ref === destinationNode.attributeMap.node_id_ref
    })

    if (!linkElement) {

      readJson.locationGraph.removePerson(person_id_ref);

      console.log("applyPathRecursive linkElement not found", destinationNode?.attributeMap.node_id_ref);
      originNode.queryOrAppend("people").appendChild("person", null, {
        person_id_ref: person_id_ref
      })
      return;
    }
    const progressProperty = linkElement.queryOptional("person_progress_property");
    if (!progressProperty) {
      console.log("applyPathRecursive progressProperty not found");
      return;
    }
    const progressValue = Number(readJson.computeOperationFromParent(progressProperty)) * remainingProgressFraction;
    const totalProgress = Number(linkElement.attributeMap.total_progress);

    if (progressValue === 0) {
      readJson.locationGraph.removePerson(person_id_ref);
      const endNode = readJson.json.queryAllOptional("location_graph").flatMap(locationGraphElement => locationGraphElement.queryAllOptional("node"))
        .find(e => e.attributeMap.id === destinationNode.attributeMap.node_id_ref);
      console.log("applyPathRecursive progressValue === 0");
      endNode.queryOrAppend("people").appendChild("person", null, {
        person_id_ref: person_id_ref
      })

      return;
    }

    if (progressValue >= totalProgress) {
      const nextRemainingProgressFraction = (progressValue - totalProgress) / progressValue;
      destinationNode.removeFromParent();

      console.log("applyPathRecursive progressValue >= totalProgress nextRemainingProgressFraction", nextRemainingProgressFraction);
      return applyPathRecursive(readJson, pathElement, destinationNode.attributeMap.node_id_ref, destinationNodeList, person_id_ref, nextRemainingProgressFraction)
    }

    readJson.locationGraph.removePerson(person_id_ref);
    const peopleElement = linkElement.queryOrAppend("people");
    const accumulated_progress = Math.trunc(progressValue);
    console.log(`applyPathRecursive on link ${linkElement.attributeMap.node_id_ref} with accumulated_progress ${accumulated_progress} truncated from ${progressValue}`);
    peopleElement.appendChild("person", null, {
      person_id_ref: person_id_ref,
      accumulated_progress: accumulated_progress
    })
  } catch (e) {
    throw mergeError(e, new Error(`Error in applyPathRecursive computing by element ${pathElement.getPath()}`));
  }


}


const applyPath = (readJson: JsonUtil, personMoveToElement: PersonMoveToQueryElement): MutationResult => {
  try {

    const pathElement = personMoveToElement.queryOptional("path");
    if (!pathElement) {
      return;
    }

    const destinationNode = pathElement.queryAllOptional("node").filter(element => element)

    if (!destinationNode) {
      return async (writeUnit) => {
        personMoveToElement.removeFromParent();
      };
    }

    const person_id_ref = personMoveToElement.attributeMap.person_id_ref;

    const hasExecuted = applyPathRecursiveFromLink(readJson, pathElement, destinationNode, person_id_ref);
    if (hasExecuted) {
      return hasExecuted
    }

    const originNodeList = readJson.json.queryAllOptional("location_graph")
      .flatMap(locationGraphElement => {
        return locationGraphElement.queryAllOptional("node").find(nodeElement => {
          return nodeElement.queryAllOptional("people").find(peopleElement => {
            return peopleElement.queryAllOptional("person")
              .find(personElement => personElement.attributeMap.person_id_ref === person_id_ref)
          })
        });
      })
    const originNode = originNodeList[0];
    if (!originNode) {
      return;
    }


    return async writeUnit => {
      applyPathRecursive(writeUnit, pathElement, originNode.attributeMap.id, destinationNode, person_id_ref, 1);
      if (pathElement.queryAllOptional("node").length === 0) {
        pathElement.removeFromParent();
      }
    }
  } catch (e) {
    throw mergeError(e, new Error(`Error in applyPath computing by element ${personMoveToElement.getPath()}`));
  }
}


export const personMoveTo: MutationMiddleware = (readJson) => {

  const actions = readJson.json.queryAllOptional("actions")
    .flatMap(actionsElement => actionsElement.queryAllOptional("person.move_to"))

  const applicable: Array<MutationResult> = actions.map(personMoveToElement => {
    return applyFindPath(readJson, personMoveToElement) || applyPath(readJson, personMoveToElement);
  }).filter(e => e);

  return async writeUnit => {

    await Promise.all(applicable.map(func => func(writeUnit)));
    actions.forEach(action => {
      if (!(action.queryAllOptional("path").length === 0)) {
        return
      }
      if (!(action.queryAllOptional("find_path_towards").length === 0)) {
        return
      }
      action.removeFromParent();
    })

  }
}