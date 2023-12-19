import {Middleware} from "./_type";
import {fillNeighbours} from "../utils/location/fillNeighbours";

export const personVision: Middleware = (readJson) => {
  try {
    const persons = readJson.json.query("people").queryAll("person");
    const ruleGroup = readJson.getRuleGroups();
    persons.map(e => {
      const location = e.query("location");

      const x = location.getAttribute("x");
      const y= location.getAttribute("y");
      const race = e.query("race").getAttribute("race_ref");

      const raceMetadata = ruleGroup.flatMap(ruleGroup => {
        return ruleGroup.queryOptional("race_metadata")
          .queryAll("entry")

      })
      const radius = raceMetadata.find(e => e.getAttribute("name") === race)
        .queryOptional("vision");

      readJson.location.create(Number(x), Number(y));
      fillNeighbours(readJson, readJson, readJson.location.grid()[Number(x)][Number(y)], Number(radius.getAttribute("value")));
    })

    return async () => {
    }
  } catch (e:any)  {
    const newError = new Error("Error in personVision middleware");
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }

}