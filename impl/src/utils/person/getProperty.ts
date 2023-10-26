import {Unit} from "../middleware";
import {JsonSchema} from "../JsonSchema";
import {nodeBodyType} from "../../JSONQuery";


type RaceQueryType = JsonSchema[typeof nodeBodyType]["race_metadata"][typeof nodeBodyType]["entry"]
type Bonus = RaceQueryType[typeof nodeBodyType]["property_bonus"]

export const getBaseProperty = (readJson: Unit, personQueryType: PersonQueryType, key: string) =>  {
  try {
    return readJson.json.queryAll("property_metadata")
      .flatMap(e => e.queryAll("entry"))
      .filter(value => value.$name === key)
      .flatMap(e => e.queryAll("default"))
      .flatMap(e => e.queryAll("operation"))
      .flatMap(e => e.children)
      .map(e => readJson.util.computeOperation(e, string => getProperty(readJson, personQueryType, string)))
      .reduce((previousValue, currentValue) => currentValue(previousValue), "0");
  } catch (e) {
    const newError = new Error(`getBaseProperty of ${key}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }
}

export const getRaceProperty = (readJson: Unit, personQueryType: PersonQueryType, raceQueryType: RaceQueryType, key: string) => {
  const base = getBaseProperty(readJson, personQueryType, key);
  const propertyBonus: Bonus = raceQueryType.queryAllOptional("property_bonus")
    .find(e => e.$ref === key);
  if (!propertyBonus) {
    return base;
  }
  return propertyBonus.queryAll("operation")
    .flatMap(e => e.children)
    .map(e => readJson.util.computeOperation(e, string => getProperty(readJson, personQueryType, string)))
    .reduce((acc, p) => p(acc), base);

}

export type PersonQueryType = JsonSchema[typeof nodeBodyType]["people"][typeof nodeBodyType]["person"]
export const getProperty = (readJson: Unit, personQueryType: PersonQueryType, key: string) => {
  try {
    let propertyList = personQueryType.queryAllOptional("properties");
    if (propertyList.length === 0) {
      personQueryType.appendChild("properties", {})
      propertyList = personQueryType.queryAll("properties");
    }
    const property = propertyList
      .flatMap(e => e.queryAllOptional("property"))
      .find(e => e.$ref === key);
    if (property) {
      return property.$value;
    }

    const raceMetadata = readJson.json.queryAll("race_metadata")
      .flatMap(e => e.queryAll("entry"))
      .find(e => e.$name === personQueryType.query("race").$name);

    const value = getRaceProperty(readJson, personQueryType, raceMetadata, key);

    propertyList.forEach(e => {
      e.appendChild("property", {
        $ref: key,
        $value: value
      })
    })
    return value;
  } catch (e) {
    const newError = new Error(`getProperty of ${key} failed for ${personQueryType.getPath()}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }

}