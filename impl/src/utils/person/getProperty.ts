import {JsonSchema} from "../JsonSchema";
import {nodeBodyType} from "../../JSONQuery";
import {JsonUtil} from "../util";

type RuleGroupQueryType = JsonSchema[typeof nodeBodyType]["rule_group"]
type RaceQueryType = RuleGroupQueryType[typeof nodeBodyType]["race_metadata"][typeof nodeBodyType]["entry"]
type Bonus = RaceQueryType[typeof nodeBodyType]["property_bonus"]

export const getBaseProperty = (readJson: JsonUtil, personQueryType: PersonQueryType, key: string):string =>  {
  try {
    const ruleGroup = readJson.json.query("rule_group");
    return ruleGroup.queryAll("property_metadata")
      .flatMap(e => e.queryAll("entry"))
      .filter(value => value.$name === key)
      .flatMap(e => e.queryAll("default"))
      .flatMap(e => e.queryAll("operation"))
      .flatMap(e => e.children)
      .map(e => readJson.computeOperation(e, string => getProperty(readJson, personQueryType, string)))
      .reduce((previousValue, currentValue) => currentValue(previousValue), "0");
  } catch (e:any)  {
    const newError = new Error(`getBaseProperty of ${key}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }
}

export const getRaceProperty = (readJson: JsonUtil, personQueryType: PersonQueryType, raceQueryType: RaceQueryType, key: string):string => {
  const base = getBaseProperty(readJson, personQueryType, key);
  const propertyBonus: Bonus = raceQueryType.queryAllOptional("property_bonus")
    .find(e => e.$property_ref === key);
  if (!propertyBonus) {
    return base;
  }
  return propertyBonus.queryAll("operation")
    .flatMap(e => e.children)
    .map(e => readJson.computeOperation(e, string => getProperty(readJson, personQueryType, string)))
    .reduce((acc, p) => p(acc), base);

}

export type PersonQueryType = JsonSchema[typeof nodeBodyType]["people"][typeof nodeBodyType]["person"]
export const getProperty = (readJson: JsonUtil, personQueryType: PersonQueryType, key: string):string => {
  try {
    const ruleGroup = readJson.json.query("rule_group");
    let propertyList = personQueryType.queryAllOptional("properties");
    if (propertyList.length === 0) {
      personQueryType.appendChild("properties", {})
      propertyList = personQueryType.queryAll("properties");
    }
    const property = propertyList
      .flatMap(e => e.queryAllOptional("property"))
      .find(e => e.$property_ref === key);
    if (property) {
      return property.$value;
    }

    const raceMetadata = ruleGroup.queryAll("race_metadata")
      .flatMap(e => e.queryAll("entry"))
      .find(e => e.$name === personQueryType.query("race").$race_ref);

    const value = getRaceProperty(readJson, personQueryType, raceMetadata, key);

    propertyList.forEach(e => {
      e.appendChild("property", {
        $property_ref: key,
        $value: value
      })
    })
    return value;
  } catch (e:any)  {
    const newError = new Error(`getProperty of ${key} failed for ${personQueryType.getPath()}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }

}