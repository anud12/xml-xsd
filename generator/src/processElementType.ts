import {XsdElement} from "./src";
import {Type} from "./type";
import {processComplexType} from "./processComplexType";
import {mergeError} from "./mergeError";

export function processElementType(element: XsdElement | XsdElement[]): Type[] {
  try {
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
      return [{
        metaType:"primitive",
        value:element.type
      }];
    }
    if (element["xs:complexContent"] !== undefined) {
      return processComplexType(element["xs:complexContent"])
    }

    if (element["xs:complexType"] !== undefined) {
      return processComplexType(element["xs:complexType"])
    }

    return [{
      metaType: "primitive",
      value: "unknown"
    }];
  } catch (e) {
    throw mergeError(e, new Error(`processElementType failed for ${JSON.stringify(element, null, 2)}`))
  }

}