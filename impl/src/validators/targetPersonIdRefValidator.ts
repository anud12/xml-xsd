import {AttributeNotInValidationError, Validator} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema["children"]["actions"]["children"]["person.on_person.property_mutation"]

export const personRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const raceMetadataNames = jsonSchema.json.queryAllOptional("people").flatMap(e => e.queryAll("person").map(e => e.attributeMap.id));

  return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("target_person_id_ref")
    .filter((race) => !raceMetadataNames.includes(race.attributeMap.target_person_id_ref))
    .map(race => new AttributeNotInValidationError(race, "target_person_id_ref", raceMetadataNames));
}

