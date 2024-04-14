import {EventMiddleware} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";
import {Dispatcher} from "../utils/triggerDispatcher/dispatcher";


type RuleGroupQueryType = JsonSchema["children"]["rule_group"]
type EventQueryType = RuleGroupQueryType["children"]["events_rule"]["children"]["entry"];

const applyFromPersonActionUsed = (event: EventQueryType): ((dispatcher:Dispatcher) => Promise<void>)[] => {

  const eventToActionMappings = event.queryAllOptional("when")
    .flatMap(whenElement => whenElement.queryAllOptional("person_action_used"))
    .flatMap(personActionUsedElement => {
      return event.queryAllOptional("then").flatMap(thenElement => {
        return thenElement.queryAllOptional("select_person").flatMap(selectPersonElement => {
          return {
            personActionUsedElement,
            selectPersonElement
          }
        })
      })
    })

  return eventToActionMappings.map(({personActionUsedElement, selectPersonElement}) =>
    async (dispatcher: Dispatcher) => {
      dispatcher.personActionUsedDispatcher.on(personActionUsedElement, async ({doElement, byElement, writeJson}) => {
        const originElement = selectPersonElement.attributeMap.origin === "self"
          ? writeJson.person.getById(byElement.attributeMap.person_ref)
          : writeJson.person.getById(doElement.attributeMap.person_ref)
        writeJson.person.selectPerson(selectPersonElement, {
          x: originElement.query("location").attributeMap.x,
          y: originElement.query("location").attributeMap.y
        });
      })
    })
}
export const eventsMetadata: EventMiddleware = (readJson) => {
  const ruleGroup = readJson.json.query("rule_group");
  const eventsMetadata = ruleGroup.queryAllOptional("events_rule").flatMap(e => e.queryAll("entry"));
  const listenerList = eventsMetadata.flatMap(event => applyFromPersonActionUsed(event));

  return async (dispatcher:Dispatcher) => {
    listenerList.forEach(e => e(dispatcher));
  }
}