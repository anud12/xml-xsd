import {XsdElement} from "./src";
import {TypeRecursive} from "./type";
import {processElementTypeToDeclaration} from "./processElementTypeToDeclaration";

export function processSequenceType(element: XsdElement | XsdElement[]): TypeRecursive[] {
  if (Array.isArray(element)) {
    let result: TypeRecursive[] = [];
    element.forEach(subElement => {
      result.push(...processSequenceType(subElement));
    })
    return result;
  }

  let types: TypeRecursive[] = [];

  if (element["xs:element"]) {
    const type: TypeRecursive = processElementTypeToDeclaration(element["xs:element"])
      .reduce((acc, value) => ({
        metaType: "recursive",
        value: {
          ...acc.value,
          [value.name]: value.value,
        }
      }), {
        metaType: "recursive",
        value: {}
      } as TypeRecursive);
    return [type];
  }
  return types;
}