import {AttributeNotInValidationError, Validator} from "./_type";
import {nodeBodyType} from "../JSONQuery";
import {JsonSchema} from "../utils/JsonSchema";

type RaceQueryType = JsonSchema[typeof nodeBodyType]["actions"][typeof nodeBodyType]["by"][typeof nodeBodyType]["do"]

export const actionRefValidator: Validator<AttributeNotInValidationError<RaceQueryType>> = async (jsonSchema) => {
  const ruleGroup = jsonSchema.query("rule_group");
  const metadata = ruleGroup.queryAll("action_metadata");
  const raceMetadataNames = metadata.flatMap(e => e.queryAll("person_to_person").map(e => e.$name));

  return jsonSchema.queryAllRecursiveWithAttributeFrom<RaceQueryType>("$action_ref")
    .filter((race) => !raceMetadataNames.includes(race.$action_ref))
    .map(race => new AttributeNotInValidationError(race, "$action_ref", raceMetadataNames));
}