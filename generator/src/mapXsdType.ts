import { Type, TypePrimitive } from "./type";

export function mapXsdTypeToTs(xsdType: string | undefined): TypePrimitive {
  if(!xsdType) {
    return {
      metaType: 'primitive',
      value: "unknown"
    } as TypePrimitive;
  }
  let value: string;
  switch (xsdType) {
    case 'xs:string':
      value = 'string';
      break;
    case 'xs:int':
    case 'xs:integer':
    case 'xs:decimal':
      value = 'number';
      break;
    case 'xs:boolean':
      value = 'boolean';
      break;
    default:
      value = xsdType;
  }
  return {
    metaType: 'primitive',
    value: value
  } as TypePrimitive;
}