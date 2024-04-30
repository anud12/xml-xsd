import {JsonSchema, SelectPersonQueryType} from "../JsonSchema";
import {JsonUtil} from "../util";
import {Position} from "./selectPerson";

type PeopleQueryType = JsonSchema['children']["people"]["children"]["person"];


const filterPersonListBasedOnPosition = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, position: Position | undefined, person: PeopleQueryType): boolean => {
  try {
    const radiusQueryElement = selectPerson.queryOptional("radius");
    if (!radiusQueryElement) {
      return true;
    }
    if (!position) {
      throw new Error("position is undefined when radius exists")
    }

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

  } catch (e) {
    const newError = new Error(`filterPersonListBasedOnPosition failed for ${selectPerson.getPath()}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }
}

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


const filterPersonBasedOnInventory = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, person: PeopleQueryType): boolean => {
  const ruleElements = selectPerson.queryAllOptional("inventory");
  if (ruleElements.length === 0) {
    return true;
  }
  const inventory = person.queryOptional("inventory");
  if (!inventory) {
    return false;
  }
  return ruleElements.flatMap(ruleElement => ruleElement.queryAllOptional("item"))
    .reduce((result, inventoryRule) => {
      const itemList = inventory.queryAllOptional("item")
      .filter(itemQueryElement => jsonUtil.item.filterItem(inventoryRule, itemQueryElement));

      const min = inventoryRule.queryOptional("min");
      if (min) {
        const minValue = Number(jsonUtil.computeOperationFromParent(min));
        if (minValue > itemList.length) {
          return false;
        }
      }

      const max = inventoryRule.queryOptional("max");
      if (max) {
        const maxValue = Number(jsonUtil.computeOperationFromParent(max));
        if (maxValue < itemList.length) {
          return false;
        }
      }

      return result;
    }, true)
}


export const filterPerson = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, person: PeopleQueryType, position?: Position): boolean => {
  try {

    return filterPersonListBasedOnPosition(jsonUtil, selectPerson, position, person)
      && filterPersonListBasedOnProperties(jsonUtil, selectPerson, person)
      && filterPersonListBasedOnClassification(jsonUtil, selectPerson, person)
      && filterPersonListBasedOnRace(jsonUtil, selectPerson, person)
      && filterPersonBasedOnInventory(jsonUtil, selectPerson, person);

  } catch (e) {
    const newError = new Error(`filterPersonList failed for ${selectPerson.getPath()} in for person ${person.getPath()}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }
}