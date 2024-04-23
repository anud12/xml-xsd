import {JsonSchema} from "./JsonSchema";
import {JsonUtil} from "./util";
import {JsonQueryType} from "../JsonQueryType";
import {mergeError} from "../mergeError";

export type NameRuleEntryQueryType = JsonSchema["children"]["rule_group"]["children"]["name_rule"]["children"]["entry"]
export type NameTokenQueryType = NameRuleEntryQueryType["children"]["name_token"]
export type NameTokenQueryTypeChild = NameTokenQueryType["childrenList"][number]

const calculateNameToken = (readJson: JsonUtil, tokenQueryType?: JsonQueryType<any, any,any>): string | undefined => {

  const nameTokenQueryType = tokenQueryType as NameTokenQueryType;

  if (!nameTokenQueryType) {
    return undefined;
  }
  const prefix = nameTokenQueryType.attributeMap.prefix;
  const value = nameTokenQueryType.childrenList.map(child => calculateChildren(readJson, child))
    .join("")
  return [prefix, value].join("");
}

const calculateChildren = (readJson: JsonUtil, child?: NameTokenQueryTypeChild): string | undefined => {

  if (!child?.tag) {
    return undefined;
  }
  if (child.tag === "one_of") {
    const element = readJson.randomFromArray(child.childrenList);
    const tokenBuffer = element.childrenList.flatMap(token => {
      const prefix = token.attributeMap.prefix;
      const value = token.childrenList.map(child => calculateNameToken(readJson, child))
        .join("")
      return [prefix, value];
    });

    return [element.attributeMap.prefix, ...tokenBuffer].join("");
  }
  if (child.tag === "ref") {
    return calculateNameFromRefString(readJson, child.attributeMap.name_rule_ref);
  }

  throw new Error(`Unknown child type ${(child as any).tag}`);
}

export const calculateNameFromChildren = (readJson: JsonUtil, element: NameRuleEntryQueryType) => {
  const tokenBuffer = element.childrenList.flatMap(token => {
    return calculateNameToken(readJson, token)
  });

  return tokenBuffer.join("")

}
export const calculateNameFromRefString = (readJson: JsonUtil, ref: string): string | undefined => {
  try {
    if (!ref) {
      return undefined;
    }
    const nameMetadataList = readJson.getRuleGroups()
      .flatMap(ruleGroup => ruleGroup.queryAllOptional("name_rule"))
      .flatMap(e => e.queryAll("entry"));

    const entry = nameMetadataList.find(e => e.attributeMap.id === ref);

    if (!entry) {
      throw new Error(`Unknown name_ref ${ref}`);
    }

    return calculateNameFromChildren(readJson, entry);
  } catch (e: any) {
    throw mergeError(e, new Error(`calculateNameFromRefString failed for ${ref}`));
  }

}