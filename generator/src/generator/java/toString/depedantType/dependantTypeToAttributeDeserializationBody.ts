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
                    var ${normalizeNameField(key)}Value = rawNode.getAttributeInt("${key}");
                    if(Objects.equals(this.${normalizeNameField(key)}, ${normalizeNameField(key)}Value)) {
                      isDirty = true;
                    }
                    this.${normalizeNameField(key)} = ${normalizeNameField(key)}Value;
                    `;
        }
        return template()`
                    innerLogger.log("${key}");
                    var ${normalizeNameField(key)}Value = rawNode.getAttributeIntRequired("${key}");
                    if(Objects.equals(this.${normalizeNameField(key)}, ${normalizeNameField(key)}Value)) {
                      isDirty = true;
                    }
                    this.${normalizeNameField(key)} = ${normalizeNameField(key)}Value;
                    `;
      }
      if ([primitives.double].includes(type)) {
        if(value.isNullable) {
          return template()`
                    innerLogger.log("${key}");
                    var ${normalizeNameField(key)}Value = rawNode.getAttributeDouble("${key}");
                    if(Objects.equals(this.${normalizeNameField(key)}, ${normalizeNameField(key)}Value)) {
                      isDirty = true;
                    }
                    this.${normalizeNameField(key)} = ${normalizeNameField(key)}Value;
                    `;
        }
        return template()`
                    innerLogger.log("${key}");
                    var ${normalizeNameField(key)}Value = rawNode.getAttributeDoubleRequired("${key}");
                    if(Objects.equals(this.${normalizeNameField(key)}, ${normalizeNameField(key)}Value)) {
                      isDirty = true;
                    }
                    this.${normalizeNameField(key)} = ${normalizeNameField(key)}Value;
                    `;
      }
      if(value.isNullable) {
        return template()`
                innerLogger.log("${key}");
                var ${normalizeNameField(key)}Value = rawNode.getAttribute("${key}");
                if(Objects.equals(this.${normalizeNameField(key)}, ${normalizeNameField(key)}Value)) {
                  isDirty = true;
                }
                this.${normalizeNameField(key)} = ${normalizeNameField(key)}Value;
                `;
      }
      return template()`
                innerLogger.log("${key}");
                var ${normalizeNameField(key)}Value = rawNode.getAttributeRequired("${key}");
                if(Objects.equals(this.${normalizeNameField(key)}, ${normalizeNameField(key)}Value)) {
                  isDirty = true;
                }
                this.${normalizeNameField(key)} = ${normalizeNameField(key)}Value;
                `;
    }
  }).filter(e => e).join("\n")

}