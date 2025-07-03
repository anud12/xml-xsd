import {DependantType} from "../typeToString";
import {template} from "../../../template/template";
import {normalizeName} from "./normalizeName";

export const dependantTypeToAttributeSerializationBody = (dependantType: DependantType): string | undefined => {

  if (dependantType.value.attributes?.metaType !== "object") {
    return undefined;
  }


  return Object.entries(dependantType.value.attributes.value ?? []).map(([key, value]) => {
    if (value.metaType === "primitive") {
      return template()`
                if(this._${normalizeName(key)} != null) 
                {
                  rawNode.attributes["${key}"] = this._${normalizeName(key)}${value.isNullable && "?"}.ToString();
                }
                `;
    }
  }).filter(e => e).join("\n")

}