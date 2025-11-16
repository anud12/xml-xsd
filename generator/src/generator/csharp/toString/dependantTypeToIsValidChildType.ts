import {DependantType} from "../typeToString";
import {template} from "../../../template/template";
import {normalizeName} from "./normalizeName";
import {getTypeName, primitives} from "./geTypeName";
import {Type} from "../../../type";
import {getDependantTypeChildNamespace} from "./getDependantTypeChildNamespace";

export const dependantTypeToIsValidChildType = (dependantType: DependantType): { dependantTypes:DependantType[], templateString: string } | undefined => {

  const dependantTypeList: DependantType[] = [];

  if (dependantType.value?.metaType !== "object") {
    return {
      dependantTypes: undefined,
      templateString: "return false;",
    };
  }


  const childrenCases =  [...Object.entries(dependantType.value.value)].flatMap(([key, value]) => {
    return [[key, value] as [string, Type]]
  })
    .map(([key, value]) => {
      let typeName = getTypeName(value, key, dependantType);
      let normalizedType = normalizeName(typeName);

      let type = `${getDependantTypeChildNamespace(dependantType)}.${normalizedType}`;
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
      candidateChild is ${type}
      `;
    }).filter(e => e)

  childrenCases.push("false")

  return {
    dependantTypes: dependantTypeList,
    templateString: "return " + (childrenCases.join("\n|| ") ?? "false") + ";",
  }
}