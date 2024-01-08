import {AttributeNotInValidationError, Validator} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema["children"]["people"]["children"]["person"]["children"]["race"]

export const raceRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const ruleGroups = jsonSchema.getRuleGroups();
  const metadata = ruleGroups.flatMap(ruleGroup => ruleGroup.queryAllOptional("race_metadata"));
  const raceMetadataNames = metadata.flatMap(e => e.queryAll("entry").map(e => e.attributeMap.name));

  return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("race_ref")
    .filter((race) => !raceMetadataNames.includes(race.attributeMap.race_ref))
    .map(race => new AttributeNotInValidationError(race, "race_ref", raceMetadataNames));
}