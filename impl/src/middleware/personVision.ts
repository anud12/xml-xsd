import {MutationMiddleware} from "./_type";
import {fillNeighbours} from "../utils/location/fillNeighbours";

export const personVision: MutationMiddleware = (readJson) => {
  try {
    const persons = readJson.json.queryOptional("people")?.queryAllOptional("person");
    const ruleGroup = readJson.getRuleGroups();
    persons?.forEach(e => {
      const location = e.queryOptional("location");
      if(!location) {
        return;
      }
      const x = location.attributeMap.x;
      const y= location.attributeMap.y;
      const race = e.queryOptional("race")?.attributeMap?.race_rule_ref;

      const raceMetadata = ruleGroup?.flatMap(ruleGroup => {
        return ruleGroup.queryOptional("race_rule")
          ?.queryAllOptional("entry")

      })
      const radius = raceMetadata.find(e => e?.attributeMap.id === race)
        ?.queryOptional("vision");
      if(!radius) {
        return;
      }
      readJson.location.create(Number(x), Number(y));
      // fillNeighbours(readJson, readJson, readJson.location.grid()[Number(x)][Number(y)], Number(radius.attributeMap.value));
    })

    return async () => {
    }
  } catch (e:any)  {
    const newError = new Error("Error in personVision middleware");
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }

}