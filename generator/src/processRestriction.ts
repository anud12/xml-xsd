import {Type, TypeDeclaration} from "./type";
import {XsdElement} from "./src";
import {mapXsdTypeToTs} from "./mapXsdType";

export function processRestriction(element: XsdElement | XsdElement[]): Type[] {
  if (Array.isArray(element)) {
    let result: Type[] = [];
    element.forEach(subElement => {
      result.push(...processRestriction(subElement));
    })
    return result;
  }

  if (element.base) {
    return [mapXsdTypeToTs(element.base)]
  }

  return [{
    metaType: "primitive",
    value: "unknown"
  }];
}