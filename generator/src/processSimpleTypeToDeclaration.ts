import {Type, TypeDeclaration} from "./type";
import {XsdElement} from "./src";
import {processRestriction} from "./processRestriction";
import {mergeError} from "./mergeError";

export function processSimpleTypeToDeclaration(element: XsdElement | XsdElement[]): TypeDeclaration[] {
  try {
    if (Array.isArray(element)) {
      let result: TypeDeclaration[] = [];
      element.forEach(subElement => {
        result.push(...processSimpleTypeToDeclaration(subElement));
      })
      return result;
    }
    if(!element) {
      return []
    }
    let type: Type = {
      metaType: "primitive",
      value: "unknown"
    };
    if (element.type) {
      type = {
        metaType:"primitive",
        value:element.type
      };
    }
    if (element["xs:restriction"] !== undefined) {
      type = processRestriction(element["xs:restriction"])[0];
    }
    return [{
      name: element.name,
      value: type
    }];
  } catch (e) {
    throw mergeError(e, new Error(`processSimpleTypeToDeclaration failed for ${JSON.stringify(element, null, 2)}`));
  }
}