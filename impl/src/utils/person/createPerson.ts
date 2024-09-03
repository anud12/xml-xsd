import {JsonUtil} from "../util";
import {JsonSchema, SelectPersonQueryType} from "../JsonSchema";
import {PersonQueryType} from "./getPersonProperty";
import {JsonQueryType} from "../../JsonQueryType";
import {Position} from "./selectPerson";
import {createItemsFromSelection} from "../item/createItem";

export type PersonQueryElement = JsonSchema["children"]["people"]["children"]["person"];

const createNewPerson = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType) => {
  const ruleGroup = jsonUtil.getRuleGroups();

  const raceList = ruleGroup.flatMap(ruleGroup => ruleGroup.queryAllOptional("race_rule"))
    .flatMap(e => e.queryAll("entry"));


  const selectRace = selectPerson.queryOptional("race")?.attributeMap?.race_rule_ref;

  const race = raceList.find(race => race.attributeMap.id === selectRace)
    || jsonUtil.randomFromArray(raceList)

  const name = jsonUtil.name.calculateNameFromRefString(race?.queryOptional("name")?.attributeMap?.name_rule_ref);

  let people = jsonUtil.json.queryOptional("people");
  if(!people) {
    jsonUtil.json.appendChild("people", undefined, {});
    people = jsonUtil.json.queryOptional("people");
  }
  const person = people.appendChild("person", undefined, {
    id: jsonUtil.getNextId()
  });
  if (name) {
    person.attributeMap.name = name;
  }
  if(race) {
    person.appendChild("race", undefined, {
      race_rule_ref: race.attributeMap.id
    });
  }
  person.appendChild("location", undefined, {
    x: "0",
    y: "0"
  });
  person.appendChild("properties", undefined, {});
  person.appendChild("inventory", undefined, {});
  person.appendChild("classifications", undefined, {});

  return person;
}


const applyClassification = (jsonUtil: JsonUtil, classificationRef: string, person: PersonQueryType) => {
  const ruleGroup = jsonUtil.getRuleGroups();
  const classification = ruleGroup.flatMap(ruleGroup => ruleGroup.queryAllOptional("classification_rule"))
    .flatMap(e => e.queryAllOptional("entry"))
    .find(e => e.attributeMap.id === classificationRef);

  if (!classification) {
    return person;
  }

  classification.queryAllOptional("property")
    .forEach(classification => {
      const propertyRef = classification.attributeMap.property_rule_ref;
      const classificationValue = Number(jsonUtil.computeOperationFromParent(classification.query("operation")))
      const property = Number(jsonUtil.person.getProperty(person, propertyRef));
      let computedValue = property;
      switch (classification.attributeMap.is) {
        case "lessThan": {
          computedValue = Math.min(classificationValue - 1, property);
          break;
        }
        case "lessThanOrEqual": {
          computedValue = Math.min(classificationValue, property);
          break;
        }
        case "greaterThan": {
          computedValue = Math.max(classificationValue + 1, property);
          break;
        }
        case "greaterThanOrEqual": {
          computedValue = Math.max(classificationValue, property);
          break;
        }
        case "equal": {
          computedValue = classificationValue;
          break;
        }
        default: {
          throw new Error(`Unknown operation ${(classification.attributeMap.is as JsonQueryType).attributeMap.is}`);
        }
      }
      jsonUtil.person.setProperty(person, propertyRef, String(computedValue))
    })

  return person;
}

const applyProperty = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, person: PersonQueryType): void => {
  selectPerson.queryAllOptional("property").map(property => {
    const stringValue = jsonUtil.person.getProperty(person, property.attributeMap.property_rule_ref);
    if (!stringValue) {
      return;
    }
    let value = Number(stringValue)

    const max = Number(jsonUtil.computeOperationFromParent(property.queryOptional("max")))
    if (max) {
      value = Math.min(value, max)
    }
    const min = Number(jsonUtil.computeOperationFromParent(property.queryOptional("min")))
    if (min) {
      value = Math.max(value, min)
    }
    jsonUtil.person.setProperty(person, property.attributeMap.property_rule_ref, String(value));
  })
}

const applyLocation = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, position: Position | undefined, person: PersonQueryType): void => {
  try {
    const location = person.queryOptional("location")
    if (!location) {
      return;
    }
    const radius = selectPerson.queryOptional("radius");
    if (!radius) {
      return;
    }
    if (!position) {
      throw new Error("position is undefined when radius exists")
    }

    const radiusX = Number(jsonUtil.computeOperationFromParent(radius));
    const randomX = jsonUtil.random() - 0.5;
    const absoluteX = Math.trunc(randomX * radiusX);

    location.attributeMap.x = String(Number(position.x) + absoluteX);


    const radiusY = Number(jsonUtil.computeOperationFromParent(radius));
    const randomY = jsonUtil.random() - 0.5;
    const absoluteY = Math.trunc(randomY * radiusY);
    location.attributeMap.y = String(Number(position.y) + absoluteY);
  } catch (e) {
    const newError = new Error(`applyLocation failed for ${selectPerson.getPath()}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }

}


const applyInventory = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, person: PersonQueryType): void => {
  const inventoryRule = selectPerson.queryOptional("inventory");

  if (!inventoryRule) {
    return;
  }

  let inventory = person.queryOptional("inventory");
  if (!inventory) {
    inventory = person.appendChild("inventory");
  }
  inventoryRule.queryAllOptional("item")
    .map(itemElement => createItemsFromSelection(jsonUtil, itemElement, inventory))

};

export const createPerson = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, position?: Position): PersonQueryElement => {
  try {
    let person = createNewPerson(jsonUtil, selectPerson);
    selectPerson.queryAllOptional("classification").forEach(value => {
      person = applyClassification(jsonUtil, value.attributeMap.classification_rule_ref, person)
    })
    applyProperty(jsonUtil, selectPerson, person);
    applyInventory(jsonUtil, selectPerson, person);
    applyLocation(jsonUtil, selectPerson, position, person);
    return person;
  } catch (e) {
    const newError = new Error(`createPerson failed for ${selectPerson.getPath()}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }
}