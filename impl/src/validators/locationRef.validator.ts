import {AttributeNotInValidationError, Validator} from "./_type";
import {nodeBodyType} from "../JSONQuery";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema[typeof nodeBodyType]["rule_group"][typeof nodeBodyType]["locations_markov_chain"][typeof nodeBodyType]["location_markov_link"][typeof nodeBodyType]["sibling"]

export const locationRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const ruleGroups = jsonSchema.getRuleGroups();
  const metadata = ruleGroups.flatMap(ruleGroup => ruleGroup.queryAllOptional("locations_markov_chain"));
  const raceMetadataNames = metadata.flatMap(e => e.queryAll("location_markov_link").map(e => e.$type));

  return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("$location_ref")
    .filter((race) => !raceMetadataNames.includes(race.$location_ref))
    .map(race => new AttributeNotInValidationError(race, "$location_ref", raceMetadataNames));
}