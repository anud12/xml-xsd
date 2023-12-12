import {useEffect, useState} from "react";

const crossSymbol = Symbol();

type State = {
  name: string
}

export class Frame {

  useGlobalState = () => {
    const [state, setState] = useState<State>({
      name: "data"
    });

    const set = (state: State) => {
      window.dispatchEvent(new CustomEvent("useGlobalState", {
        detail: state
      }))
    }

    useEffect(() => {
      window.addEventListener("useGlobalState" as any, (evt: CustomEvent) => {
        setState(evt.detail)
      })
    }, [])

    return {
      ...state,
      set,
    }
  }


  open = (string:string) => {
    const childWindow = window.open(string)

    childWindow?.window.addEventListener("useGlobalState" as any, (ev:CustomEvent) => {
      if(ev.detail[crossSymbol]) {
        return
      }
      window.dispatchEvent(new CustomEvent("useGlobalState", {
        detail: {
          ...ev.detail,
          [crossSymbol]: true,
        }
      }))
    })

    window.addEventListener("useGlobalState" as any, ev => {
      if(ev.detail[crossSymbol]) {
        return
      }
      childWindow?.window.dispatchEvent(new CustomEvent("useGlobalState", {
        detail: {
          ...ev.detail,
          [crossSymbol]: true,
        }
      }))
    })

    return childWindow;
  }
}

export const frame = new Frame();