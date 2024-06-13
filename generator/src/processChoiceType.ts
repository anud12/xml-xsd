import {Type, typeMergeAsUnion, TypeObject} from "./type";
import {XsdElement} from "./src";
import {processElementType} from "./processElementType";
import {mergeError} from "./mergeError";

export function processChoice(element: XsdElement | XsdElement[]): Type[] {
  try {
    if (Array.isArray(element)) {
      let result: Type[] = [];
      element.forEach(subElement => {
        result.push(...processChoice(subElement));
      })
      return result;
    }

    if (element.type) {
      return [{
        metaType: "primitive",
        value: element.type
      }]
    }
    let type: Type = {
      metaType: "union",
      value: []
    };

    if (element["xs:element"] !== undefined) {
      const objectType = processElementType(element["xs:element"]).map((type, key) => {
        return {
          metaType: "object",
          value: {
            [element["xs:element"][key].name]: type
          },
        }satisfies TypeObject
      })
      type = typeMergeAsUnion(...objectType);
    }

    return [type];
  } catch (e) {
    throw mergeError(e, new Error(`processChoice failed for ${JSON.stringify(element, null, 2)}`))
  }
}