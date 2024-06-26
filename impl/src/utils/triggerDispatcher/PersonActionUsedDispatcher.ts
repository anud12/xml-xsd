import {JsonSchema, TriggerQueryType} from "../JsonSchema";
import {TriggerDispatcher} from "./TriggerDispatcher";
import {MutationMiddleware} from "../../middleware/_type";
import {JsonUtil} from "../util";


type ByQueryType = JsonSchema["children"]["actions"]["children"]["by"];
type DoQueryType = ByQueryType["children"]["do"];
type PersonActionUsedType = TriggerQueryType["children"]["person_action_used"];

export type PersonActionUsedTriggerData = {
  writeJson: JsonUtil,
  doElement: DoQueryType,
  byElement: ByQueryType,
}

export type PersonActionUsedListener = (data: PersonActionUsedTriggerData) => Promise<void>;

export class PersonActionUsedDispatcher {

  dispatcher: TriggerDispatcher<string, PersonActionUsedTriggerData> = new TriggerDispatcher();

  public on(key: PersonActionUsedType, listener: PersonActionUsedListener) {
    this.dispatcher.on(key.attributeMap.action_rule_ref, listener);
  }

  public remove(key: PersonActionUsedType, listener: PersonActionUsedListener) {
    this.dispatcher.remove(key.attributeMap.action_rule_ref, listener);
  }

  public middleware: MutationMiddleware = readJson => {
    type KeyValue = {
      key: string,
      value: Omit<PersonActionUsedTriggerData, "writeJson">
    }
    const triggers = readJson.json.queryAllOptional("actions")
      .flatMap(actionElement => {
        return actionElement.queryAllOptional("by").flatMap(byElement => {
          return byElement.queryAllOptional("do").flatMap(doElement => {
            if (!doElement.attributeMap.action_rule_ref) {
              return undefined;
            }
            return {
              key: doElement.attributeMap.action_rule_ref,
              value: {
                byElement,
                doElement,
              }
            } satisfies KeyValue
          })
        });
      })

    return async writeUnit => {

      for (const trigger of triggers.filter(e => e)) {
        await this.dispatcher.dispatch(trigger.key, {
          ...trigger.value,
          writeJson: writeUnit
        })
      }
      return;
    }
  }

}