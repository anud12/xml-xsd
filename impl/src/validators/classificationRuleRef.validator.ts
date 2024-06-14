import {AttributeNotInValidationError, Validator} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema["children"]["people"]["children"]["person"]["children"]["classifications"]["children"]["classification"]

export const classificationRuleRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const ruleGroups = jsonSchema.getRuleGroups();
  const metadata = ruleGroups.flatMap(ruleGroup => ruleGroup.queryAllOptional("classification_rule"));
  const raceMetadataNames = metadata.flatMap(e => e.queryAll("entry").map(e => e.attributeMap.id));

  return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("classification_rule_ref")
    .filter((race) => !raceMetadataNames.includes(race.attributeMap.classification_rule_ref))
    .map(race => new AttributeNotInValidationError(race, "classification_rule_ref", raceMetadataNames));
}