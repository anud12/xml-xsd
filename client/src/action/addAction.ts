import {JsonUtil} from "demo/dist/utils/util";

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
    ?.filter(by => by.$person_ref === mainPersonId)
    ?.forEach(by => {
      by.queryOptional("do")?.removeFromParent();
    })

  const by = actions?.appendChild("by", {
    $person_ref: mainPersonId,
  })
  by?.appendChild("do", {
    $person_ref: toPersonRef,
    $action_ref: actionName,
  })
  return;

}