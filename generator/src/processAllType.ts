import {XsdElement} from "./src";
import {Type} from "./type";
import {mergeError} from "./mergeError";
import {processSequenceType} from "./processSequenceType";

export function processAllType(element: XsdElement | XsdElement[]): Type[] {
  try {
    if (Array.isArray(element)) {
      let result: Type[] = [];
      element.forEach(subElement => {
        result.push(...processAllType(subElement));
      })
      return result;
    }

    return processSequenceType(element);
  } catch (e) {
    throw mergeError(e, new Error(`processAllType failed for ${JSON.stringify(element, null, 2)}`));
  }
}