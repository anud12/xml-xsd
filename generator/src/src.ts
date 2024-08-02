import * as fs from 'fs';
import FastXMLParser from 'fast-xml-parser';
import {TypeDeclaration} from "./type";
import {processElementTypeToDeclaration} from "./processElementTypeToDeclaration";
import {processSimpleTypeToDeclaration} from "./processSimpleTypeToDeclaration";
import {processComplexTypeToDeclaration} from "./processComplexTypeToDeclaration";
import {processGroupToDeclaration} from "./processGroupToDeclaration";
import {processAttributeGroupToDeclaration} from "./processAttributeGroupToDeclaration";

import {processAttributeToDeclaration} from "./processAttributeToDeclaration";
import {typeDeclarationToString} from "./generator/typescript/typeToString";

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
export function parseXsdSchema(filePath: string): any {
  const xsdContent = fs.readFileSync(filePath, 'utf-8');
  const parser = new FastXMLParser.XMLParser({ignoreAttributes: false, attributeNamePrefix: ''});
  return parser.parse(xsdContent);
}


// Function to generate TypeScript types from the parsed XSD schema
export function generateTypes(xml: any): TypeDeclaration[] {
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



// // Run the main function
