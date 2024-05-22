import * as fs from 'fs';
import FastXMLParser from 'fast-xml-parser';

// Define interface for XML schema element
type XsdElement = {
  name: string;
  type?: string;
  attributes?: { [key: string]: string };
} & {
  [P in string]: XsdElement | XsdElement[]
}

// Function to parse the XSD schema file
function parseXsdSchema(filePath: string): any {
  const xsdContent = fs.readFileSync(filePath, 'utf-8');
  const parser = new FastXMLParser.XMLParser({ ignoreAttributes: false, attributeNamePrefix: '' });
  return parser.parse(xsdContent);
}


function processAttributes(attributeElement: XsdElement[] | XsdElement, ident= "  "): Array<string> {
  if(Array.isArray(attributeElement)) {
    return attributeElement.flatMap(subElement => {
      return processAttributes(subElement);
    })
  }

  return [`${ident}"${attributeElement.name}": ${mapXsdTypeToTs(attributeElement.type)}`];
}

function processTypeAttribute(elements: XsdElement[] | XsdElement): string {
  if(Array.isArray(elements)) {
    let result = '';
    for (const subElement of elements) {
      result += processTypeAttribute(subElement);
    }
    return result;
  }
  if(!elements.name) {
    return "";
  }
  let  type = mapXsdTypeToTs(elements.type);
  return `${type}`;
}

function processElementType(sequenceElement: XsdElement | XsdElement[], ident = "  "):Array<string> {
  if(Array.isArray(sequenceElement)) {
    let result = `{`;
    sequenceElement.forEach(subElement => {
      result += processElementType(subElement);
    })
    result += `}`;
    return [result];
  }
  if(!sequenceElement["xs:element"]) {
    return[];
  }
  let element = sequenceElement["xs:element"];
  if(!Array.isArray(element)) {
    element = [element]
  };
  return element.map(e => {
    let  type = processElement(e, `${ident}`);
    return `${ident}"${e.name}": ${type}`;
  })
}

function processComplexTypeToType(element: XsdElement | XsdElement[], ident:string = ""):Array<string> {
  if(Array.isArray(element)) {
    return element.flatMap(subElement => processComplexTypeToType(subElement));
  }
  return processComplexType(element).map(e => `type ${element?.name} = ${e}`)

}
function processComplexType(element: XsdElement | XsdElement[], ident:string = ""):Array<string>  {
  if(Array.isArray(element)) {
    let result = `{`;
    element.forEach(subElement => {
      result += processComplexType(subElement);
    })
    result += `}`;
    return [result];
  }

  let types = `{\n`;
  if (element?.["xs:attribute"]) {
    const attributeType = processAttributes(element?.["xs:attribute"], `${ident}  `)
      .join(";\n");
    types += `${attributeType};\n`;
  }

  if (element?.["xs:sequence"]) {
    const elementType = processElementType(element?.["xs:sequence"],`${ident}  `)
      .join(";\n");
    types += `${elementType};\n`;
  }

  types += `${ident}}`;
  return [types];
}


function processElement(element: XsdElement | XsdElement[], ident:string = ""): Array<string> {
  if(!element) {
    return [];
  }
  if(Array.isArray(element)) {
    let result = `{`;
    element.forEach(subElement => {
      result += processElement(subElement);
    })
    result += `}`;
    return [result];
  }
  if(element.type) {
    return  [processTypeAttribute(element)];
  }
  let result = [];
  if(element["xs:element"]) {
    const type = processElementType(element["xs:element"], ident)
    result.push(type) ;

  }

  if(element["xs:complexType"]) {
    const type = processComplexType(element["xs:complexType"], ident);
    result.push(type) ;
  }
  if(result.length === 0) {
    return ['unknown']
  }
  return result;
}

// Function to generate TypeScript types from the parsed XSD schema
function generateTypes(schema: any): string {
  // Start processing from the root element
  const rootElement = schema['xs:schema']['xs:element'];
  const typeName = rootElement?.name;
  if(!typeName) {
    return "";
  }

  let types = [];
  if(schema['xs:schema']['xs:complexType']) {
    types = [...types, ...processComplexTypeToType(schema['xs:schema']['xs:complexType'])]
  }
  let file = "";
  file +=
  file += `type ${typeName} = `
  file += processElement(rootElement, "");
  types = [...types, file]
  return types.join("\n") + "\n";
}

// Helper function to map XSD types to TypeScript types
function mapXsdTypeToTs(xsdType: string | undefined): string {
  if(!xsdType) {
    return "unknown";
  }
  switch (xsdType) {
    case 'xs:string':
      return 'string';
    case 'xs:int':
    case 'xs:integer':
    case 'xs:decimal':
      return 'number';
    case 'xs:boolean':
      return 'boolean';
    default:
      return xsdType;
  }
}

// Main function to read XSD file and output TypeScript types
export function main(path:string) {
  const schema = parseXsdSchema(path);
  const types = generateTypes(schema);
  console.log(types);
  return types;
}

// // Run the main function
// main("../world_step.xsd");
