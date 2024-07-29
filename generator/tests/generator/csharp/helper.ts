import * as fs from "fs";
import {typeDeclarationToString} from "../../../src/generator/csharp/typeToString";

export function test_helper(dirname:string): void {
  const filePath = `${dirname}/input.json`; // Path to the XSD schema file
  const inputJson = fs.readFileSync(filePath);

  const typeString = JSON.parse(inputJson.toString())
    .map(value => {
      return typeDeclarationToString(value)
    })
    .join("\n");
  const outputFilePath = `${dirname}/output.txt`;
  let expectedTypes = fs.readFileSync(outputFilePath, 'utf-8');

  //replace crlf to ln for expected types string;
  expectedTypes = expectedTypes.replace(/\r\n/g, '\n');

  // Compare the generated types with the expected output using Jest assertions
  expect(typeString).toEqual(expectedTypes);
}
