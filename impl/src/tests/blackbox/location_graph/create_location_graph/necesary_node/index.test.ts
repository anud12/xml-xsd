import {testBase} from "../../../test_base";

/*description
# `create_location_graph` action with necessary_node
## Given
create_location_graph with attribute `location_graph_rule_ref` set to "location_graph_rule_id"

'location_graph_rule' with 'necessary_node' set
## Then
It should create a new location graph starting from `setup > starting node` rule
and populate the graph with nodes until all the `necessary_node` rule is satisfied

When trying to populate the graph it should try to create an adjacent node for last created node, until it can't,
then it should repeat the process for the next created node.
 */

/*tags
- location_graph
- location_graph.create
- necessary_node
 */
const test= testBase(__dirname)
it(test.name, test.success)
