import {Type, TypeDeclaration, TypeObject, TypeReference} from "../../type";
import {template} from "../../template/template";
import {typeDeclarationElementToString} from "./toString/typeDeclarationToString";
import {unionTypeDeclarationToString} from "./toString/unionTypeDeclarationToString";
import {compositionTypeDeclarationToString} from "./toString/compositionTypeDeclarationToString";

export type DependantType<T extends Type = Type> = {
  name: string,
  value: T,
  type: "element" | "union" | "reference" | "composition"
}

export type GetObjectBodyReturn = {
  dependantTypes: DependantType[],
  templateString: string,
  writtenClass: string[]
}

export function typeDeclarationToString(typeDeclarationArg: TypeDeclaration | Array<TypeDeclaration>): string {

  let typeDeclarationList:Array<TypeDeclaration> = typeDeclarationArg instanceof Array
    ? typeDeclarationArg
    : [typeDeclarationArg];

  let referenceList = typeDeclarationList.reduce((acc, element) => {
    return {
      ...acc,
      [element.name]: element
    }
  }, {} as {[key: string]: TypeDeclaration})

  let writtenClassesList: string[] = [];
  let elementDeclarationList: DependantType[] = typeDeclarationList.filter(element => element.type === "element")
    .map(element => {
      return {
        type: "element",
        value: element.value,
        name: element.name
      }
    });
  let templateList: string[] = [];
  do {
    const iterate = [...elementDeclarationList];
    elementDeclarationList = [];
    iterate?.forEach((element) => {
      if(writtenClassesList.includes(element.name)) {
        return;
      }
      if (element.type === "element") {
        const {dependantTypes, templateString, writtenClass} = typeDeclarationElementToString(writtenClassesList, element);
        writtenClassesList.push(...writtenClass);
        dependantTypes?.forEach(e => elementDeclarationList.push(e));
        templateList.push(templateString)
      }
      if(element.type === "union") {
        const {dependantTypes, templateString, writtenClass} = unionTypeDeclarationToString(writtenClassesList, element);
        writtenClassesList.push(...writtenClass);
        dependantTypes?.forEach(e => elementDeclarationList.push(e));
        templateList.push(templateString)
      }
      if(element.type === "composition") {
        const {dependantTypes, templateString, writtenClass} = compositionTypeDeclarationToString(typeDeclarationList, writtenClassesList, element);
        writtenClassesList.push(...writtenClass);
        dependantTypes?.forEach(e => elementDeclarationList.push(e));
        templateList.push(templateString)
      }

      if(element.type === "reference") {
        const referenceType =  referenceList[element.name]
        if(referenceType) {
          const {dependantTypes, templateString, writtenClass} = typeDeclarationElementToString(writtenClassesList,{
            type: "element",
            value: referenceType.value,
            name: element.name
          });
          writtenClassesList.push(...writtenClass);
          dependantTypes?.forEach(e => elementDeclarationList.push(e));
          templateList.push(templateString)
        }
      }
      writtenClassesList.push(element.name);

    })
  } while (elementDeclarationList.length > 0)


  return template()`
    ${templateList.join("\n")}
    `
}
