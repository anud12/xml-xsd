import {testBase} from "../../../test_base";

/*description
# `person.teleport` action on person to a `link_to`

Having an empty person
It should teleport person `person_id` to `link_to` under `location_graph_id > node`
with given `accumulated_distance`

## Given
- 1 `person`
- 1 `location_graph` with 1 `node`
- 1 `actions` with `person.teleport`
## Then
It should create a `person` with `person_id_ref` under the target node.
and it should should remove the `person` with `person_id_ref` under the previous node.
 */

/*tags
- person
- person.teleport
 */
const test= testBase(__dirname)
it(test.name, test.success)
