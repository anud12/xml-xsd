import {Type, TypeDeclaration, TypeObject, TypeReference} from "../../../type";
import {typeDeclarationElementToString} from "./typeDeclarationToString";
import {DependantType, GetObjectBodyReturn} from "../typeToString";
import {DirectoryMetadata} from "../../../memory_fs/directoryMetadata";

export function compositionTypeDeclarationToString(directoryMetadata: DirectoryMetadata, typeDeclarationList:Array<TypeDeclaration>, writtenClassesList: string[], dependantType:DependantType):GetObjectBodyReturn {
  if(dependantType.type === "composition") {
    if(dependantType.value.metaType  === "composition") {

      const complexTypeDeclarationList = typeDeclarationList.filter(e => e.type === "complex");

      const extensionsDependantTypes:TypeDeclaration[] = dependantType.value.value.flatMap(dependantType => {
        if(dependantType.metaType === "primitive") {
          const baseComplex= complexTypeDeclarationList.find(e => e.name === dependantType.value);
          if(!baseComplex) {
            return [];
          }

          return [baseComplex]
        }
        return [];
      });

      const extensions:DependantType[] = extensionsDependantTypes.map(e => {
        return {
          type: "element",
          value: e.value,
          name: e.name,
        } satisfies DependantType;
      });

      const value = dependantType.value.value.flatMap(e => {
        if(e.metaType === "object") {
          return Object.entries(e.value)
        }
        return [];
      }) .reduce((acc, [key, value]) => {
        return {
          ...acc,
          [key]: value,
        }
      }, {} as TypeObject["value"]);

      const attributes = dependantType.value.value.flatMap(e => {
        if(e.metaType === "object" && e.attributes?.metaType === "object") {
          return Object.entries(e.attributes.value)
        }
        return [];
      }) .reduce((acc, [key, value]) => {
        return {
          ...acc,
          [key]: value,
        }
      }, {} as TypeObject["value"])
      const type:Type = {
        metaType: "object",
        attributes: {
          metaType: "object",
          value: attributes,
        },
        value: value
      }
      const result = typeDeclarationElementToString(directoryMetadata, writtenClassesList, {
        type: "element",
        value: type,
        name: dependantType.name,
        parentType: dependantType.parentType,
      }, extensions)
      return {
        writtenClass: result.writtenClass,
        dependantTypes: [...result.dependantTypes, ...extensions],
        templateString: result.templateString,
      }
    }

  }
  throw Error(`Invalid ${JSON.stringify(dependantType, null ,2)}`);
}
