import {DependantType} from "../typeToString";
import {template} from "../../../template/template";
import {normalizeName} from "./normalizeName";

export const dependantTypeToChildrenDeserializationBody = (dependantType: DependantType): string | undefined => {

  if (dependantType.value?.metaType !== "object") {
    return undefined;
  }


  return Object.entries(dependantType.value.value).map(([key, value]) => {
    if (value.metaType === "object" || value.metaType === "union" || value.metaType === "composition" || value.metaType === "reference") {
      return template()`this._${normalizeName(key)} = rawNode.InitializeWithRawNode("${key}", this._${normalizeName(key)});`;
    }
  }).filter(e => e).join("\n")

}