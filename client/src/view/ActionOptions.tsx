import {frame} from "../frame/frame";
import {Button} from "../terminal/Button";

type Props = {
  onClick?: (actionName: string) => void;
}

export const ActionOptions = (props: Props) => {
  const global = frame.useGlobalState()
  const personToPerson = global.jsonUtil?.json?.queryAll("rule_group")
    .flatMap(ruleGroup => ruleGroup.queryAll("action_rule"))
    .flatMap(actionMetadata => actionMetadata.queryAll("person_to_person"));

  return <div className={"ActionOptions"}>
    {personToPerson?.map(action => {
      return <div className={"ActionOptions__action"}>
        <Button onClick={() => {
          if (!action.attributeMap.id) {
            console.error("No name for action", action)
            return
          }
          props.onClick?.(action.attributeMap.id)
        }}>{action.attributeMap.id}</Button>
      </div>
    })}
  </div>
}