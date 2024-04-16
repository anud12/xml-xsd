import * as fs from "fs";
import {executeFromStringToString} from "../../../execute";
import xmlFormat from "xml-formatter";
import * as path from "path";

export const description = `
# Empty
Given an empty input it should run without errors.
`

it(__dirname.split("tests")[1], async () => {
  const input = fs.readFileSync(`${__dirname}/1_input.xml`, "utf-8");
  const targetDir = fs.readdirSync(__dirname)
    .find(file => file.startsWith('2_expected'));
  const expected = fs.readFileSync(path.join(__dirname, targetDir), 'utf8');
  const result = await executeFromStringToString(input, () => {
  });
  expect(xmlFormat(result)).toBe(xmlFormat(expected))
})

