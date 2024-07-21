import {MutationMiddleware} from "../_type";
import {mergeError} from "../../mergeError";
import {JsonUtil} from "../../utils/util";
import {JsonSchema} from "../../utils/JsonSchema";

type RuleGroupQueryType = JsonSchema["children"]["rule_group"];
type PersonQueryType = JsonSchema["children"]["people"]["children"]["person"];
type PersonActionMetadataQueryType = RuleGroupQueryType["children"]["action_rule"]["children"]["person_to_person"];

type MutationQueryType = RuleGroupQueryType["children"]["action_rule"]["children"]["person_to_person"]["children"]["property_mutation"];
type FromQueryType = MutationQueryType["children"]["from"];


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

// const isOutOfRange = (readJson: JsonUtil, personAction: PersonActionMetadataQueryType, person: PersonQueryType, targetPerson: PersonQueryType,) => {
//   const maxRange = personAction.query("max_range");
//   if (!maxRange) {
//     return true;
//   }
//   const maxRangeValue = readJson.computeOperationFromParent(maxRange.query("operation"), string => readJson.person.getProperty(person, string));
//   const distance = readJson.person.getDistance(person, targetPerson);
//   if ((distance + 1) > (Number(maxRangeValue))) {
//     return true;
//   }
//   const minRange = personAction.queryOptional("min_range");
//   if (!minRange) {
//     return false;
//   }
//   const minRangeValue = readJson.computeOperationFromParent(maxRange.query("operation"), string => readJson.person.getProperty(person, string));
//   return (Number(minRangeValue) + 1) > distance;
// }

export const personOnPersonPropertyMutation: MutationMiddleware =readJson => {

  const actionMetadata = readJson.getRuleGroups()
    .flatMap(e => e.queryAllOptional("action_rule"))
    .flatMap(e => e.queryAllOptional("person_to_person"));


  const personList = readJson.json.queryAllOptional("people").flatMap(e => e.queryAll("person"));

  const actions = readJson.json.queryAllOptional("actions")
    .flatMap(e => e.queryAllOptional("person.on_person.property_mutation"))
    .flatMap(personOnPersonPropertyMutation => {
      try {
        const action = actionMetadata.find(action => action.attributeMap.id === personOnPersonPropertyMutation.attributeMap.action_property_mutation_rule_ref);
        const person = personList.find(person => person.attributeMap.id === personOnPersonPropertyMutation.attributeMap.person_id_ref);
        const targetPerson = personList.find(person => person.attributeMap.id === personOnPersonPropertyMutation.attributeMap.target_person_id_ref);

        if (!action) {
          return;
        }
        // if (isOutOfRange(readJson, action, person, targetPerson)) {
        //   return [];
        // }

        const property_mutation_list = action.queryAllOptional("property_mutation").map(property_mutation => {
          const value = mutationToValue(readJson, property_mutation, person, targetPerson);
          return {value, property_mutation: property_mutation}
        });
        return [{
          personIdRef: targetPerson.attributeMap.id,
          targetPersonIdRef: targetPerson.attributeMap.id,
          property_mutation_list: property_mutation_list
        }]
      } catch (e: any) {
        throw mergeError(e, new Error(`Error computing by element ${personOnPersonPropertyMutation.getPath()}`));
      }

    })

  return async writeJson => {
    writeJson.json.queryAllOptional("actions")
      .flatMap(action => action.queryAllOptional("person.on_person.property_mutation"))
      .forEach(element => {
        element.removeFromParent();
      });
    actions.filter(e => e).forEach(({personIdRef, targetPersonIdRef, property_mutation_list}) => {
      const personList = writeJson.json.queryAll("people").flatMap(e => e.queryAll("person"));
      const person = personList.find(e => e.attributeMap.id === personIdRef);
      const targetPerson = personList.find(e => e.attributeMap.id === targetPersonIdRef);

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
  }

}