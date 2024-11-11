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
        fromElement.attributeMap.value = (currentValue + Number(value)) as any;
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

  const newValueString = readJson.computeOperationFromParent(fromElement?.queryOptional("operation"), getProperty)

  return async (writeJson: JsonUtil) => {
    if (!newValueString) {
      return
    }

    writeJson.json.queryOptional("data").queryAllOptional("people")
      .flatMap(peopleElement => peopleElement.queryAllOptional("person"))
      .filter(personElement => personElement.attributeMap.id === outputPersonQueryType.attributeMap.id)
      .forEach(personElement => {
        const oldValue = writeJson.person.getProperty(personElement, propertyRuleRef);
        const newValueNumber = Number(newValueString) + Number(oldValue);
        if (isNaN(Number(newValueString)) || isNaN(Number(oldValue))) {
          return;
        }
        const properties = personElement.queryOrAppend("properties")
        if(!properties) {

        }
        const propertyElement = properties.queryAllOptional("property")
          .find(element => element.attributeMap.property_rule_ref === propertyRuleRef);
        if (!propertyElement) {
          properties.appendChild("property", undefined, {
            property_rule_ref: propertyRuleRef,
            value: newValueNumber.toString()
          })
          return;
        }
        propertyElement.attributeMap.value = newValueNumber.toString()
      })

  }
}