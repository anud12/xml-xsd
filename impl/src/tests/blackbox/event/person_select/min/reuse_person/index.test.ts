import {testBase} from "../../../../test_base";

/*description
#Person selection with min values and no peoples
##When

selecting persons with
  - a `min` value of 2

##It should
create 1 people at location x: 0, y: 0
 */

/*tags
- person_select
 */
const test= testBase(__dirname)
it(test.name, test.success)

