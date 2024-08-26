import {testBase} from "../../../test_base";

/*description
# `location_graph.node.add_classificationt` action with node id selection
## Given
- `location_graph.node.add_classificationt` action with `<has__node_graph_id node_graph_id_ref="node_id"/>`
-
## Then
It should add classification to the node with the given node id.
 */

/*tags
- location_graph
- location_graph.node.add_classification
- type__node_graph__selection
 */
const test= testBase(__dirname)
it(test.name, test.success)
