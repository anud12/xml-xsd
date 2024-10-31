import {typeDeclarationToString} from "./generator/java/typeToString";
import fs from "fs";
import {generateTypes, parseXsdSchema} from "./src";

main("../world_step.xsd", "../implementation/src/main/java/ro/anud/xml_xsd/implementation/model");

// Main function to read XSD file and output TypeScript types
export function main(path: string, output: string = "./type.cs") {
  const schema = parseXsdSchema(path);
  const types = generateTypes(schema);
  const directoryMetadata = typeDeclarationToString(types);


  directoryMetadata.getAllFilesRecursively().forEach(file => {

    let path = directoryMetadata.getStringPathTo(file.parentDirectory) ?? file.name.split(".")[0];
    console.log("writing file",file.name, "to", directoryMetadata.getStringPathTo(file.parentDirectory) ?? "");
    fs.mkdirSync(`${output}/${path}`, {recursive:true})
    if (output) {
      fs.writeFileSync(`${output}/${path}/${file.name}`, file.data(), {});
      fs.writeFileSync(`${output}/_types.json`, JSON.stringify(types, null, 2));
    }

  })

  return types;
}