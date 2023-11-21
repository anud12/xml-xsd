import {Middleware, Unit} from "../utils/middleware";
import {nodeBodyType} from "../JSONQuery";
import {JsonSchema} from "../utils/JsonSchema";
import {JsonUtil} from "../utils";

type EventQueryType = JsonSchema[typeof nodeBodyType]["events_metadata"][typeof nodeBodyType]["entry"];
type ThenQueryType = EventQueryType[typeof nodeBodyType]["then"]


type Origin = {
  thenList: ThenQueryType[]
  self: { $x: string, $y: string },
  target: { $x: string, $y: string },
}

const applyFromPersonActionUsed = (readJson: Unit, event: EventQueryType): Origin[] => {
  const personActionUsedTypeList = event.queryAll("when")
    .flatMap(when => when.queryAllOptional("person_action_used"))
    .flatMap(person_action_used => person_action_used.$type);
  const byList = readJson.json.queryAll("actions").flatMap(action => action.queryAll("by"));

  return byList.filter(by => personActionUsedTypeList.includes(by.queryOptional("do")?.$action))
    .flatMap(by => {

      const self = readJson.util.person.getByName(by.$name);
      const selfLocation = self.query("location");
      const target = readJson.util.person.getByName(by.queryOptional("do").$to)
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
          const race = create_person.queryOptional("race")?.$name;
          const x = String(Math.floor(readJson.util.random() * radius * 2) - radius) + Number(originElement.$x);
          const y = String(Math.floor(readJson.util.random() * radius * 2) - radius) + Number(originElement.$y);
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
  const originList = applyFromPersonActionUsed(readJson, readJson.json.query("events_metadata").query("entry"));
  const actions = originList.flatMap(origin => thenCreatePerson(readJson, origin));

  return async writeJson => {
    const writeJsonUtil = new JsonUtil(writeJson);
    actions.forEach(action => action(writeJsonUtil));
  }
}