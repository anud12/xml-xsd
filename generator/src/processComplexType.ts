import {Type, typeDeclarationsToRecursive, typeMerge, TypeObject} from "./type";
import {XsdElement} from "./src";
import {processSequenceType} from "./processSequenceType";
import {mapXsdTypeToTs} from "./mapXsdType";
import {processTypeAttribute} from "./processTypeAttribute";
import {processAttributeGroup} from "./processAttributeGroup";
import {processExtension} from "./processExtension";
import {processChoice} from "./processChoiceType";
import {mergeError} from "./mergeError";

export function processComplexType(element: XsdElement | XsdElement[]): Type[] {
  try {
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
    let type: Type = {
      metaType: "object",
      value: {},
    } as TypeObject;

    if (element["xs:complexContent"] !== undefined) {
      type = typeMerge(type, ...processComplexType(element["xs:complexContent"]))
    }
    if (element["xs:extension"] !== undefined) {
      type = typeMerge(type, ...processExtension(element["xs:extension"]))
    }
    if (element["xs:choice"] !== undefined) {
      type = typeMerge(type, ...processChoice(element["xs:choice"]));
    }
    if (element["xs:sequence"] !== undefined) {
      type = typeMerge(type, ...processSequenceType(element["xs:sequence"]));
    }
    if (element["xs:attributeGroup"] !== undefined) {
      type.attributes = typeMerge(type.attributes, ...processAttributeGroup(element["xs:attributeGroup"]));
    }
    if (element["xs:attribute"] !== undefined) {
      type.attributes = typeMerge(type.attributes, ...processTypeAttribute(element["xs:attribute"]));

    }
    return [type];
  } catch (e) {
    throw mergeError(e, new Error(`processComplexType failed for ${JSON.stringify(element, null, 2)}`))
  }
}