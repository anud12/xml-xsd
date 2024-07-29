
import {typeDeclarationToString} from "./generator/csharp/typeToString";
import fs from "fs";
import {generateTypes, parseXsdSchema} from "./src";
import {template} from "./template/template";

main("../world_step.xsd", "../gui-client/schema.cs");
// Main function to read XSD file and output TypeScript types
export function main(path: string, output: string = "./type.cs") {
  const schema = parseXsdSchema(path);
  const types = generateTypes(schema);
  const typeString = typeDeclarationToString(...types);

  let result = template()`
  using System.Collections.Generic;
  using System.Xml;
  
  namespace XSD {
    ${typeString}
  }
  `

  console.log(typeString);
  if (output) {
    fs.writeFileSync(output, result);
    fs.writeFileSync(`${output}.json`, JSON.stringify(types, null, 2));
  }

  return types;
}