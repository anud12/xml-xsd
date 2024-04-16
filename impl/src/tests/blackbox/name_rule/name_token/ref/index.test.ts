import * as fs from "fs";
import xmlFormat from "xml-formatter";
import {executeFromStringToString} from "../../../../../execute";
import * as path from "path";

export const description = `
# \`name_rule\` \`ref\`
The \`name_rule\` is used to generate a string based on the \`name_token\` elements it contains.
The \`prefix\` attribute of a \`name_token\` is a string that is added to the beginning of the generated string.
The \`ref\` element is a feature that allows for the referencing of another \`name_rule\` entry.

## Given
During the execution phase when
  - An XML input with a 'name_rule' defined
  - The 'name_rule' contains a 'name_token' with a 'ref' element
  - A \`name_rule\` is defined with an entry that contains a \`name_token\`. 
This \`name_token\` has a \`prefix\` attribute with the value "[prefix]" and a \`ref\` element
that references another \`name_rule\` entry with the id "name_metadata_ref".
  - The referenced \`name_rule\` entry "name_metadata_ref" contains a \`name_token\` with a \`prefix\`
   attribute of "[ref_prefix]".

## Then
  - The function 'executeFromStringToString' should correctly interpret the '--name_rule' parameter
  - It should execute the rule and produce the expected output
  - The output should match the expected result, by concatenating the \`prefix\` of the outer \`name_token\`
   ("[prefix]") and the \`prefix\` of the referenced \`name_token\` ("[ref_prefix]"). This results in the string 
   "[prefix][ref_prefix]".
`
it(__dirname.split("tests")[1], async () => {
  const input = fs.readFileSync(`${__dirname}/1_input.xml`, "utf-8");
  const targetDir = fs.readdirSync(__dirname)
    .find(file => file.startsWith('2_expected'));
  const expected = fs.readFileSync(path.join(__dirname, targetDir), 'utf8');
  const result = await executeFromStringToString(input, () => {
  }, ["--name_rule name_rule"]);
  expect(xmlFormat(result, {throwOnFailure: false,}))
    .toBe(xmlFormat(expected, {throwOnFailure: false,}))
})