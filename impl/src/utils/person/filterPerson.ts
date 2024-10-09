import {JsonSchema, SelectPersonQueryType} from "../JsonSchema";
import {JsonUtil} from "../util";
import {Position} from "./selectPerson";

type PeopleQueryType = JsonSchema['children']["data"]["children"]["people"]["children"]["person"];


const filterPersonListBasedOnProperties = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, person: PeopleQueryType): boolean => {
  const ruleElements = selectPerson.queryAllOptional("property");
  if (ruleElements.length === 0) {
    return true;
  }

  const filteredRules = ruleElements.filter(element => {
    const propertyMin = Number(jsonUtil.computeOperationFromParent(element.queryOptional("min")));
    const propertyMax = Number(jsonUtil.computeOperationFromParent(element.queryOptional("max")));
    const propertyRef = element.attributeMap.property_rule_ref;

    const propertyValue = Number(jsonUtil.person.getProperty(person, propertyRef))

    if (propertyValue > propertyMax) {
      return false;
    }
    if (propertyMin > propertyValue) {
      return false
    }
    return true;
  })
  return ruleElements.length === filteredRules.length;
}


const filterPersonListBasedOnClassification = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, person: PeopleQueryType): boolean => {
  const ruleElements = selectPerson.queryAllOptional("classification");
  if (ruleElements.length === 0) {
    return true;
  }

  const classifications = jsonUtil.person.classifyPerson(person);
  const filteredRules = ruleElements.filter(element => {
    const ref = element.attributeMap.classification_rule_ref
    return classifications.includes(ref);
  })
  return ruleElements.length === filteredRules.length;

}


const filterPersonListBasedOnRace = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, person: PeopleQueryType): boolean => {
  const ruleElements = selectPerson.queryAllOptional("race");
  if (ruleElements.length === 0) {
    return true;
  }
  const race = person.queryOptional("race");
  const filteredRules = ruleElements.filter(element => {
    return race?.attributeMap?.race_rule_ref === element.attributeMap.race_rule_ref
  })
  return ruleElements.length === filteredRules.length;
}




export const filterPerson = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType | undefined, person: PeopleQueryType, position?: Position): boolean => {
  try {
    if(!selectPerson) {
      return true;
    }
    return filterPersonListBasedOnProperties(jsonUtil, selectPerson, person)
      && filterPersonListBasedOnClassification(jsonUtil, selectPerson, person)
      && filterPersonListBasedOnRace(jsonUtil, selectPerson, person);

  } catch (e) {
    const newError = new Error(`filterPersonList failed for ${selectPerson.getPath()} in for person ${person.getPath()}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }
}