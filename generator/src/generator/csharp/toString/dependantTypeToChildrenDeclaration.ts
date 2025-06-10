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
          public ${type} ${normalizeName(key)}  
          { 
            get
            {
              if(_${normalizeName(key)} == null) 
              {
                _${normalizeName(key)} = new();
                _${normalizeName(key)}.ParentNode = this;
                NotifyChange();
              }
              return _${normalizeName(key)};
            }
            set
            {
              _${normalizeName(key)} = value;
              _${normalizeName(key)}.ParentNode = this;
            }
          }
        `}
        ${!value.isSingle && template()`
          private LinkedNodeCollection<${type}> _${normalizeName(key)} = new();
          public LinkedNodeCollection<${type}> ${normalizeName(key)} 
          { 
            get => _${normalizeName(key)}; 
            set
            {
              _${normalizeName(key)} = value;
              value.ForEach(linkedNode => linkedNode.ParentNode = this);
              _${normalizeName(key)}.OnAdd = (value) =>
              {
                value.ParentNode = this;
                NotifyChange();
              };
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