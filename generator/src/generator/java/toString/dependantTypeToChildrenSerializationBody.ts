import {DependantType} from "../typeToString";
import {template} from "../../../template/template";
import {normalizeNameClass, normalizeNameField} from "./normalizeNameClass";

export const dependantTypeToChildrenSerializationBody = (dependantType: DependantType): string | undefined => {

  if (dependantType.value?.metaType !== "object") {
    return undefined;
  }


  return Object.entries(dependantType.value.value).map(([key, value]) => {
    if (value.metaType === "object" || value.metaType === "union" || value.metaType === "composition" || value.metaType === "reference") {
      return template()`rawNode.addChildren("${key}", ${normalizeNameField(key)});`;
    }
  }).filter(e => e).join("\n")

}