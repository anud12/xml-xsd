import {DependantType} from "../typeToString";
import {template} from "../../../template/template";
import {normalizeName} from "./normalizeName";
import {getTypeName} from "./geTypeName";
import {Type} from "../../../type";
import {getDependantTypeChildNamespace} from "./getDependantTypeChildNamespace";

export const dependantTypeToChildrenGetterSetter = (dependantType: DependantType): { dependantTypes:DependantType[], templateString: string } | undefined => {

  const dependantTypeList: DependantType[] = [];

  if (dependantType.value?.metaType !== "object") {
    return undefined;
  }


  const templateString =  Object.entries(dependantType.value.value).flatMap(([key, value]) => {
    return [[key, value] as [string, Type]]
  })
    .map(([key, value]) => {
      let type = getTypeName(value, key, dependantType);
      type = normalizeName(type);

      const fullPathTypeString = value.isSingle
        ? `${getDependantTypeChildNamespace(dependantType)}.${type}`
        : `List<${getDependantTypeChildNamespace(dependantType)}.${type}>`;
      const fullPathNullableTypeString = value.isNullable
        ? `${fullPathTypeString}?`
        : fullPathTypeString;

      const typeString = value.isSingle
        ? `${type}`
        : `List<${type}>`;
      const nullableTypeString = value.isNullable
        ? `${typeString}?`
        : typeString;

      if (value.metaType === "object") {
        dependantTypeList.push({
          type: "element",
          value: value,
          name: type,
          parentType: dependantType,
        })
        return template()`
              public ${fullPathNullableTypeString} Get_${normalizeName(key)}()
              {
                return this.${normalizeName(key)};
              }
              public ${fullPathTypeString} GetOrInsertDefault_${normalizeName(key)}()
              {
                if(this.${normalizeName(key)} == null) {
                  this.${normalizeName(key)} = new ${fullPathTypeString}();
                }
                return this.${normalizeName(key)};
              }
              public void Set_${normalizeName(key)}(${fullPathNullableTypeString} value)
              {
                this.${normalizeName(key)} = value;
              }
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
              public ${fullPathNullableTypeString} Get_${normalizeName(key)}()
              {
                return this.${normalizeName(key)};
              }
              public void Set_${normalizeName(key)}(${fullPathNullableTypeString} value)
              {
                this.${normalizeName(key)} = value;
              }
              `
      }
      if (value.metaType === "reference") {
        dependantTypeList.push({
          type: "reference",
          value: value,
          name: type,
        })
        return template()`
              public ${nullableTypeString} Get_${normalizeName(key)}()
              {
                return this.${normalizeName(key)};
              }
              public void Set_${normalizeName(key)}(${nullableTypeString} value)
              {
                this.${normalizeName(key)} = value;
              }
              `
      }
      return template()`/* ignored children key:${key} of type:${type}*/`
    }).filter(e => e).join("\n")

  return {
    dependantTypes: dependantTypeList,
    templateString: templateString,
  }
}