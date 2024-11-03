import {Type, TypeObject} from "../../../type";
import {typeDeclarationElementToString} from "./typeDeclarationToString";
import {DependantType, GetObjectBodyReturn} from "../typeToString";
import {DirectoryMetadata} from "../../../memory_fs/directoryMetadata";

export function unionTypeDeclarationToString(directoryMetadata: DirectoryMetadata, writtenClassesList: string[], dependantType: DependantType): GetObjectBodyReturn {
  if (dependantType.type === "union") {
    if (dependantType.value.metaType === "union") {


      const value = dependantType.value.value.flatMap(e => {
        if (e.metaType === "object") {
          return Object.entries(e.value)
        }
        return [];
      }).reduce((acc, [key, value]) => {
        return {
          ...acc,
          [key]: value,
        }
      }, {} as TypeObject["value"])
      const type: Type = {
        metaType: "object",
        attributes: dependantType.value.attributes,
        value: value
      }
      const result = typeDeclarationElementToString(directoryMetadata, writtenClassesList, {
        type: "element",
        value: type,
        name: dependantType.name,
        typeDeclaration: dependantType.typeDeclaration,
        parentType: dependantType.parentType,
      }, [])
      return {
        writtenClass: result.writtenClass,
        dependantTypes: [...result.dependantTypes],
        templateString: result.templateString
      }
    }

  }
  throw Error(`Invalid ${JSON.stringify(dependantType, null, 2)}`);
}
