import {DependantType} from "../../typeToString";
import {template} from "../../../../template/template";
import {normalizeNameClass, normalizeNameField} from "../normalizeNameClass";
import {basePackage, getDependantTypePackage} from "./getDependantTypePackage";
import {getTypeName} from "../getTypeName";

export const dependantTypeToChildrenSerializationBody = (dependantType: DependantType): string | undefined => {

  if (dependantType.value?.metaType !== "object") {
    return undefined;
  }


  return Object.entries(dependantType.value.value).map(([key, value]) => {
    if (value.metaType === "object" || value.metaType === "union" || value.metaType === "composition" || value.metaType === "reference") {


      let type = getTypeName(value, key, dependantType);
      const normalizedName = normalizeNameClass(type);
      let fullClassName = `${getDependantTypePackage(dependantType)}.${normalizedName}.${normalizedName}`
      if (value.metaType === "reference") {
        fullClassName = `${basePackage}.${normalizedName}.${normalizedName}`;
      }


      if(value.isNullable) {
        return template()`
          innerLogger.log("${key}");
          rawNode.setChildren("${key}", ${normalizeNameField(key)}.stream().map(${fullClassName}::serializeIntoRawNode).toList());
        `;
      }
      if(value.isSingle) {
        return template()`
          innerLogger.log("${key}");
          rawNode.setChildren("${key}", Optional.ofNullable(${normalizeNameField(key)}).stream().map(${fullClassName}::serializeIntoRawNode).toList());
        `;
      }
      return template()`
        innerLogger.log("${key}");
        rawNode.setChildren("${key}", ${normalizeNameField(key)}.stream().map(${fullClassName}::serializeIntoRawNode).toList());
        `;


    }
  }).filter(e => e).join("\n")

}