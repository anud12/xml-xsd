import {getPersonProperty, PersonQueryType} from "./getPersonProperty";
import {JsonUtil} from "../util";
import {mergeError} from "../../mergeError";
import {addClassificationBasedOnProperty} from "../classification/addClassificationBasedOnProperty";


export const classifyPerson = (readJson: JsonUtil, personQueryType: PersonQueryType): string[] => {
  try {
    console.log(`classifyPerson for ${personQueryType.attributeMap.id}`)
    const computedClassificationIdList = addClassificationBasedOnProperty(readJson, key => getPersonProperty(readJson, personQueryType, key))
      .map(value => value.attributeMap.id);

    const emptyClassificationRules = readJson.getRuleGroups()
      .flatMap(ruleGroup => ruleGroup.queryAllOptional("classification_rule"))
      .flatMap(e => e.queryAllOptional("entry"))
      .filter(classificationRuleElement => classificationRuleElement.childrenList.length === 0);

    const staticClassificationId = personQueryType.queryAllOptional("classifications")
      .flatMap(classifications => classifications.queryAllOptional("classification"))
      .filter(classification => {
        return emptyClassificationRules.map(entry => entry.attributeMap.id)
          .includes(classification.attributeMap.classification_rule_ref);
      })
      .map(value => value.attributeMap.classification_rule_ref)


    return [...computedClassificationIdList, ...staticClassificationId];
  } catch (e: any) {
    throw mergeError(e, new Error(`classifyPerson failed for ${personQueryType.attributeMap.id}`));
  }

}