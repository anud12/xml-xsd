import {JsonSchema} from "../JsonSchema";

type PersonQueryType = JsonSchema["children"]["data"]["children"]["people"]["children"]["person"]

export const getById = (jsonSchema: JsonSchema, name: string): PersonQueryType => {
  return jsonSchema.queryOptional("data")
    .queryAll("people")
    .flatMap(e => e.queryAll("person"))
    .find(e => e.attributeMap.id === name)
}