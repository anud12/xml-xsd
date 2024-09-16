import {testBase, testEndpoints} from "../../../test_base";

/* description
# `name_rule` `ref`
The `name_rule` is used to generate a string based on the `name_token` elements it contains.
The `prefix` attribute of a `name_token` is a string that is added to the beginning of the generated string.
The `ref` element is a feature that allows for the referencing of another `name_rule` entry.

## Given
During the execution phase when
  - An XML input with a 'name_rule' defined
  - The 'name_rule' contains a 'name_token' with a 'ref' element
  - A `name_rule` is defined with an entry that contains a `name_token`.
This `name_token` has a `prefix` attribute with the value "[prefix]" and a `ref` element
that references another `name_rule` entry with the id "name_metadata_ref".
  - The referenced `name_rule` entry "name_metadata_ref" contains a `name_token` with a `prefix`
   attribute of "[ref_prefix]".

## Then
  - The function 'executeFromStringToString' should correctly interpret the '--name_rule' parameter
  - It should execute the rule and produce the expected output
  - The output should match the expected result, by concatenating the `prefix` of the outer `name_token`
   ("[prefix]") and the `prefix` of the referenced `name_token` ("[ref_prefix]"). This results in the string
   "[prefix][ref_prefix]".
 */

/* tags
- name_rule
 */
const test= testBase(__dirname, testEndpoints.analyzeNameRule("name_rule"));
it(test.name, test.success)