import {executeFromStringToString, StringArguments} from "../../execute";
import xmlFormat from "xml-formatter";
import * as fs from "fs";
import * as path from "path";
import * as xmllint from "xmllint"

export const documentation = `
The \`testBase\` function is a test runner that takes a directory name and an array of string arguments. It is designed to run tests based on XML files. Here's what a programmer should be aware of:

- **Parameters**: The function accepts two parameters:
  - \`dirname\`: A string representing the directory name where the test files are located.
  - \`...stringArguments\`: A rest parameter that represents an array of string arguments.

- **Test Files**: The function expects two types of files in the provided directory:
  - \`1_input.xml\`: This file contains the input data for the test.
  - Files that start with \`2_expected\`: These files contain the expected output of the test.

- **Test Cases**: The function
  - validates input xml against xsd schema 
  - returns an object with two async methods, \`success\` and \`error\`, which represent successful and error test cases respectively.

- **Success Case**: In the \`success\` method, the function reads the \`1_input.xml\` file, executes the \`executeFromStringToString\` function with the input and string arguments, and compares the formatted result with the expected output.

- **Error Case**: In the \`error\` method, the function tries to execute the \`executeFromStringToString\` function with the input and string arguments. If an error is thrown, it compares the error message with the expected output. If no error is thrown, it throws an "Expected error".

- **XML Formatting**: Both the result and expected output are formatted using the \`xmlFormat\` function before comparison. This function is configured not to throw on failure.

- **Carriage Return Characters**: The function removes all carriage return characters (\`\\r\`) from the result and expected output before comparison.

- **Test Name**: The name of the test is derived from the directory name by removing the "tests" string.
`

export const testBase = (dirname:string, ...stringArguments: Array<StringArguments>) => {

  const schema = fs.readFileSync(`${__dirname}${path.sep}..${path.sep}..${path.sep}..${path.sep}..${path.sep}world_step.xsd`, "utf-8");
  // const formattedSchema = xmlFormat(schema, {throwOnFailure: false,})
  const input = fs.readFileSync(`${dirname}/1_input.xml`, "utf-8");
  const validationResult = xmllint.validateXML({
    xml: input,
    schema: schema,
  })
  if(validationResult.errors?.length > 0) {
    throw new Error(validationResult.errors.join("\n"))
  }
  const targetDir = fs.readdirSync(dirname)
    .find(file => file.startsWith('2_expected'));
  const expected = fs.readFileSync(path.join(dirname, targetDir), 'utf8').replace(/\r/g, "");
  return {
    name: dirname.split("tests")[1],
    success: async () => {
      const result = (await executeFromStringToString(input, () => {
      }, stringArguments)).replace(/\r/g, "");
      expect(xmlFormat(result, {throwOnFailure: false,}))
        .toBe(xmlFormat(expected, {throwOnFailure: false,}))
    },
    error: async () => {
      try {
        await executeFromStringToString(input, () => {
        }, stringArguments);
      } catch (e: any) {
        const error = e as Error;
        const result = error.message.replace(/\r/g, "");
        expect(xmlFormat(result, {throwOnFailure: false,}))
          .toBe(xmlFormat(expected, {throwOnFailure: false,}))
        return;
      }
      throw new Error("Expected error")
    }
  }
}
