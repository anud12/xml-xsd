import {AttributeNotInValidationError, Validator} from "./_type";
import {nodeBodyType} from "../JSONQuery";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema[typeof nodeBodyType]["people"][typeof nodeBodyType]["person"][typeof nodeBodyType]["inventory"][typeof nodeBodyType]["item"]

export const itemRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const ruleGroup = jsonSchema.query("rule_group");
  const metadata = ruleGroup.queryAll("item_metadata");
  const raceMetadataNames = metadata.flatMap(e => e.queryAll("entry").map(e => e.$name));

  return jsonSchema.queryAllRecursiveWithAttributeFrom<QueryType>("$item_ref")
    .filter((race) => !raceMetadataNames.includes(race.$item_ref))
    .map(race => new AttributeNotInValidationError(race, "$item_ref", raceMetadataNames));
}