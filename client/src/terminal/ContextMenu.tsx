import "./ContextMenu.css"
import {PropsWithChildren} from "react";

type Props = PropsWithChildren & {}

export const ContextMenu = (props: Props) => {
  return <div className={"ContextMenu"}>
    {props.children}
  </div>
}