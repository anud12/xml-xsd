import {testBase} from "../../../test_base";

export const description = `
# \`name_rule\` \`name_token\` \`prefix\`
## Given
During the execution phase when
  - An XML input with a 'name_rule' defined
  - The 'name_rule' contains a 'name_token' with a 'prefix'
## Then
  - The function 'executeFromStringToString' should correctly interpret the '--name_rule' parameter
  - It should execute the rule and produce the expected output
  - The output should match the expected result, considering the 'name_rule' and 'name_token' prefix
`
const test= testBase(__dirname, "--name_rule name_rule")
it(test.name, test.success)