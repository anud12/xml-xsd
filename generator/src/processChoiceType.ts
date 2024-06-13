import {Type, typeMerge, typeMergeAsUnion, typeUnionCreate} from "./type";
import {XsdElement} from "./src";
import {mapXsdTypeToTs} from "./mapXsdType";
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
      return [mapXsdTypeToTs(element.type)]
    }
    let type: Type = {
      metaType: "union",
      value: []
    };

    if(element["xs:element"] !== undefined) {
      type = typeMergeAsUnion(...processElementType(element["xs:element"]));
    }

    return [type];
  } catch (e) {
    throw mergeError(e, new Error(`processChoice failed for ${JSON.stringify(element, null, 2)}`))
  }
}