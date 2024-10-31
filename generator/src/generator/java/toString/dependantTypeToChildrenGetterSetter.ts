import {DependantType} from "../typeToString";
import {template} from "../../../template/template";
import {normalizeNameClass, normalizeNameField} from "./normalizeNameClass";
import {getTypeName} from "./geTypeName";
import {Type} from "../../../type";
import {getDependantTypeChildPackage} from "./getDependantTypeChildPackage";
import {basePackage, getDependantTypePackage} from "./getDependantTypePackage";

export const dependantTypeToChildrenGetterSetter = (dependantType: DependantType, parentDependantType?:DependantType): { dependantTypes:DependantType[], templateString: string } | undefined => {

  const dependantTypeList: DependantType[] = [];

  if (dependantType.value?.metaType !== "object") {
    return undefined;
  }


  const templateString =  Object.entries(dependantType.value.value).flatMap(([key, value]) => {
    return [[key, value] as [string, Type]]
  })
    .map(([key, value]) => {

      let type = getTypeName(value, key, dependantType);
      const normalizedName = normalizeNameClass(type);

      let nullableFullPathString =  "";
      if(value.isSingle) {
        nullableFullPathString = `${getDependantTypePackage(dependantType)}.${normalizedName}.${normalizedName}`;
      }
      if(value.isNullable) {
        nullableFullPathString = `Optional<${getDependantTypePackage(dependantType)}.${normalizedName}.${normalizedName}>`
      }
      if(!value.isSingle) {
        nullableFullPathString = `List<${getDependantTypePackage(dependantType)}.${normalizedName}.${normalizedName}>`
      }

      let nullableTypeString = ""
      if(value.isSingle) {
        nullableTypeString = `${basePackage}.${normalizedName}.${normalizedName}`;
      }
      if(value.isNullable) {
        nullableTypeString = `Optional<${basePackage}.${normalizedName}.${normalizedName}>`
      }
      if(!value.isSingle) {
        nullableTypeString = `List<${basePackage}.${normalizedName}.${normalizedName}>`
      }


      const fullPathTypeInitialization = !value.isSingle
        ? `new ArrayList<>()`
        : value.isNullable
          ? `Optional.empty()`
          : `new ${getDependantTypePackage(dependantType)}.${normalizedName}.${normalizedName}()`;

      const typeInitialization = !value.isSingle
        ? `new ArrayList<>()`
        : value.isNullable
          ? `Optional.empty()`
          : `new ${basePackage}.${normalizedName}.${normalizedName}()`

      if (value.metaType === "object") {
        dependantTypeList.push({
          type: "element",
          value: value,
          name: type,
          parentType: dependantType,
        })
        return template()`
              public ${nullableFullPathString} get${normalizeNameClass(key)}()
              {
                return this.${normalizeNameField(key)};
              }
              /*
              public ${nullableFullPathString} GetOrInsertDefault_${normalizeNameClass(key)}()
              {
                if(this.${normalizeNameField(key)} == null) {
                  this.${normalizeNameField(key)} = ${fullPathTypeInitialization};
                }
                return this.${normalizeNameField(key)};
              }
              */
              public ${normalizeNameClass(parentDependantType?.name ?? dependantType.name)} set${normalizeNameClass(key)}(${nullableFullPathString} value)
              {
                this.${normalizeNameField(key)} = value;
                onChangeList.forEach(consumer -> consumer.accept(this));
                return this;
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
              public ${nullableFullPathString} get${normalizeNameClass(key)}()
              {
                return this.${normalizeNameField(key)};
              }
              public ${normalizeNameClass(parentDependantType?.name ?? dependantType.name)} set${normalizeNameClass(key)}(${nullableFullPathString} value)
              {
                this.${normalizeNameField(key)} = value;
                onChangeList.forEach(consumer -> consumer.accept(this));
                return this;
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
              public ${nullableTypeString} get${normalizeNameClass(key)}()
              {
                return this.${normalizeNameField(key)};
              }
              public ${normalizeNameClass(parentDependantType?.name ?? dependantType.name)} set${normalizeNameClass(key)}(${nullableTypeString} value)
              {
                this.${normalizeNameField(key)} = value;
                onChangeList.forEach(consumer -> consumer.accept(this));
                return this;
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