import * as fs from "fs";
import xmlFormat from "xml-formatter";
import {executeFromStringToString} from "../../../../../execute";
import * as path from "path";

export const description = `
# Classify person
## Given
During classification phase when
  - declare property rule \`attribute\` with \`person_default\` random value that:
    - starts at 10
    - adds a random value from 0 to 100
  - 3 person without properties
  - classification rule requiring that attribute is equal or more than 10
## Then
  - Offset randomization table by 1
  
  - On person:
    - add classification \`classification\`
    - add property \`attribute\` for each person with value:
      - first person: 35
      - second person: 60
      - third person: 85
`

it(__dirname.split("tests")[1], async () => {
  const input = fs.readFileSync(`${__dirname}/1_input.xml`, "utf-8");
  const targetDir = fs.readdirSync(__dirname)
    .find(file => file.startsWith('2_expected'));
  const expected = fs.readFileSync(path.join(__dirname, targetDir), 'utf8');
  const result = await executeFromStringToString(input, () => {});
  expect(xmlFormat(result)).toBe(xmlFormat(expected))
})

