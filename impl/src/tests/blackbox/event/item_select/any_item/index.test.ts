import {testBase} from "../../../test_base";

export const description = `
#Item selection
##When
selecting items with a \`min\` value of 1

##It should
create item fill missing item by creating them based on a random item rule
`

const test= testBase(__dirname)
it(test.name, test.success)

