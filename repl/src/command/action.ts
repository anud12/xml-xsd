import {Command} from "./commandType";
import {jsonSchema} from "../";
import {promptChoice} from "../promptChoice";

export const action: Command<[string]> = {
  key: "action",
  action: async (personName: string) => {


    const actionList = jsonSchema.query("action_metadata").queryAll("person_to_person");
    const action = await promptChoice("Choose action", actionList, e => e.$name)
    if (!action) {
      return;
    }
    const personList = jsonSchema.query("people").queryAll("person");
    const target = await promptChoice("Choose target", personList.filter(e => e.$name !== personName), u => u.$name)
    if (!target) {
      return
    }

    jsonSchema.query("actions").appendChild("by", {
      $name: personName
    }).appendChild("do", {
      $to: target.$name,
      $action: action.$name,
    })
  }
}