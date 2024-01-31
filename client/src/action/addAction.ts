import {JsonUtil} from "demo/src/utils/util";

export const addAction = (jsonUtil: JsonUtil | undefined, mainPersonId: string | undefined, toPersonRef: string | undefined, actionName: string | undefined) => {
  if (!jsonUtil) {
    return;
  }
  if (!mainPersonId) {
    return;
  }
  if (!toPersonRef) {
    return;
  }
  if (!actionName) {
    return;
  }
  const actions = jsonUtil.json.queryOptional("actions")

  actions?.queryAllOptional("by")
    ?.filter(by => by.attributeMap.person_rule_ref === mainPersonId)
    ?.forEach(by => {
      by.queryOptional("do")?.removeFromParent();
    })

  const by = actions?.appendChild("by", undefined, {
    person_rule_ref: mainPersonId,
  })
  by?.appendChild("do", undefined, {
    person_rule_ref: toPersonRef,
    action_rule_ref: actionName,
  })
  return;

}