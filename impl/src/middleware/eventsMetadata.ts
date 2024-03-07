import {Middleware} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";
import {JsonUtil} from "../utils/util";


type RuleGroupQueryType = JsonSchema["children"]["rule_group"]
type EventQueryType = RuleGroupQueryType["children"]["events_rule"]["children"]["entry"];
type ThenQueryType = EventQueryType["children"]["then"]


type Origin = {
  thenList: ThenQueryType[]
  self: { x: string, y: string },
  target: { x: string, y: string },
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
          x: selfLocation.attributeMap.x,
          y: selfLocation.attributeMap.y,
        },
        target: {
          x: targetLocation.attributeMap.x,
          y: targetLocation.attributeMap.y,
        }
      }
    });
}


const thenCreatePerson = (readJson: JsonUtil, origin: Origin): Array<(util: JsonUtil) => void> => {
  const thenList = origin.thenList;

  return thenList.flatMap(then => {
    return then.queryAllOptional("select_person")
      .map(select_person =>
        (util: JsonUtil) => {
        const originElement = select_person.attributeMap.origin === "self"
          ? origin.self
          : origin.target
          return util.person.selectPerson(select_person, originElement);
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