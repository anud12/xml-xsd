import {JsonUtil} from "../util";
import {JsonSchema} from "../JsonSchema";
import {mergeError} from "../../mergeError";

export type LocationGraphQueryType = JsonSchema["children"]["data"]["children"]["location"]["children"]["location_graph"]
export type LocationGraphNodeQueryType = LocationGraphQueryType["children"]["node"];
export type PositionQueryType = LocationGraphNodeQueryType["children"]["position"];

export const createGraphNode = (readJson: JsonUtil, locationQueryGraph: LocationGraphQueryType, ref: string, position: PositionQueryType["attributeMap"] = {
  x: "0",
  y: "0"
}, classificationLocation: string[] = []): (writeUnit: JsonUtil) => Promise<LocationGraphNodeQueryType> => {
  try {
    return async (writeUnit) => {
      console.log(`createGraphNode from locationQueryGraph ${locationQueryGraph.getPath()} and ref ${ref} at position ${position}`)

      const locationGraphRule = readJson.getRuleGroups().flatMap(ruleGroups => ruleGroups.queryAllOptional("location_graph_rule"))
        .find(locationQueryGraphRuleElement => locationQueryGraphRuleElement.attributeMap.id === locationQueryGraph.queryOptional("rule")?.attributeMap.location_graph_rule_ref)
      const nodeRule = locationGraphRule?.queryAllOptional("node_rule")
        ?.find(nodeRuleElement => nodeRuleElement.attributeMap.id === ref);

      if (!nodeRule) {
        return;
      }

      const nodeElement = locationQueryGraph.appendChild("node", undefined, {
        node_rule_ref: ref,
        id: writeUnit.getNextId(),
      })


      const nameRuleRef = nodeRule.queryOptional("name");

      if (nameRuleRef) {
        const name = readJson.name.calculateNameFromRefString(nameRuleRef.attributeMap.name_rule_ref);
        nodeElement.appendChild("name", null, {
          value: name
        })

      }

      const existingPersonRule = nodeRule.queryOptional("existing_person");

      existingPersonRule?.queryAllOptional("person_selection").forEach(personElement => {
        const min = existingPersonRule.attributeMap.min;
        let max = existingPersonRule.attributeMap.max ?? min;
        const iterations = writeUnit.randomBetweenInt(Number(min), Number(max));
        console.log(`createAdjacent populating "${iterations}" people due to ${personElement.getPath()}`)


        let peopleElement = nodeElement.appendChild("people");
        for (let i = 0; i < iterations; i++) {
          const person = writeUnit.person.createPerson(personElement);
          peopleElement.appendChild("person", undefined, {
            person_id_ref: person.attributeMap.id
          });
        }
      })

      nodeElement.appendChild("position", undefined, position)
      if (classificationLocation?.length) {
        const classificationElement = nodeElement.appendChild("classifications")
        classificationLocation.forEach(classification => {
          classificationElement.appendChild("classification", undefined, {
            location_classification_rule_ref: classification
          })
        })
      }
      return nodeElement;
    }
  } catch (e) {
    throw mergeError(e, new Error(`Error in createGraphNode failed for locationQueryGraph:${locationQueryGraph?.getPath()} and ref:${ref}`));
  }
}