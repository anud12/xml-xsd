import {testBase} from "../../../../test_base";

export const description = `
#person.create
##When
- person.create action is used with property
- property_ref has default person value

##It should
create person with property set
`

const test= testBase(__dirname)
it(test.name, test.success)

