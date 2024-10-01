import {Type, TypeDeclaration} from "./type";
import {XsdElement} from "./src";
import {processRestriction} from "./processRestriction";
import {mergeError} from "./mergeError";

export function processSimpleTypeToDeclaration(element: XsdElement | XsdElement[]): TypeDeclaration[] {
  try {
    if (Array.isArray(element)) {
      let result: TypeDeclaration[] = [];
      element.forEach(subElement => {
        result.push(...processSimpleTypeToDeclaration(subElement));
      })
      return result;
    }
    if (!element) {
      return []
    }


    const use = element.use ?? "optional";
    const isNullable = use === "optional";

    let type: Type = {
      metaType: "primitive",
      value: "unknown",
      isNullable: isNullable,
    };
    if (element.type) {
      type = {
        metaType: "primitive",
        value: element.type,
        isNullable: isNullable,
      };
    }
    if (element["xs:restriction"] !== undefined) {
      type = processRestriction(element["xs:restriction"])[0];
    }
    return [{
      name: element.name,
      type: "simple",
      value: type,
      isNullable: isNullable,
    }];
  } catch (e) {
    throw mergeError(e, new Error(`processSimpleTypeToDeclaration failed for ${JSON.stringify(element, null, 2)}`));
  }
}