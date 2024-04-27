import {testBase} from "../test_base";

export const description = `
# Empty
Given an empty input it should run without errors.
`
const test= testBase(__dirname)
it(test.name, test.success)
