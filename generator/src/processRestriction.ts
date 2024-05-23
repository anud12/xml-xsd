import {Type, TypePrimitive, typeUnionCreate} from "./type";
import {XsdElement} from "./src";
import {mapXsdTypeToTs} from "./mapXsdType";

export function processRestriction(element: XsdElement | XsdElement[]): Type[] {
  if (Array.isArray(element)) {
    let result: Type[] = [];
    element.forEach(subElement => {
      result.push(...processRestriction(subElement));
    })
    return result;
  }

  if (element["xs:enumeration"]) {
    const enumeration = Array.isArray(element["xs:enumeration"])
      ? element["xs:enumeration"]
      : [element["xs:enumeration"]]
    const enumerationType:TypePrimitive[] = enumeration.map(value => ({
      metaType: "primitive",
      value: `"${value.value}"`
    }));
    //create union from enumerations
    return [typeUnionCreate(...enumerationType)];
  }

  if (element.base) {
    return [mapXsdTypeToTs(element.base)]
  }
  return [{
    metaType: "primitive",
    value: "unknown"
  }];
}