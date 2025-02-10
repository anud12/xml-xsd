import {DependantType} from "../typeToString";
import {template} from "../../../template/template";
import {normalizeName} from "./normalizeName";

export const dependantTypeToChildrenSerializationBody = (dependantType: DependantType): string | undefined => {

  if (dependantType.value?.metaType !== "object") {
    return undefined;
  }


  return Object.entries(dependantType.value.value).map(([key, value]) => {
    if (value.metaType === "object" || value.metaType === "union" || value.metaType === "composition" || value.metaType === "reference") {

      if (value.isSingle) {
        return template()`
          if(${normalizeName(key)} != null) {
            rawNode.children["${key}"] = new List<RawNode> { ${normalizeName(key)}.SerializeIntoRawNode() };
          }
        `;

      }
      return template()`rawNode.children["${key}"] = _${normalizeName(key)}?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();`;
    }
  }).filter(e => e).join("\n")

}