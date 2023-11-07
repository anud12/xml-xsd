import * as logUpdate from 'log-update';
import * as readline from "readline";
import {createRender} from "./createRender";


readline.emitKeypressEvents(process.stdin);
export const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
const update = logUpdate.create(process.stdout, { showCursor: true});

const logs = [];
export const consoleRenderer= () => {
  const renderer = createRender();
  renderer.onUpdate(update);
  return renderer;
}

