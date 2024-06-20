import {main} from "../src/src";
import * as fs from "fs";


export function test_helper(dirname:string): void {
  const xsdFilePath = `${dirname}/input.xsd`; // Path to the XSD schema file
  const generatedTypes = main(xsdFilePath);
  //TODO: add comparison with _output.txt content

  // Read the contents of the _output.txt file
  const outputFilePath = `${dirname}/output.txt`;
  const expectedTypes = fs.readFileSync(outputFilePath, 'utf-8');

  // Compare the generated types with the expected output using Jest assertions
  expect(JSON.stringify(generatedTypes, null, 2)).toEqual(expectedTypes);
}
