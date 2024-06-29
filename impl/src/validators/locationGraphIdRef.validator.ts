import {AttributeNotInValidationError, Validator} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema["children"]["actions"]["children"]["location_graph.node.create_adjacent"]

export const locationGraphIdRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const ruleGroups = jsonSchema.json.queryAllOptional("location_graph");
  const metadata = ruleGroups.flatMap(ruleGroup => ruleGroup.attributeMap.id);

  return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("location_graph_id_ref")
    .filter((testElement) => !metadata.includes(testElement.attributeMap.location_graph_id_ref))
    .map(testElement => new AttributeNotInValidationError(testElement, "location_graph_id_ref", metadata));
}