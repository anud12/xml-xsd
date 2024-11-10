import {DependantType} from "../../typeToString";
import {template} from "../../../../template/template";
import {normalizeNameClass, normalizeNameField} from "../normalizeNameClass";

export const dependantTypeToAttributeSerializationBody = (dependantType: DependantType): string | undefined => {

  if (dependantType.value.attributes?.metaType !== "object") {
    return undefined;
  }


  return Object.entries(dependantType.value.attributes.value ?? []).map(([key, value]) => {
    if (value.metaType === "primitive") {
      if(value.isNullable) {
        return template()`
          innerLogger.log("${key}");
          this.${normalizeNameField(key)}.ifPresent(o -> rawNode.setAttribute("${key}", o));
          `
      }
      return template()`
                innerLogger.log("${key}");
                rawNode.setAttribute("${key}", this.${normalizeNameField(key)});
                `;
    }
  }).filter(e => e).join("\n")

}