import {MutationMiddleware} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";
import {JsonUtil} from "../utils/util";
import {mergeError} from "../mergeError";

type RuleGroupQueryType = JsonSchema["children"]["rule_group"]
type PersonQueryType = JsonSchema["children"]["data"]["children"]["people"]["children"]["person"]
type PersonActionMetadataQueryType = RuleGroupQueryType["children"]["action_rule"]["children"]["person_to_person"];

type MutationQueryType = RuleGroupQueryType["children"]["action_rule"]["children"]["person_to_person"]["children"]["property_mutation"]
type FromQueryType = MutationQueryType["children"]["from"]

const mutationToValue = (readJson: JsonUtil, mutation: MutationQueryType, person: PersonQueryType, targetPerson: PersonQueryType) => {
  const operations = mutation.queryAll("from").flatMap((from: FromQueryType) => {
    const participant = from.attributeMap.participant
    const participantPerson = participant === "target"
      ? targetPerson
      : person;

    const list = from.queryAllOptional("operation")
      .flatMap(operation => {
        return readJson.computeOperationFromParent(operation, string => {
          return readJson.person.getProperty(participantPerson, string)
        })
      })
    return list;
  });
  return operations.reduce((e, op) => String(Number(e) + Number(op)), "0");
}

export const isOutOfRange = (readJson: JsonUtil, personAction: PersonActionMetadataQueryType, person: PersonQueryType, targetPerson: PersonQueryType,) => {
  return false;
  // const maxRange = personAction.query("max_range");
  // if (!maxRange) {
  //   return true;
  // }
  // const maxRangeValue = readJson.computeOperationFromParent(maxRange.query("operation"), string => readJson.person.getProperty(person, string));
  // const distance = readJson.person.getDistance(person, targetPerson);
  // if ((distance + 1) > (Number(maxRangeValue))) {
  //   return true;
  // }
  // const minRange = personAction.queryOptional("min_range");
  // if (!minRange) {
  //   return false;
  // }
  // const minRangeValue = readJson.computeOperationFromParent(maxRange.query("operation"), string => readJson.person.getProperty(person, string));
  // return (Number(minRangeValue) + 1) > distance;
}

export const personAction: MutationMiddleware = readJson => {

  const actionMetadata = readJson.getRuleGroups()
    .flatMap(e => e.queryAllOptional("action_rule"))
    .flatMap(e => e.queryAllOptional("person_to_person"));


  const personList = readJson.json.queryOptional("data").queryAllOptional("people").flatMap(e => e.queryAllOptional("person"));

  const actions = readJson.json.queryAllOptional("actions")
    .flatMap(e => e.queryAllOptional("by"))
    .flatMap(by => {
      try {
        const personDo = by.queryOptional("do")
        if (!personDo) {
          return [];
        }
        const action = actionMetadata.find(action => action.attributeMap.id === personDo.attributeMap.action_rule_ref);
        const person = personList.find(person => person.attributeMap.id === by.attributeMap.person_ref);
        const targetPerson = personList.find(person => person.attributeMap.id === personDo.attributeMap.person_ref);

        if (!action) {
          return;
        }
        if (isOutOfRange(readJson, action, person, targetPerson)) {
          return [{
            by: by,
            personAction: personDo,
            property_mutation_list: []
          }];
        }

        const property_mutation_list = action.queryAllOptional("property_mutation").map(property_mutation => {
          const value = mutationToValue(readJson, property_mutation, person, targetPerson);
          return {value, property_mutation: property_mutation}
        });
        return [{
          by: by,
          personAction: personDo,
          property_mutation_list: property_mutation_list
        }]
      } catch (e: any) {
        throw mergeError(e, new Error(`Error computing by element ${by.getPath()}`));
      }

    })

  return async writeJson => {
    actions.filter(e => e).forEach(({by: by, personAction, property_mutation_list}) => {
      const personList = writeJson.json.queryOptional("data").queryAll("people").flatMap(e => e.queryAll("person"));
      const person = personList.find(e => e.attributeMap.id === by.attributeMap.person_ref);
      const targetPerson = personList.find(e => e.attributeMap.id === personAction.attributeMap.person_ref);

      property_mutation_list.forEach(mutation => {
        const applicablePerson = mutation.property_mutation.attributeMap.on === "target"
          ? targetPerson
          : person;
        const propertyName = mutation.property_mutation.attributeMap.property_rule_ref;
        const propertyValue = writeJson.person.getProperty(applicablePerson, propertyName);

        applicablePerson.queryAll("properties")
          .flatMap(e => e.queryAll("property"))
          .find(e => e.attributeMap.property_rule_ref === propertyName)
          .setAttribute("value", String(Number(propertyValue) + Number(mutation.value)))
      })
    })
    writeJson.json.queryAllOptional("actions")
      .flatMap(action => action.queryAllOptional("by"))
      .forEach(by => {
        if (!by.queryOptional("move_towards")) {
          by.removeFromParent();
        }
      });
  }

}