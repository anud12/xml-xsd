import {Middleware, Unit} from "../utils/middleware";
import {JsonSchema} from "../utils/JsonSchema";
import {nodeBodyType} from "../JSONQuery";

type PersonQueryType = JsonSchema[typeof nodeBodyType]["people"][typeof nodeBodyType]["person"]


/*
* Middleware 3 step
* prepare, compute, apply
* */
const getProperty = (readJson: Unit, person: PersonQueryType, property: string) => {

}

export const personAction: Middleware = readJson => {
  const actionMetadata = readJson.json.queryAll("action_metadata")
    .flatMap(e => e.queryAll("person_entry"));

  const personList = readJson.json.queryAll("people").flatMap(e => e.queryAll("person"));

  readJson.json.queryAll("action")
    .flatMap(e => e.queryAll("person_action"))
    .map(personAction => {
      const action = actionMetadata.find(e => e.$name === personAction.$ref);

      const mutations = action.queryAll("property_mutation")
      const result = mutations.flatMap(e => e.queryAll("operation"))
        .flatMap(e => e.children)
        .map(e => readJson.util.computeOperation(e))
        .reduce((e, op) => op(e), "0")
      console.log("result", result);
      const person = personList.find(e => e.$name === personAction.$name);
      const targetPerson = personList.find(e => e.$name === personAction.$target_name);
    })

  return async writeJson => {

  }
}