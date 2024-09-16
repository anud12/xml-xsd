import {testBase} from "../../../test_base";

/*description
# `location_graph_id_ref` validation
## Given
A property value of `location_graph_id_ref` that isn't found in
  - 'location_graph@id'
## Then
It should throw an error.
 */

/*tags
- validation
- location_graph_id_ref
 */
const test= testBase(__dirname)
it(test.name, test.validationError)
