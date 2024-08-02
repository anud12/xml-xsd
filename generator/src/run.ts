
import {typeDeclarationToString} from "./generator/typescript/typeToString";
import fs from "fs";
import {generateTypes, parseXsdSchema} from "./src";

main("../world_step.xsd", "../impl/src/world_step.schema.ts");
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