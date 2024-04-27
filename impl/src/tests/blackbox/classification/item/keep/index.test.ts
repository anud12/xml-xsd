import {testBase} from "../../../test_base";

export const description = `
# Keep classification on item
## Given
  - classification rule
  - item with classification
## Then
  Item doesn't change.
`
const test= testBase(__dirname)
it(test.name, test.success)

