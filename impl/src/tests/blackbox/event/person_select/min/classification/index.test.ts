import {testBase} from "../../../../test_base";

/*description
# Person selection with min values and classification
## When

selecting persons with
  - a `min` value of 2
  - classification `classification` using a random value between 1 and 4
  - property_rule with default value 10

## It should
create 2 people
  - with property 2
  - with property 1
 */

/*tags
- person_select
 */
const test= testBase(__dirname)
it(test.name, test.success)

