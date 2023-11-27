import {JsonSchema} from "../utils/JsonSchema";

export type Validator = (unit: JsonSchema) => void;