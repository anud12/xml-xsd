import {testBase} from "../../../../../test_base";

/*description
# Person selection with min values and inventory with min 1 item
## When

selecting persons with
  - a `min` value of 3
  - `inventory` with a `min` value of 4

## It should
first create a person then its item, only after it should go on the next person
create 3 persons with random 4 item in inventory
  - person `0.0` should have
    - item `0.1 with name `second_item`
    - item `0.2 with name `third_item`
    - item `0.3 with name `item`
    - item `0.4 with name `second_item`

  - person `0.5` should have
    - item `0.6 with name `item`
    - item `0.7 with name `second_item`
    - item `0.8 with name `third_item`
    - item `0.9 with name `item`

  - person `0.10` should have
    - item `0.11 with name `third_item`
    - item `0.12 with name `item`
    - item `0.13 with name `second_item`
    - item `0.14 with name `third_item`
 */

/*tags
- person_select
 */

const test= testBase(__dirname)
it(test.name, test.success)

