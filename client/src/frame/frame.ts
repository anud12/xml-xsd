import {useEffect, useState} from "react";
import {JsonUtil} from "demo/dist/utils/util";

const crossSymbol = Symbol();

type State = {
  jsonUtil?: JsonUtil,
  activePersonId?: string,
}
window.addEventListener("useGlobalState" as any, (ev: CustomEvent) => {
  (window as any).globalState = ev.detail;
})

export class Frame {

  useGlobalState = () => {
    const [state, setState] = useState<State>((window as any).globalState);

    const set = (state: State) => {
      window.dispatchEvent(new CustomEvent("useGlobalState", {
        detail: state
      }))
    }

    useEffect(() => {
      (window as any).globalState = state;
      window.addEventListener("useGlobalState" as any, (evt: CustomEvent) => {
        (window as any).globalState = evt.detail;
        setState(evt.detail)
      })
    }, []);

    return {
      ...state,
      set,
    }
  }


  open = (string: string) => {
    const childWindow = window.open("http://localhost:3000/" + string);
    if (childWindow) {
      (childWindow as any).globalState = (window as any).globalState
    }

    childWindow?.window.addEventListener("useGlobalState" as any, (ev: CustomEvent) => {
      if (ev.detail[crossSymbol]) {
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
      if (ev.detail[crossSymbol]) {
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