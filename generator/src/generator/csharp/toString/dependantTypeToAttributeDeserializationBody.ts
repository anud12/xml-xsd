import {DependantType} from "../typeToString";
import {template} from "../../../template/template";
import {normalizeName} from "./normalizeName";

export const dependantTypeToAttributeDeserializationBody = (dependantType: DependantType): string | undefined => {

  if (dependantType.value.attributes?.metaType !== "object") {
    return undefined;
  }


  return Object.entries(dependantType.value.attributes.value ?? []).map(([key, value]) => {
    if (value.metaType === "primitive") {
      if (value.value === "xs:int") {
        return template()`
                  if(rawNode.attributes.ContainsKey("${key}"))
                  {
                    var attribute_${normalizeName(key)} = rawNode.attributes["${key}"];
                    this.${normalizeName(key)} = attribute_${normalizeName(key)}${value.isNullable && "?"}.ToInt();
                  }
                  `;
      }
      return template()`
                if(rawNode.attributes.ContainsKey("${key}"))
                {
                  var attribute_${normalizeName(key)} = rawNode.attributes["${key}"];
                  this.${normalizeName(key)} = rawNode.attributes["${key}"];
                }
                `;
    }
  }).filter(e => e).join("\n")

}