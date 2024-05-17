import {MutationMiddleware} from "./_type";
import {mergeError} from "../mergeError";
import {JsonUtil} from "../utils/util";
import {GlobalActionQueryType, JsonSchema} from "../utils/JsonSchema";

type ByElement = JsonSchema["children"]["actions"]["children"]["by"];

const isApplicable = (readJson: JsonUtil, globalRules: GlobalActionQueryType[], byElement: ByElement): boolean => {
  const doElement = byElement.queryOptional("do");
  const ref = doElement?.attributeMap.action_ref
  const rule = globalRules.find(element => element.attributeMap.id === ref);

  const fromPersonElement = rule?.queryAllOptional("from")
    .flatMap(fromElement => fromElement.queryAllOptional("person"))
    .flatMap(personElement => {
      return readJson.person.selectPerson(personElement.queryOptional("select"))
        .find(e => e.attributeMap.id === byElement.attributeMap.person_ref);
    })
  .filter(e => e);

  const onPersonElement = rule?.queryAllOptional("on")
    .flatMap(fromElement => fromElement.queryAllOptional("person"))
    .flatMap(personElement => readJson.person.selectPerson(personElement.queryOptional("select")))
  const anyEmpty = fromPersonElement?.length === 0 || onPersonElement?.length === 0;
  return !anyEmpty;
}

const applyOn = (readJson: JsonUtil, globalRules: GlobalActionQueryType[], byElement: ByElement): Array<((writeJson: JsonUtil) => Promise<void>)> => {
  const actionRef = byElement.queryOptional("do")?.attributeMap?.action_ref
  const rule = globalRules.find(element => element.attributeMap.id === actionRef);
  const elementList =  rule?.queryAllOptional("on") ?? []
  return elementList.flatMap(onElement => onElement.queryOptional("person"))
    .flatMap(rule => {
      const personList = readJson.person.selectPerson(rule.queryOptional("select"))
      const mutations = personList.map(personElement => readJson.person.applyPropertyMutation(personElement, rule.queryOptional("property_mutation")))
      return mutations;
    });
}

const applyFrom = (readJson: JsonUtil, globalRules: GlobalActionQueryType[], byElement: ByElement): Array<((writeJson: JsonUtil) => Promise<void>)> => {
  const actionRef = byElement.queryOptional("do")?.attributeMap?.action_ref
  const rule = globalRules.find(element => element.attributeMap.id === actionRef);
  const elementList = rule?.queryAllOptional("from") ?? []

  return elementList.flatMap(onElement => onElement.queryOptional("person"))
    .flatMap(rule => {
      const personList = readJson.person.selectPerson(rule.queryOptional("select"))
      .filter(person => person.attributeMap.id === byElement.attributeMap.person_ref)
      const mutations = personList.map(personElement => readJson.person.applyPropertyMutation(personElement, rule.queryOptional("property_mutation")))
      return mutations;
    })
}


export const globalAction: MutationMiddleware = (readJson) => {
  try {
    const globalRules = readJson.getRuleGroups()
      .flatMap(value => {
        return value.queryAllOptional("action_rule")
      })
      .flatMap(value => {
        return value.queryAllOptional("global")
      })
      .flatMap(value => {
        return value.queryAllOptional("entry")
      })
    const byList = readJson.json.queryAllOptional("actions")
      .flatMap(value => value.queryAllOptional("by"))
      .filter(byElement => isApplicable(readJson, globalRules, byElement));

    const callbackList = byList.flatMap(byElement => {
      return [
        ...applyOn(readJson, globalRules, byElement),
        ...applyFrom(readJson, globalRules, byElement)
      ]
    })

    return async (writeJson) => {
      await Promise.all(callbackList.map(callback => callback(writeJson)))
    }
  } catch (e: any) {
    throw mergeError(e, new Error("Error in globalAction middleware"));
  }

}