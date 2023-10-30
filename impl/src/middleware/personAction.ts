import {Middleware, Unit} from "../utils/middleware";
import {JsonSchema} from "../utils/JsonSchema";
import {nodeBodyType} from "../JSONQuery";
import {JsonUtil} from "../utils";

type PersonQueryType = JsonSchema[typeof nodeBodyType]["people"][typeof nodeBodyType]["person"]


type MutationQueryType = JsonSchema[typeof nodeBodyType]["action_metadata"][typeof nodeBodyType]["person_to_person"][typeof nodeBodyType]["property_mutation"]
const mutationToValue = (readJson: Unit, mutation: MutationQueryType, person: PersonQueryType, targetPerson: PersonQueryType) => {
  const operations = mutation.queryAll("from").flatMap(from => {
    const partaker = from.$partaker;
    const partakerPerson = partaker === "target"
      ? targetPerson
      : person;
    return from.queryAll("operation")
      .flatMap(operation => operation.children)
      .flatMap(operation => readJson.util.computeOperation(operation, string => {
        return readJson.util.person.getProperty(partakerPerson, string)
      }))
  });
  return operations.reduce((e, op) => op(e), "0");
}

export const personAction: Middleware = readJson => {
  const actionMetadata = readJson.json.queryAll("action_metadata")
    .flatMap(e => e.queryAll("person_to_person"));

  const personList = readJson.json.queryAll("people").flatMap(e => e.queryAll("person"));

  const actions = readJson.json.queryAll("actions")
    .flatMap(e => e.queryAllOptional("by"))
    .flatMap(from => {
      const personDo = from.queryOptional("do")
      if(!personDo) {
        return [];
      }
      const action = actionMetadata.find(e => e.$name === personDo.$action);
      const person = personList.find(e => e.$name === from.$name);
      const targetPerson = personList.find(e => e.$name === personDo.$to);

      const property_mutation_list = action.queryAll("property_mutation").map(e => {
        const value = mutationToValue(readJson, e, person, targetPerson);
        return {value, property_mutation: e}
      });
      return [{
        from,
        personAction: personDo,
        property_mutation_list: property_mutation_list
      }]
    })

  return async writeJson => {
    const writeJsonUtil = new JsonUtil(writeJson);
    actions.forEach(({from, personAction, property_mutation_list}) => {
      const personList = writeJson.queryAll("people").flatMap(e => e.queryAll("person"));
      const person = personList.find(e => e.$name === from.$name);
      const targetPerson = personList.find(e => e.$name === personAction.$to);

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
  }
}