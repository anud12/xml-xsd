import {testBase} from "../../../test_base";

/*description
# `node_rule_ref` validation
## Given
A property value of `node_rule_ref` that isn't found in
  - `location_graph_rule/node_rule@id`
## Then
It should throw an error.
 */

/*tags
- validation
- node_rule_ref
 */
const test= testBase(__dirname)
it(test.name, test.error)
