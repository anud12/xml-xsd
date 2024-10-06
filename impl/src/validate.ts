import {propertyRefValidator} from "./validators/propertyRef.validator";
import {raceRefValidator} from "./validators/raceRef.validator";
import {JsonQuery} from "./JSONQuery";
import {JsonSchema} from "./utils/JsonSchema";
import {ValidationError} from "./validators/_type";
import {actionRuleRefValidator} from "./validators/actionRuleRef.validator";
import {personRefValidator} from "./validators/personRefValidator";
import {JsonUtil} from "./utils/util";
import {nameRuleRefValidator} from "./validators/nameRuleRef.validator";
import {nodeRuleRefValidator} from "./validators/nodeRuleRef.validator";
import {nodeIdRefValidator} from "./validators/nodeIdRef.validator";
import {locationGraphIdRefValidator} from "./validators/locationGraphIdRef.validator";
import {locationClassificationRuleRefValidator} from "./validators/locationClassificationRuleRefValidator";
import {classificationRuleRefValidator} from "./validators/classificationRuleRef.validator";

export const validateString = async (xmlString: string, log: (...string: any[]) => void) => {
  const readJson = JsonQuery.fromText<JsonSchema>(xmlString.toString());
  const jsonUtils = new JsonUtil(readJson);
  return validate(jsonUtils, log);
}


export const validate = async (jsonUtils: JsonUtil, log: (...string: any[]) => void) => {
  const result: Array<ValidationError<any>> = [];
  result.push(...await propertyRefValidator(jsonUtils));
  result.push(...await raceRefValidator(jsonUtils));
  result.push(...await actionRuleRefValidator(jsonUtils));
  result.push(...await classificationRuleRefValidator(jsonUtils));
  result.push(...await locationClassificationRuleRefValidator(jsonUtils));
  result.push(...await personRefValidator(jsonUtils));
  result.push(...await nameRuleRefValidator(jsonUtils));
  result.push(...await nodeRuleRefValidator(jsonUtils));
  result.push(...await nodeIdRefValidator(jsonUtils));
  result.push(...await locationGraphIdRefValidator(jsonUtils));

  return result;
}