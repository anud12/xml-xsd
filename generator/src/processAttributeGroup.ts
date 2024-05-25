import {Type} from "./type";
import {XsdElement} from "./src";
import {processComplexType} from "./processComplexType";
import {mergeError} from "./mergeError";

export function processAttributeGroup(element: XsdElement | XsdElement[]): Type[] {
  try {
    if (Array.isArray(element)) {
      let result: Type[] = [];
      element.forEach(subElement => {
        result.push(...processAttributeGroup(subElement));
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
  } catch (e) {
    throw mergeError(e, new Error(`processAttributeGroup failed for ${JSON.stringify(element, null, 2)}`))
  }

}