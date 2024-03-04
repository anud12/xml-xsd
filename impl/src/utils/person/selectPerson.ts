import {JsonUtil} from "../util";
import {JsonSchema, SelectPersonQueryType} from "../JsonSchema";
import {queryPerson} from "./queryPerson/queryPerson";


type PeopleQueryType = JsonSchema['children']["people"]["children"]["person"];




export const selectPerson = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType) => {
  try {
    return queryPerson(jsonUtil, selectPerson);
  } catch (e: any) {
    const newError = new Error(`selectPerson failed for ${selectPerson.getPath()}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }
}