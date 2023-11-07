//create command that takes no argument but it runs execute function from demo package with jsonQuery parameter
import {Command} from "./commandType";
import {state} from "../index";
import {execute} from "demo/src/execute";
import {writeToDisk} from "./writeToDiskCommand";

export const run: Command<[]> = {
  key: () => ["run"],
  action: async (render) => {
    try {
      state.jsonSchema = await execute(state.jsonSchema.serialize(), () => {});
      writeToDisk();
    } catch (e) {
      const newError = new Error(`run failed`);
      newError.stack += '\nCaused by: ' + e.stack;
      console.error(newError);
    }
    render.update("");
  }
}