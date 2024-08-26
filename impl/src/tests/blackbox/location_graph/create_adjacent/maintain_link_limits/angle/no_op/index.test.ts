import {testBase} from "../../../../../test_base";

/*description
# `location_graph.node.create_adjacent` action should maintain link limits when adding adjacent links based on angle
## Given

## Then
- The adjacent link limits should be maintained by not creating any adjacent links because there are no valid spaces defined in `link_groups`
 */

/*tags
- location_graph
- location_graph.node.create_adjacent
 */
const test= testBase(__dirname)
it(test.name, test.success)
