import {JsonUtil} from "../util";
import {ItemDataQueryType, ItemQueryType, SelectItemQueryType} from "../JsonSchema";
import {mergeError} from "../../mergeError";
import {JsonQueryType} from "../../JsonQueryType";
import exp from "constants";

const createNewItem = (jsonUtil: JsonUtil, selectItem: ItemDataQueryType, target?: JsonQueryType): ItemQueryType => {
  try {
    const itemRules = jsonUtil.getRuleGroups()
      .flatMap(rule => rule.queryAllOptional("item_rule"))
      .flatMap(rule => rule.queryAllOptional("entry"))
    ;

    if (itemRules.length === 0) {
      throw new Error("No item rules found");
    }

    const rule = jsonUtil.randomFromArray(itemRules);

    let itemsElement = jsonUtil.json.queryOptional("items");
    if (!target && !itemsElement) {
      itemsElement = jsonUtil.json.appendChild("items")
    }

    if (target) {
      return  target.appendChild("item", undefined, {
        id: jsonUtil.getNextId(),
        name: jsonUtil.name.calculateNameFromChildren(rule.queryOptional("name"))
      })
    }
    return itemsElement.appendChild("item", undefined, {
      id: jsonUtil.getNextId(),
      name: jsonUtil.name.calculateNameFromChildren(rule.queryOptional("name"))
    });
  } catch (e: any) {
    throw mergeError(e, new Error(`createNewItem failed for ${selectItem.getPath()}`));
  }
}


export const createItem = (jsonUtil: JsonUtil, selectItem: ItemDataQueryType, target?: JsonQueryType):ItemQueryType => {
  try {
    let item = createNewItem(jsonUtil, selectItem, target);
    return item;
  } catch (e: any) {
    throw mergeError(e, new Error(`createItem failed for ${selectItem.getPath()}`));
  }
}

export const createItemsFromSelection = (jsonUtil: JsonUtil, selectItem: SelectItemQueryType, target?: JsonQueryType):ItemQueryType[] =>{
  const min = selectItem.queryOptional("min");
  if(!min) {
    return [];
  }
  const minValue = jsonUtil.computeOperationFromParent(min);
  new Array(Number(minValue)).fill("").forEach(() => {
    createItem(jsonUtil,selectItem, target);
  })
}