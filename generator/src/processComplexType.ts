import {Type, TypeRecursive} from "./type";
import {XsdElement} from "./src";
import {processSequenceType} from "./processSequenceType";
import {mapXsdTypeToTs} from "./mapXsdType";
import {processTypeAttribute} from "./processTypeAttribute";

export function processComplexType(element: XsdElement | XsdElement[]): Type[] {
  if (Array.isArray(element)) {
    let result: Type[] = [];
    element.forEach(subElement => {
      result.push(...processComplexType(subElement));
    })
    return result;
  }

  if (element.type) {
    return [mapXsdTypeToTs(element.type)]
  }
  let type: TypeRecursive = {
    metaType: "recursive",
    value: {}
  }

  if (element["xs:sequence"]) {
    type.value = {
      ...type.value,
      ...processSequenceType(element["xs:sequence"]).reduce((acc, value) => {
        return {
          ...acc,
          ...value.value
        }
      }, {})
    }
  }
  if (element["xs:attribute"]) {
    type.value = {
      ...type.value,
      ...processTypeAttribute(element["xs:attribute"]).reduce((acc, value) => {
        return {
          ...acc,
          [value.name]: value.value
        }
      }, {})
    }
  }
  return [type];
}