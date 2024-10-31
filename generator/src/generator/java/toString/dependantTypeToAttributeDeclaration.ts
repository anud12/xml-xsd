import {DependantType} from "../typeToString";
import {template} from "../../../template/template";
import {normalizeNameClass, normalizeNameField} from "./normalizeNameClass";
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
          ? `Optional<${primitives.string}>`
          : primitives.string;

        return template()`
                private ${typeString} ${normalizeNameField(key)};
                `
      }

      const typeString = value.isNullable
        ? `Optional<${type}>`
        : type;

      return template()`
              private ${typeString} ${normalizeNameField(key)};
              `
    }

    return template()`/* ignored attribute key={key} of type=${type}*/`
  }).filter(e => e).join("\n")


}