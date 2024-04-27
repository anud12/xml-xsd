import {testBase} from "../../../../test_base";

export const description = `
# Add classification on item if property exists
## Given
  - classification rule for \`property\` value equal to 10
  - item with property \`property\` value 10
## Then
  Item gains classification \`classification\`.
`
const test= testBase(__dirname)
it(test.name, test.success)

