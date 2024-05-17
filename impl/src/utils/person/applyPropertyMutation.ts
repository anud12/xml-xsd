import {JsonUtil} from "../util";
import {PersonQueryType} from "./getPersonProperty";
import {PropertyMutationQueryType} from "../JsonSchema";

export const applyPropertyMutation = (readJson: JsonUtil, personQueryType: PersonQueryType, propertyMutation: PropertyMutationQueryType | undefined, getPropertyTarget?: (key: string) => string) => {

  const fromElement = propertyMutation?.queryOptional("from")
  const propertyRuleRef = propertyMutation?.attributeMap?.property_rule_ref;

  let getProperty = getPropertyTarget;

  if (fromElement?.attributeMap.participant === "self") {
    getProperty = (key) => readJson.person.getProperty(personQueryType, key);
  }

  const value = readJson.computeOperationFromParent(fromElement?.queryOptional("operation"), getProperty)

  return async (writeJson: JsonUtil) => {
    if(!value) {
      return
    }

    writeJson.json.queryAllOptional("people").flatMap(peopleElement => peopleElement.queryAllOptional("person"))
      .flatMap(personElement => personElement.queryAllOptional("properties"))
      .flatMap(property => property.queryAllOptional("property"))
      .filter(element => element.attributeMap.property_rule_ref === propertyRuleRef)
      .forEach(fromElement => {
        fromElement.attributeMap.value = value;
      })

  }
}