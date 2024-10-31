import {DependantType} from "../typeToString";
import {template} from "../../../template/template";
import {normalizeNameClass, normalizeNameField} from "./normalizeNameClass";

export const dependantTypeToAttributeDeserializationBody = (dependantType: DependantType): string | undefined => {

  if (dependantType.value.attributes?.metaType !== "object") {
    return undefined;
  }


  return Object.entries(dependantType.value.attributes.value ?? []).map(([key, value]) => {
    if (value.metaType === "primitive") {
      if (value.value === "xs:int") {
        if(value.isNullable) {
          return template()`
                    this.${normalizeNameField(key)} = rawNode.getAttributeInt("${key}");
                  `;
        }
        return template()`
                    this.${normalizeNameField(key)} = rawNode.getAttributeIntRequired("${key}");
                  `;
      }
      if(value.isNullable) {
        return template()`
                this.${normalizeNameField(key)} = rawNode.getAttribute("${key}");
                `;
      }
      return template()`
                this.${normalizeNameField(key)} = rawNode.getAttributeRequired("${key}");
                `;
    }
  }).filter(e => e).join("\n")

}