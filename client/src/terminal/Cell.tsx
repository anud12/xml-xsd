import React, {PropsWithChildren} from "react";
import "./Cell.css";

type Props = PropsWithChildren & {
  onClick?: () => void;
  onContextMenu?: () => void;
}


export const Cell = (props: Props) => {

  const childrenCount = ((props.children as any)?.length ?? 0)
  console.log(childrenCount);

  return <div className={"cell"} onClick={props.onClick} onContextMenu={props.onContextMenu}>
    {(props.children as any)?.length &&
      (props.children as any)?.map((child: any) => {
        return <div
          className={"content"}>
          {child}
        </div>
      })
    }
    {!(props.children as any)?.length &&
        <div className={"content"}>
          {props.children}
        </div>
    }
  </div>
}