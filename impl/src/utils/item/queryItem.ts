import {JsonUtil} from "../util";
import {ItemQueryType, SelectItemQueryType} from "../JsonSchema";

export const queryItem = (jsonUtil: JsonUtil, selectItem: SelectItemQueryType): ItemQueryType[] => {
  try {
    const peopleList = jsonUtil.json.queryAllOptional("people")
      .flatMap(peopleElement => peopleElement.queryAllOptional("person"));
    const inventoryList = peopleList.flatMap(peopleElement => peopleElement.queryAllOptional("inventory"))
    return inventoryList.flatMap(inventoryMap => inventoryMap.queryAllOptional("item"))
  } catch (e:any) {
    const newError = new Error(`queryItem failed for ${selectItem.getPath()}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }
}