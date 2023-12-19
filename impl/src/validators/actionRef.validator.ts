import {AttributeNotInValidationError, Validator} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema["children"]["actions"]["children"]["by"]["children"]["do"]

export const actionRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const ruleGroups = jsonSchema.getRuleGroups();
const metadata = ruleGroups.flatMap(ruleGroup => ruleGroup.queryAllOptional("action_metadata"));
const raceMetadataNames = metadata.flatMap(e => e.queryAll("person_to_person").map(e => e.getAttribute("name")));

return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("action_ref")
  .filter((race) => !raceMetadataNames.includes(race.getAttribute("action_ref")))
  .map(race => new AttributeNotInValidationError(race, "action_ref", raceMetadataNames));
}