import {JsonSchema} from "./JsonSchema";
import {JsonUtil} from "./util";
import {JsonQueryType} from "../JsonQueryType";

type NameTokenQueryType = JsonSchema["children"]["rule_group"]["children"]["name_metadata"]["children"]["entry"]["children"]["name_token"]
type Children = NameTokenQueryType["childrenList"][number]

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

const calculateChildren = (readJson: JsonUtil, child?: Children): string | undefined => {

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
    return calculateNameFromRefString(readJson, child.attributeMap.name_ref);
  }

  throw new Error(`Unknown child type ${(child as any).tag}`);
}
export const calculateNameFromRefString = (readJson: JsonUtil, ref: string): string | undefined => {
  try {
    if (!ref) {
      return undefined;
    }
    const nameMetadataList = readJson.getRuleGroups()
      .flatMap(ruleGroup => ruleGroup.queryAllOptional("name_metadata"))
      .flatMap(e => e.queryAll("entry"));

    const entry = nameMetadataList.find(e => e.attributeMap.name === ref);

    if (!entry) {
      throw new Error(`Unknown name_ref ${ref}`);
    }

    const tokenBuffer = entry.childrenList.flatMap(token => {
      return calculateNameToken(readJson, token)
    });

    return tokenBuffer.join("")
  } catch (e: any) {
    const newError = new Error(`calculateNameFromRefString failed for ${ref}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }

}