import {Command} from "./commandType";
import {sideBySide} from "../sideBySide";
import {personStatusView} from "../view/personStatusView";
import {personMapView} from "../view/personMapView";

export const status: Command<[string]> = {
  key: () => ["status"],
  action: async (personName: string) => {
    console.log(sideBySide(personMapView(personName), personStatusView(personName)))
  }
}