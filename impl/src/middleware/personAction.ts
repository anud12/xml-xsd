import {Middleware, Unit} from "../utils/middleware";
import {JsonSchema} from "../utils/JsonSchema";
import {nodeBodyType} from "../JSONQuery";

type PersonQueryType = JsonSchema[typeof nodeBodyType]["people"][typeof nodeBodyType]["person"]


type MutationQueryType = JsonSchema[typeof nodeBodyType]["action_metadata"][typeof nodeBodyType]["person_entry"][typeof nodeBodyType]["property_mutation"]
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
    .flatMap(e => e.queryAll("person_entry"));

  const personList = readJson.json.queryAll("people").flatMap(e => e.queryAll("person"));

  const actions = readJson.json.queryAll("action")
    .flatMap(e => e.queryAll("person_action"))
    .map(personAction => {
      const action = actionMetadata.find(e => e.$name === personAction.$ref);
      const person = personList.find(e => e.$name === personAction.$name);
      const targetPerson = personList.find(e => e.$name === personAction.$target_name);

      const property_mutation_list = action.queryAll("property_mutation").map(e => {
        const value = mutationToValue(readJson, e, person, targetPerson);
        return {value, property_mutation: e}
      });
      return {
        personAction,
        property_mutation_list: property_mutation_list
      }
    })

  return async writeJson => {
    actions.forEach(({personAction, property_mutation_list}) => {
      const personList = writeJson.json.queryAll("people").flatMap(e => e.queryAll("person"));
      const person = personList.find(e => e.$name === personAction.$name);
      const targetPerson = personList.find(e => e.$name === personAction.$target_name);

      property_mutation_list.forEach(mutation => {
        const applicablePerson = mutation.property_mutation.$on === "target"
          ? targetPerson
          : person;
        const propertyName = mutation.property_mutation.$name;
        const propertyValue = writeJson.util.person.getProperty(applicablePerson, propertyName);

        applicablePerson.queryAll("properties")
          .flatMap(e => e.queryAll("property"))
          .find(e => e.$ref === propertyName)
          .$value = String(Number(propertyValue) + Number(mutation.value))
      })
    })
  }
}