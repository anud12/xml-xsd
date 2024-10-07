import {JsonUtil} from "../util";
import {JsonSchema, SelectPersonQueryType} from "../JsonSchema";
import {queryPerson} from "./queryPerson";
import {createPerson} from "./createPerson";
import {filterPerson} from "./filterPerson";
import {mergeError} from "../../mergeError";

export type Position = {
  x: string,
  y: string,
}

type PeopleQueryType = JsonSchema['children']["data"]["children"]["people"]["children"]["person"];

export const filterPersonMaxQuantity = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType | undefined, list: Array<PeopleQueryType>): Array<PeopleQueryType> => {
  if(!selectPerson) {
    return list;
  }
  const maxElement = selectPerson.queryOptional("max");

  if (!maxElement) {
    return list;
  }
  const maxQuantityValue = jsonUtil.computeOperationFromParent(maxElement, () => "0")
  return jsonUtil.randomListFromArray(list, Number(maxQuantityValue));
}

export const filterPersonMinQuantity = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType | undefined, list: Array<PeopleQueryType>): Array<PeopleQueryType> => {
  if(!selectPerson) {
    return list;
  }
  const minValue = Number(jsonUtil.computeOperationFromParent(selectPerson.queryOptional("min")));
  const difference = list.length - minValue;
  if (difference >= 0) {
    return list;
  }
  new Array(Math.abs(difference)).fill("")
    .map(() => {
      const person = createPerson(jsonUtil, selectPerson);
      list.push(person);
    })
  return list;
}


export const selectPerson = (jsonUtil: JsonUtil, selectPerson: SelectPersonQueryType | undefined, position?: Position):Array<PeopleQueryType> => {
  try {
    let people = queryPerson(jsonUtil)
    .filter(person => filterPerson(jsonUtil, selectPerson, person, position));

   people = filterPersonMaxQuantity(jsonUtil, selectPerson, people);
   people = filterPersonMinQuantity(jsonUtil, selectPerson, people);

    return people;
  } catch (e: any) {
    throw mergeError(e, new Error(`selectPerson failed for ${selectPerson?.getPath()}`));
  }
}