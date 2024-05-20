import {testBase} from "../../../../../../test_base";

export const description = `
#Global Action
## Update property when selecting a target and has property
##When
A global action is defined selecting a person with classification \`classification\`
to set 10 to \`property\` on target

Using global action on different person with \`property\`

Target person doesn't have classification

##It should
do nothing
`

const test = testBase(__dirname)
it(test.name, test.success)

