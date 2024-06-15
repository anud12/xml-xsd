import {XsdElement} from "./src";
import {Type, TypeDeclaration} from "./type";
import {processElementType} from "./processElementType";
import {mergeError} from "./mergeError";

export function processElementTypeToDeclaration(element: XsdElement | XsdElement[]): TypeDeclaration[] {
  try {
    if (Array.isArray(element)) {
      let result: TypeDeclaration[] = [];
      element.forEach(subElement => {
        result.push(...processElementTypeToDeclaration(subElement));
      })
      return result;
    }

    if (!element) {
      return [];
    }
    let types: Type[] = processElementType(element);
    return types.map(type => {
      return {
        name: element.name,
        type: "element",
        value: type
      } as TypeDeclaration;
    });
  } catch (e) {
    throw mergeError(e, new Error(`processElementTypeToDeclaration failed for ${JSON.stringify(element, null, 2)}`));
  }
}