import {Command} from "./commandType";
import {constRenderer, state} from "../index";
import {promptChoice} from "../promptChoice";
import {personNameToSymbol} from "../view/personStatusView";

export const setTarget: Command<[string]> = {
  key: () => ["set target"],
  action: async (render, personId: string) => {
    const personList = state.jsonSchema.query("people").queryAll("person");
    const target = await promptChoice(constRenderer.target, "Choose target", personList.filter(e => e.$id !== personId), u => `${u.$name}(${personNameToSymbol(u.$id)})`)
    state.targetId = target?.$id;
    if (!target) {
      return
    }


  }
}