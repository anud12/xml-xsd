import {XsdElement} from "./src";
import {Type, typeDeclarationsToRecursive} from "./type";
import {processElementTypeToDeclaration} from "./processElementTypeToDeclaration";
import {processGroup} from "./processGroup";
import {mergeError} from "./mergeError";
import {processAny} from "./processAny";

export function processSequenceType(element: XsdElement | XsdElement[]): Type[] {
  try {
    if (Array.isArray(element)) {
      let result: Type[] = [];
      element.forEach(subElement => {
        result.push(...processSequenceType(subElement));
      })
      return result;
    }

    let types: Type[] = [];
    if(element["xs:any"] !== undefined) {
      return processAny(element["xs:any"]);
    }
    if (element["xs:element"] !== undefined) {
      const type = typeDeclarationsToRecursive(...processElementTypeToDeclaration(element["xs:element"]));

      types.push(type);
    }
    if (element["xs:group"] !== undefined) {
      types.push(...processGroup(element["xs:group"]));
    }
    return types;
  } catch (e) {
    throw mergeError(e, new Error(`processSequenceType failed for ${JSON.stringify(element, null, 2)}`));
  }
}