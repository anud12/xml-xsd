import {Type, TypeDeclaration, TypePrimitive} from "./type";
import { XsdElement } from "./src";
import {mapXsdTypeToTs} from "./mapXsdType";

export function processTypeAttribute(elements: XsdElement[] | XsdElement): TypeDeclaration[] {
  if(Array.isArray(elements)) {
    let result: TypeDeclaration[] = [];
    for (const subElement of elements) {
      result.push(...processTypeAttribute(subElement));
    }
    return result;
  }
  if(!elements.name) {
    return [];
  }
  let type: Type = mapXsdTypeToTs(elements.type);
  return [{
    value:type,
    name: elements.name,
  }];
}