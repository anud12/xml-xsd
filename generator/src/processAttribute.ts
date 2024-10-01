import {Type, TypeObject, TypeReference} from "./type";
import {XsdElement} from "./src";
import {processSimpleTypeToDeclaration} from "./processSimpleTypeToDeclaration";
import {mergeError} from "./mergeError";

export function processAttribute(element: XsdElement[] | XsdElement): (TypeObject| TypeReference)[] {
  try {
    if (Array.isArray(element)) {
      let result: (TypeObject| TypeReference)[] = [];
      for (const subElement of element) {
        result.push(...processAttribute(subElement));
      }
      return result;
    }

    const use = element.use ?? "optional";
    const isNullable = use === "optional";

    if(element.ref) {
      return [{
        metaType: "reference",
        value: element.ref,
        isNullable: isNullable,
      }];
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
      isNullable: isNullable,
    } satisfies Type;

    if (element.type) {
      type = {
        metaType:"primitive",
        value: element.type,
        isNullable: isNullable,
      }
    }
    return [{
      metaType: "object",
      value: {
        [element.name]: type,
      },
      isNullable: isNullable,
    }];
  } catch (e) {
    throw mergeError(e, new Error(`processTypeAttribute failed for ${JSON.stringify(element, null, 2)}`));
  }

}