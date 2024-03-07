import {JsonUtil} from "../util";
import {JsonSchema, SelectPersonQueryType} from "../JsonSchema";
import {queryPerson} from "./queryPerson/queryPerson";
import {createPerson} from "./createPerson";

export type Position = {
  x:string,
  y:string,
}

export const selectPerson = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, position?:Position) => {
  try {
    const people = queryPerson(jsonUtil, selectPerson, position);

    const minValue = Number(jsonUtil.computeOperationFromParent(selectPerson.queryOptional("min")));

    const difference = people.length - minValue;

    if (difference >= 0) {
      return people;
    }

    new Array(Math.abs(difference)).fill("")
      .map(() => {
        const person = createPerson(jsonUtil, selectPerson, position);
        people.push(person);
      })

    return people;
  } catch (e: any) {
    const newError = new Error(`selectPerson failed for ${selectPerson.getPath()}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }
}