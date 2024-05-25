import {Type, TypeDeclaration, TypePrimitive} from "./type";
import { XsdElement } from "./src";
import {mapXsdTypeToTs} from "./mapXsdType";
import {processSimpleTypeToDeclaration} from "./processSimpleTypeToDeclaration";
import {mergeError} from "./mergeError";

export function processTypeAttribute(elements: XsdElement[] | XsdElement): TypeDeclaration[] {
  try {
    if(Array.isArray(elements)) {
      let result: TypeDeclaration[] = [];
      for (const subElement of elements) {
        result.push(...processTypeAttribute(subElement));
      }
      return result;
    }
    if(!elements.name) {
      return [];
    }

    if(elements.type) {
      let type: Type = mapXsdTypeToTs(elements.type);
      return [{
        value:type,
        name: elements.name,
      }];
    }
    if(elements["xs:simpleType"]) {
      const type = processSimpleTypeToDeclaration(elements["xs:simpleType"]);
      return  type.map(t => ({
        value: t.value,
        name: elements.name,
      }));
    }

    return []
  } catch (e) {
    throw mergeError(e, new Error(`processTypeAttribute failed for ${JSON.stringify(elements, null, 2)}`));
  }

}