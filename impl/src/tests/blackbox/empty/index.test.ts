import * as fs from "fs";
import {executeFromString, executeFromStringToString} from "../../../execute";
import xmlFormat from "xml-formatter";

export const description = `
# Empty
Given an empty input it should run without errors.
`

it("index", async () => {
  const input = fs.readFileSync(`${__dirname}/1_input.xml`, "utf-8");
  const expected = fs.readFileSync(`${__dirname}/2_expected.xml`, "utf-8");
  const result = await executeFromStringToString(input, () => {});
  expect(xmlFormat(result)).toBe(xmlFormat(expected))
})

