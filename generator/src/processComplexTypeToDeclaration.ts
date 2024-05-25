import {XsdElement} from "./src";
import {processComplexType} from "./processComplexType";
import {Type, TypeDeclaration} from "./type";
import {mergeError} from "./mergeError";

export function processComplexTypeToDeclaration(element: XsdElement | XsdElement[]): TypeDeclaration[] {
  try {
    if (Array.isArray(element)) {
      let result: TypeDeclaration[] = [];
      element.forEach(subElement => {
        result.push(...processComplexTypeToDeclaration(subElement));
      })
      return result;
    }
    if (!element) {
      return []
    }

    let types: Type[] = processComplexType(element);
    return types.map(type => {
      return {
        name: element?.name,
        value: type
      } as TypeDeclaration;
    });
  } catch (e) {
    throw mergeError(e, new Error(`processComplexTypeToDeclaration failed for ${JSON.stringify(element, null, 2)}`))
  }
}