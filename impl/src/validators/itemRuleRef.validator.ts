import {AttributeNotInValidationError, Validator} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema["children"]["rule_group"]["children"]["events_rule"]["children"]["entry"]["children"]["then"]["children"]["select_person"]["children"]["inventory"]["children"]["item"]

export const itemRuleRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const ruleGroups = jsonSchema.getRuleGroups();
  const metadata = ruleGroups.flatMap(ruleGroup => ruleGroup.queryAllOptional("item_rule"));
  const raceMetadataNames = metadata.flatMap(e => e.queryAll("entry").map(e => e.attributeMap.id));

  return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("item_rule_ref")
    .filter((race) => !raceMetadataNames.includes(race.attributeMap.item_rule_ref))
    .map(race => new AttributeNotInValidationError(race, "item_rule_ref", raceMetadataNames));
}