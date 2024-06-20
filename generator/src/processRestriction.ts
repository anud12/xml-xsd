import {Type, TypePrimitive, typeUnionCreate} from "./type";
import {XsdElement} from "./src";
import {mergeError} from "./mergeError";

export function processRestriction(element: XsdElement | XsdElement[]): Type[] {
  try {
    if (Array.isArray(element)) {
      let result: Type[] = [];
      element.forEach(subElement => {
        result.push(...processRestriction(subElement));
      })
      return result;
    }
    if (element.base === "xs:string" !== undefined) {
      let type: Type = {
        metaType:"primitive",
        value:element.base
      };
      if (element["xs:enumeration"] !== undefined) {
        const enumeration = Array.isArray(element["xs:enumeration"])
          ? element["xs:enumeration"]
          : [element["xs:enumeration"]]
        const enumerationType: TypePrimitive[] = enumeration.map(value => ({
          metaType: "primitive",
          value: `"${value.value}"`
        }));
        //create union from enumerations
        type = typeUnionCreate(...enumerationType);
      }
      return [type];
    }
    return [{
      metaType: "primitive",
      value: "unknown"
    }];
  } catch (e) {
    throw mergeError(e, new Error(`processRestriction failed for ${JSON.stringify(element, null, 2)}`));
  }
}