import {testBase} from "../test_base";

export const description = `
# Empty
## Given 
An empty input 
## Then
it should run without errors.
`
const test= testBase(__dirname)
it(test.name, test.success)
