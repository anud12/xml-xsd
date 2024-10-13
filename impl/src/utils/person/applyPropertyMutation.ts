import {JsonUtil} from "../util";
import {PersonQueryType} from "./getPersonProperty";
import {PropertyMutationQueryType} from "../JsonSchema";

export const oldApplyPropertyMutation = (readJson: JsonUtil, personQueryType: PersonQueryType, propertyMutation: PropertyMutationQueryType | undefined, getPropertyTarget?: (key: string) => string) => {

  const fromElement = propertyMutation?.queryOptional("from")
  const propertyRuleRef = propertyMutation?.attributeMap?.property_rule_ref;

  let getProperty = getPropertyTarget;

  if (fromElement?.attributeMap.participant === "self") {
    getProperty = (key) => readJson.person.getProperty(personQueryType, key);
  }

  const value = readJson.computeOperationFromParent(fromElement?.queryOptional("operation"), getProperty)

  return async (writeJson: JsonUtil) => {
    if (!value) {
      return
    }

    writeJson.json.queryOptional("data").queryAllOptional("people")
      .flatMap(peopleElement => peopleElement.queryAllOptional("person"))
      .filter(personElement => personElement.attributeMap.id === personQueryType.attributeMap.id)
      .flatMap(personElement => personElement.queryAllOptional("properties"))
      .flatMap(property => property.queryAllOptional("property"))
      .filter(element => element.attributeMap.property_rule_ref === propertyRuleRef)
      .forEach(fromElement => {
        const currentValue = Number(fromElement.attributeMap.value)
        if (isNaN(currentValue)) {
          return
        }
        fromElement.attributeMap.value = currentValue + Number(value);
      })

  }
}


export const applyPropertyMutation = (readJson: JsonUtil, outputPersonQueryType: PersonQueryType, propertyMutation: PropertyMutationQueryType | undefined, selfPersonQueryType: PersonQueryType, targetPersonQueryType: PersonQueryType) => {

  const fromElement = propertyMutation?.queryOptional("from")
  const propertyRuleRef = propertyMutation?.attributeMap?.property_rule_ref;

  let getProperty = (key: string) => readJson.person.getProperty(targetPersonQueryType, key);

  if (fromElement?.attributeMap.participant === "self") {
    console.log("DD")
    getProperty = (key: string) => {
      const value = readJson.person.getProperty(selfPersonQueryType, key);
      console.log(`value ${value}`)
      return value;
    }
  }

  const value = readJson.computeOperationFromParent(fromElement?.queryOptional("operation"), getProperty)

  return async (writeJson: JsonUtil) => {
    if (!value) {
      return
    }

    writeJson.json.queryOptional("data").queryAllOptional("people")
      .flatMap(peopleElement => peopleElement.queryAllOptional("person"))
      .filter(personElement => personElement.attributeMap.id === outputPersonQueryType.attributeMap.id)
      .flatMap(personElement => personElement.queryAllOptional("properties"))
      .flatMap(property => property.queryAllOptional("property"))
      .filter(element => element.attributeMap.property_rule_ref === propertyRuleRef)
      .forEach(fromElement => {
        const currentValue = Number(fromElement.attributeMap.value)
        if (isNaN(currentValue)) {
          return
        }
        const newValue = Number(value);
        if(isNaN(newValue)) {
          return;
        }
        fromElement.attributeMap.value = currentValue + newValue;
      })

  }
}