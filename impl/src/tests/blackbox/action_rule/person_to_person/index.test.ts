import {testBase} from "../../test_base";

/*description
# Person to person action
## When
A action is defined

Using global action on from Billy to Bob
Distance between them is 0

##It should
compute billy strength to 10
compute bob health to 15
  -base 10
  -add billy's strength divided by 2 (5)
 */

/*tags
  - person_to_person
 */

const test= testBase(__dirname)
it(test.name, test.success)

