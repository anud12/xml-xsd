import {generateTypes, parseXsdSchema} from "../src/src";
import * as fs from "fs";


export function test_helper(dirname:string): void {
  const xsdFilePath = `${dirname}/input.xsd`; // Path to the XSD schema file
  const schema = parseXsdSchema(xsdFilePath);
  const types = generateTypes(schema);
  //TODO: add comparison with _output.txt content

  // Read the contents of the _output.txt file
  const outputFilePath = `${dirname}/output.txt`;
  let expectedTypes = fs.readFileSync(outputFilePath, 'utf-8');

  //replace crlf to ln for expected types string;
  expectedTypes = expectedTypes.replace(/\r\n/g, '\n');

  // Compare the generated types with the expected output using Jest assertions
  expect(JSON.stringify(types, null, 2)).toEqual(expectedTypes);
}
