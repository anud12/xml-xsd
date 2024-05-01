import {ItemQueryType, SelectItemQueryType} from "../JsonSchema";
import {JsonUtil} from "../util";
import {mergeError} from "../../mergeError";


const filterBasedOnProperty = (jsonUtil: JsonUtil, selectItem: SelectItemQueryType, item: ItemQueryType): boolean => {
  try {
    const itemPropertyList = item.queryOptional("properties")?.queryAllOptional("property") ?? [];
    const selectItemPropertyList = selectItem.queryOptional("properties").queryAllOptional("property");

    const applicableItemPropertyList = selectItemPropertyList.filter(propertyRuleElement => {
      const itemProperty = itemPropertyList.find(itemPropertyElement => itemPropertyElement.attributeMap.property_rule_ref === propertyRuleElement.attributeMap.property_rule_ref);
      if (!itemProperty) {
        return false;
      }
      return itemProperty.attributeMap.value === propertyRuleElement.attributeMap.value
    });

  return selectItemPropertyList.length === applicableItemPropertyList.length;

  } catch (e: any) {
    throw mergeError(e, new Error(`Error while filtering item ${item?.attributeMap?.id} based on given property list`));
  }
}

export const filterItem = (jsonUtil: JsonUtil, selectItem: SelectItemQueryType, item: ItemQueryType): boolean => {
  try {
    return filterBasedOnProperty(jsonUtil,selectItem,item)
  } catch (e) {
    throw mergeError(e, new Error(`Error while filtering item ${item?.attributeMap.id}`));
  }


}