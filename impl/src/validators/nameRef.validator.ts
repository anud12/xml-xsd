import {AttributeNotInValidationError, Validator} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema["children"]["rule_group"]["children"]["name_metadata"]["children"]["entry"]["children"]["name_token"]["children"]["ref"]

export const nameRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
	const metadata = jsonSchema.getRuleGroups()
		.flatMap(ruleGroup => ruleGroup.queryAllOptional("name_metadata"))
		.flatMap(e => e.queryAll("entry"));
	const nameMetadataNames = metadata.map(e => e.attributeMap.name);

	return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("name_ref")
		.filter((name) => !nameMetadataNames.includes(name.attributeMap.name_ref))
		.map(name => new AttributeNotInValidationError(name, "name_ref", nameMetadataNames));

}