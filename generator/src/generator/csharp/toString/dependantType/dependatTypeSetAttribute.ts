import {DependantType} from "../../typeToString";
import {Type} from "../../../../type";
import {getTypeName, primitives} from "../geTypeName";
import {normalizeName} from "../normalizeName";
import {getDependantTypeChildNamespace} from "../getDependantTypeChildNamespace";
import {template} from "../../../../template/template";


export const dependantTypeSetAttribute = (dependantType: DependantType): string | undefined => {

  if (dependantType.value.attributes?.metaType !== "object") {
    return undefined;
  }


  return Object.entries(dependantType.value.attributes.value ?? {}).map(([key, value]) => {
    let type = getTypeName(value, key, dependantType);

    if (value.metaType === "primitive") {
      if (type !== primitives.int) {
        return template()`
                if(name == "${normalizeName(key)}")
                {
                  Set_${normalizeName(key)}(value);
                }
                `
      }
      if (type === primitives.int) {
        return template()`
                if(name == "${normalizeName(key)}")
                {
                  Set_${normalizeName(key)}(value?.ToInt() ?? 0);
                }
                `
      }
    }

    return template()`/* ignored attribute key={key} of type=${type}*/`
  }).filter(e => e).join("\n")


}