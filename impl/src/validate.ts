import {propertyRefValidator} from "./validators/propertyRef.validator";
import {raceRefValidator} from "./validators/raceRef.validator";
import {JsonQuery} from "./JSONQuery";
import {JsonSchema} from "./utils/JsonSchema";
import {ValidationError} from "./validators/_type";
import {actionRuleRefValidator} from "./validators/actionRuleRef.validator";
import {locationRefValidator} from "./validators/locationRef.validator";
import {personRefValidator} from "./validators/personRefValidator";
import {itemRuleRefValidator} from "./validators/itemRuleRef.validator";
import {JsonUtil} from "./utils/util";
import {nameRuleRefValidator} from "./validators/nameRuleRef.validator";
import {actionRefValidator} from "./validators/actionRef.validator";

export const validateString = async (xmlString: string, log: (...string: any[]) => void) => {
  const readJson = JsonQuery.fromText<JsonSchema>(xmlString.toString());
  const jsonUtils = new JsonUtil(readJson);
  const result: Array<ValidationError<any>> = [];
  result.push(...await propertyRefValidator(jsonUtils));
  result.push(...await raceRefValidator(jsonUtils));
  result.push(...await actionRefValidator(jsonUtils));
  result.push(...await actionRuleRefValidator(jsonUtils));
  result.push(...await locationRefValidator(jsonUtils));
  result.push(...await personRefValidator(jsonUtils));
  result.push(...await itemRuleRefValidator(jsonUtils));
  result.push(...await nameRuleRefValidator(jsonUtils));

  return validate(jsonUtils, log);
}


export const validate = async (jsonUtils: JsonUtil, log: (...string: any[]) => void) => {
  const result: Array<ValidationError<any>> = [];
  result.push(...await propertyRefValidator(jsonUtils));
  result.push(...await raceRefValidator(jsonUtils));
  result.push(...await actionRuleRefValidator(jsonUtils));
  result.push(...await locationRefValidator(jsonUtils));
  result.push(...await personRefValidator(jsonUtils));
  result.push(...await itemRuleRefValidator(jsonUtils));
  result.push(...await nameRuleRefValidator(jsonUtils));

  return result;
}