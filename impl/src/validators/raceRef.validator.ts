import {AttributeNotInValidationError, Validator} from "./_type";
import {nodeBodyType} from "../JSONQuery";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema[typeof nodeBodyType]["people"][typeof nodeBodyType]["person"][typeof nodeBodyType]["race"]

export const raceRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const ruleGroups = jsonSchema.getRuleGroups();
  const metadata = ruleGroups.flatMap(ruleGroup => ruleGroup.queryAllOptional("race_metadata"));
  const raceMetadataNames = metadata.flatMap(e => e.queryAll("entry").map(e => e.$name));

  return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("$race_ref")
    .filter((race) => !raceMetadataNames.includes(race.$race_ref))
    .map(race => new AttributeNotInValidationError(race, "$race_ref", raceMetadataNames));
}