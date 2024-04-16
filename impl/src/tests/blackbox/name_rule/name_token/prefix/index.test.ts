import * as fs from "fs";
import xmlFormat from "xml-formatter";
import {executeFromStringToString} from "../../../../../execute";
import * as path from "path";

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
