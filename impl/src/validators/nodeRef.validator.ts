import {AttributeNotInValidationError, Validator} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema["children"]["rule_group"]["children"]["location_graph_rule"]["children"]["node"]["children"]["link_group"]["children"]["to_option"]

export const nodeRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const ruleGroups = jsonSchema.getRuleGroups();
  const metadata = ruleGroups.flatMap(ruleGroup => ruleGroup.queryAllOptional("location_graph_rule"));
  const raceMetadataNames = metadata.flatMap(e => e.queryAllOptional("node").map(e => e.attributeMap.id));

  return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("node_ref")
    .filter((race) => !raceMetadataNames.includes(race.attributeMap.node_ref))
    .map(race => new AttributeNotInValidationError(race, "node_ref", raceMetadataNames));
}