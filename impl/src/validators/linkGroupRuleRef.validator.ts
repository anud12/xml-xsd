import {AttributeNotInValidationError, Validator} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema["children"]["rule_group"]["children"]["location_graph_rule"]["children"]["node_rule"]["children"]["link_group_list"]["children"]["reference"]

export const linkGroupRuleRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const ruleGroups = jsonSchema.getRuleGroups();
  const metadata = ruleGroups.flatMap(ruleGroup => ruleGroup.queryAllOptional("link_group_rule_list"));
  const raceMetadataNames = metadata.flatMap(e => e.queryAllOptional("link_group_rule").map(e => e.attributeMap.id));

  return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("link_group_rule_ref")
    .filter((race) => !raceMetadataNames.includes(race.attributeMap.link_group_rule_ref))
    .map(race => new AttributeNotInValidationError(race, "link_group_rule_ref", raceMetadataNames));
}