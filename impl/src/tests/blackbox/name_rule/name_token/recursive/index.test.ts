import {testBase} from "../../../test_base";

export const description = `
# \`name_rule\` \`recursive\`

The \`calculateNameFromRefString\` function is used to generate a string based on the \`name_token\` elements it contains.
The \`prefix\` attribute of a \`name_token\` is a string that is added to the beginning of the generated string.
The \`one_of\` list is a feature that allows for the selection of one \`name_token\` from a list.

The \`calculateNameFromRefString\` function is used to generate a string based on the \`name_token\` elements it contains.
The \`prefix\` attribute of a \`name_token\` is a string that is added to the beginning of the generated string.
The \`one_of\` list is a feature that allows for the selection of one \`name_token\` from a list.

During the execution phase when
  - A XML input with a 'name_rule' defined
  - The 'name_rule' contains a 'name_token' with a 'one_of' list
  - A \`name_rule\` is defined with an entry that contains a \`name_token\`. 
This \`name_token\` has a \`prefix\` attribute with the value "[prefix]" and a \`one_of\` list
that contains another \`name_token\` with a \`prefix\` attribute of "[one of]".
  - Inside the second \`one_of\` list, there is a \`name_token\` with a \`prefix\` attribute 
  of "[second one of]" and a \`ref\` element. The \`ref\` element references another \`name_rule\`
   entry with the id "name_metadata_ref".
  - The referenced \`name_rule\` entry "name_metadata_ref" contains a \`name_token\` with a \`prefix\`
   attribute of "[ref_prefix]".

Then
  - The function 'calculateNameFromRefString' should correctly interpret the 'name_rule' parameter
  - It should execute the rule and produce the expected output
  - The output should match the expected result, by concatenating the \`prefix\` of the outer \`name_token\`
   ("[prefix]"), the \`prefix\` of the selected \`name_token\` from the \`one_of\` list ("[one of]"), 
   the \`prefix\` of the \`name_token\` in the second \`one_of\` list ("[second one of]"), and the \`prefix\`
    of the referenced \`name_token\` ("[ref_prefix]"). This results in the string 
    "[prefix][one of][second one of][ref_prefix]".
`
const test= testBase(__dirname, "--name_rule name_rule")
it(test.name, test.success)