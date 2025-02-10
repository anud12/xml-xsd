import {DependantType} from "../typeToString";
import {normalizeName} from "./normalizeName";
import {getTypeName} from "./geTypeName";
import {Type} from "../../../type";
import {template} from "../../../template/template";
import {getDependantTypeChildNamespace} from "./getDependantTypeChildNamespace";

export const dependantTypeToChildrenDeclaration = (dependantType: DependantType): { dependantTypes:DependantType[], templateString: string } | undefined => {

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
          private ${type}${value.isNullable && `?`} _${normalizeName(key)} = ${value.isNullable? `null`: `new ${type}()`};
          public ${type}${value.isNullable && `?`} ${normalizeName(key)} {
            get { return _${normalizeName(key)}; }
            set { _${normalizeName(key)} = value; }
          }
        `}
        ${!value.isSingle && template()`
          private Dictionary<int, ${type}> _${normalizeName(key)} = new Dictionary<int, ${type}>();
          public List<${type}> ${normalizeName(key)} {
            get { return _${normalizeName(key)}.Values.ToList(); }
            set 
            { 
              _${normalizeName(key)} = value
                .Select((value, index) => new { index, value })
                .ToDictionary(item => item.index, item => item.value);
            }
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