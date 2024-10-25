import {DependantType} from "../typeToString";
import {normalizeName} from "./normalizeName";
import {getTypeName} from "./geTypeName";
import {Type} from "../../../type";
import {template} from "../../../template/template";
import {getDependantTypeChildNamespace} from "./getDependantTypeChildNamespace";

export const dependantTypeToChildrenDeclaration = (dependantType: DependantType): { dependantTypes:DependantType[], templateString: string } | undefined => {

  const dependantTypeList: DependantType[] = [];

  if (dependantType.value?.metaType !== "object") {
    return undefined;
  }


  const templateString = Object.entries(dependantType.value.value).flatMap(([key, value]) => {
    return [[key, value] as [string, Type]]
  })
    .map(([key, value]) => {
      let type = getTypeName(value, key, dependantType);
      type = normalizeName(type);

      const fullPathTypeString = value.isSingle
        ? `${getDependantTypeChildNamespace(dependantType)}.${type}`
        : `List<${getDependantTypeChildNamespace(dependantType)}.${type}>`;
      const nullableFullPathString = value.isNullable
        ? `${fullPathTypeString}?`
        : fullPathTypeString;

      const typeString = value.isSingle
        ? `${type}`
        : `List<${type}>`;
      const nullableTypeString = value.isNullable
        ? `${typeString}?`
        : typeString;

      const fullPathTypeInitialization = value.isSingle
        ? value.isNullable
          ? `null`
          : `new ${getDependantTypeChildNamespace(dependantType)}.${type}()`
        : `new List<${getDependantTypeChildNamespace(dependantType)}.${type}>()`;

      const typeInitialization = value.isSingle
        ? value.isNullable
          ? `null`
          : `new ${type}()`
        : `new List<${type}>()`;

      if (value.metaType === "object") {
        dependantTypeList.push({
          type: "element",
          value: value,
          name: type,
          parentType: dependantType,
        })
        return template()`
              public ${nullableFullPathString} ${normalizeName(key)} = ${fullPathTypeInitialization};
              `
      }
      if (value.metaType === "union" || value.metaType === "composition") {
        dependantTypeList.push({
          type: value.metaType,
          value: value,
          name: type,
          parentType: dependantType,
        })
        return template()`
              public ${nullableFullPathString} ${normalizeName(key)} = ${fullPathTypeInitialization};
              `
      }
      if (value.metaType === "reference") {
        dependantTypeList.push({
          type: "reference",
          value: value,
          name: type,
          parentType: dependantType,
        })
        return template()`
              public ${nullableTypeString} ${normalizeName(key)} = ${typeInitialization};
              `
      }
      return template()`/* ignored children key:${key} of type:${type}*/`
    }).filter(e => e).join("\n");

  return {
    dependantTypes: dependantTypeList,
    templateString: templateString,
  }


}