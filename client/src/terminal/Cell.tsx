import {PropsWithChildren} from "react";
import "./Cell.css";
type Props = PropsWithChildren & {

}


export const Cell = (props:Props) => {
  if(props.children === "\n") return <br/>
  return <div className={"cell"}>{props.children}</div>
}