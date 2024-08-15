import {Type} from "../../../type";

export const primitives = {
  int: "System.Int32",
  string: "System.String",
  boolean: "System.Boolean",
  object: "System.Object"
}

export function getTypeName(type: Type, parentKey?: string, parentName?: string) {
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
    case "composition":
      return `${parentName}__${parentKey}`;
    default:
      return primitives.object;
  }
}