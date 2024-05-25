import {Type, TypePrimitive} from "./type";
import {XsdElement} from "./src";
import {processComplexType} from "./processComplexType";
import {mergeError} from "./mergeError";

export function processExtension(element: XsdElement | XsdElement[]): Type[] {
  try {
    if (Array.isArray(element)) {
      let result: Type[] = [];
      element.forEach(subElement => {
        result.push(...processExtension(subElement));
      })
      return result;
    }
    let type = processComplexType(element);
    let primitiveType: TypePrimitive = {
      metaType: "primitive",
      value: element.base
    }
    return [{
      metaType: "composition",
      value: [...type, primitiveType]
    }]
  } catch (e) {
    throw mergeError(e, new Error(`processExtension failed for ${JSON.stringify(element, null, 2)}`));
  }
}