import {DependantType} from "../typeToString";
import {template} from "../../../template/template";
import {normalizeName} from "./normalizeName";
import {getTypeName, primitives} from "./geTypeName";

export const dependantTypeToAttributeGetterSetter = (dependantType: DependantType): string | undefined => {

  if (dependantType.value.attributes?.metaType !== "object") {
    return undefined;
  }


  return Object.entries(dependantType.value.attributes.value ?? {}).map(([key, value]) => {
    let type = getTypeName(value, key, dependantType.name);

    if (value.metaType === "primitive") {
      if (type !== primitives.int) {
        const typeString = value.isNullable
          ? `${primitives.string}?`
          : primitives.string;

        return template()`
                public ${typeString} Get_${normalizeName(key)}()
                {
                  return this.${normalizeName(key)};
                }
                public void Set_${normalizeName(key)}(${typeString} value)
                {
                  this.${normalizeName(key)} = value;
                }
                `
      }

      const typeString = value.isNullable
        ? `${type}?`
        : type;

      return template()`
              public ${typeString} Get_${normalizeName(key)}()
              {
                return this.${normalizeName(key)};
              }
              public void Set_${normalizeName(key)}(${typeString} value)
              {
                this.${normalizeName(key)} = value;
              }
              `
    }

    return template()`/* ignored attribute key={key} of type=${type}*/`
  }).filter(e => e).join("\n")


}