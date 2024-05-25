import {Type, TypeDeclaration} from "./type";
import {XsdElement} from "./src";
import {processAttributeGroup} from "./processAttributeGroup";
import {mergeError} from "./mergeError";

export function processAttributeGroupToDeclaration(element: XsdElement | XsdElement[]): TypeDeclaration[] {
  try {
    if (Array.isArray(element)) {
      let result: TypeDeclaration[] = [];
      element.forEach(subElement => {
        result.push(...processAttributeGroupToDeclaration(subElement));
      })
      return result;
    }
    if (!element) {
      return []
    }

    let types: Type[] = processAttributeGroup(element);
    return types.map(type => {
      return {
        name: element?.name,
        value: type
      } as TypeDeclaration;
    });
  } catch (e) {
    throw mergeError(e, new Error(`processAttributeGroupToDeclaration failed for ${JSON.stringify(element, null, 2)}`))
  }
}