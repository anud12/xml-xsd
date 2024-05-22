import {XsdElement} from "./src";
import {Type, TypeDeclaration} from "./type";
import {processElementType} from "./processElementType";

export function processElementTypeToDeclaration(element: XsdElement | XsdElement[], ident: string = ""): TypeDeclaration[] {
  if (Array.isArray(element)) {
    let result: TypeDeclaration[] = [];
    element.forEach(subElement => {
      result.push(...processElementTypeToDeclaration(subElement));
    })
    return result;
  }

  let types: Type[] = processElementType(element);
  return types.map(type => {
    return {
      name: element.name,
      value: type
    } as TypeDeclaration;
  });
}