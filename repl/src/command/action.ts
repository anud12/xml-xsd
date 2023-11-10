import {Command} from "./commandType";
import {state} from "../";
import {promptChoice} from "../promptChoice";
import {personNameToSymbol} from "../view/personStatusView";

export const action: Command<[string]> = {
  key: () => {
    return ["action"];

  },
  action: async (render, personName: string) => {

    // const actionList = state.jsonSchema.query("action_metadata").queryAll("person_to_person");
    // const action = actionList.find(e => e.$name === actionName);

    const personList = state.jsonSchema.query("people").queryAll("person");
    const target = await promptChoice(render.addRight(), "Choose target", personList.filter(e => e.$name !== personName), u => `${u.$name}(${personNameToSymbol(u.$name)})`)
    if (!target) {
      return
    }
    const actionList = state.jsonSchema.query("action_metadata").queryAll("person_to_person");
    const action = await promptChoice(render.getRight().addRight(), "Choose Action", actionList.filter(e => e.$name !== personName), u => u.$name)
    render.unsubscribeRight();

    state.jsonSchema.query("actions").appendChild("by", {
      $name: personName
    }).appendChild("do", {
      $to: target.$name,
      $action: action.$name,
    })
  }
}