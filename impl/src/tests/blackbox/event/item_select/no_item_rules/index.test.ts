import {testBase} from "../../../test_base";

export const description = `
#Item selection
##When
selecting items with a \`min\` value of 1 and no item rules

##It should
throw error
`

const test= testBase(__dirname)
it(test.name, test.error)

