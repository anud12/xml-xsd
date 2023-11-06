import {Render} from "./printer/render";

export const select = async <T>(render:Render, message:() => string, options: T[], mapper: (t: T) => string = t => t as string): Promise<T> => {
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
      render.update(message() + "\n" + stringOptions);
    }
    print();
    const listener = (_, key) => {

      if (key.name === "left") {
        process.stdout.write("\b");
        return;
      }
      if(key.name === "right") {
        process.stdout.write("\b");
        return;
      }
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
        process.stdout.write("\b");
        process.stdin.removeListener('keypress', listener);
        resolve(options[selectedIndex])
      }
      process.stdout.write("\b");
      process.stdout.write(" ");
      print();
    };
    process.stdin.on('keypress', listener);

  });

}