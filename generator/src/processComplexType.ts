import {Type, typeMerge, TypeObject, TypePrimitive} from "./type";
import {XsdElement} from "./src";
import {processSequenceType} from "./processSequenceType";
import {processAttribute} from "./processAttribute";
import {processAttributeGroup} from "./processAttributeGroup";
import {processExtension} from "./processExtension";
import {processChoice} from "./processChoiceType";
import {mergeError} from "./mergeError";
import {processGroup} from "./processGroup";
import {processAllType} from "./processAllType";

export function processComplexType(element: XsdElement | XsdElement[]): Type[] {
  try {
    if (Array.isArray(element)) {
      let result: Type[] = [];
      element.forEach(subElement => {
        result.push(...processComplexType(subElement));
      })
      return result;
    }

    const maxOccurs = element.maxOccurs ?? "1";
    const isSingle = maxOccurs === "1";

    if (element.type) {
      return [
        {
          metaType: 'primitive',
          value: element.type,
          isSingle: isSingle,
        } as TypePrimitive
      ]
    }
    let type: Type = {
      metaType: "object",
      value: {},
      isSingle: isSingle,
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
    if (element["xs:all"] !== undefined) {
      type = typeMerge(type, ...processAllType(element["xs:all"]));
    }
    if (element["xs:group"] !== undefined) {
      type = typeMerge(type, ...processGroup(element["xs:group"]));
    }
    if (element["xs:attributeGroup"] !== undefined) {
      type.attributes = typeMerge(type.attributes, ...processAttributeGroup(element["xs:attributeGroup"]));
    }
    if (element["xs:attribute"] !== undefined) {
      type.attributes = typeMerge(type.attributes, ...processAttribute(element["xs:attribute"]));
    }
    return [type];
  } catch (e) {
    throw mergeError(e, new Error(`processComplexType failed for ${JSON.stringify(element, null, 2)}`))
  }
}