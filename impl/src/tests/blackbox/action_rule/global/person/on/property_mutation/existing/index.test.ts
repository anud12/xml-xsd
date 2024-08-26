import {testBase} from "../../../../../../test_base";

/*description
# Global Action
## Update property when target has property
## When
A global action is defined to set 10 to `property` on target

Using global action on different person with `property`

## It should
set `property` value to 10
 */

/*tags
- global_action
- property
- type__person_selection
 */

const test= testBase(__dirname)
it(test.name, test.success)

