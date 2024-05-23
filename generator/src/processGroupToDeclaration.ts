import {TypeDeclaration} from "./type";
import {XsdElement} from "./src";
import {processComplexTypeToDeclaration} from "./processComplexTypeToDeclaration";
import {processGroup} from "./processGroup";

export function processGroupToDeclaration(element: XsdElement | XsdElement[]): TypeDeclaration[] {
  if (Array.isArray(element)) {
    let result: TypeDeclaration[] = [];
    element.forEach(subElement => {
      result.push(...processComplexTypeToDeclaration(subElement));
    })
    return result;
  }

  if(!element) {
    return []
  }

  return [{
    name: element.name,
    value: processGroup(element)[0]
  }]
}