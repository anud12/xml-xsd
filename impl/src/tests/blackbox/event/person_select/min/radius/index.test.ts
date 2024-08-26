import {testBase} from "../../../../test_base";

/*description
# Person selection with min values and classification
## When

selecting persons with
  - a `min` value of 3
  - radius of 100
  - property_rule with default value 10

## It should
create 2 people because `0` is within the radius
  - with location x: -16, y: 0
  - with location x: 33, y: 50
 */

/*tags
- person_select
 */
const test= testBase(__dirname)
it(test.name, test.success)

