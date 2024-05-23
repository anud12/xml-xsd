import * as fs from 'fs';
import FastXMLParser from 'fast-xml-parser';
import {typeDeclarationToString} from "./type";
import {processElementTypeToDeclaration} from "./processElementTypeToDeclaration";
import {processSimpleTypeToDeclaration} from "./processSimpleTypeToDeclaration";
import {processComplexTypeToDeclaration} from "./processComplexTypeToDeclaration";
import {processGroupToDeclaration} from "./processGroupToDeclaration";

// Define interface for XML schema element
export type XsdElement = {
  name: string;
  value?:string;
  type?: string;
  base?: string;
  ref?:string;
  attributes?: { [key: string]: string };
} & {
  [P in string]: XsdElement | XsdElement[]
}


// // Function to parse the XSD schema file
function parseXsdSchema(filePath: string): any {
  const xsdContent = fs.readFileSync(filePath, 'utf-8');
  const parser = new FastXMLParser.XMLParser({ignoreAttributes: false, attributeNamePrefix: ''});
  return parser.parse(xsdContent);
}


// Function to generate TypeScript types from the parsed XSD schema
function generateTypes(xml: any): string {
  // Start processing from the root element
  const schema = xml['xs:schema'];
  let types = [];
  types = [...types, ...processSimpleTypeToDeclaration(schema["xs:simpleType"])];
  types = [...types, ...processGroupToDeclaration(schema["xs:group"])];
  types = [...types, ...processComplexTypeToDeclaration(schema["xs:complexType"])];
  types = [...types, ...processElementTypeToDeclaration(schema["xs:element"])];
  return types
    .map(value => {
      return typeDeclarationToString(value)
    })
    .join("\n");
}


// Main function to read XSD file and output TypeScript types
export function main(path: string, output?: string) {
  const schema = parseXsdSchema(path);
  const types = generateTypes(schema);
  console.log(types);
  if (output) {
    fs.writeFileSync(output, types);
  }

  return types;
}

// // Run the main function
main("../world_step.xsd", "output.ts");
