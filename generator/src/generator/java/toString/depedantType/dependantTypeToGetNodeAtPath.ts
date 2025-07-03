
import {Type} from "../../../../type";
import {template} from "../../../../template/template";
import {getTypeName} from "../geTypeName";
import {normalizeNameClass, normalizeNameField} from "../normalizeNameClass";
import {basePackage, getDependantTypePackage} from "./getDependantTypePackage";
import {DependantType} from "../../typeToString";

export const dependantTypeToGetNodeAtPath = (dependantType: DependantType): { dependantTypes:DependantType[], templateString: string } | undefined => {
  const dependantTypeList: DependantType[] = [];

  if (dependantType.value?.metaType !== "object") {
    return undefined;
  }


  const childrenCases =  Object.entries(dependantType.value.value).flatMap(([key, value]) => {
    return [[key, value] as [string, Type]]
  })
    .map(([key, value]) => {
      let typeName = getTypeName(value, key, dependantType);
      let normalizedName = normalizeNameClass(typeName);

      let type = `${getDependantTypePackage(dependantType)}.${normalizedName}.${normalizedName}`;
      if (value.metaType === "reference") {
        dependantTypeList.push({
          type: "reference",
          value: value,
          name: typeName,
          typeDeclaration: undefined,
          parentType: dependantType,
        })
        type = `${basePackage}.${normalizedName}.${normalizedName}`;
      }
      if(value.isSingle) {
        return template()`
          if(xpath.startsWith(${type}.nodeName))
          {
            ${value.isNullable && template()`
              if(this.${normalizeNameField(key)}.isEmpty()) {
                this.${normalizeNameField(key)} = Optional.of(new ${type}());
              }
            `}
            var childXPath = xpath.substring(${type}.nodeName.length() + 3);
            return this.${normalizeNameField(key)}${value.isNullable && ".get()"}.getNodeAtPath(childXPath);
          }
        `
      }
      if(!value.isSingle) {
        return template()`
          if(xpath.startsWith(${type}.nodeName + "["))
          {
            var startTokens = xpath.split(${type}.nodeName + "\\\\[");
            var endToken = startTokens[1].split("]");
            var indexString = endToken[0];
            var childXPath = xpath.replace(${type}.nodeName + "[" + indexString + "]", "");
            var pathIndex = Integer.parseInt(indexString);
            if(this.${normalizeNameField(key)}.size() > pathIndex) {
              return this.${normalizeNameField(key)}.get(pathIndex).getNodeAtPath(childXPath);
            }
            return Optional.empty();
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