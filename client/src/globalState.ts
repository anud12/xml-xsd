import {useEffect, useState} from "react";

type State = {
  name: string
}

export const useGlobalState = () => {
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