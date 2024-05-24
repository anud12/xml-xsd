import {
  Type,
  typeAddDeclarations, typeDeclarationsToRecursive,
  typeMerge,
  TypeRecursive,
  typeRecursiveAddDeclarations,
  typeRecursiveMerge
} from "./type";
import {XsdElement} from "./src";
import {processSequenceType} from "./processSequenceType";
import {mapXsdTypeToTs} from "./mapXsdType";
import {processTypeAttribute} from "./processTypeAttribute";
import {processAttributeGroup} from "./processAttributeGroup";

export function processComplexType(element: XsdElement | XsdElement[]): Type[] {
  if (Array.isArray(element)) {
    let result: Type[] = [];
    element.forEach(subElement => {
      result.push(...processComplexType(subElement));
    })
    return result;
  }

  if (element.type) {
    return [mapXsdTypeToTs(element.type)]
  }
  let type: Type = {
    metaType: "recursive",
    value: {}
  } as TypeRecursive;

  if (element["xs:sequence"]) {
    type = typeMerge(type, ...processSequenceType(element["xs:sequence"]));
  }
  if (element["xs:attributeGroup"]) {
    type = typeMerge(type, ...processAttributeGroup(element["xs:attributeGroup"]));
  }
  if (element["xs:attribute"]) {
    const attributeTypes = processTypeAttribute(element["xs:attribute"]);
    if(attributeTypes.length > 0) {
      type = typeMerge(type, typeDeclarationsToRecursive(...attributeTypes));
    }
  }
  return [type];
}