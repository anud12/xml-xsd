import {DependantType} from "../typeToString";
import {template} from "../../../template/template";
import {normalizeName} from "./normalizeName";
import {getTypeName, primitives} from "./geTypeName";

export const dependantTypeToAttributeDeclaration = (dependantType: DependantType): string | undefined => {

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
                public ${typeString} ${normalizeName(key)};
                `
      }

      const typeString = value.isNullable
        ? `${type}?`
        : type;

      return template()`
              public ${typeString} ${normalizeName(key)};
              `
    }

    return template()`/* ignored attribute key={key} of type=${type}*/`
  }).filter(e => e).join("\n")


}