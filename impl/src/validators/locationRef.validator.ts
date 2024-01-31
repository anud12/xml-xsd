import {AttributeNotInValidationError, Validator} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema["children"]["rule_group"]["children"]["locations_markov_chain"]["children"]["location_markov_link"]["children"]["sibling"]

export const locationRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const ruleGroups = jsonSchema.getRuleGroups();
  const metadata = ruleGroups.flatMap(ruleGroup => ruleGroup.queryAllOptional("locations_markov_chain"));
  const raceMetadataNames = metadata.flatMap(e => e.queryAll("location_markov_link").map(e => e.attributeMap.type));

  return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("location_rule_ref")
    .filter((race) => !raceMetadataNames.includes(race.attributeMap.location_rule_ref))
    .map(race => new AttributeNotInValidationError(race, "location_rule_ref", raceMetadataNames));
}