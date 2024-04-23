import {getProperty, PersonQueryType} from "./getProperty";
import {createOperationFromParent} from "../operation/createOperationFromParent";
import {JsonUtil} from "../util";
import {JsonQueryType} from "../../JsonQueryType";
import {mergeError} from "../../mergeError";


export const classifyPerson = (readJson: JsonUtil, personQueryType: PersonQueryType): string[] => {
  try {
    console.log(`classifyPerson for ${personQueryType.attributeMap.id}`)
    const ruleGroup = readJson.getRuleGroups();

    const classificationMetadataEntry = ruleGroup.flatMap(ruleGroup => ruleGroup.queryAllOptional("classification_rule"))
      .flatMap(e => e.queryAllOptional("entry"));

    const propertyBasedClassificationList = classificationMetadataEntry.filter(entry => {
      return entry.queryAllOptional("property").length !== 0
    })

    const computedClassificationIdList = propertyBasedClassificationList.filter(entry => {

      const isTrue = entry.queryAllOptional("property")
        .reduce((acc, operation) => {
          const propertyValue = getProperty(readJson, personQueryType, operation.attributeMap.property_rule_ref);
          const value = createOperationFromParent(readJson, operation.query("operation"), key => getProperty(readJson, personQueryType, key));
          switch (operation.attributeMap.is) {
            case "lessThan":
              return acc && (Number(propertyValue) < Number(value));
            case "lessThanOrEqual":
              return acc && (Number(propertyValue) <= Number(value));
            case "greaterThan":
              return acc && (Number(propertyValue) > Number(value));
            case "greaterThanOrEqual":
              return acc && (Number(propertyValue) >= Number(value));
            case "equal":
              return acc && (Number(propertyValue) === Number(value));
            default: {
              throw new Error(`Unknown operation ${(operation as JsonQueryType).attributeMap.is}`);
            }
          }
        }, true);
      console.log(`classifyPerson ${entry.attributeMap.id} result ${isTrue}`)
      return isTrue;
    })
    .map(value => value.attributeMap.id);

    const staticClassificationId = personQueryType.queryAllOptional("classifications").flatMap(classifications => classifications.queryAllOptional("classification"))
      .filter(classification => {
        return !propertyBasedClassificationList.map(entry => entry.attributeMap.id)
          .includes(classification.attributeMap.classification_rule_ref);
      })
      .map(value => value.attributeMap.classification_rule_ref)


    return [...computedClassificationIdList, ...staticClassificationId];
  } catch (e: any) {
    throw mergeError(e, new Error(`classifyPerson failed for ${personQueryType.attributeMap.id}`));
  }

}