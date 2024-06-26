import * as fs from 'fs';
import FastXMLParser from 'fast-xml-parser';
import {TypeDeclaration} from "./type";
import {processElementTypeToDeclaration} from "./processElementTypeToDeclaration";
import {processSimpleTypeToDeclaration} from "./processSimpleTypeToDeclaration";
import {processComplexTypeToDeclaration} from "./processComplexTypeToDeclaration";
import {processGroupToDeclaration} from "./processGroupToDeclaration";
import {processAttributeGroupToDeclaration} from "./processAttributeGroupToDeclaration";
import {typeDeclarationToString} from "./typeToString";
import {processAttributeToDeclaration} from "./processAttributeToDeclaration";

// Define interface for XML schema element
export type XsdElement = {
  name: string;
  value?: string;
  type?: string;
  base?: string;
  ref?: string;
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
function generateTypes(xml: any): TypeDeclaration[] {
  // Start processing from the root element
  const schema = xml['xs:schema'];
  let types: TypeDeclaration[] = [];
  types = [...types, ...processAttributeToDeclaration(schema["xs:attribute"])];
  types = [...types, ...processAttributeGroupToDeclaration(schema["xs:attributeGroup"])];
  types = [...types, ...processGroupToDeclaration(schema["xs:group"])];
  types = [...types, ...processSimpleTypeToDeclaration(schema["xs:simpleType"])];
  types = [...types, ...processComplexTypeToDeclaration(schema["xs:complexType"])];
  types = [...types, ...processElementTypeToDeclaration(schema["xs:element"])];

  return types;
}


// Main function to read XSD file and output TypeScript types
export function main(path: string, output?: string) {
  const schema = parseXsdSchema(path);
  const types = generateTypes(schema);
  const typeString = typeDeclarationToString(...types);
  let result = `import {JsonQueryType} from "./JsonQueryType"\n`
  result += typeString;
  console.log(typeString);
  if (output) {
    fs.writeFileSync(output, result);
    fs.writeFileSync(`${output}.json`, JSON.stringify(types, null, 2));
  }

  return types;
}

// // Run the main function
