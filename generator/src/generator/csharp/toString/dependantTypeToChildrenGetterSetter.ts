import {DependantType} from "../typeToString";
import {template} from "../../../template/template";
import {normalizeName} from "./normalizeName";
import {getTypeName, primitives} from "./geTypeName";
import {Type} from "../../../type";

export const dependantTypeToChildrenGetterSetter = (dependantType: DependantType): { dependantTypes:DependantType[], templateString: string } | undefined => {

  const dependantTypeList: DependantType[] = [];

  if (dependantType.value?.metaType !== "object") {
    return undefined;
  }


  const templateString =  Object.entries(dependantType.value.value).flatMap(([key, value]) => {
    return [[key, value] as [string, Type]]
  })
    .map(([key, value]) => {
      let type = getTypeName(value, key, dependantType.name);
      type = normalizeName(type);

      const typeString = value.isSingle
        ? `${type}`
        : `List<${type}>`;
      const nullableTypeString = value.isNullable
        ? `${typeString}?`
        : typeString;

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
        })
        return template()`
              public ${nullableTypeString} Get_${normalizeName(key)}()
              {
                return this.${normalizeName(key)};
              }
              public ${typeString} GetOrInsertDefault_${normalizeName(key)}()
              {
                if(this.${normalizeName(key)} == null) {
                  this.${normalizeName(key)} = new ${typeString}();
                }
                return this.${normalizeName(key)};
              }
              public void Set_${normalizeName(key)}(${nullableTypeString} value)
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