import {getProperty, PersonQueryType} from "./getProperty";
import {createOperationFromParent} from "../operation/createOperationFromParent";
import {JsonUtil} from "../util";


export const classifyPerson = (readJson: JsonUtil, personQueryType: PersonQueryType): string[] => {
  try {
    const ruleGroup = readJson.getRuleGroups();

    const classificationMetadataEntry = ruleGroup.flatMap(ruleGroup => ruleGroup.queryAllOptional("classification_metadata"))
      .flatMap(e => e.queryAllOptional("entry"));

    return classificationMetadataEntry.filter(entry => {
      const isTrue = entry.queryAll("property")
        .reduce((acc, operation) => {
          const propertyValue = getProperty(readJson, personQueryType, operation.$property_ref);
          const formula = createOperationFromParent(readJson, operation, key => getProperty(readJson, personQueryType, key));
          const value = formula("0");
          switch (operation.$is) {
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
              throw new Error(`Unknown operation ${operation.$is}`);
            }
          }
        }, true);
      return isTrue;
    })
      .map(entry => entry.$name);
  } catch (e:any)  {
    const newError = new Error(`classifyPerson failed for ${personQueryType.$name}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }

}