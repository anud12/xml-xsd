import {DependantType} from "../typeToString";
import {template} from "../../../template/template";
import {normalizeName} from "./normalizeName";
import {getTypeName, primitives} from "./geTypeName";
import {Type} from "../../../type";
import {getDependantTypeChildNamespace} from "./getDependantTypeChildNamespace";

export const dependantTypeToSetXPath = (dependantType: DependantType): { dependantTypes:DependantType[], templateString: string } | undefined => {

  const dependantTypeList: DependantType[] = [];

  if (dependantType.value?.metaType !== "object") {
    return undefined;
  }


  const childrenCases =  Object.entries(dependantType.value.value).flatMap(([key, value]) => {
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
      if(value.isSingle) {
        return template()`
          if(xpath.StartsWith(${type}.TagName))
          {
            ${value.isNullable && `this.${normalizeName(key)} ??= new ${type}();`}
            var childXPath = xpath.Substring(${type}.TagName.Length + 3);
            this.${normalizeName(key)}.SetXPath(childXPath, rawNode);
            return;
          }
        `
      }
      if(!value.isSingle) {
        return template()`
          if(xpath.StartsWith(${type}.TagName + "["))
          {
            var startIndex = (${type}.TagName + "[").Length;
            var indexString = xpath.Substring(startIndex, 1);
            var childXPath = xpath.Substring(startIndex + 2);
            var pathIndex = indexString.ToInt();
            if(this.${normalizeName(key)}.ContainsKey(pathIndex)) 
            {
              this.${normalizeName(key)}[pathIndex].SetXPath(childXPath, rawNode);
              return;
            }
            var newEntry = new ${type}();
            this.${normalizeName(key)}[pathIndex] = newEntry;
            newEntry.SetXPath(childXPath, rawNode);
            
            return;
          }
        `
      }
      return "";
    }).filter(e => e).join("\n")

  return {
    dependantTypes: dependantTypeList,
    templateString: childrenCases,
  }
}