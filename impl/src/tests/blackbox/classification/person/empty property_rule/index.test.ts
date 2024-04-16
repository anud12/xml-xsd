import * as fs from "fs";
import xmlFormat from "xml-formatter";
import {executeFromStringToString} from "../../../../../execute";

export const description = `
# Classify person without any properties and property_rule doesn't have a default value for people
## Given
  - declare property rule \`attribute\`
  - person without properties
  - classification rule requiring that attribute is equal to 10
## Then
  Person doesn't change.
`

it("index", async () => {
  const input = fs.readFileSync(`${__dirname}/1_input.xml`, "utf-8");
  const expected = fs.readFileSync(`${__dirname}/2_expected.xml`, "utf-8");
  const result = await executeFromStringToString(input, () => {});
  expect(xmlFormat(result)).toBe(xmlFormat(expected))
})

