import {testBase} from "../../../../test_base";

export const description = `
#Person selection with min values and race
##When

selecting persons with
  - a \`min\` value of 2
  - race \`race\`

##It should
create 2 people with race \`race\`
`

const test= testBase(__dirname)
it(test.name, test.success)

