import {Button} from "./Button";
import "./MenuLine.css";
type Props = {
  options: Record<string, () => void>
}

export const MenuLine = (props: Props) => {
  return <div className={"MenuLine"}>
    {Object.entries(props.options).map(([key, value], index) => {
      return <div key={index}>
        {index + 1}:<Button key={key} onClick={value}>{key}</Button>
      </div>
    })}
  </div>
}