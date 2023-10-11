import {Unit} from "../middleware";
import {JsonSchema} from "../JsonSchema";
import {nodeBodyType} from "../../JSONQuery";


type RaceQueryType = JsonSchema[typeof nodeBodyType]["race_metadata"][typeof nodeBodyType]["entry"]
type Bonus = RaceQueryType[typeof nodeBodyType]["property_bonus"]
export const getRaceProperty = (readJson: Unit, raceQueryType: RaceQueryType, key: string) => {
  const base = readJson.json.queryAll("property_metadata")
    .flatMap(e => e.queryAll("entry"))
    .flatMap(e => e.queryAll("default"))
    .flatMap(e => e.queryAll("operation"))
    .flatMap(e => e.children)
    .map(e => readJson.util.computeOperation(e))
    .reduce((previousValue, currentValue) => currentValue(previousValue), "0")


  const propertyBonus: Bonus = raceQueryType.queryAll("property_bonus")
    .find(e => e.$ref === key);
  if(!propertyBonus) {
    return base;
  }
  return propertyBonus.queryAll("operation")
    .flatMap(e => e.children)
    .map(e => readJson.util.computeOperation(e))
    .reduce((acc, p) => p(acc), base);

}

type PersonQueryType = JsonSchema[typeof nodeBodyType]["people"][typeof nodeBodyType]["person"]
export const getProperty = (readJson: Unit, personQueryType: PersonQueryType, key: string) => {
  const propertyList = personQueryType.queryAll("properties");
  const property = propertyList
    .flatMap(e => e.queryAll("property"))
    .find(e => e.$ref === key);
  if (property) {
    return property.$value;
  }

  const raceMetadata = readJson.json.queryAll("race_metadata")
    .flatMap(e => e.queryAll("entry"))
    .find(e => e.$name === personQueryType.query("race").$name);
  const value = getRaceProperty(readJson, raceMetadata, key);

  propertyList.forEach(e => {
    e.appendChild("property", {
      $ref: key,
      $value: value
    })
  })
  return value;
}