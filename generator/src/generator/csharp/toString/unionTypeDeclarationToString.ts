import {Type, TypeObject, TypeReference} from "../../../type";
import {typeDeclarationElementToString} from "./typeDeclarationToString";
import {DependantType, GetObjectBodyReturn} from "../typeToString";

export function unionTypeDeclarationToString(dependantType:DependantType):GetObjectBodyReturn {
  if(dependantType.type === "union") {
    if(dependantType.value.metaType === "union" || dependantType.value.metaType  === "composition") {

      const extensionsDependantTypes:DependantType<TypeReference>[] = dependantType.value.value.flatMap(e => {
        if(e.metaType === "reference") {
          return [{
            name: e.value,
            value: e,
            type: "reference"
          }]
        }
        return [];
      });

      const extensions = extensionsDependantTypes.map(e => {
        return e.value.value;
      });

      const value = dependantType.value.value.flatMap(e => {
        if(e.metaType === "object") {
          return Object.entries(e.value)
        }
        return [];
      }) .reduce((acc, [key, value]) => {
        return {
          ...acc,
          [key]: value,
        }
      }, {} as TypeObject["value"])
      const type:Type = {
        metaType: "object",
        attributes: dependantType.value.attributes,
        value: value
      }
      const result = typeDeclarationElementToString({
        type: "element",
        value: type,
        name: dependantType.name
      }, extensions)
      return {
        dependantTypes: [...result.dependantTypes, ...extensionsDependantTypes],
        templateString: result.templateString
      }
    }

  }
  throw Error(`Invalid ${JSON.stringify(dependantType, null ,2)}`);
}
