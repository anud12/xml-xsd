import {Type, typeDeclarationsToRecursive, TypeObject} from "./type";
import {XsdElement} from "./src";
import {mapXsdTypeToTs} from "./mapXsdType";
import {processSimpleTypeToDeclaration} from "./processSimpleTypeToDeclaration";
import {mergeError} from "./mergeError";

export function processTypeAttribute(elements: XsdElement[] | XsdElement): TypeObject[] {
  try {
    if (Array.isArray(elements)) {
      let result: TypeObject[] = [];
      for (const subElement of elements) {
        result.push(...processTypeAttribute(subElement));
      }
      return result;
    }
    if (!elements.name) {
      return [];
    }

    if (elements.type) {
      let type: Type = mapXsdTypeToTs(elements.type);
      return [{
        metaType: "object",
        value: {
          [elements.name]: type,
        }
      }
      ];
    }
    if (elements["xs:simpleType"]) {
      const typeDeclarations = processSimpleTypeToDeclaration(elements["xs:simpleType"]);
      return [{
        metaType:"object",
        value: {
          [elements.name]: typeDeclarations[0].value
        }
      }];
    }

    return []
  } catch (e) {
    throw mergeError(e, new Error(`processTypeAttribute failed for ${JSON.stringify(elements, null, 2)}`));
  }

}