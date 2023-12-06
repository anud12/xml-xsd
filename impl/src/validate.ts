import {propertyRefValidator} from "./validators/propertyRef.validator";
import {raceRefValidator} from "./validators/raceRef.validator";
import {JsonQuery} from "./JSONQuery";
import {JsonSchema} from "./utils/JsonSchema";
import {ValidationError} from "./validators/_type";
import {actionRefValidator} from "./validators/actionRef.validator";
import {locationRefValidator} from "./validators/locationRef.validator";
import {personRefValidator} from "./validators/personRefValidator";
import {itemRefValidator} from "./validators/itemRef.validator";
import {JsonUtil} from "./utils/util";

export const validate = async (xmlString: string, log: (...string: any[]) => void) => {
  const readJson = JsonQuery.fromText<JsonSchema>(xmlString.toString());
  const jsonUtils = new JsonUtil(readJson);
  const result: Array<ValidationError<any>> = [];
  result.push(...await propertyRefValidator(jsonUtils));
  result.push(...await raceRefValidator(jsonUtils));
  result.push(...await actionRefValidator(jsonUtils));
  result.push(...await locationRefValidator(jsonUtils));
  result.push(...await personRefValidator(jsonUtils));
  result.push(...await itemRefValidator(jsonUtils));

  return result;
}