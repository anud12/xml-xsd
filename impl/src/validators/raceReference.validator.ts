import {ValidationError, Validator} from "./_type";
import {nodeBodyType} from "../JSONQuery";
import {JsonSchema} from "../utils/JsonSchema";

type RaceQueryType = JsonSchema[typeof nodeBodyType]["people"][typeof nodeBodyType]["person"][typeof nodeBodyType]["race"]

export class RaceReferenceValidationError extends ValidationError<RaceQueryType> {

  constructor(public jsonQuery: RaceQueryType, expectedValues: string[]) {
    const message = `RaceReferenceValidationError: ${jsonQuery.$name} at ${jsonQuery.getPath()}@name not in [${expectedValues.join(", ")}]`
    super(jsonQuery, "$name", message);
  }
}

export const raceReferenceValidator: Validator<RaceReferenceValidationError> = async (jsonSchema) => {
  const ruleGroup = jsonSchema.query("rule_group");
  const raceMetadata = ruleGroup.queryAll("race_metadata");
  const raceMetadataNames = raceMetadata.flatMap(e => e.queryAll("entry").map(e => e.$name));

  const raceQueryElement = jsonSchema.queryOptional("people")
    .queryOptional("person")
    .queryOptional("race");


  return jsonSchema.queryAllRecursiveLike(raceQueryElement)
    .filter((race) => !raceMetadataNames.includes(race.$name))
    .map(race => new RaceReferenceValidationError(race, raceMetadataNames));
}