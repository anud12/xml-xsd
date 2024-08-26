import {testBase} from "../../../test_base";

/*description
# Classify person
## Given
During classification phase when
  - declare property rule `attribute` with `person_default` random value that:
    - starts at 10
    - adds a random value from 0 to 100
  - 3 person without properties
  - classification rule requiring that attribute is equal or more than 10
## Then
  - Offset randomization table by 1

  - On person:
    - add classification `classification`
    - add property `attribute` for each person with value:
      - first person: 35
      - second person: 60
      - third person: 85
 */
/*tags
- person
- classification
- property
 */
const test= testBase(__dirname)
it(test.name, test.success)

