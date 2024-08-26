import {testBase} from "../../../../test_base";

/*description
# Person selection with min values and no peoples
## When

selecting persons with
  - a `min` value of 2

## It should
create 2 people with races chosen at random
  - race
  - second_race
 */

/*tags
- person_select
 */
const test= testBase(__dirname)
it(test.name, test.success)

