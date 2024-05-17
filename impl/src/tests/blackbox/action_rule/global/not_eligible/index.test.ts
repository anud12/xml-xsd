import {testBase} from "../../../test_base";

export const description = `
#Global Action
##When
A global action is defined with from person selector

Using global action on target

Owner is not eligible to use the action

##It should
do nothing
`

const test= testBase(__dirname)
it(test.name, test.success)

