import {DependantType} from "../typeToString";
import {template} from "../../../template/template";
import {normalizeNameClass, normalizeNameField} from "./normalizeNameClass";
import {getTypeName} from "./geTypeName";
import {Type} from "../../../type";
import {getDependantTypeChildPackage} from "./getDependantTypeChildPackage";

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
      type = normalizeNameClass(type);

      const fullPathTypeString = value.isSingle
        ? `${getDependantTypeChildPackage(dependantType)}.${type}`
        : `List<${getDependantTypeChildPackage(dependantType)}.${type}>`;
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
              public ${fullPathNullableTypeString} Get_${normalizeNameClass(key)}()
              {
                return this.${normalizeNameField(key)};
              }
              public ${fullPathTypeString} GetOrInsertDefault_${normalizeNameClass(key)}()
              {
                if(this.${normalizeNameClass(key)} == null) {
                  this.${normalizeNameClass(key)} = new ${fullPathTypeString}();
                }
                return this.${normalizeNameField(key)};
              }
              public void Set_${normalizeNameClass(key)}(${fullPathNullableTypeString} value)
              {
                this.${normalizeNameField(key)} = value;
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
              public ${fullPathNullableTypeString} Get_${normalizeNameClass(key)}()
              {
                return this.${normalizeNameField(key)};
              }
              public void Set_${normalizeNameClass(key)}(${fullPathNullableTypeString} value)
              {
                this.${normalizeNameField(key)} = value;
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
              public ${nullableTypeString} Get_${normalizeNameClass(key)}()
              {
                return this.${normalizeNameField(key)};
              }
              public void Set_${normalizeNameClass(key)}(${nullableTypeString} value)
              {
                this.${normalizeNameField(key)} = value;
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