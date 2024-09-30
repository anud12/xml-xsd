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

    const maxOccurs = element.maxOccurs ?? "1";
    const isSingle = maxOccurs === "1";

    if (element.type) {
      return [{
        metaType: "primitive",
        value: element.type,
        isSingle
      }]
    }
    let type: Type = {
      metaType: "union",
      value: []
    };

    if (element["xs:element"] !== undefined) {
      const objectType = processElementType(element["xs:element"]).map((type, key) => {
        const xsElement = element["xs:element"][key] ?? element["xs:element"];
        return {
          metaType: "object",
          isSingle: type.isSingle,
          value: {
            [xsElement.name]: type
          },
        } satisfies TypeObject
      })
      type = typeMergeAsUnion(...objectType);
    }

    type.isSingle = isSingle;
    return [type];
  } catch (e) {
    throw mergeError(e, new Error(`processChoice failed for ${JSON.stringify(element, null, 2)}`))
  }
}