import {AttributeNotInValidationError, Validator} from "./_type";
import {nodeBodyType} from "../JSONQuery";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema[typeof nodeBodyType]["actions"][typeof nodeBodyType]["by"]

export const personRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const raceMetadataNames = jsonSchema.queryAll("people").flatMap(e => e.queryAll("person").map(e => e.$id));

  return jsonSchema.queryAllRecursiveWithAttributeFrom<QueryType>("$person_ref")
    .filter((race) => !raceMetadataNames.includes(race.$person_ref))
    .map(race => new AttributeNotInValidationError(race, "$person_ref", raceMetadataNames));
}