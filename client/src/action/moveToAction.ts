import {JsonUtil} from "demo/dist/utils/util";

export const moveToAction = (jsonUtil: JsonUtil | undefined, mainPersonId: string | undefined, x: string | number, y: string | number) => {
  if (!jsonUtil) {
    return;
  }
  const actions = jsonUtil.json.queryOptional("actions")

  const by = actions?.appendChild("by", {
    $person_ref: mainPersonId,
  })
  by?.appendChild("move_towards", {
    $x: String(x),
    $y: String(y),
  })
  return;
}