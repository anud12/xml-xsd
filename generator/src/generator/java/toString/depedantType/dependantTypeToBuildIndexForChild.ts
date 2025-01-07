import {DependantType} from "../../typeToString";
import {template} from "../../../../template/template";
import {normalizeNameClass, normalizeNameField} from "../normalizeNameClass";
import {basePackage, getDependantTypePackage} from "./getDependantTypePackage";

export const dependantTypeToBuildIndexForChild = (dependantType: DependantType): string | undefined => {

  if (dependantType.value?.metaType !== "object") {
    return undefined;
  }

  return Object.entries(dependantType.value.value).map(([key, value]) => {
    let className = `${getDependantTypePackage(dependantType)}.${normalizeNameClass(key)}.${normalizeNameClass(key)}`;

    if (value.metaType === "reference") {
      className = `${basePackage}.${normalizeNameClass(value.value)}.${normalizeNameClass(value.value)}`;
    }

    let extractString = `null`;
    if (value.isSingle) {
      extractString = `0;`;
    }
    if (!value.isSingle) {
      extractString = `this.${normalizeNameField(key)}.indexOf(object);`;
    }
    return template()`
      if(object instanceof ${className}) {
        return ${extractString}
      }
    `
  }).filter(e => e).join("\n");

}