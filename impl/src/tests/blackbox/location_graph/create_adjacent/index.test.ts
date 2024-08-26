import {testBase} from "../../test_base";

/*description
# `location_graph.node.create_adjacent` action
## Given
3 entries with `location_graph.node.create_adjacent` with attribute `location_graph_id_ref` set to "location_graph_id"
and `node_id_ref` set to `node_id`
## Then
It should create 3 new nodes and links them to the node references by `node_id_ref`
 */

/*tags
- location_graph
- location_graph.node.create_adjacent
 */
const test= testBase(__dirname)
it(test.name, test.success)
