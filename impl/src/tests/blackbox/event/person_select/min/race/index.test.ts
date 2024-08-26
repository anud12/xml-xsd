import {testBase} from "../../../../test_base";

/*description
# Person selection with min values and race
## When

selecting persons with
  - a `min` value of 2
  - race `race`

## It should
create 2 people with race `race`
 */

/*tags
- person_select
 */
const test= testBase(__dirname)
it(test.name, test.success)

