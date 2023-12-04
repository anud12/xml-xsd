import {Middleware} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";
import {nodeBodyType} from "../JSONQuery";
import {JsonUtil} from "../utils";

type RuleGroupQueryType = JsonSchema[typeof nodeBodyType]["rule_group"]
type PersonQueryType = JsonSchema[typeof nodeBodyType]["people"][typeof nodeBodyType]["person"]
type PersonActionMetadataQueryType = RuleGroupQueryType[typeof nodeBodyType]["action_metadata"][typeof nodeBodyType]["person_to_person"];

type MutationQueryType = RuleGroupQueryType[typeof nodeBodyType]["action_metadata"][typeof nodeBodyType]["person_to_person"][typeof nodeBodyType]["property_mutation"]
type FromQueryType = MutationQueryType[typeof nodeBodyType]["from"]

const mutationToValue = (readJson: JsonUtil, mutation: MutationQueryType, person: PersonQueryType, targetPerson: PersonQueryType) => {
  const operations = mutation.queryAll("from").flatMap((from: FromQueryType) => {
    const participant = from.$participant
    const participantPerson = participant === "target"
      ? targetPerson
      : person;
    return from.queryAll("operation")
      .flatMap(operation => operation.children)
      .flatMap(operation => readJson.computeOperation(operation, string => {
        return readJson.person.getProperty(participantPerson, string)
      }))
  });
  return operations.reduce((e, op) => op(e), "0");
}

export const isOutOfRange = (readJson: JsonUtil, personAction: PersonActionMetadataQueryType, person: PersonQueryType, targetPerson: PersonQueryType,) => {
  const maxRange = personAction.query("max_range");
  if (!maxRange) {
    return true;
  }
  const maxRangeValue = readJson.computeOperationFromParent(maxRange, string => readJson.person.getProperty(person, string))("0");
  const distance = readJson.person.getDistance(person, targetPerson);
  if ((distance + 1) > (Number(maxRangeValue))) {
    return true;
  }
  const minRange = personAction.queryOptional("min_range");
  if (!minRange) {
    return false;
  }
  const minRangeValue = readJson.computeOperationFromParent(minRange, string => readJson.person.getProperty(person, string))("0");
  return (Number(minRangeValue) + 1) > distance;
}

export const personAction: Middleware = readJson => {

  const actionMetadata = readJson.getRuleGroups()
    .flatMap(e => e.queryAllOptional("action_metadata"))
    .flatMap(e => e.queryAll("person_to_person"));


  const personList = readJson.json.queryAll("people").flatMap(e => e.queryAll("person"));

  const actions = readJson.json.queryAll("actions")
    .flatMap(e => e.queryAllOptional("by"))
    .flatMap(by => {
      try {
        const personDo = by.queryOptional("do")
        if (!personDo) {
          return [];
        }
        const action = actionMetadata.find(action => action.$name === personDo.$action_ref);
        const person = personList.find(person => person.$id === by.$person_ref);
        const targetPerson = personList.find(person => person.$id === personDo.$person_ref);

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
      } catch (e) {
        const newError = new Error(`Error computing by element ${by.getPath()}`);
        newError.stack += '\nCaused by: ' + e.stack;
        throw newError;
      }

    })

  return async writeJson => {
    actions.forEach(({by: by, personAction, property_mutation_list}) => {
      const personList = writeJson.json.queryAll("people").flatMap(e => e.queryAll("person"));
      const person = personList.find(e => e.$id === by.$person_ref);
      const targetPerson = personList.find(e => e.$id === personAction.$person_ref);

      property_mutation_list.forEach(mutation => {
        const applicablePerson = mutation.property_mutation.$on === "target"
          ? targetPerson
          : person;
        const propertyName = mutation.property_mutation.$property_ref;
        const propertyValue = writeJson.person.getProperty(applicablePerson, propertyName);

        applicablePerson.queryAll("properties")
          .flatMap(e => e.queryAll("property"))
          .find(e => e.$property_ref === propertyName)
          .$value = String(Number(propertyValue) + Number(mutation.value))
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