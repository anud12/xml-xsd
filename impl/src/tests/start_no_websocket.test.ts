import * as index from "../index";
import {launchWebserver} from "../launchWebserver";

it("runs", () => {
  return new Promise<void>((res) => {
    launchWebserver(8080, (server) => setTimeout(() => {
      res();
      server.close();
    }, 5000));
  })
}, 100000000)