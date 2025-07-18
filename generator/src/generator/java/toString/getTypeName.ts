import {Type} from "../../../type";
import {DependantType} from "../typeToString";

export const primitives = {
  int: "Integer",
  string: "String",
  boolean: "Boolean",
  object: "Object",
  double: "Double"
}

export function getTypeName(type: Type, parentKey?: string, parent?: DependantType) {
  switch (type.metaType) {
    case "reference":
    case "primitive":
      switch (type.value) {
        case 'xs:int':
        case 'xs:integer':
          return primitives.int
        case 'xs:decimal':
        case 'xs:double':
          return primitives.double
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