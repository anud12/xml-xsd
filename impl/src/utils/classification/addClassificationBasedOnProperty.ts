import {JsonUtil} from "../util";
// import {getProperty} from "../person/getProperty";
import {createOperationFromParent} from "../operation/createOperationFromParent";
import {JsonQueryType} from "../../JsonQueryType";
import {mergeError} from "../../mergeError";

export const addClassificationBasedOnProperty = (readJson: JsonUtil, getProperty: (key:string) => string) => {
  try {
    const ruleGroup = readJson.getRuleGroups();

    const classificationMetadataEntry = ruleGroup.flatMap(ruleGroup => ruleGroup.queryAllOptional("classification_rule"))
      .flatMap(e => e.queryAllOptional("entry"));

    const propertyBasedClassificationList = classificationMetadataEntry.filter(entry => {
      return entry.queryAllOptional("property").length !== 0
    })

    return propertyBasedClassificationList.filter(entry => {

      const isTrue = entry.queryAllOptional("property")
        .reduce((acc, operation) => {
          const propertyValue = getProperty(operation.attributeMap.property_rule_ref);
          const value = createOperationFromParent(readJson, operation.query("operation"), key => getProperty(key));
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
      return isTrue;
    });
  } catch (e) {
    throw mergeError(e, new Error(`classifyBasedOnProperty failed`));
  }

}