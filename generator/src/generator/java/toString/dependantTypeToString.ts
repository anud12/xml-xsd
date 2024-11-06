import {dependantTypeGetFullQualifiedName} from "./depedantType/dependantTypeGetFullQualifiedName";
import {typeDeclarationElementToString} from "./typeDeclarationToString";
import {unionTypeDeclarationToString} from "./unionTypeDeclarationToString";
import {compositionTypeDeclarationToString} from "./compositionTypeDeclarationToString";
import {DirectoryMetadata} from "../../../memory_fs/directoryMetadata";
import {DependantType, ReferenceMap} from "../typeToString";
import {TypeDeclaration} from "../../../type";

export const dependantTypeToString = (directoryMetadata: DirectoryMetadata, typeDeclarationList: Array<TypeDeclaration>, writtenClassesList: string[], element: DependantType, referenceList:ReferenceMap): DependantType[] => {
  if (writtenClassesList.includes(dependantTypeGetFullQualifiedName(element))) {
    return [];
  }
  const elementDeclarationList: DependantType[] = [];
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
  return elementDeclarationList;
}