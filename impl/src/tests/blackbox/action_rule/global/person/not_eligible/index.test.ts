import {testBase} from "../../../../test_base";

/*description
# Global Action
## When
A global action is defined with from person selector

Using global action on target

Owner is not eligible to use the action

## It should
do nothing
 */

/*tags
- action_rule
- global_action
- type__person_selection
 */
const test= testBase(__dirname)
it(test.name, test.success)

