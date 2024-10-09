import {JsonSchema} from "../JsonSchema";
import {JsonUtil} from "../util";
import {mergeError} from "../../mergeError";

export type PersonQueryType = JsonSchema["children"]["data"]["children"]["people"]["children"]["person"]

export const setProperty = (readJson: JsonUtil, personQueryType: PersonQueryType, key: string, value:string) => {
  try {
    let properties = personQueryType.queryOptional("properties");
    if (!properties) {
      properties = personQueryType.appendChild("properties");
    }
    let property = properties.queryAllOptional("property")
      .find(e => e.attributeMap.property_rule_ref === key);
    if(!property) {
      property = properties.appendChild("property", undefined, {
        property_rule_ref: key,
      })
    }
    property.attributeMap.value = value;
  } catch (e: any) {
    throw mergeError(e, new Error(`setProperty of ${key} failed for ${personQueryType.getPath()}`));
  }

}