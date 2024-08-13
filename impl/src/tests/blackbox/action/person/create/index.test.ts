import {testBase} from "../../../test_base";

export const description = `
#person.create
##When
person.create action is used with no children

##It should
create an empty person
`

const test= testBase(__dirname)
it(test.name, test.success)

