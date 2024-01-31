import {AttributeNotInValidationError, Validator} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema["children"]["rule_group"]["children"]["name_rule"]["children"]["entry"]["children"]["name_token"]["children"]["ref"]

export const nameRuleRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
	const metadata = jsonSchema.getRuleGroups()
		.flatMap(ruleGroup => ruleGroup.queryAllOptional("name_rule"))
		.flatMap(e => e.queryAll("entry"));
	const nameMetadataNames = metadata.map(e => e.attributeMap.id);

	return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("name_rule_ref")
		.filter((name) => !nameMetadataNames.includes(name.attributeMap.name_rule_ref))
		.map(name => new AttributeNotInValidationError(name, "name_rule_ref", nameMetadataNames));

}