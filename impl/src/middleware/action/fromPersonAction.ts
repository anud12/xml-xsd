import {MutationMiddleware, MutationResult} from "../_type";
import {JsonUtil} from "../../utils/util";
import {JsonSchema} from "../../utils/JsonSchema";
import {PersonQueryType} from "../../utils/person/setProperty";

export type FromPersonQueryElement = JsonSchema["children"]["rule_group"]["children"]["action_rule"]["children"]["from_person"]
export type OnPersonQueryElement = FromPersonQueryElement["children"]["on_person"]

const onPersonHandle = (writeUnit: JsonUtil, onPersonQueryElement: OnPersonQueryElement, originPerson: PersonQueryType, targetPerson: PersonQueryType): MutationResult[] => {
  return onPersonQueryElement
    ?.queryOptional("mutations")
    ?.queryAllOptional("property_mutation")
    ?.flatMap(property_mutation => {
      return writeUnit.person.applyPropertyMutation(targetPerson, property_mutation, targetPerson, originPerson);
    });
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
      const result = actionElement.queryAllOptional("on_person").flatMap(on_person => {
        const targetPerson = personList.find(person => person.attributeMap.id === on_person.attributeMap.person_id_ref);
        let selfResult = actionRule.queryOptional("mutations")
          ?.queryAllOptional("property_mutation")
          ?.map(property_mutation => {
            return writeUnit.person.applyPropertyMutation(selfPerson, property_mutation, selfPerson, targetPerson);
          })
        const onPersonRule = actionRule.queryOptional("on_person");
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
