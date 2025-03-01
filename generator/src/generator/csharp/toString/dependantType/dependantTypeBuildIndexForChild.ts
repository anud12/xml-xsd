import {DependantType} from "../../typeToString";
import {template} from "../../../../template/template";
import {getDependantTypeChildNamespace} from "../getDependantTypeChildNamespace";
import {normalizeName} from "../normalizeName";
import {getTypeName} from "../geTypeName";

export const dependantTypeBuildIndexForChild = (dependantType: DependantType): string | undefined => {

  if (dependantType.value?.metaType !== "object") {
    return undefined;
  }

  return Object.entries(dependantType.value.value).map(([key, value]) => {
    let typeName = getTypeName(value, key, dependantType);
    let normalizedType = normalizeName(typeName);
    let type = `${getDependantTypeChildNamespace(dependantType)}.${normalizedType}`;

    if (value.metaType === "reference") {
      type = normalizedType;
    }

    let extractString = `null`;
    if (value.isSingle) {
      extractString = `0;`;
    }
    if (!value.isSingle) {
      extractString = `this._${normalizeName(key)}.KeyOf(casted_${normalizeName(key)});`;
    }
    return template()`
      if(linkedNode is ${type} casted_${normalizeName(key)}) {
        return ${extractString}
      }
    `
  }).filter(e => e).join("\n");


}