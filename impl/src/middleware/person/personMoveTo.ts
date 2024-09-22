import {MutationMiddleware} from "../_type";
import {JsonUtil} from "../../utils/util";
import {JsonSchema} from "../../utils/JsonSchema";

type PersonMoveToQueryElement = JsonSchema["children"]["actions"]["children"]["person.move_to"]

const applyFindPath = (readJson: JsonUtil, personMoveToElement: PersonMoveToQueryElement) => {
  const findPathTowardsElement = personMoveToElement.queryOptional("find_path_towards");
  if (!findPathTowardsElement) {
    return () => {
    };
  }

  const person_id_ref = personMoveToElement.attributeMap.person_id_ref;

  const originNodeList = readJson.json.queryAllOptional("location_graph")
    .flatMap(locationGraphElement => {
      return locationGraphElement.queryAllOptional("node").find(nodeElement => {
        return nodeElement.queryAllOptional("people").find(peopleElement => {
          return peopleElement.queryAllOptional("person")
            .find(personElement => personElement.attributeMap.person_id_ref)
        })
      });
    })
  const originNode = originNodeList[0];
  if(!originNode) {
    return () => {}
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

  return (writeUnit: JsonUtil) => {
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


export const personMoveTo: MutationMiddleware = (readJson) => {

  const actions = readJson.json.queryAllOptional("actions")
    .flatMap(actionsElement => actionsElement.queryAllOptional("person.move_to"))

  const applicable = actions.map(personMoveToElement => {
    return applyFindPath(readJson, personMoveToElement);
  })

  return async writeUnit => {

    await Promise.all(applicable.map(func => func(writeUnit)));
  }
}