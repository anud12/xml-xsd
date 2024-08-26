import {testBase} from "../../../../test_base";

/*description
# Add classification on item if property exists
## Given
  - classification rule for `property` value equal to 10
  - item with property `property` value 10
## Then
  Item gains classification `classification`.
 */

/*tags
- item
- classification
- property
 */
const test= testBase(__dirname)
it(test.name, test.success)

