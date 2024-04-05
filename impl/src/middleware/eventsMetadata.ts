import {EventMiddleware} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";
import {JsonUtil} from "../utils/util";
import {Dispatcher} from "../utils/triggerDispatcher/dispatcher";


type RuleGroupQueryType = JsonSchema["children"]["rule_group"]
type EventQueryType = RuleGroupQueryType["children"]["events_rule"]["children"]["entry"];

const applyFromPersonActionUsed = (readJson: JsonUtil,  event: EventQueryType): ((dispatcher:Dispatcher) => Promise<void>)[] => {

  return  event.queryAllOptional("when")
    .flatMap(whenElement => whenElement.queryAllOptional("person_action_used"))
    .flatMap(personActionUsedElement => {
      return event.queryAllOptional("then")
        .flatMap(thenElement => {
        return thenElement.queryAllOptional("select_person").flatMap(selectPersonElement => {
          return async (dispatcher:Dispatcher) => {
            dispatcher.personActionUsedDispatcher.on(personActionUsedElement, async data => {
              const originElement = selectPersonElement.attributeMap.origin === "self"
                ? data.writeJson.person.getById(data.byElement.attributeMap.person_ref)
                : data.writeJson.person.getById(data.doElement.attributeMap.person_ref)
              data.writeJson.person.selectPerson(selectPersonElement, {
                x: originElement.query("location").attributeMap.x,
                y: originElement.query("location").attributeMap.y
              });
            })
          }
        })
      });
    })
}
export const eventsMetadata: EventMiddleware = (readJson) => {
  const ruleGroup = readJson.json.query("rule_group");
  const eventsMetadata = ruleGroup.queryAll("events_rule").flatMap(e => e.queryAll("entry"));
  const listenerList = eventsMetadata.flatMap(event => applyFromPersonActionUsed(readJson, event));

  return async (dispatcher:Dispatcher) => {
    listenerList.forEach(e => e(dispatcher));
  }
}