import {Type, TypeDeclaration} from "./type";
import {XsdElement} from "./src";
import {processComplexType} from "./processComplexType";
import {processAttributeGroup} from "./processAttributeGroup";

export function processAttributeGroupToDeclaration(element: XsdElement | XsdElement[]): TypeDeclaration[] {
  if (Array.isArray(element)) {
    let result: TypeDeclaration[] = [];
    element.forEach(subElement => {
      result.push(...processAttributeGroupToDeclaration(subElement));
    })
    return result;
  }
  if(!element) {
    return []
  }

  let types: Type[] = processAttributeGroup(element);
  return types.map(type => {
    return {
      name: element?.name,
      value: type
    } as TypeDeclaration;
  });
}