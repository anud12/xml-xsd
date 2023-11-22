import {Command} from "./commandType";
import {state} from "../";
import {promptChoice} from "../promptChoice";
import {personNameToSymbol} from "../view/personStatusView";

export const action: Command<[string]> = {
  key: () => {
    return ["action"];

  },
  action: async (render, personId: string) => {

    // const actionList = state.jsonSchema.query("action_metadata").queryAll("person_to_person");
    // const action = actionList.find(e => e.$name === actionName);

    const personList = state.jsonSchema.query("people").queryAll("person");
    const target = await promptChoice(render.addRight(), "Choose target", personList.filter(e => e.$id !== personId), u => `${u.$name}(${personNameToSymbol(u.$id)})`)

    if (!target) {
      render.unsubscribeRight();
      return
    }
    const actionList = state.jsonSchema.query("action_metadata").queryAll("person_to_person");
    const action = await promptChoice(render.getRight().addRight(), "Choose Action", actionList.filter(e => e.$name !== personId), u => u.$name)
    render.unsubscribeRight();

    state.jsonSchema.query("actions").appendChild("by", {
      $person: personId,
    }).appendChild("do", {
      $to: target.$id,
      $action: action.$name,
    })
  }
}