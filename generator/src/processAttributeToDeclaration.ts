import {Type, TypeDeclaration} from "./type";
import {XsdElement} from "./src";
import {mergeError} from "./mergeError";
import {processAttribute} from "./processAttribute";

export function processAttributeToDeclaration(element: XsdElement | XsdElement[]): TypeDeclaration[] {
  try {
    if (Array.isArray(element)) {
      let result: TypeDeclaration[] = [];
      element.forEach(subElement => {
        result.push(...processAttributeToDeclaration(subElement));
      })
      return result;
    }
    if (!element) {
      return []
    }

    let types: Type[] = processAttribute(element);
    return types.map(type => {
      return {
        name: element?.name,
        type: "attribute",
        value: type
      } as TypeDeclaration;
    });
  } catch (e) {
    throw mergeError(e, new Error(`processAttributeGroupToDeclaration failed for ${JSON.stringify(element, null, 2)}`))
  }
}