import {JsonUtil} from "../util";
import {SelectItemQueryType} from "../JsonSchema";
import {mergeError} from "../../mergeError";

const createNewItem = (jsonUtil: JsonUtil, selectItem: SelectItemQueryType) => {
  try {
    const itemRules = jsonUtil.getRuleGroups()
        .flatMap(rule => rule.queryAllOptional("item_rule"))
        .flatMap(rule => rule.queryAllOptional("entry"))
    ;

    if(itemRules.length === 0) {
      throw new Error("No item rules found");
    }

    const rule = jsonUtil.randomFromArray(itemRules);

    let itemsElement = jsonUtil.json.queryOptional("items");
    if(!itemsElement)  {
      itemsElement = jsonUtil.json.appendChild("items")
    }

    const item = itemsElement.appendChild("item", undefined, {
      id: jsonUtil.getNextId(),
      name: jsonUtil.name.calculateNameFromChildren(rule.queryOptional("name"))
    })
    return item;
  } catch (e: any) {
    throw mergeError(e, new Error(`createNewItem failed for ${selectItem.getPath()}`));
  }
}


export const createItem = (jsonUtil: JsonUtil, selectItem: SelectItemQueryType) => {
  try {
    let item = createNewItem(jsonUtil, selectItem);
    return item;
  } catch (e:any) {
    throw mergeError(e, new Error(`createItem failed for ${selectItem.getPath()}`));
  }

}