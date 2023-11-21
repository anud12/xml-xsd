import {JsonSchema} from "../JsonSchema";
import {nodeBodyType} from "../../JSONQuery";

type PersonQueryType = JsonSchema[typeof nodeBodyType]["people"][typeof nodeBodyType]["person"]

export const getById = (jsonSchema: JsonSchema, name: string): PersonQueryType => {
  return jsonSchema.queryAll("people")
    .flatMap(e => e.queryAll("person"))
    .find(e => e.$id === name)
}