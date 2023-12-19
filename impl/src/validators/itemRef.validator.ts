import {AttributeNotInValidationError, Validator} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema["children"]["people"]["children"]["person"]["children"]["inventory"]["children"]["item"]

export const itemRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const ruleGroups = jsonSchema.getRuleGroups();
  const metadata = ruleGroups.flatMap(ruleGroup => ruleGroup.queryAllOptional("item_metadata"));
  const raceMetadataNames = metadata.flatMap(e => e.queryAll("entry").map(e => e.getAttribute("name")));

  return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("item_ref")
    .filter((race) => !raceMetadataNames.includes(race.getAttribute("item_ref")))
    .map(race => new AttributeNotInValidationError(race, "item_ref", raceMetadataNames));
}