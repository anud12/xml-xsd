import {Type} from "../../../type";
import {DependantType} from "../typeToString";

export const primitives = {
  int: "Integer",
  string: "String",
  boolean: "Boolean",
  object: "Object"
}

export function getTypeName(type: Type, parentKey?: string, parent?: DependantType) {
  switch (type.metaType) {
    case "reference":
    case "primitive":
      switch (type.value) {
        case 'xs:int':
        case 'xs:integer':
        case 'xs:decimal':
          return primitives.int
        case 'xs:boolean':
          return primitives.boolean
        case 'xs:string':
        case 'xs:anyURI':
          return primitives.string;
        case 'unknown':
          return `${primitives.object} /*unknown primitive*/`
        default:
          return type.value
      }
    case "union":
    case "object":
    case "composition":{
      return `${parentKey}`;
    }

    default:
      return primitives.object;
  }
}