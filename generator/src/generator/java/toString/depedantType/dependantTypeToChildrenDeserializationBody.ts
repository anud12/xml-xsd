import {DependantType} from "../../typeToString";
import {template} from "../../../../template/template";
import {normalizeNameClass, normalizeNameField} from "../normalizeNameClass";
import {getDependantTypeChildPackage} from "./getDependantTypeChildPackage";
import {basePackage, getDependantTypePackage} from "./getDependantTypePackage";

export const dependantTypeToChildrenDeserializationBody = (dependantType: DependantType): string | undefined => {

  if (dependantType.value?.metaType !== "object") {
    return undefined;
  }


  return Object.entries(dependantType.value.value).map(([key, value]) => {
    let extractString = `null`;
    if(value.isSingle && value.isNullable) {
      extractString = `rawNode.getChildrenFirst("${key}")`;
    }
    if(value.isSingle && !value.isNullable) {
      extractString = `rawNode.getChildrenFirst("${key}").get()`;
    }
    if(!value.isSingle && value.isNullable) {
      extractString = `rawNode.getChildrenList("${key}")`;
    }
    if(!value.isSingle && !value.isNullable) {
      extractString = `rawNode.getChildrenList("${key}")`;
    }

    if (value.metaType === "object" || value.metaType === "union" || value.metaType === "composition") {
      return template()`this.${normalizeNameField(key)} = ${getDependantTypePackage(dependantType)}.${normalizeNameClass(key)}.${normalizeNameClass(key)}.fromRawNode(${extractString}, this);`;
    }

    if (value.metaType === "reference") {
      return template()`
              this.${normalizeNameField(key)} = ${basePackage}.${normalizeNameClass(value.value)}.${normalizeNameClass(value.value)}.fromRawNode(${extractString}, this);
              `
    }
  }).filter(e => e).join("\n")

}