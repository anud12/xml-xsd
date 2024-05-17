import {testBase} from "../../../test_base";

export const description = `
#Global Action
##When
A global action is defined

Using global action on self

##It should
do nothing
`

const test= testBase(__dirname)
it(test.name, test.success)

