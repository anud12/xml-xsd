import {Type, TypeDeclaration} from "./type";
import {XsdElement} from "./src";
import {mapXsdTypeToTs} from "./mapXsdType";
import {processRestriction} from "./processRestriction";

export function processSimpleTypeToDeclaration(element: XsdElement | XsdElement[]): TypeDeclaration[] {
  if (Array.isArray(element)) {
    let result: TypeDeclaration[] = [];
    element.forEach(subElement => {
      result.push(...processSimpleTypeToDeclaration(subElement));
    })
    return result;
  }
  if(!element) {
    return []
  }
  let type: Type = {
    metaType: "primitive",
    value: "unknown"
  };
  if (element.type) {
    type = mapXsdTypeToTs(element.type);
  }
  if (element["xs:restriction"]) {
    type = processRestriction(element["xs:restriction"])[0];
  }
  return [{
    name: element.name,
    value: type
  }];
}