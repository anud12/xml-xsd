import {AttributeNotInValidationError, Validator} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";
import any = jasmine.any;

type QueryType = JsonSchema["children"]["actions"]["children"]["by"]

export const personRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const raceMetadataNames = jsonSchema.json.queryAll("people").flatMap(e => e.queryAll("person").map(e => e.attributeMap.id));


  return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("person_ref")
    .filter((race) => !raceMetadataNames.includes(race.attributeMap.person_ref))
    .map(race => new AttributeNotInValidationError(race, "person_ref", raceMetadataNames));
}

