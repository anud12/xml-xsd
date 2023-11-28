import {JsonSchema} from "../utils/JsonSchema";
import {JsonQueryType, nodeAttributes} from "../JSONQuery";

export class ValidationError<P extends JsonQueryType> {
  constructor(public jsonQuery: P, attribute?:keyof P[typeof nodeAttributes], public message?: string) {
  }
}

export type Validator<T extends ValidationError<any>> = (unit: JsonSchema) => Promise<T[]>;