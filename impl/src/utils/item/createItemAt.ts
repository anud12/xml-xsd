import {JsonUtil} from "../util";
import {JsonQueryType} from "../../JsonQueryType";
import {ItemQueryType} from "../JsonSchema";

export type CreateItemArgs = {
  item_rule_ref: string,
  parentElement: JsonQueryType
}


export const createItemAt = (jsonUtil: JsonUtil, args: CreateItemArgs): void => {
  const itemRules = jsonUtil.getRuleGroups().flatMap(rule_group => rule_group.queryAllOptional("item_rule"))
    .flatMap(item_rule => item_rule.queryAllOptional("entry"));

  const rule = itemRules.find(rule => rule.attributeMap.id === args.item_rule_ref);

  const itemElement:ItemQueryType = args.parentElement.appendChild("item")
  itemElement.attributeMap.id = jsonUtil.getNextId();

  const name = rule.query("name")
  itemElement.attributeMap.name = jsonUtil.name.calculateNameFromChildren(name);
}