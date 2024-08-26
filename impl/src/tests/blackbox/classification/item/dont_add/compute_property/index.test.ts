import {testBase} from "../../../../test_base";

/*description
# Don't classification on item based on property without item default value
## Given
  - classification rule for `property` value equal to 10
  - property `property` with `item_default` value to 10
## Then
  Item doesn't change
 */

/*tags
- item
- classification
- property
 */
const test= testBase(__dirname)
it(test.name, test.success)

