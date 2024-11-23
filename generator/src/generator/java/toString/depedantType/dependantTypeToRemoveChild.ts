import {DependantType} from "../../typeToString";
import {template} from "../../../../template/template";
import {normalizeNameClass, normalizeNameField} from "../normalizeNameClass";
import {basePackage, getDependantTypePackage} from "./getDependantTypePackage";

export const dependantTypeToRemoveChild = (dependantType: DependantType): string | undefined => {

  if (dependantType.value?.metaType !== "object") {
    return undefined;
  }


  return Object.entries(dependantType.value.value).map(([key, value]) => {
    let className = `${getDependantTypePackage(dependantType)}.${normalizeNameClass(key)}.${normalizeNameClass(key)}`;

    if(value.metaType === "reference") {
      className = `${basePackage}.${normalizeNameClass(value.value)}.${normalizeNameClass(value.value)}`;
    }

    let extractString = `null`;
    if(value.isSingle && value.isNullable) {
      extractString = `this.${normalizeNameField(key)} = Optional.empty();`;
    }
    if(value.isSingle && !value.isNullable) {
      extractString = `throw new RuntimeException("trying to delete ${normalizeNameField(key)} which is required");`;
    }
    if(!value.isSingle && value.isNullable) {
      extractString = `this.${normalizeNameField(key)}.remove(object);`;
    }
    if(!value.isSingle && !value.isNullable) {
      extractString = `throw new RuntimeException("trying to delete ${normalizeNameField(key)} which is required");`;
    }

    return template()`
      if(object instanceof ${className}) {
        ${extractString}
      }
    `
    //
    // if (value.metaType === "object" || value.metaType === "union" || value.metaType === "composition") {
    //   return template()`this.${normalizeNameField(key)} = ${getDependantTypePackage(dependantType)}.${normalizeNameClass(key)}.${normalizeNameClass(key)}.fromRawNode(${extractString});`;
    // }
    //
    // if (value.metaType === "reference") {
    //   return template()`
    //           this.${normalizeNameField(key)} = ${basePackage}.${normalizeNameClass(value.value)}.${normalizeNameClass(value.value)}.fromRawNode(${extractString});
    //           `
    // }
  }).filter(e => e).join("\n")

}