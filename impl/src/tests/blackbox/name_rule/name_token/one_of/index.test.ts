import {testBase} from "../../../test_base";

export const description = `
# \`name_rule\` \`name_token\` \`one_of\`

The name_rule is used to generate a string based on the name_token elements it contains.
The prefix attribute of a name_token is a string that is added to the beginning of the generated string.
The one_of list is a feature that allows for the selection of one name_token from a list.

## Given
During the execution phase when
  - An XML input with a 'name_rule' defined
  - The 'name_rule' contains a 'name_token' with a 'one_of' list
  - a name_rule is defined with an entry that contains a name_token. 
This name_token has a prefix attribute with the value "prefix" and a one_of list
that contains another name_token with a prefix attribute of "first one_of".

## Then
  - The function 'executeFromStringToString' should correctly interpret the '--name_rule' parameter
  - It should execute the rule and produce the expected output
  - The output should match the expected result, by concatenating the prefix of the outer name_token ("prefix"), the prefix of
the selected name_token from the one_of list ("first one_of"). This results in the string "prefixfirst one_of".
`
const test= testBase(__dirname, "--name_rule name_rule")
it(test.name, test.success)