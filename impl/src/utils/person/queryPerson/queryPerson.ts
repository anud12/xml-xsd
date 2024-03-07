import {JsonUtil} from "../../util";
import {JsonSchema, SelectPersonQueryType} from "../../JsonSchema";
import {Position} from "../selectPerson";

type PeopleQueryType = JsonSchema['children']["people"]["children"]["person"];

export const filterPersonListBasedOnPosition = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, position: Position | undefined, people: Array<PeopleQueryType>):Array<PeopleQueryType> => {
  try {
    const radiusQueryElement = selectPerson.queryOptional("radius");
    if (!radiusQueryElement) {
      return people;
    }
    if(!position) {
      throw new Error("position is undefined when radius exists")
    }

    return people.filter(person => {
      const location = person.query("location");
      const x = Number(location.attributeMap.x);
      const y = Number(location.attributeMap.y);

      const radius = Number(jsonUtil.computeOperationFromParent(radiusQueryElement));
      const maxX = Number(position.x) + radius;
      const minX = Number(position.x) - radius;

      const maxY = Number(position.y) + radius;
      const minY = Number(position.y) - radius;

      const xUnderMax = maxX >= x;
      const xOverMin = x >= minX;
      const yUnderMax = maxY >= y;
      const yOverMin = y >= minY;

      return xUnderMax && xOverMin && yUnderMax && yOverMin;
    });
  } catch (e) {
    const newError = new Error(`filterPersonListBasedOnPosition failed for ${selectPerson.getPath()}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }
}

export const filterPersonListBasedOnProperties = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, people: Array<PeopleQueryType>):Array<PeopleQueryType> => {
  const ruleElements = selectPerson.queryAllOptional("property");
  if (ruleElements.length === 0) {
    return people;
  }
  return people.filter(person => {
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


export const filterPersonListBasedOnClassification = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, people: Array<PeopleQueryType>):Array<PeopleQueryType> => {
  const ruleElements = selectPerson.queryAllOptional("classification");
  if (ruleElements.length === 0) {
    return people;
  }
  return people.filter(person => {
    const classifications = jsonUtil.person.classifyPerson(person);
    const filteredRules = ruleElements.filter(element => {
      const ref = element.attributeMap.classification_rule_ref
      return classifications.includes(ref);
    })
    return ruleElements.length === filteredRules.length;
  });
}


export const filterPersonListBasedOnRace = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, people: Array<PeopleQueryType>):Array<PeopleQueryType> => {
  const ruleElements = selectPerson.queryAllOptional("race");
  if (ruleElements.length === 0) {
    return people;
  }
  return people.filter(person => {
    const race = person.queryOptional("race");
    const filteredRules = ruleElements.filter(element => {
      return race.attributeMap.race_rule_ref === element.attributeMap.race_rule_ref
    })
    return ruleElements.length === filteredRules.length;
  });
}


export const queryPerson = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, position?: Position) => {
  try {
    let people = jsonUtil.json.queryAll("people").flatMap(people => people.queryAllOptional("person"));
    people = filterPersonListBasedOnPosition(jsonUtil, selectPerson, position, people);
    people = filterPersonListBasedOnProperties(jsonUtil, selectPerson, people);
    people = filterPersonListBasedOnClassification(jsonUtil, selectPerson, people);
    people = filterPersonListBasedOnRace(jsonUtil, selectPerson, people);

    const maxElement = selectPerson.queryOptional("max");

    if (!maxElement) {
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