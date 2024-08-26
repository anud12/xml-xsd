import {testBase} from "../../../test_base";

/*description
# Classify person without any properties and property_rule doesn't have a default value for people
## Given
  - declare property rule `attribute`
  - person without properties
  - classification rule requiring that attribute is equal to 10
## Then
  Person doesn't change.
 */

/*tags
- person
- classification
- property
 */
const test= testBase(__dirname)
it(test.name, test.success)

