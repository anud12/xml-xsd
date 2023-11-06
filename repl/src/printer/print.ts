import * as logUpdate from 'log-update';
import * as readline from "readline";
import {render} from "./render";


readline.emitKeypressEvents(process.stdin);
export const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
const update = logUpdate.create(process.stdout, { showCursor: true});

const logs = [];
export const consoleRenderer= () => {
  const renderer = render();
  renderer.onUpdate(update);
  return renderer;
}

