import {MutationMiddleware} from "../_type";
import {JsonUtil} from "../../utils/util";

export const locationGraphAddClassification: MutationMiddleware = (readJson) => {
  const actionList = readJson.json.queryAllOptional("actions")
    .flatMap(actionsElement => actionsElement.queryAllOptional("location_graph.node.add_classification"))
    .flatMap(addClassificationElement => {
      const applicableNode = readJson.locationGraph.selectNodeGraph(addClassificationElement.queryOptional("node_graph_selection"))
      if (applicableNode.length === 0) {
        return []
      }
      return applicableNode.map(node => async () => {
          let classificationsElement = node.queryOptional("classifications");
          if (!classificationsElement) {
            classificationsElement = node.appendChild("classifications", undefined, {});
          }
          addClassificationElement.queryAllOptional("to_be_added__classification").forEach(toBeAddedElement => {
            classificationsElement.appendChild("classification", undefined, {
              location_classification_rule_ref: toBeAddedElement.attributeMap.location_classification_rule_ref
            })
            toBeAddedElement.queryAllOptional("and").forEach(andElement => {
              classificationsElement.appendChild("classification", undefined, {
                location_classification_rule_ref: andElement.attributeMap.location_classification_rule_ref
              })
            });
          });
        }
      )
    });
  return async (writeJson) => {
    writeJson.json.queryAllOptional("actions")
      .flatMap(actionsElement => actionsElement.queryAllOptional("location_graph.node.add_classification"))
      .forEach(addClassificationElement => {
        addClassificationElement.removeFromParent();
      });
    actionList.forEach(actionList => actionList());
  }
}