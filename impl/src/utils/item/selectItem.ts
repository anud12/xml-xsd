import {JsonUtil} from "../util";
import {ItemQueryType, SelectItemQueryType} from "../JsonSchema";
import {queryItem} from "./queryItem";
import {filterItem} from "./filterItem";
import {createItem} from "./createItem";
import {mergeError} from "../../mergeError";

export const filterItemMaxQuantity = (jsonUtil: JsonUtil, selectItem: SelectItemQueryType, list: Array<ItemQueryType>) => {
  try {
    const maxElement = selectItem.queryOptional("max");

    if (!maxElement) {
      return list;
    }
    const maxQuantityValue = jsonUtil.computeOperationFromParent(maxElement, () => "0")
    return jsonUtil.randomListFromArray(list, Number(maxQuantityValue));
  } catch (e: any) {
    throw mergeError(e, new Error(`filterItemMaxQuantity failed for ${selectItem.getPath()}`));
  }
}

export const filterItemMinQuantity = (jsonUtil: JsonUtil, selectItem: SelectItemQueryType, list: Array<ItemQueryType>) => {
  try {
    const minValue = Number(jsonUtil.computeOperationFromParent(selectItem.queryOptional("min")));
    const difference = list.length - minValue;
    if (difference >= 0) {
      return list;
    }
    new Array(Math.abs(difference)).fill("")
      .map(() => {
        const item = createItem(jsonUtil, selectItem);
        list.push(item);
      })
    return list;
  } catch (e: any) {
    throw mergeError(e, new Error(`filterItemMinQuantity failed for ${selectItem.getPath()}`));
  }
}

export const selectItem = (jsonUtil: JsonUtil, selectItem: SelectItemQueryType): Array<ItemQueryType> => {
  try {
    let items = queryItem(jsonUtil, selectItem)
      .filter(item => filterItem(jsonUtil, selectItem, item))

    items = filterItemMaxQuantity(jsonUtil, selectItem, items);
    items = filterItemMinQuantity(jsonUtil, selectItem, items);

    return items;
  } catch (e:any) {
    throw mergeError(e, new Error(`selectItem failed for ${selectItem.getPath()}`));
  }
}