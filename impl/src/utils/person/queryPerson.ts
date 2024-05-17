import {JsonSchema} from "../JsonSchema";
import {JsonUtil} from "../util";
import {mergeError} from "../../mergeError";

type PeopleQueryType = JsonSchema['children']["people"]["children"]["person"];

export const queryPerson = (jsonUtil: JsonUtil): Array<PeopleQueryType> => {
  try {
    return jsonUtil.json.queryAll("people")
      .flatMap(people => people.queryAllOptional("person"));

  } catch (e: any) {
    throw mergeError(e, new Error(`queryPerson failed`));
  }
}