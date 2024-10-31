import {DependantType} from "../typeToString";
import {template} from "../../../template/template";
import {normalizeNameClass, normalizeNameField} from "./normalizeNameClass";
import {getTypeName, primitives} from "./geTypeName";

export const dependantTypeToAttributeGetterSetter = (dependantType: DependantType, parentDependantType?:DependantType): string | undefined => {

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
                public ${typeString} get${normalizeNameClass(key)}()
                {
                  return this.${normalizeNameField(key)};
                }
                public ${normalizeNameClass(parentDependantType?.name ?? dependantType.name)} set${normalizeNameClass(key)}(${typeString} value)
                {
                  this.${normalizeNameField(key)} = value;
                  onChangeList.forEach(consumer -> consumer.accept(this));
                  return this;
                }
                `
      }

      const typeString = value.isNullable
        ? `Optional<${type}>`
        : type;

      return template()`
              public ${typeString} get${normalizeNameClass(key)}()
              {
                return this.${normalizeNameField(key)};
              }
              public ${normalizeNameClass(parentDependantType?.name ?? dependantType.name)} set${normalizeNameClass(key)}(${typeString} value)
              {
                this.${normalizeNameField(key)} = value;
                onChangeList.forEach(consumer -> consumer.accept(this));
                return this;
              }
              `
    }

    return template()`/* ignored attribute key={key} of type=${type}*/`
  }).filter(e => e).join("\n")


}