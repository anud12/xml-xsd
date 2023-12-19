import {JsonSchema} from "../JsonSchema";

type PersonQueryType = JsonSchema["children"]["people"]["children"]["person"]

export const getById = (jsonSchema: JsonSchema, name: string): PersonQueryType => {
  return jsonSchema.queryAll("people")
    .flatMap(e => e.queryAll("person"))
    .find(e => e.getAttribute("id") === name)
}