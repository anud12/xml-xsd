import React, {Fragment, ReactNode} from "react";
import "./Grid.css"

type Props ={
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

  return <div className={"Grid"}>
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
                  // const cell = grid.locations.get(y)?.get(x);
                  // const cellElements = cell?.map((element, index) => element.cell);
                  // const contextMenu = cell?.find(cell => {
                  //   return cell.cell.tag === "person"
                  // })
                  // return <Cell key={y}
                  //              onClick={() => {
                  //                props.onClick?.(cellElements ?? [], {
                  //                  x, y,
                  //                })
                  //              }}
                  //              onContextMenu={contextMenu ? () => {
                  //                console.log("Context menu")
                  //              } : undefined}>
                  //   {!cell && " "}
                  //   {cell?.map((element, index) => {
                  //     if (element.display === "@") {
                  //       return <span ref={props.onMainPersonRef} key={index}
                  //                    style={element.style}
                  //                    className={element.className}>
                  //         {element.display}
                  //       </span>
                  //     }
                  //     return <span key={index}
                  //                  className={element.className}
                  //                  style={element.style}>
                  //       {element.display ?? ")"}
                  //     </span>
                  //   })}
                  // </Cell>
                })}
            </div>
          })}
      </div>
      <div/>
    </div>
  </div>
}