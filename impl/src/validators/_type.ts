import {JsonUtil} from "../utils/util";
import {JsonQueryType} from "../JsonQueryType";

export class ValidationError<P extends JsonQueryType<any,any>> {
  constructor(public jsonQuery: P, attribute?:keyof P["attributeMap"], public message?: string) {
  }
}

export class AttributeNotInValidationError<T extends JsonQueryType<any>> extends ValidationError<T> {

  constructor(public jsonQuery: T, attribute: keyof T["attributeMap"], expectedValues: string[]) {
    const message = `ValidationError: ${jsonQuery[attribute]} at ${jsonQuery.getPath()}@${String(attribute).replace("$", "")} not in [${expectedValues.join(", ")}]`
    super(jsonQuery, attribute, message);
  }
}
export type Validator<T extends ValidationError<any>> = (unit: JsonUtil) => Promise<T[]>;