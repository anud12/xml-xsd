import {JsonUtil} from "demo/src/utils/util";

export const moveToAction = (jsonUtil: JsonUtil | undefined, mainPersonId: string | undefined, x: string | number, y: string | number) => {
  if (!jsonUtil) {
    return;
  }
  const actions = jsonUtil.json.queryOptional("actions")

  actions?.queryAllOptional("by")
    ?.filter(by => by.attributeMap.person_rule_ref === mainPersonId)
    ?.forEach(by => {
      by.queryOptional("move_towards")?.removeFromParent();
    })

  const by = actions?.appendChild("by", undefined, {
    person_rule_ref: mainPersonId,
  })
  by?.appendChild("move_towards", undefined, {
    x: String(x),
    y: String(y),
  })
  return;
}