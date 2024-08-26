import {testBase} from "../../../test_base";

/*description
# `location_graph.node.add_classificationt` action with empty selection
## Given
- `location_graph.node.add_classificationt` action with empty selection
-
## Then
It should do nothing.
 */

/*tags
- location_graph
- location_graph.node.add_classification
- type__node_graph__selection
 */
const test= testBase(__dirname)
it(test.name, test.success)
