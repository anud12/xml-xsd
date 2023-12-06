import {Middleware} from "./_type";
import {nodeBodyType} from "../JSONQuery";
import {JsonSchema} from "../utils/JsonSchema";
import {JsonUtil} from "../utils/util";


type RuleGroupQueryType = JsonSchema[typeof nodeBodyType]["rule_group"]
type EventQueryType = RuleGroupQueryType[typeof nodeBodyType]["events_metadata"][typeof nodeBodyType]["entry"];
type ThenQueryType = EventQueryType[typeof nodeBodyType]["then"]


type Origin = {
  thenList: ThenQueryType[]
  self: { $x: string, $y: string },
  target: { $x: string, $y: string },
}

const applyFromPersonActionUsed = (readJson: JsonUtil, event: EventQueryType): Origin[] => {
  const personActionUsedTypeList = event.queryAll("when")
    .flatMap(when => when.queryAllOptional("person_action_used"))
    .flatMap(person_action_used => person_action_used.$action_ref);
  const byList = readJson.json.queryAll("actions").flatMap(action => action.queryAllOptional("by"));

  return byList.filter(by => personActionUsedTypeList.includes(by.queryOptional("do")?.$action_ref))
    .flatMap(by => {
      if(!by.queryOptional("do")?.$action_ref) {
        return [];
      }
      const self = readJson.person.getById(by.$person_ref);
      const selfLocation = self.query("location");
      const target = readJson.person.getById(by.queryOptional("do").$person_ref)
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


const thenCreatePerson = (readJson: JsonUtil, origin: Origin): Array<(util: JsonUtil) => void> => {
  const thenList = origin.thenList;

  return thenList.flatMap(then => {
    const radiusElement = then.query("at").query("radius");
    const radiusOperation = readJson.computeOperationFromParent(radiusElement, string => string);
    const radius = Number(radiusOperation("0"))

    const originElement = then.query("at").$origin === "self"
      ? origin.self
      : origin.target

    return then.queryAllOptional("create_person")
      .map(create_person =>
        (util: JsonUtil) => {
          const race = create_person.queryOptional("race")?.$race_ref;
          const x = String(Math.floor(readJson.random() * radius * 2) - radius + Number(originElement.$x));
          const y = String(Math.floor(readJson.random() * radius * 2) - radius + Number(originElement.$y));

          const itemList = create_person.queryAllOptional("inventory")
          .flatMap(inventory => inventory.queryAllOptional("item"))
          .flatMap(item => {
            const item_ref = item.$item_ref;
            const quantity = readJson.computeOperationFromParent(item.queryOptional("quantity"), string => string)("0");
            return {
              $item_ref: item_ref,
              $quantity: String(Math.floor(Number(quantity))),
            }

          })
          util.person.create({
            race: race,
            location: {
              $x: x,
              $y: y
            },
            items: itemList,
          })
        }
      )
  })
}

export const eventsMetadata: Middleware = readJson => {
  const ruleGroup = readJson.json.query("rule_group");
  const eventsMetadata = ruleGroup.queryAll("events_metadata").flatMap(e => e.queryAll("entry"));
  const originList = eventsMetadata.flatMap(event => applyFromPersonActionUsed(readJson, event));
  const actions = originList.flatMap(origin => thenCreatePerson(readJson, origin));

  return async writeJson => {
    actions.forEach(action => action(writeJson));
  }
}