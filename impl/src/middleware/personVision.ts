import {Middleware} from "./_type";
import {fillNeighbours} from "../utils/location/fillNeighbours";

export const personVision: Middleware = (readJson) => {
  try {
    const persons = readJson.json.query("people").queryAll("person");
    const ruleGroup = readJson.getRuleGroups();
    persons.map(e => {
      const location = e.query("location");

      const {$x, $y} = location;
      const race = e.query("race").$race_ref;

      const raceMetadata = ruleGroup.flatMap(ruleGroup => {
        return ruleGroup.queryOptional("race_metadata")
          .queryAll("entry")

      })
      const radius = raceMetadata.find(e => e.$name === race)
        .queryOptional("vision");

      readJson.location.create(Number($x), Number($y));
      fillNeighbours(readJson, readJson, readJson.location.grid()[Number($x)][Number($y)], Number(radius.$value));
    })

    return async () => {
    }
  } catch (e) {
    const newError = new Error("Error in personVision middleware");
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }

}