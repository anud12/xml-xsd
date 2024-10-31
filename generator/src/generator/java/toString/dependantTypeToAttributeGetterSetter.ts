import {DependantType} from "../typeToString";
import {template} from "../../../template/template";
import {normalizeNameClass, normalizeNameField} from "./normalizeNameClass";
import {getTypeName, primitives} from "./geTypeName";

export const dependantTypeToAttributeGetterSetter = (dependantType: DependantType): string | undefined => {

  if (dependantType.value.attributes?.metaType !== "object") {
    return undefined;
  }


  return Object.entries(dependantType.value.attributes.value ?? {}).map(([key, value]) => {
    let type = getTypeName(value, key, dependantType);

    if (value.metaType === "primitive") {
      if (type !== primitives.int) {
        const typeString = value.isNullable
          ? `${primitives.string}?`
          : primitives.string;

        return template()`
                public ${typeString} Get_${normalizeNameClass(key)}()
                {
                  return this.${normalizeNameField(key)};
                }
                public void Set_${normalizeNameClass(key)}(${typeString} value)
                {
                  this.${normalizeNameField(key)} = value;
                }
                `
      }

      const typeString = value.isNullable
        ? `${type}?`
        : type;

      return template()`
              public ${typeString} Get_${normalizeNameClass(key)}()
              {
                return this.${normalizeNameField(key)};
              }
              public void Set_${normalizeNameClass(key)}(${typeString} value)
              {
                this.${normalizeNameField(key)} = value;
              }
              `
    }

    return template()`/* ignored attribute key={key} of type=${type}*/`
  }).filter(e => e).join("\n")


}