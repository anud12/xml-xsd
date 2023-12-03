import {AttributeNotInValidationError, Validator} from "./_type";
import {nodeBodyType} from "../JSONQuery";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema[typeof nodeBodyType]["people"][typeof nodeBodyType]["person"][typeof nodeBodyType]["classifications"][typeof nodeBodyType]["classification"]

export const classificationRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const ruleGroup = jsonSchema.query("rule_group");
  const metadata = ruleGroup.queryAll("classification_metadata");
  const raceMetadataNames = metadata.flatMap(e => e.queryAll("entry").map(e => e.$name));

  return jsonSchema.queryAllRecursiveWithAttributeFrom<QueryType>("$classification_ref")
    .filter((race) => !raceMetadataNames.includes(race.$classification_ref))
    .map(race => new AttributeNotInValidationError(race, "$classification_ref", raceMetadataNames));
}