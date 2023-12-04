import {AttributeNotInValidationError, Validator} from "./_type";
import {nodeBodyType} from "../JSONQuery";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema[typeof nodeBodyType]["actions"][typeof nodeBodyType]["by"][typeof nodeBodyType]["do"]

export const actionRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const ruleGroups = jsonSchema.getRuleGroups();
const metadata = ruleGroups.flatMap(ruleGroup => ruleGroup.queryAllOptional("action_metadata"));
const raceMetadataNames = metadata.flatMap(e => e.queryAll("person_to_person").map(e => e.$name));

return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("$action_ref")
  .filter((race) => !raceMetadataNames.includes(race.$action_ref))
  .map(race => new AttributeNotInValidationError(race, "$action_ref", raceMetadataNames));
}