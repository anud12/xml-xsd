import {testBase} from "../../../../test_base";

/*description
#Person selection
##When
- selecting person with
  - `min` value of 1
- apply property_mutation to increase `property` value by 1

- already having item `0`

##It should
modify person `1` by adding property with value 1
 */

/*tags
- person_select
 */
const test= testBase(__dirname)
it(test.name, test.success)
