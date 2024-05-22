import {XsdElement} from "./src";
import {processComplexType} from "./processComplexType";
import {Type, TypeDeclaration} from "./type";

export function processComplexTypeToDeclaration(element: XsdElement | XsdElement[], ident:string = ""): TypeDeclaration[] {
  if(Array.isArray(element)) {
    let result: TypeDeclaration[] = [];
    element.forEach(subElement => {
      result.push(...processComplexTypeToDeclaration(subElement));
    })
    return result;
  }
  if(!element) {
    return []
  }

  let types: Type[] = processComplexType(element);
  return types.map(type => {
    return {
      name: `${ident}${element?.name}`,
      value: type
    } as TypeDeclaration;
  });
}