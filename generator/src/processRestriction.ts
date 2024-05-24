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
  if (element.base === "xs:string") {
    let type: Type = mapXsdTypeToTs(element.base);
    if (element["xs:enumeration"]) {
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
}