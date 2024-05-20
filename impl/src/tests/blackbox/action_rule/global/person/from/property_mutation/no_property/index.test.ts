import {testBase} from "../../../../../../test_base";

export const description = `
#Global Action 
## Update property when target doesn't have one
##When
A global action is defined to add 1 to \`property\` on self

Using global action on different person without \`property\`

##It should
do nothing
`

const test= testBase(__dirname)
it(test.name, test.success)

