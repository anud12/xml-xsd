import {Render} from "./printer/createRender";
import * as readline from "readline";
import {clearInput} from "./printer/clearInput";



export const select = async <T>(render:Render, message:() => string, options: T[], mapper: (t: T) => string = t => t as string): Promise<T> => {
  return await new Promise<T>((resolve) => {
    let selectedIndex = 0;
    const print = () => {
      render.focus();
      const stringOptions = options.map(e => mapper(e))
        .map((e, i) => {
          const prefix = i === selectedIndex ? "> " : "";
          const postfix = i === selectedIndex ? "" : "  ";
          return `${prefix}${e}${postfix}`;
        }).join("\n")
      const messageString = message();
      if(messageString?.length > 0) {
        render.update(messageString + "\n" + stringOptions);
        return;
      }
      render.update(stringOptions);
    }
    print();
    const listener = async (_, key:readline.Key) => {
      await clearInput(key);
      if (key.name === "up") {
        selectedIndex = Math.max(0, selectedIndex - 1);
        print();
        return;
      }
      if (key.name === "down") {
        selectedIndex = Math.min(options.length - 1, selectedIndex + 1);
        print();
        return;
      }
      if (key.name === "return") {
        process.stdin.removeListener('keypress', listener);
        resolve(options[selectedIndex])
        return;
      }
      print();
    };
    process.stdin.on('keypress', listener);

  });

}