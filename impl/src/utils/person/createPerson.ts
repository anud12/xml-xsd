import {JsonUtil} from "../util";
import {JsonSchema, SelectPersonQueryType} from "../JsonSchema";
import {PersonQueryType} from "./getPersonProperty";
import {JsonQueryType} from "../../JsonQueryType";
import {Position} from "./selectPerson";

export type PersonQueryElement = JsonSchema["children"]["data"]["children"]["people"]["children"]["person"];

const createNewPerson = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType) => {
  const ruleGroup = jsonUtil.getRuleGroups();

  const raceList = ruleGroup.flatMap(ruleGroup => ruleGroup.queryAllOptional("race_rule"))
    .flatMap(e => e.queryAll("entry"));


  const selectRace = selectPerson.queryOptional("race")?.attributeMap?.race_rule_ref;

  const race = raceList.find(race => race.attributeMap.id === selectRace)
    || jsonUtil.randomFromArray(raceList)

  const name = jsonUtil.name.calculateNameFromRefString(race?.queryOptional("name")?.attributeMap?.name_rule_ref);

  let people = jsonUtil.json.queryOptional("data").queryOptional("people");
  if (!people) {
    jsonUtil.json.queryOptional("data").appendChild("people", undefined, {});
    people = jsonUtil.json.queryOptional("data").queryOptional("people");
  }
  const person = people.appendChild("person", undefined, {
    id: jsonUtil.getNextId()
  });
  console.log(`createNewPerson name ${name}`);
  if (name) {
    person.attributeMap.name = name;
  }
  if (race) {
    person.appendChild("race", undefined, {
      race_rule_ref: race.attributeMap.id
    });
  }
  person.appendChild("properties", undefined, {});
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

  const classificationsElement = person.queryOrAppend("classifications");
  classificationsElement.appendChild("classification", undefined, {
    classification_rule_ref: classification.attributeMap.id,
  })


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
    console.log(`applyProperty ${property.getPath()}`)
    jsonUtil.person.getProperty(person, property.attributeMap.property_rule_ref);

    console.log("applyProperty has stringValue")
    let max = Number(jsonUtil.computeOperationFromParent(property.queryOptional("max")));
    let min = Number(jsonUtil.computeOperationFromParent(property.queryOptional("min")))

    if (!max) {
      max = min;
    }
    console.log(`applyProperty has max ${max}`)
    if (!min) {
      min = max;
    }
    console.log(`applyProperty has min ${min}`)
    if (!min && !max) {
      return;
    }
    console.log("applyProperty has any")
    let value = jsonUtil.randomBetweenInt(min, max);
    jsonUtil.person.setProperty(person, property.attributeMap.property_rule_ref, String(value));
  })
}


export const createPerson = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType): PersonQueryElement => {
  try {
    console.log(`createPerson from ${selectPerson.getPath()}`)
    let person = createNewPerson(jsonUtil, selectPerson);
    selectPerson.queryAllOptional("classification").forEach(value => {
      person = applyClassification(jsonUtil, value.attributeMap.classification_rule_ref, person)
    })
    applyProperty(jsonUtil, selectPerson, person);
    return person;
  } catch (e) {
    const newError = new Error(`createPerson failed for ${selectPerson.getPath()}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }
}