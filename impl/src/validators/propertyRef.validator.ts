import {AttributeNotInValidationError, Validator} from "./_type";
import {nodeBodyType} from "../JSONQuery";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema[typeof nodeBodyType]["people"][typeof nodeBodyType]["person"][typeof nodeBodyType]["properties"][typeof nodeBodyType]["property"]

export const propertyRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const ruleGroup = jsonSchema.query("rule_group");
  const metadata = ruleGroup.queryAll("property_metadata");
  const raceMetadataNames = metadata.flatMap(e => e.queryAll("entry").map(e => e.$name));

  return jsonSchema.queryAllRecursiveWithAttributeFrom<QueryType>("$property_ref")
    .filter((race) => !raceMetadataNames.includes(race.$property_ref))
    .map(race => new AttributeNotInValidationError(race, "$property_ref", raceMetadataNames));
}