import {testBase} from "../../../../../../test_base";

/*description
# Global Action
## Update property when target doesn't have one
## When
A global action is defined to add 1 to `property` on target

Using global action on different person without `property`

## It should
do nothing
 */

/*tags
- global_action
- property
- type__person_selection
 */

const test= testBase(__dirname)
it(test.name, test.success)

