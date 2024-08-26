import {testBase} from "../../test_base";

/*description
# `create_location_graph` action
## Given
create_location_graph with attribute `location_graph_rule_ref` set to "location_graph_rule_id"
## Then
It should create a new location graph starting from `setup > starting node` rule
 */

/*tags
- location_graph
- location_graph.create
 */
const test= testBase(__dirname)
it(test.name, test.success)
