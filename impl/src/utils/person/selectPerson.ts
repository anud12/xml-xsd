import {JsonUtil} from "../util";
import {JsonSchema, SelectPersonQueryType} from "../JsonSchema";
import {queryPerson} from "./queryPerson";
import {createPerson} from "./createPerson";
import {filterPerson} from "./filterPerson";

export type Position = {
  x: string,
  y: string,
}

type PeopleQueryType = JsonSchema['children']["people"]["children"]["person"];

export const filterPersonMaxQuantity = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, people: Array<PeopleQueryType>): Array<PeopleQueryType> => {
  const maxElement = selectPerson.queryOptional("max");

  if (!maxElement) {
    return people;
  }
  const maxQuantityValue = jsonUtil.computeOperationFromParent(maxElement, () => "0")
  return jsonUtil.randomListFromArray(people, Number(maxQuantityValue));
}

export const filterPersonMinQuantity = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, position: Position | undefined, people: Array<PeopleQueryType>): Array<PeopleQueryType> => {
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
}


export const selectPerson = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType, position?: Position) => {
  try {
    let people = queryPerson(jsonUtil, selectPerson)
    .filter(person => filterPerson(jsonUtil, selectPerson, person, position));

   people = filterPersonMaxQuantity(jsonUtil, selectPerson, people);
   people = filterPersonMinQuantity(jsonUtil, selectPerson, position, people);

    return people;
  } catch (e: any) {
    const newError = new Error(`selectPerson failed for ${selectPerson.getPath()}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }
}