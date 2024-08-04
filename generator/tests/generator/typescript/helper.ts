import * as fs from "fs";
import {TypeDeclaration} from "../../../src/type";
import {typeDeclarationToString} from "../../../src/generator/typescript/typeToString";

export function test_helper(dirname:string): void {
  const filePath = `${dirname}/input.json`; // Path to the XSD schema file

  const inputJsonString = fs.readFileSync(filePath);
  const inputJson:Array<TypeDeclaration> = JSON.parse(inputJsonString.toString());
  const typeString = typeDeclarationToString(...inputJson)

  const outputFilePath = `${dirname}/output.txt`;
  let expectedTypes = fs.readFileSync(outputFilePath, 'utf-8');

  //replace crlf to ln for expected types string;
  expectedTypes = expectedTypes.replace(/\r\n/g, '\n');

  // Compare the generated types with the expected output using Jest assertions
  expect(typeString).toEqual(expectedTypes);
}
