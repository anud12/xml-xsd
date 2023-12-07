import {PropsWithChildren} from "react";
import "./Button.css";

type Props = PropsWithChildren &{
  onClick: () => void;
}

export const Button = (props: Props) => {
  return <button className={"Button"} onClick={props.onClick}>{props.children}</button>
}
