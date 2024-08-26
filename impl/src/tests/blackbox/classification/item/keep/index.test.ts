import {testBase} from "../../../test_base";

/*description
# Keep classification on item
## Given
  - classification rule
  - item with classification
## Then
  Item doesn't change.
 */

/*tags
- item
- classification
 */
const test= testBase(__dirname)
it(test.name, test.success)

