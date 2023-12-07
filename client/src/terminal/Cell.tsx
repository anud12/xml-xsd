import React, {PropsWithChildren} from "react";
import "./Cell.css";

type Props = PropsWithChildren & {}


export const Cell = (props: Props) => {

  const childrenCount = ((props.children as any)?.length ?? 0)
  console.log(childrenCount);

  return <div className={"cell"}>
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