import {MutationMiddleware, MutationResult} from "../_type";
import {JsonUtil} from "../../utils/util";
import {JsonSchema} from "../../utils/JsonSchema";
import {PersonQueryType} from "../../utils/person/setProperty";

export type FromPersonQueryElement = JsonSchema["children"]["rule_group"]["children"]["action_rule"]["children"]["from_person"]
export type OnPersonRuleQueryElement = FromPersonQueryElement["children"]["on_person"]
export type FromPersonSameLocationGraphNode = OnPersonRuleQueryElement["children"]["selection"]["children"]["from_person_same_location_graph_node"];

const onPersonHandle = (writeUnit: JsonUtil, onPersonQueryElement: OnPersonRuleQueryElement, originPerson: PersonQueryType, targetPerson: PersonQueryType): MutationResult[] => {
  return onPersonQueryElement
    ?.queryOptional("mutations")
    ?.queryAllOptional("property_mutation")
    ?.flatMap(property_mutation => {
      return writeUnit.person.applyPropertyMutation(targetPerson, property_mutation, targetPerson, originPerson);
    });
}


const isFromPersonSameLocationGraphNode = (writeUnit: JsonUtil, originPerson: PersonQueryType, targetPerson: PersonQueryType, fromPersonSameLocationGraphNode?: FromPersonSameLocationGraphNode): boolean => {
  if (!fromPersonSameLocationGraphNode) {
    return true;
  }
  const originLocation = writeUnit.locationGraph.findPersonLocation(originPerson.attributeMap.id);
  const targetLocation = writeUnit.locationGraph.findPersonLocation(targetPerson.attributeMap.id);

  if (originLocation.length === 0 || targetLocation.length === 0) {
    return false;
  }

  const commonLocation = originLocation.find(originLocation => {
    return targetLocation.find(targetLocation => {
      return originLocation?.locationGraph?.attributeMap?.id === targetLocation?.locationGraph?.attributeMap?.id
        && originLocation?.node?.attributeMap?.id === targetLocation?.node?.attributeMap?.id
    })
  })
  const applicable = fromPersonSameLocationGraphNode?.attributeMap?.value === "true";
  if (applicable) {
    return !!commonLocation;
  } else {
    return !commonLocation;
  }
}

const onPersonApplicable = (writeUnit: JsonUtil, originPerson: PersonQueryType, targetPerson: PersonQueryType, onPersonQueryElement: OnPersonRuleQueryElement,): boolean => {
  const selection = onPersonQueryElement.queryOptional("selection");
  const fromPersonSameLocationGraphNode = selection?.queryOptional("from_person_same_location_graph_node")
  if (!isFromPersonSameLocationGraphNode(writeUnit, originPerson, targetPerson, fromPersonSameLocationGraphNode)) {
    return false;
  }
  if (!writeUnit.person.isSelectionApplicableTo(selection, targetPerson)) {
    return false;
  }
  return true;

}


export const fromPersonActionMiddleware: MutationMiddleware = readJson => {
  const actionMetadataList = readJson.getRuleGroups()
    .flatMap(rule_group => rule_group.queryAllOptional("action_rule"))
    .flatMap(action_rule => action_rule.queryAllOptional("from_person"));

  const actionElementList = readJson.json.queryOptional("actions")
    ?.queryAllOptional("from_person")

  return async writeUnit => {
    if (!(actionElementList)) {
      return;
    }

    const people = writeUnit.json.queryOptional("data")?.queryOptional("people");
    if (!people) {
      return
    }


    const result = actionElementList.flatMap(actionElement => {
      const actionRule = actionMetadataList.find(metadata => metadata.attributeMap.id === actionElement.attributeMap.from_person_rule_ref);
      if (!actionRule) {
        return [];
      }
      const action: Array<(writeUnit: JsonUtil) => Promise<void>> = [];
      const personList = people.queryAllOptional("person");
      const selfPerson = personList.find(person => person.attributeMap.id === actionElement.attributeMap.person_id_ref);

      const selfSelection = actionRule.queryOptional("selection");
      if (selfSelection) {
        if (!writeUnit.person.isSelectionApplicableTo(selfSelection, selfPerson)) {
          return
        }
      }

      const result = actionElement.queryAllOptional("on_person")
        .flatMap(on_person => {
          const onPersonRule = actionRule.queryOptional("on_person");
          const targetPerson = personList.find(person => person.attributeMap.id === on_person.attributeMap.person_id_ref);

          if (!onPersonApplicable(writeUnit, selfPerson, targetPerson, onPersonRule)) {
            return;
          }

          let selfResult = actionRule.queryOptional("mutations")
            ?.queryAllOptional("property_mutation")
            ?.map(property_mutation => {
              return writeUnit.person.applyPropertyMutation(selfPerson, property_mutation, selfPerson, targetPerson);
            })

          const handleResult = onPersonHandle(writeUnit, onPersonRule, selfPerson, targetPerson);
          return [...(selfResult ?? []), ...(handleResult ?? [])]
        })
      action.push(...result);
      return action;
    });

    await Promise.all(result.map(e => e?.(writeUnit)));

    writeUnit.json.queryOptional("actions")
      ?.queryAllOptional("from_person")
      ?.forEach(from_person => from_person.removeFromParent());
  }
}
