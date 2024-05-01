import {testBase} from "../../../../test_base";

export const description = `
#Person selection
##When
- selecting person with 
  - \`min\` value of 1
- apply property_mutation to increase \`property\` value by 1

- already having item \`0\` with \`property\` value 1 

##It should
modify person \`1\` property by adding 1 changing it to \`2\`
`
const test= testBase(__dirname)
it(test.name, test.success)
