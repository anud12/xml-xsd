import {TypeAny} from "./type";
import {XsdElement} from "./src";
import {mergeError} from "./mergeError";

export function processAny(element: XsdElement | XsdElement[]): TypeAny[] {
  try {
    if (Array.isArray(element)) {
      let result: TypeAny[] = [];
      element.forEach(subElement => {
        result.push(...processAny(subElement));
      })
      return result;
    }
    return [{
      metaType: "any"
    }]
  } catch (e) {
    throw mergeError(e, new Error(`processAny failed for ${JSON.stringify(element, null, 2)}`));
  }
}