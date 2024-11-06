import {Type, TypeDeclaration, TypeObject, TypeReference} from "../../type";
import {template} from "../../template/template";
import {typeDeclarationElementToString} from "./toString/typeDeclarationToString";
import {unionTypeDeclarationToString} from "./toString/unionTypeDeclarationToString";
import {compositionTypeDeclarationToString} from "./toString/compositionTypeDeclarationToString";
import {DirectoryMetadata} from "../../memory_fs/directoryMetadata";
import {dependantTypeGetFullQualifiedName} from "./toString/depedantType/dependantTypeGetFullQualifiedName";
import {dependantTypeToString} from "./toString/dependantTypeToString";

export type DependantType<T extends Type = Type> = {
  name: string,
  value: T,
  parentType?: DependantType,
  typeDeclaration:TypeDeclaration | undefined,
  type: "element" | "union" | "reference" | "composition"
}

export type GetObjectBodyReturn = {
  dependantTypes: DependantType[],
  writtenClass: string[],
  templateString: string,
}

export type ReferenceMap = { [key: string]: TypeDeclaration }

export function typeDeclarationToString(typeDeclarationArg: TypeDeclaration | Array<TypeDeclaration>): DirectoryMetadata {

  const directoryMetadata = new DirectoryMetadata();

  let typeDeclarationList: Array<TypeDeclaration> = typeDeclarationArg instanceof Array
    ? typeDeclarationArg
    : [typeDeclarationArg];

  let referenceList = typeDeclarationList.reduce((acc, element) => {
    return {
      ...acc,
      [element?.name]: element
    }
  }, {} as ReferenceMap)

  let writtenClassesList: string[] = [];
  let elementDeclarationList: DependantType[] = typeDeclarationList.filter(element => element?.type === "element")
    .map(element => {
      return {
        type: "element",
        value: element.value,
        typeDeclaration: element,
        name: element.name
      }
    });
  // let templateList: string[] = [];
  do {
    const iterate = [...elementDeclarationList];
    elementDeclarationList = [];
    iterate?.forEach((element) => {
      const dependantTypes = dependantTypeToString(directoryMetadata, typeDeclarationList, writtenClassesList, element, referenceList);
      dependantTypes?.forEach(e => elementDeclarationList.push(e));

    })
  } while (elementDeclarationList.length > 0)


  return directoryMetadata;

}
