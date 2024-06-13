import {Type, TypeObject} from "./type";
import {XsdElement} from "./src";
import {processSimpleTypeToDeclaration} from "./processSimpleTypeToDeclaration";
import {mergeError} from "./mergeError";

export function processTypeAttribute(element: XsdElement[] | XsdElement): TypeObject[] {
  try {
    if (Array.isArray(element)) {
      let result: TypeObject[] = [];
      for (const subElement of element) {
        result.push(...processTypeAttribute(subElement));
      }
      return result;
    }
    if (!element.name) {
      return [];
    }

    if (element["xs:simpleType"]) {
      const typeDeclarations = processSimpleTypeToDeclaration(element["xs:simpleType"]);
      return [{
        metaType: "object",
        value: {
          [element.name]: typeDeclarations[0].value
        }
      }];
    }

    let type: Type = {
      metaType: "unknown",
    } satisfies Type;
    if (element.type) {
      type = {
        metaType:"primitive",
        value: element.type
      }
    }
    return [{
      metaType: "object",
      value: {
        [element.name]: type,
      }
    }];
  } catch (e) {
    throw mergeError(e, new Error(`processTypeAttribute failed for ${JSON.stringify(element, null, 2)}`));
  }

}