import * as index from "../index";
import {launchWebserver} from "../launchWebserver";

it("runs", () => {
  return new Promise<void>((res) => {
    launchWebserver(8080, () => res());
  })
}, 100000000)