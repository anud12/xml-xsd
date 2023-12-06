import {JsonQueryType, nodeAttributes} from "../JSONQuery";
import {JsonUtil} from "../utils/util";

export class ValidationError<P extends JsonQueryType<any,any>> {
  constructor(public jsonQuery: P, attribute?:keyof P[typeof nodeAttributes], public message?: string) {
  }
}

export class AttributeNotInValidationError<T extends JsonQueryType<any, any>> extends ValidationError<T> {

  constructor(public jsonQuery: T, attribute: keyof T[typeof nodeAttributes], expectedValues: string[]) {
    const message = `ValidationError: ${jsonQuery[attribute]} at ${jsonQuery.getPath()}@${String(attribute).replace("$", "")} not in [${expectedValues.join(", ")}]`
    super(jsonQuery, attribute, message);
  }
}
export type Validator<T extends ValidationError<any>> = (unit: JsonUtil) => Promise<T[]>;