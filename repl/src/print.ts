import * as logUpdate from 'log-update';
import * as readline from "readline";


readline.emitKeypressEvents(process.stdin);
export const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
const update = logUpdate.create(process.stdout, { showCursor: true});

const logs = [];

export const consolePrint = (str: string) => {
  update([...logs, str].join("\n"));
}
export const log = str => {
  logs.push(str);
  update(logs.join("\n"));
};
