import {testBase} from "../../../../test_base";

export const description = `
# Add classification on item based on property with default item value
## Given
  - classification rule for \`property\` value equal to 10
  - property \`property\` with \`item_default\` value to 10
## Then
  Item gains 
    - classification \`classification\`.
    - property \`property\` with value 10
`
const test= testBase(__dirname)
it(test.name, test.success)

