import {testBase} from "../../../test_base";


/*description
# person.create
## When
person.create action is used with no children

## It should
create an empty person
 */

/*tags
  action,person,person.create
 */

const test= testBase(__dirname)
it(test.name, test.success)

