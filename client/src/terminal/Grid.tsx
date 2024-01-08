import React, {Fragment, ReactNode} from "react";
import "./Grid.css"

type Props ={
  className?:string,
  max:{
    x:number,
    y:number,
  },
  min: {
    x:number,
    y:number,
  }
  getNode: (x:number,y:number) => ReactNode
}

export const Grid = (props:Props) => {
  const maxY = Math.abs(props.min.y) + Math.abs(props.max.y)+ 1;
  const maxX = Math.abs(props.min.x) +Math.abs(props.max.x) + 1;

  return <div className={`Grid ${props.className || ""}`}>
    <div>
      <div>
        {new Array(maxY).fill(0)
          .map((_, y) => y + props.min.y)
          .map((y) => {
            return <div key={y} className={"column"}>
              {new Array(maxX).fill(0)
                .map((_, x) => x + props.min.x)
                .map((x) => {
                  return <Fragment key={x}>
                  {props.getNode(x,y)}
                  </Fragment>
                })}
            </div>
          })}
      </div>
      <div/>
    </div>
  </div>
}