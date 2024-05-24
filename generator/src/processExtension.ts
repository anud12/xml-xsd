import {Type, TypePrimitive} from "./type";
import {XsdElement} from "./src";
import {processComplexType} from "./processComplexType";

export function processExtension(element: XsdElement | XsdElement[]): Type[] {
  if (Array.isArray(element)) {
    let result: Type[] = [];
    element.forEach(subElement => {
      result.push(...processExtension(subElement));
    })
    return result;
  }
  let type = processComplexType(element);
  let primitiveType:TypePrimitive = {
    metaType:"primitive",
    value: element.base
  }
  return [{
    metaType:"composition",
    value: [...type, primitiveType]
  }]
}