import {EventMiddleware} from "./_type";
import {JsonSchema} from "../utils/JsonSchema";
import {Dispatcher} from "../utils/triggerDispatcher/dispatcher";
import {PersonQueryType} from "../utils/person/setProperty";
import {JsonUtil} from "../utils/util";


type RuleGroupQueryType = JsonSchema["children"]["rule_group"]
type EventQueryType = RuleGroupQueryType["children"]["events_rule"]["children"]["entry"];


const applyPropertyMutationToPerson = (readJson:JsonUtil, event: EventQueryType, target: PersonQueryType) => {
  const propertyMutationList = event.queryAllOptional("then").flatMap(thenElement => thenElement.queryAllOptional("property_mutation"))
  if(propertyMutationList.length === 0) {
    return
  }
  let propertiesElement = target.queryOptional("properties")
  if(!propertiesElement) {
    propertiesElement = target.appendChild("properties");
  }
  const propertiesList = propertiesElement.queryAllOptional("property");
  propertyMutationList.forEach(propertyMutation => {
    const addedValue = readJson.computeOperationFromParent(propertyMutation);
    const targetProperty = propertiesList.find(propertyElement => {
      return propertyMutation.attributeMap.property_rule_ref === propertyElement.attributeMap.property_rule_ref
    });
    if(targetProperty) {
      targetProperty.attributeMap.value = String(Number(addedValue) + Number(targetProperty.attributeMap.value))
      return;
    }
    propertiesElement.appendChild("property", undefined, {
      property_rule_ref: propertyMutation.attributeMap.property_rule_ref,
      value: String(addedValue)
    })
  })
}

const applyFromPersonActionUsed = (readJson:JsonUtil , event: EventQueryType): ((dispatcher: Dispatcher) => Promise<void>)[] => {

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
            const targetElement = writeJson.person.selectPerson(selectPersonElement);
            targetElement.forEach(element => applyPropertyMutationToPerson(readJson, event, element))
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
  const listenerList = eventsMetadata.flatMap(event => applyFromPersonActionUsed(readJson, event));

  return async (dispatcher: Dispatcher) => {
    listenerList.forEach(e => e(dispatcher));
  }
}