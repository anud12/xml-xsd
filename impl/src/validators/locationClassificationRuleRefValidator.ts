import {AttributeNotInValidationError, Validator} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema["children"]["rule_group"]["children"]["location_graph_rule"]["children"]["node_rule"]["children"]["classifications"]["children"]["classification"];

export const locationClassificationRuleRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const ruleGroups = jsonSchema.getRuleGroups();
  const metadata = ruleGroups.flatMap(ruleGroup => ruleGroup.queryAllOptional("location_classification_rule"));
  const raceMetadataNames = metadata.flatMap(e => e.queryAll("entry").map(e => e.attributeMap.id));

  return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("location_classification_rule_ref")
    .filter((race) => !raceMetadataNames.includes(race.attributeMap.location_classification_rule_ref))
    .map(race => new AttributeNotInValidationError(race, "location_classification_rule_ref", raceMetadataNames));
}