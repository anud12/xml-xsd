import {AttributeNotInValidationError, Validator} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";

type QueryType = JsonSchema["children"]["actions"]["children"]["location_graph.node.create_adjacent"]

export const nodeIdRefValidator: Validator<AttributeNotInValidationError<QueryType>> = async (jsonSchema) => {
  const ruleGroups = jsonSchema.json
    .queryOptional("data")
    ?.queryOptional("location")
    ?.queryAllOptional("location_graph");
  const metadata = ruleGroups?.flatMap(ruleGroup => ruleGroup.queryAllOptional("node"))
  .map(element => element.attributeMap.id) ?? [];

  return jsonSchema.json.queryAllRecursiveWithAttributeFrom<QueryType>("node_id_ref")
    .filter((testElement) => !metadata.includes(testElement.attributeMap.node_id_ref))
    .map(testElement => new AttributeNotInValidationError(testElement, "node_id_ref", metadata));
}