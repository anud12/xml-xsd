import {Middleware} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";
import {JsonUtil} from "../utils/util";


type RuleGroupQueryType = JsonSchema["children"]["rule_group"]
type EventQueryType = RuleGroupQueryType["children"]["events_rule"]["children"]["entry"];
type ThenQueryType = EventQueryType["children"]["then"]


type Origin = {
  thenList: ThenQueryType[]
  self: { $x: string, $y: string },
  target: { $x: string, $y: string },
}

const applyFromPersonActionUsed = (readJson: JsonUtil, event: EventQueryType): Origin[] => {
  const personActionUsedTypeList = event.queryAll("when")
    .flatMap(when => when.queryAllOptional("person_action_used"))
    .flatMap(person_action_used => person_action_used.attributeMap.action_rule_ref);
  const byList = readJson.json.queryAll("actions").flatMap(action => action.queryAllOptional("by"));

  return byList.filter(by => personActionUsedTypeList.includes(by.queryOptional("do")?.attributeMap.action_rule_ref))
    .flatMap(by => {
      if(!by.queryOptional("do")?.attributeMap.action_rule_ref) {
        return [];
      }
      const self = readJson.person.getById(by.attributeMap.person_rule_ref);
      const selfLocation = self.query("location");
      const target = readJson.person.getById(by.queryOptional("do").attributeMap.action_rule_ref)
      const targetLocation = target.query("location");

      return {
        thenList: event.queryAllOptional("then"),
        self: {
          $x: selfLocation.attributeMap.x,
          $y: selfLocation.attributeMap.y,
        },
        target: {
          $x: targetLocation.attributeMap.x,
          $y: targetLocation.attributeMap.y,
        }
      }
    });
}


const thenCreatePerson = (readJson: JsonUtil, origin: Origin): Array<(util: JsonUtil) => void> => {
  const thenList = origin.thenList;

  return thenList.flatMap(then => {
    const radiusElement = then.query("at").query("radius");
    const radiusResult = readJson.computeOperationFromParent(radiusElement, string => string);
    const radius = Number(radiusResult)

    const originElement = then.query("at").attributeMap.origin === "self"
      ? origin.self
      : origin.target

    return then.queryAllOptional("create_person")
      .map(create_person =>
        (util: JsonUtil) => {
          const race = create_person.queryOptional("race")?.attributeMap.race_rule_ref;
          const x = String(Math.floor(readJson.random() * radius * 2) - radius + Number(originElement.$x));
          const y = String(Math.floor(readJson.random() * radius * 2) - radius + Number(originElement.$y));

          const itemList = create_person.queryAllOptional("inventory")
          .flatMap(inventory => inventory.queryAllOptional("item"))
          .flatMap(item => {
            const item_ref = item.attributeMap.item_rule_ref;
            const quantity = readJson.computeOperationFromParent(item.queryOptional("quantity"), string => string);
            return {
              item_rule_ref: item_ref,
              quantity: String(Math.floor(Number(quantity))),
            }

          })
          util.person.create({
            race: race,
            location: {
              x: x,
              y: y
            },
            items: itemList,
          })
        }
      )
  })
}

export const eventsMetadata: Middleware = readJson => {
  const ruleGroup = readJson.json.query("rule_group");
  const eventsMetadata = ruleGroup.queryAll("events_rule").flatMap(e => e.queryAll("entry"));
  const originList = eventsMetadata.flatMap(event => applyFromPersonActionUsed(readJson, event));
  const actions = originList.flatMap(origin => thenCreatePerson(readJson, origin));

  return async writeJson => {
    actions.forEach(action => action(writeJson));
  }
}