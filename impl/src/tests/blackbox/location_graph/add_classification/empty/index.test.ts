import {testBase} from "../../../test_base";

/*description
# `location_graph.node.add_classification` action with empty selection
## Given
- `location_graph.node.add_classification` action with empty selection
-
## Then
It should add classification to all nodes.
 */

/*tags
- location_graph
- location_graph.node.add_classification
- type__node_graph__selection
 */
const test= testBase(__dirname)
it(test.name, test.success)
