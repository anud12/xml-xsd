import {propertyRefValidator} from "./validators/propertyRef.validator";
import {raceRefValidator} from "./validators/raceRef.validator";
import {JsonQuery} from "./JSONQuery";
import {JsonSchema} from "./utils/JsonSchema";
import {ValidationError} from "./validators/_type";
import {actionRefValidator} from "./validators/actionRef.validator";
import {locationRefValidator} from "./validators/locationRef.validator";
import {personRefValidator} from "./validators/personRefValidator";
import {itemRefValidator} from "./validators/itemRef.validator";

export const validate = async (xmlString: string, log: (...string: any[]) => void) => {
  const readJson = JsonQuery.fromText<JsonSchema>(xmlString.toString());

  const result: Array<ValidationError<any>> = [];
  result.push(...await propertyRefValidator(readJson));
  result.push(...await raceRefValidator(readJson));
  result.push(...await actionRefValidator(readJson));
  result.push(...await locationRefValidator(readJson));
  result.push(...await personRefValidator(readJson));
  result.push(...await itemRefValidator(readJson));

  return result;
}