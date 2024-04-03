import {Position} from "./selectPerson";
import {JsonSchema, SelectPersonQueryType} from "../JsonSchema";
import {JsonUtil} from "../util";

type PeopleQueryType = JsonSchema['children']["people"]["children"]["person"];

export const queryPerson = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType): Array<PeopleQueryType> => {
  try {
    return jsonUtil.json.queryAll("people")
      .flatMap(people => people.queryAllOptional("person"));

  } catch (e: any) {
    const newError = new Error(`queryPerson failed for ${selectPerson.getPath()}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }
}