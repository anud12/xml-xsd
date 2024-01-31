import {AttributeNotInValidationError, Validator} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema["children"]["actions"]["children"]["by"]["children"]["do"]

export const actionRuleRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const ruleGroups = jsonSchema.getRuleGroups();
  const metadata = ruleGroups.flatMap(ruleGroup => ruleGroup.queryAllOptional("action_rule"));
  const raceMetadataNames = metadata.flatMap(e => e.queryAll("person_to_person").map(e => e.attributeMap.id));

  return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("action_rule_ref")
    .filter((race) => !raceMetadataNames.includes(race.attributeMap.action_rule_ref))
    .map(race => new AttributeNotInValidationError(race, "action_rule_ref", raceMetadataNames));
}