import {Type} from "./type";
import {XsdElement} from "./src";
import {processComplexType} from "./processComplexType";

export function processGroup(element: XsdElement | XsdElement[]): Type[] {
  if (Array.isArray(element)) {
    let result: Type[] = [];
    element.forEach(subElement => {
      result.push(...processGroup(subElement));
    })
    return result;
  }
  if (element.ref) {
    return [{
      metaType: "primitive",
      value: element.ref
    }]
  }
  return processComplexType(element)
}