import {JsonSchema} from "../JsonSchema";
import {JsonUtil} from "../util";
import {mergeError} from "../../mergeError";

type RuleGroupQueryType = JsonSchema["children"]["rule_group"]
type RaceQueryType = RuleGroupQueryType["children"]["race_rule"]["children"]["entry"]
type Bonus = RaceQueryType["children"]["property_bonus"]

export const getBaseProperty = (readJson: JsonUtil, personQueryType: PersonQueryType, key: string): string | undefined => {

  try {
    console.log(`getBaseProperty '${key}' for ${personQueryType.attributeMap.id} `)
    const propertyRuleEntries = readJson.getRuleGroups()
      .flatMap(rulesGroup => {
        return rulesGroup.queryAllOptional("property_rule")
      })
      .flatMap(propertyRule => propertyRule.queryAllOptional("entry"))

    const personDefaultElement = propertyRuleEntries
      .find(entryElement => entryElement?.attributeMap?.id === key)
      ?.queryOptional("person_default");

    if(!personDefaultElement) {
      console.log(`getBaseProperty '${key}' for ${personQueryType.attributeMap.id} is 'undefined'`)
      return
    }
    const value = readJson.computeOperationFromParent(personDefaultElement, string => getPersonProperty(readJson, personQueryType, string));
    console.log(`getBaseProperty '${key}' for ${personQueryType.attributeMap.id} is '${value}'`)
    return value;

  } catch (e: any) {
    throw mergeError(e, new Error(`getBaseProperty of ${key}`));
  }
}

export const getRaceProperty = (readJson: JsonUtil, personQueryType: PersonQueryType, raceQueryType: RaceQueryType, key: string): string | undefined => {

  console.log(`getRaceProperty for race '${raceQueryType.attributeMap.id}' and key '${key}' for ${personQueryType.attributeMap.id} `)
  const propertyBonus: Bonus = raceQueryType.queryAllOptional("property_bonus")
    .find(e => e.attributeMap.property_rule_ref === key);
  if (!propertyBonus) {
    console.log(`getRaceProperty for race '${raceQueryType.attributeMap.id}' and key '${key}' for ${personQueryType.attributeMap.id} is 'undefined'`)
    return undefined;
  }
  const base = getBaseProperty(readJson, personQueryType, key) ?? "0";

  const value = propertyBonus.queryAll("operation")
    .flatMap(e => e.childrenList)
    .map(e => readJson.computeOperation(e, string => getPersonProperty(readJson, personQueryType, string)))
    .reduce((acc, p) => p(acc), base);

  console.log(`getRaceProperty for race '${raceQueryType.attributeMap.id}' and key '${key}' for ${personQueryType.attributeMap.id} is '${value}'`)
  return value;

}

export type PersonQueryType = JsonSchema["children"]["people"]["children"]["person"]

export const getPersonProperty = (readJson: JsonUtil, personQueryType: PersonQueryType, key: string): string | undefined => {
  try {
    console.log(`getProperty key:'${key}' for personId: '${personQueryType.attributeMap.id}'`)
    const ruleGroup = readJson.json.query("rule_group");
    let propertyList = personQueryType.queryAllOptional("properties");
    if (propertyList.length === 0) {
      personQueryType.appendChild("properties")
      propertyList = personQueryType.queryAll("properties");
    }
    const property = propertyList
      .flatMap(e => e.queryAllOptional("property"))
      .find(e => e.attributeMap.property_rule_ref === key);
    if (property) {
      return property.attributeMap.value;
    }

    const raceMetadata = ruleGroup.queryAllOptional("race_rule")
      .flatMap(e => e.queryAll("entry"))
      .find(e => e.attributeMap.id === personQueryType.queryOptional("race")?.attributeMap.race_rule_ref);

    let value = undefined;
    if (raceMetadata) {
      value = getRaceProperty(readJson, personQueryType, raceMetadata, key);
    }
    if (!value) {
      value = getBaseProperty(readJson, personQueryType, key)
    }
    if(!value) {
      console.log(`getProperty key:'${key}' for personId: '${personQueryType.attributeMap.id}' is undefined`)
      return;
    }
    propertyList.forEach(e => {
      e.appendChild("property", undefined, {
        property_rule_ref: key,
        value: value
      })
    })
    console.log(`getProperty key:'${key}' for personId: '${personQueryType.attributeMap.id}' is '${value}'`)
    return value;
  } catch (e: any) {
    throw mergeError(e, new Error(`getProperty of ${key} failed for ${personQueryType.getPath()}`));
  }

}