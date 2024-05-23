import {XsdElement} from "./src";
import {Type, typeDeclarationsToRecursive} from "./type";
import {processElementTypeToDeclaration} from "./processElementTypeToDeclaration";
import {processGroup} from "./processGroup";

export function processSequenceType(element: XsdElement | XsdElement[]): Type[] {
  if (Array.isArray(element)) {
    let result: Type[] = [];
    element.forEach(subElement => {
      result.push(...processSequenceType(subElement));
    })
    return result;
  }

  let types: Type[] = [];

  if (element["xs:element"]) {
    const type = typeDeclarationsToRecursive(...processElementTypeToDeclaration(element["xs:element"]));
    return [type];
  }
  if (element["xs:group"]) {
    return processGroup(element["xs:group"]);
  }
  return types;
}