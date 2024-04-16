import * as fs from "fs";
import xmlFormat from "xml-formatter";
import {executeFromStringToString} from "../../../../../execute";
import * as path from "path";


export const description = `
# Classify person without any properties and property_rule doesn't have a default value for people
## Given
  - declare property rule \`attribute\`
  - person without properties
  - classification rule requiring that attribute is equal to 10
## Then
  Person doesn't change.
`

it(__dirname.split("tests")[1], async () => {
  const input = fs.readFileSync(`${__dirname}/1_input.xml`, "utf-8");
  const targetDir = fs.readdirSync(__dirname)
    .find(file => file.startsWith('2_expected'));
  const expected = fs.readFileSync(path.join(__dirname, targetDir), 'utf8');
  const result = await executeFromStringToString(input, () => {});
  expect(xmlFormat(result)).toBe(xmlFormat(expected))
})

