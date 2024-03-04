import {JsonUtil} from "../../util";
import {JsonSchema, SelectPersonQueryType} from "../../JsonSchema";

type PeopleQueryType = JsonSchema['children']["people"]["children"]["person"];

export const filterPersonListBasedOnProperties = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, people: Array<PeopleQueryType>) => {
  return people.filter(person => {
    const ruleElements = selectPerson.queryAllOptional("property");
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
  });
}


export const filterPersonListBasedOnClassification = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, people: Array<PeopleQueryType>) => {
  return people.filter(person => {
    const ruleElements = selectPerson.queryAllOptional("classification");
    if(ruleElements.length === 0) {
      return true;
    }
    const classifications = jsonUtil.person.classifyPerson(person);
    const filteredRules = ruleElements.filter(element => {

      const ref = element.attributeMap.classification_rule_ref
      return classifications.includes(ref);
    })
    return ruleElements.length === filteredRules.length;
  });
}


export const filterPersonListBasedOnRace = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, people: Array<PeopleQueryType>) => {
  return people.filter(person => {
    const race = person.queryOptional("race");
    const ruleElements = selectPerson.queryAllOptional("race");
    const filteredRules = ruleElements.filter(element => {
      return race.attributeMap.race_rule_ref === element.attributeMap.race_rule_ref
    })
    return ruleElements.length === filteredRules.length;
  });
}


export const queryPerson = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType) => {
  try {
    let people = jsonUtil.json.queryAll("people").flatMap(people => people.queryAllOptional("person"));
    people = filterPersonListBasedOnProperties(jsonUtil, selectPerson, people);
    people = filterPersonListBasedOnClassification(jsonUtil, selectPerson, people);
    people = filterPersonListBasedOnRace(jsonUtil, selectPerson, people);

    const maxElement = selectPerson.queryOptional("max");

    if(!maxElement) {
      return people;
    }
    const maxQuantityValue = jsonUtil.computeOperationFromParent(maxElement, () => "0")
    return jsonUtil.randomListFromArray(people, Number(maxQuantityValue));
  } catch (e: any) {
    const newError = new Error(`queryPerson failed for ${selectPerson.getPath()}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }
}