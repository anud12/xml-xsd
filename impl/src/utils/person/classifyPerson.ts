import {Unit} from "../middleware";
import {getProperty, PersonQueryType} from "./getProperty";
import {createOperationFromParent} from "../operation/createOperationFromParent";

export const classifyPerson = (readJson: Unit, personQueryType: PersonQueryType): string[] => {
  try {
    const classificationMetadataEntry = readJson.json.queryAll("classification_metadata")
      .flatMap(e => e.queryAllOptional("entry"));

    const applicableClassificationNames = classificationMetadataEntry.filter(entry => {
      const isTrue = entry.queryAll("has_positive_value")
        .reduce((acc, operation) => {
          const formula = createOperationFromParent(readJson, operation, key => getProperty(readJson, personQueryType, key));
          const value = formula("0");
          return acc && Number(value) > 0;

        }, true);
      return isTrue;
    })
      .map(entry => entry.$name)

    return applicableClassificationNames;
  } catch (e) {
    const newError = new Error(`classifyPerson failed for ${personQueryType.$name}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }

}