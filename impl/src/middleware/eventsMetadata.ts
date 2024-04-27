import {EventMiddleware} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";
import {Dispatcher} from "../utils/triggerDispatcher/dispatcher";


type RuleGroupQueryType = JsonSchema["children"]["rule_group"]
type EventQueryType = RuleGroupQueryType["children"]["events_rule"]["children"]["entry"];

const applyFromPersonActionUsed = (event: EventQueryType): ((dispatcher: Dispatcher) => Promise<void>)[] => {

  const thenToActionMappings = event.queryAllOptional("when")
    .flatMap(whenElement => whenElement.queryAllOptional("person_action_used"))
    .flatMap(personActionUsedElement => {
      return {
        personActionUsedElement,
        thenElement: event.queryAllOptional("then")
      }
    });

  return thenToActionMappings.map(({personActionUsedElement, thenElement}) => {
    return async (dispatcher: Dispatcher) => {
      dispatcher.personActionUsedDispatcher.on(personActionUsedElement, async ({doElement, byElement, writeJson}) => {
        thenElement.flatMap(thenElement => thenElement
          .queryAllOptional("select_person")
          .forEach(selectPersonElement => {
            const originElement = selectPersonElement.attributeMap.origin === "self"
              ? writeJson.person.getById(byElement.attributeMap.person_ref)
              : writeJson.person.getById(doElement.attributeMap.person_ref)
            writeJson.person.selectPerson(selectPersonElement, {
              x: originElement.query("location").attributeMap.x,
              y: originElement.query("location").attributeMap.y
            });
          }))

        thenElement.flatMap(thenElement => thenElement
          .queryAllOptional("select_item")
          .forEach(selectItemElement => {
            writeJson.item.selectItem(selectItemElement);
          }))
      })
    }
  })

}


export const eventsMetadata: EventMiddleware = (readJson) => {
  const ruleGroup = readJson.getRuleGroups();
  const eventsMetadata = ruleGroup.flatMap(ruleGroup => ruleGroup.queryAllOptional("events_rule")
    .flatMap(e => e.queryAll("entry"))
  )
  const listenerList = eventsMetadata.flatMap(event => applyFromPersonActionUsed(event));

  return async (dispatcher: Dispatcher) => {
    listenerList.forEach(e => e(dispatcher));
  }
}