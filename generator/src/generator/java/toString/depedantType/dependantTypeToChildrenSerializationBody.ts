import {DependantType} from "../../typeToString";
import {template} from "../../../../template/template";
import {normalizeNameClass, normalizeNameField} from "../normalizeNameClass";

export const dependantTypeToChildrenSerializationBody = (dependantType: DependantType): string | undefined => {

  if (dependantType.value?.metaType !== "object") {
    return undefined;
  }


  return Object.entries(dependantType.value.value).map(([key, value]) => {
    if (value.metaType === "object" || value.metaType === "union" || value.metaType === "composition" || value.metaType === "reference") {

      if(value.isNullable) {
        return template()`rawNode.setChildren("${key}", ${normalizeNameField(key)}.stream().map(o -> o.serializeIntoRawNode()).toList());`;
      }
      if(value.isSingle) {
        return template()`rawNode.setChildren("${key}", Optional.ofNullable(${normalizeNameField(key)}).stream().map(o -> o.serializeIntoRawNode()).toList());`;
      }
      return template()`rawNode.setChildren("${key}", ${normalizeNameField(key)}.stream().map(o -> o.serializeIntoRawNode()).toList());`;


    }
  }).filter(e => e).join("\n")

}