import {consolePrint} from "./print";

export const select = async <T>(message:() => string, options: T[], mapper: (t: T) => string = t => t as string): Promise<T> => {
  return await new Promise<T>((resolve) => {
    let selectedIndex = 0;
    const print = () => {
      const stringOptions = options.map(e => mapper(e))
        .map((e, i) => {
          const tip = i === selectedIndex ? "─>" : "─";

          if(i === options.length - 1) {
            return `╰${tip}${e}`;
          }
          return `├${tip}${e}`;
          // return i === selectedIndex ? `> ${e} <` : `  ${e}`
        }).join("\n")
      consolePrint(message() + "\n" + stringOptions);
    }
    print();
    const listener = (_, key) => {

      if (key.name === "up") {
        selectedIndex = Math.max(0, selectedIndex - 1);
      }
      if (key.name === "down") {
        selectedIndex = Math.min(options.length - 1, selectedIndex + 1);
      }
      if (key.name === "return") {
        resolve(options[selectedIndex])
        process.stdin.removeListener('keypress', listener);
      }
      print();
    };
    process.stdin.on('keypress', listener);

  });

}