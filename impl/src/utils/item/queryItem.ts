import {JsonUtil} from "../util";
import {ItemQueryType, SelectItemQueryType} from "../JsonSchema";
import {mergeError} from "../../mergeError";

export const queryItem = (jsonUtil: JsonUtil): ItemQueryType[] => {
  try {
    const peopleList = jsonUtil.json.queryAllOptional("people")
      .flatMap(peopleElement => peopleElement.queryAllOptional("person"));
    const inventoryList = peopleList.flatMap(peopleElement => peopleElement.queryAllOptional("inventory"))
    const inventoryItems = inventoryList.flatMap(inventoryMap => inventoryMap.queryAllOptional("item"));

    const items = jsonUtil.json.queryAllOptional("items").flatMap(itemsElement => itemsElement.queryAllOptional("item"));
    return [...inventoryItems, ...items];
  } catch (e:any) {
    throw mergeError(e, new Error(`queryItem failed`));
  }
}