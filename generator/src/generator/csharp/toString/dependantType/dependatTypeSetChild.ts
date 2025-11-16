import {DependantType} from "../../typeToString";
import {Type} from "../../../../type";
import {getTypeName, primitives} from "../geTypeName";
import {normalizeName} from "../normalizeName";
import {getDependantTypeChildNamespace} from "../getDependantTypeChildNamespace";
import {template} from "../../../../template/template";


export const dependantTypeSetChild = (dependantType: DependantType): { dependantTypes:DependantType[], templateString: string } | undefined => {

  const dependantTypeList: DependantType[] = [];

  if (dependantType.value?.metaType !== "object") {
    return undefined;
  }


  const templateString = Object.entries(dependantType.value.value).flatMap(([key, value]) => {
    return [[key, value] as [string, Type]]
  })
    .map(([key, value]) => {
      let typeName = getTypeName(value, key, dependantType);
      let normalizedType = normalizeName(typeName);

      let type = `${getDependantTypeChildNamespace(dependantType)}.${normalizedType}`;

      if (value.metaType === "object") {
        dependantTypeList.push({
          type: "element",
          value: value,
          name: typeName,
          parentType: dependantType,
        })
      }
      if (value.metaType === "union" || value.metaType === "composition") {
        dependantTypeList.push({
          type: value.metaType,
          value: value,
          name: typeName,
          parentType: dependantType,
        })
      }
      if (value.metaType === "reference") {
        dependantTypeList.push({
          type: "reference",
          value: value,
          name: typeName,
          parentType: dependantType,
        })
        type = normalizedType;
      }

      return template()`
        ${value.isSingle && template()`
          if(linkedNode is ${type} ${normalizeName(key)}) 
          {
            this.${normalizeName(key)} = ${normalizeName(key)};
          }
          
        `}
        ${!value.isSingle && template()`
          if(linkedNode is LinkedNodeCollection<${type}> ${normalizeName(key)}) 
          {
            this.${normalizeName(key)} = ${normalizeName(key)};
          }
        `}
      `
      return template()`/* ignored children key:${key} of type:${typeName}*/`
    }).filter(e => e).join("\n");

  return {
    dependantTypes: dependantTypeList,
    templateString: templateString,
  }

}