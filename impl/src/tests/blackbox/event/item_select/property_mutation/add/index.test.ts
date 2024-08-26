import {testBase} from "../../../../test_base";

/*description
# Item selection
## When
- selecting items with
  - `min` value of 1
- apply property_mutation to increase `property` value by 1

- already having item `0`

## It should
modify item `0` by adding property with value 1
 */
/*tags
- item
- property_mutation
 */
const test= testBase(__dirname)
it(test.name, test.success)
