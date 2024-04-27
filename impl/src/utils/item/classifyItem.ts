import {JsonUtil} from "../util";
import {addClassificationBasedOnProperty} from "../classification/addClassificationBasedOnProperty";
import {mergeError} from "../../mergeError";
import {ItemQueryType} from "../JsonSchema";

export const classifyItem = (readJson: JsonUtil, itemQueryType: ItemQueryType): string[] => {
  try {
    console.log(`classifyItem for ${itemQueryType.attributeMap.id}`)
    const computedClassificationIdList = addClassificationBasedOnProperty(readJson, key => {
      return readJson.item.getProperty(itemQueryType, key);
    })
      .map(value => value.attributeMap.id);

    const emptyClassificationRules = readJson.getRuleGroups()
      .flatMap(ruleGroup => ruleGroup.queryAllOptional("classification_rule"))
      .flatMap(e => e.queryAllOptional("entry"))
      .filter(classificationRuleElement => classificationRuleElement.childrenList.length === 0);

    const staticClassificationId = itemQueryType.queryAllOptional("classifications")
      .flatMap(classifications => classifications.queryAllOptional("classification"))
      .filter(classification => {
        return emptyClassificationRules.map(entry => entry.attributeMap.id)
          .includes(classification.attributeMap.classification_rule_ref);
      })
      .map(value => value.attributeMap.classification_rule_ref)


    return [...computedClassificationIdList, ...staticClassificationId];
  } catch (e: any) {
    throw mergeError(e, new Error(`classifyItem failed for ${itemQueryType.attributeMap.id}`));
  }

}