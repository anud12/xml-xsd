import {XsdElement} from "./src";
import {Type} from "./type";
import {processComplexType} from "./processComplexType";
import {mergeError} from "./mergeError";

export function processElementType(element: XsdElement | XsdElement[]): Type[] {
  try {
    if (Array.isArray(element)) {
      let result: Type[] = [];
      element.forEach(subElement => {
        result.push(...processElementType(subElement));
      })
      return result;
    }
    if (!element) {
      return [];
    }
    const maxOccurs = element.maxOccurs ?? "1";
    const isSingle = maxOccurs === "1";

    const minOccurs = element.minOccurs ?? "1";
    const isNullable = minOccurs === "0";
    if (element.type) {
      return [{
        metaType: "reference",
        value: element.type,
        isSingle: isSingle,
        isNullable: isNullable,
      }];
    }
    if (element["xs:complexContent"] !== undefined) {
      return processComplexType(element["xs:complexContent"]).map(type => {
        return {
          ...type,
          isSingle: isSingle,
          isNullable: isNullable,
        }
      });
    }

    if (element["xs:complexType"] !== undefined) {
      return processComplexType(element["xs:complexType"]).map(type => {
        return {
          ...type,
          isSingle: isSingle,
          isNullable: isNullable,
        }
      });
    }

    return [{
      metaType: "primitive",
      value: "unknown",
      isSingle: isSingle,
      isNullable: isNullable,
    }];
  } catch (e) {
    throw mergeError(e, new Error(`processElementType failed for ${JSON.stringify(element, null, 2)}`))
  }

}