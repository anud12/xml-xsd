import React, {PropsWithChildren} from "react";
import "./Cell.css";

type Props = PropsWithChildren & {
  onClick?: () => void;
  onContextMenu?: (evt:MouseEvent) => void;
}


export const Cell = (props: Props) => {

  const childrenCount = ((props.children as any)?.length ?? 0)
  console.log(childrenCount);
  const contextMenu = props.onContextMenu ? "context_menu" : "";
  const click = props.onClick ? "onClick" : "";
  return <div className={`cell interactible ${click} ${contextMenu}`} onClick={props.onClick} onContextMenu={evt => props.onContextMenu?.(evt as any)}>
    {(props.children as any)?.length &&
      (props.children as any)?.map((child: any, index:any) => {
        return <div key={index}
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