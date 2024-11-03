import {Type, TypeDeclaration, TypeObject, TypeReference} from "../../type";
import {template} from "../../template/template";
import {typeDeclarationElementToString} from "./toString/typeDeclarationToString";
import {unionTypeDeclarationToString} from "./toString/unionTypeDeclarationToString";
import {compositionTypeDeclarationToString} from "./toString/compositionTypeDeclarationToString";
import {DirectoryMetadata} from "../../memory_fs/directoryMetadata";
import {dependantTypeGetFullQualifiedName} from "./toString/dependantTypeGetFullQualifiedName";

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
  }, {} as { [key: string]: TypeDeclaration })

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
      if (writtenClassesList.includes(dependantTypeGetFullQualifiedName(element))) {
        return;
      }
      if (element.type === "element") {
        const {
          dependantTypes,
          writtenClass
        } = typeDeclarationElementToString(directoryMetadata, writtenClassesList, element);
        writtenClassesList.push(...writtenClass);
        dependantTypes?.forEach(e => elementDeclarationList.push(e));
        // directoryMetadata.createFile(`${element.name}.cs`, () => template()`${templateString}`)
      }
      if (element.type === "union") {
        const {
          dependantTypes,
          writtenClass
        } = unionTypeDeclarationToString(directoryMetadata, writtenClassesList, element);
        writtenClassesList.push(...writtenClass);
        dependantTypes?.forEach(e => elementDeclarationList.push(e));
        // directoryMetadata.createFile(`${element.name}.cs`, () => template()`${templateString}`)
      }
      if (element.type === "composition") {
        const {
          dependantTypes,
          writtenClass
        } = compositionTypeDeclarationToString(directoryMetadata, typeDeclarationList, writtenClassesList, element);
        writtenClassesList.push(...writtenClass);
        dependantTypes?.forEach(e => elementDeclarationList.push(e));
        // directoryMetadata.createFile(`${element.name}.cs`, () => template()`${templateString}`)
      }

      if (element.type === "reference") {
        const referenceType = referenceList[element.name]
        if (referenceType) {
          const {
            dependantTypes,
            writtenClass
          } = typeDeclarationElementToString(directoryMetadata, writtenClassesList, {
            type: "element",
            value: referenceType.value,
            typeDeclaration: referenceType,
            name: element.name
          });
          writtenClassesList.push(...writtenClass);
          dependantTypes?.forEach(e => elementDeclarationList.push(e));
          // directoryMetadata.createFile(`${element.name}.cs`, () => template()`${templateString}`)
        }
      }
      writtenClassesList.push(element.name);

    })
  } while (elementDeclarationList.length > 0)


  return directoryMetadata;

}
