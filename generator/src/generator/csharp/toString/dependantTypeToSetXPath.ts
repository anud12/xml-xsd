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
            xpath = xpath.Substring(${type}.TagName.Length + 3);
            this.${normalizeName(key)}.SetXPath(xpath, rawNode);
            return;
          }
        `
      }
      if(!value.isSingle) {
        return template()`
          if(xpath.StartsWith(${type}.TagName + "["))
          {
            var startIndex = (${type}.TagName + "[").Length;
            var indexString = xpath.Substring(startIndex, startIndex + 1);
            xpath = xpath.Substring(startIndex + 2);
            if(this._${normalizeName(key)}.ContainsKey(indexString.ToInt())) 
            {
              this._${normalizeName(key)}[indexString.ToInt()].SetXPath(xpath, rawNode);
            }
            var newEntry = new ${type}();
            newEntry.SetXPath(xpath, rawNode);
            this._${normalizeName(key)}.Add(indexString.ToInt(), newEntry);
            
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