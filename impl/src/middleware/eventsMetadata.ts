import {Middleware, Unit} from "./_type";
import {nodeBodyType} from "../JSONQuery";
import {JsonSchema} from "../utils/JsonSchema";
import {JsonUtil} from "../utils";


type RuleGroupQueryType = JsonSchema[typeof nodeBodyType]["rule_group"]
type EventQueryType = RuleGroupQueryType[typeof nodeBodyType]["events_metadata"][typeof nodeBodyType]["entry"];
type ThenQueryType = EventQueryType[typeof nodeBodyType]["then"]


type Origin = {
  thenList: ThenQueryType[]
  self: { $x: string, $y: string },
  target: { $x: string, $y: string },
}

const applyFromPersonActionUsed = (readJson: Unit, event: EventQueryType): Origin[] => {
  const personActionUsedTypeList = event.queryAll("when")
    .flatMap(when => when.queryAllOptional("person_action_used"))
    .flatMap(person_action_used => person_action_used.$action_ref);
  const byList = readJson.json.queryAll("actions").flatMap(action => action.queryAllOptional("by"));

  return byList.filter(by => personActionUsedTypeList.includes(by.queryOptional("do")?.$action_ref))
    .flatMap(by => {
      if(!by.queryOptional("do")?.$action_ref) {
        return [];
      }
      const self = readJson.util.person.getById(by.$person);
      const selfLocation = self.query("location");
      const target = readJson.util.person.getById(by.queryOptional("do").$to)
      const targetLocation = target.query("location");

      return {
        thenList: event.queryAllOptional("then"),
        self: {
          $x: selfLocation.$x,
          $y: selfLocation.$y,
        },
        target: {
          $x: targetLocation.$x,
          $y: targetLocation.$y,
        }
      }
    });
}


const thenCreatePerson = (readJson: Unit, origin: Origin): Array<(util: JsonUtil) => void> => {
  const thenList = origin.thenList;

  return thenList.flatMap(then => {
    const radiusElement = then.query("at").query("radius");
    const radiusOperation = readJson.util.computeOperationFromParent(radiusElement, string => string);
    const radius = Number(radiusOperation("0"))

    const originElement = then.query("at").$origin === "self"
      ? origin.self
      : origin.target

    return then.queryAllOptional("create_person")
      .map(create_person =>
        (util: JsonUtil) => {
          const race = create_person.queryOptional("race")?.$race_ref;
          const x = String(Math.floor(readJson.util.random() * radius * 2) - radius + Number(originElement.$x));
          const y = String(Math.floor(readJson.util.random() * radius * 2) - radius + Number(originElement.$y));
          util.person.create({
            race: race,
            location: {
              $x: x,
              $y: y
            }
          })
        }
      )
  })
}

export const eventsMetadata: Middleware = readJson => {
  const ruleGroup = readJson.json.query("rule_group");
  const originList = applyFromPersonActionUsed(readJson, ruleGroup.query("events_metadata").query("entry"));
  const actions = originList.flatMap(origin => thenCreatePerson(readJson, origin));

  return async writeJson => {
    const writeJsonUtil = new JsonUtil(writeJson);
    actions.forEach(action => action(writeJsonUtil));
  }
}