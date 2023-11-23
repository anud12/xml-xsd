import readline from "readline";

export const clearInput = async (key:readline.Key) => {
  if(key.name === "right") {
    await new Promise<void>(resolve => process.stdout.moveCursor(-1, 0, resolve));
  }
  if(key.name === "up") {
    return;
  }
  if(key.name === "down") {
    return;
  }
  if(key.name === "return") {
    await new Promise<void>(resolve => process.stdout.moveCursor(0, -1, resolve));
    process.stdout.clearLine(0);
    return;
  }
  process.stdout.write("\b \b");
}