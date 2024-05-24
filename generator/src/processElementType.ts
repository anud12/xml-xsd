import {XsdElement} from "./src";
import {Type} from "./type";
import {mapXsdTypeToTs} from "./mapXsdType";
import {processComplexType} from "./processComplexType";

export function processElementType(element: XsdElement | XsdElement[]): Type[] {
  if (Array.isArray(element)) {
    let result: Type[] = [];
    element.forEach(subElement => {
      result.push(...processElementType(subElement));
    })
    return result;
  }
  if (!element) {
    return [];
  }

  if (element.type) {
    return [mapXsdTypeToTs(element.type)];
  }
  if (element["xs:complexContent"]) {
    return processComplexType(element["xs:complexContent"])
  }

  if (element["xs:complexType"]) {
    return processComplexType(element["xs:complexType"])
  }

  return [{
    metaType: "primitive",
    value: "unknown"
  }];
}