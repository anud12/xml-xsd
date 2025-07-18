import {DependantType} from "../../typeToString";
import {template} from "../../../../template/template";
import {normalizeNameClass, normalizeNameField} from "../normalizeNameClass";
import {getTypeName, primitives} from "../getTypeName";

export const dependantTypeToAttributeDeserializationBody = (dependantType: DependantType): string | undefined => {

  if (dependantType.value.attributes?.metaType !== "object") {
    return undefined;
  }


  return Object.entries(dependantType.value.attributes.value ?? []).map(([key, value]) => {
    let type = getTypeName(value, key, dependantType);
    if (value.metaType === "primitive") {
      if ([primitives.int].includes(type)) {
        if(value.isNullable) {
          return template()`
                    innerLogger.log("${key}");
                    this.${normalizeNameField(key)} = rawNode.getAttributeInt("${key}");
                  `;
        }
        return template()`
                    innerLogger.log("${key}");
                    this.${normalizeNameField(key)} = rawNode.getAttributeIntRequired("${key}");
                  `;
      }
      if ([primitives.double].includes(type)) {
        if(value.isNullable) {
          return template()`
                    innerLogger.log("${key}");
                    this.${normalizeNameField(key)} = rawNode.getAttributeDouble("${key}");
                  `;
        }
        return template()`
                    innerLogger.log("${key}");
                    this.${normalizeNameField(key)} = rawNode.getAttributeDoubleRequired("${key}");
                  `;
      }
      if(value.isNullable) {
        return template()`
                innerLogger.log("${key}");
                this.${normalizeNameField(key)} = rawNode.getAttribute("${key}");
                `;
      }
      return template()`
                innerLogger.log("${key}");
                this.${normalizeNameField(key)} = rawNode.getAttributeRequired("${key}");
                `;
    }
  }).filter(e => e).join("\n")

}