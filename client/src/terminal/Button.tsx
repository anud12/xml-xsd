import {PropsWithChildren} from "react";
import "./Button.css";

type Props = PropsWithChildren &{
  onClick: () => void;
  spawnsNew?: boolean;
}

export const Button = (props: Props) => {
  return <button className={"Button interactible" + (props.spawnsNew ? " popup__color" : "")} onClick={props.onClick}>{props.children}</button>
}
