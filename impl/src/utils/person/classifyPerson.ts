import {getProperty, PersonQueryType} from "./getProperty";
import {createOperationFromParent} from "../operation/createOperationFromParent";
import {JsonUtil} from "../util";
import {JsonQueryType} from "../../JsonQueryType";


export const classifyPerson = (readJson: JsonUtil, personQueryType: PersonQueryType): string[] => {
  try {
    console.log(`classifyPerson for ${personQueryType.attributeMap.id}`)
    const ruleGroup = readJson.getRuleGroups();

    const classificationMetadataEntry = ruleGroup.flatMap(ruleGroup => ruleGroup.queryAllOptional("classification_rule"))
      .flatMap(e => e.queryAllOptional("entry"));

    return classificationMetadataEntry.filter(entry => {
      const isTrue = entry.queryAll("property")
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
            case "notEqual":
              return acc && (Number(propertyValue) !== Number(value));
            default: {
              throw new Error(`Unknown operation ${(operation as JsonQueryType).attributeMap.is}`);
            }
          }
        }, true);
      console.log(`classifyPerson ${entry.attributeMap.id} result ${isTrue}`)
      return isTrue;
    })
      .map(entry => entry.attributeMap.id);
  } catch (e:any)  {
    const newError = new Error(`classifyPerson failed for ${personQueryType.attributeMap.id}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }

}