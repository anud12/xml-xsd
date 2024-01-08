import {AttributeNotInValidationError, Validator} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema["children"]["people"]["children"]["person"]["children"]["classifications"]["children"]["classification"]

export const classificationRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const ruleGroups = jsonSchema.getRuleGroups();
  const metadata = ruleGroups.flatMap(ruleGroup => ruleGroup.queryAllOptional("classification_metadata"));
  const raceMetadataNames = metadata.flatMap(e => e.queryAll("entry").map(e => e.attributeMap.name));

  return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("classification_ref")
    .filter((race) => !raceMetadataNames.includes(race.getAttribute("classification_ref")))
    .map(race => new AttributeNotInValidationError(race, "classification_ref", raceMetadataNames));
}