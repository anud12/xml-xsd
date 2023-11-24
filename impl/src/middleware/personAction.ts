import {Middleware, Unit} from "../utils/middleware";
import {JsonSchema} from "../utils/JsonSchema";
import {nodeBodyType} from "../JSONQuery";
import {JsonUtil} from "../utils";

type PersonQueryType = JsonSchema[typeof nodeBodyType]["people"][typeof nodeBodyType]["person"]
type PersonActionMetadataQueryType = JsonSchema[typeof nodeBodyType]["action_metadata"][typeof nodeBodyType]["person_to_person"];

type MutationQueryType = JsonSchema[typeof nodeBodyType]["action_metadata"][typeof nodeBodyType]["person_to_person"][typeof nodeBodyType]["property_mutation"]
type FromQueryType = MutationQueryType[typeof nodeBodyType]["from"]

const mutationToValue = (readJson: Unit, mutation: MutationQueryType, person: PersonQueryType, targetPerson: PersonQueryType) => {
  const operations = mutation.queryAll("from").flatMap((from: FromQueryType) => {
    const participant = from.$participant
    const participantPerson = participant === "target"
      ? targetPerson
      : person;
    return from.queryAll("operation")
      .flatMap(operation => operation.children)
      .flatMap(operation => readJson.util.computeOperation(operation, string => {
        return readJson.util.person.getProperty(participantPerson, string)
      }))
  });
  return operations.reduce((e, op) => op(e), "0");
}

export const isOutOfRange = (readJson: Unit, personAction: PersonActionMetadataQueryType, person: PersonQueryType, targetPerson: PersonQueryType, ) => {
  const maxRange = personAction.query("max_range");
  if (!maxRange) {
    return true;
  }
  const maxRangeValue = readJson.util.computeOperationFromParent(maxRange, string => readJson.util.person.getProperty(person, string))("0");
  const distance = readJson.util.person.getDistance(person, targetPerson);
  if(distance > Number(maxRangeValue)) {
    return true;
  }
  const minRange = personAction.query("min_range");
  if (!minRange) {
    return false;
  }
  const minRangeValue = readJson.util.computeOperationFromParent(minRange, string => readJson.util.person.getProperty(person, string))("0");
  return Number(minRangeValue) > distance;
}

export const personAction: Middleware = readJson => {
  const actionMetadata = readJson.json.queryAll("action_metadata")
    .flatMap(e => e.queryAll("person_to_person"));

  const personList = readJson.json.queryAll("people").flatMap(e => e.queryAll("person"));

  const actions = readJson.json.queryAll("actions")
    .flatMap(e => e.queryAllOptional("by"))
    .flatMap(by => {
      const personDo = by.queryOptional("do")
      if (!personDo) {
        return [];
      }
      const action = actionMetadata.find(action => action.$name === personDo.$action);
      const person = personList.find(person => person.$id === by.$person);
      const targetPerson = personList.find(person => person.$id === personDo.$to);

      if(isOutOfRange(readJson, action, person, targetPerson)) {
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
    })

  return async writeJson => {
    const writeJsonUtil = new JsonUtil(writeJson);
    actions.forEach(({by: by, personAction, property_mutation_list}) => {
      const personList = writeJson.queryAll("people").flatMap(e => e.queryAll("person"));
      const person = personList.find(e => e.$id === by.$person);
      const targetPerson = personList.find(e => e.$id === personAction.$to);

      property_mutation_list.forEach(mutation => {
        const applicablePerson = mutation.property_mutation.$on === "target"
          ? targetPerson
          : person;
        const propertyName = mutation.property_mutation.$name;
        const propertyValue = writeJsonUtil.person.getProperty(applicablePerson, propertyName);

        applicablePerson.queryAll("properties")
          .flatMap(e => e.queryAll("property"))
          .find(e => e.$ref === propertyName)
          .$value = String(Number(propertyValue) + Number(mutation.value))
      })
    })
    writeJsonUtil.jsonQuery.queryAllOptional("actions")
      .flatMap(action => action.queryAllOptional("by"))
      .forEach(by => {
        if (!by.queryOptional("move_towards")) {
          by.removeFromParent();
        }
      });
  }


}