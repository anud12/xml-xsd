import {Type, typeMerge, typeMergeAsUnion, typeUnionCreate} from "./type";
import {XsdElement} from "./src";
import {mapXsdTypeToTs} from "./mapXsdType";
import {processElementType} from "./processElementType";

export function processChoice(element: XsdElement | XsdElement[]): Type[] {
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

  if(element["xs:element"]) {
    type = typeMergeAsUnion(type, ...processElementType(element["xs:element"]));
  }

  return [type];
}