import {AttributeNotInValidationError, Validator} from "./_type";
import {nodeBodyType} from "../JSONQuery";
import {JsonSchema} from "../utils/JsonSchema";

type RaceQueryType = JsonSchema[typeof nodeBodyType]["people"][typeof nodeBodyType]["person"][typeof nodeBodyType]["race"]

export const raceRefValidator: Validator<AttributeNotInValidationError<RaceQueryType>> = async (jsonSchema) => {
  const ruleGroup = jsonSchema.query("rule_group");
  const metadata = ruleGroup.queryAll("race_metadata");
  const raceMetadataNames = metadata.flatMap(e => e.queryAll("entry").map(e => e.$name));

  return jsonSchema.queryAllRecursiveWithAttributeFrom<RaceQueryType>("$race_ref")
    .filter((race) => !raceMetadataNames.includes(race.$race_ref))
    .map(race => new AttributeNotInValidationError(race, "$race_ref", raceMetadataNames));
}