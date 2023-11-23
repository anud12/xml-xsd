import {Render} from "./printer/createRender";
import {clearInput} from "./printer/clearInput";
import readline from "readline";

export const select2d = async <T>(
  render: Render,
  message: () => string,
  options: T[][],
  mapper: (t: T) => string = (t) => t as string,
  initialPosition?: { x: number, y: number },
): Promise<T | undefined> => {
  return await new Promise<T>((resolve) => {
    let selectedRowIndex = initialPosition.y ?? 0;
    let selectedColIndex = initialPosition.x ?? 0;

    const numRows = options.length;
    const numCols = options[0].length;

    const print = () => {
      render.focus();
      const gridOptions = options.map((row, rowIndex) => {
        return row
          .map((col, colIndex) => {
            if (rowIndex === selectedRowIndex && colIndex === selectedColIndex) {
              return `>${mapper(col)}<`;
            } else {
              return ` ${mapper(col)} `;
            }
          })
          .join('');
      });
      const messageString = message();
      if (messageString?.length > 0) {
        render.update(messageString + "\n" + gridOptions.join('\n'));
        return;
      }
      render.update(gridOptions.join('\n'));
    };

    print();

    const listener = (_, key: readline.Key ) => {
      clearInput(key)
      if (key.name === 'up') {
        selectedRowIndex = Math.max(0, selectedRowIndex - 1);
        print();
        return;
      }
      if (key.name === 'down') {
        selectedRowIndex = Math.min(numRows - 1, selectedRowIndex + 1);
        print();
        return;
      }
      if (key.name === 'left') {
        selectedColIndex = Math.max(0, selectedColIndex - 1);
        print();
        return;
      }
      if (key.name === 'right') {
        selectedColIndex = Math.min(numCols - 1, selectedColIndex + 1);
        print();
        return;
      }
      if (key.name === 'return') {
        process.stdin.removeListener('keypress', listener);
        resolve(options[selectedRowIndex][selectedColIndex]);
        return;
      }
      if(key.name === 'escape') {
        process.stdin.removeListener('keypress', listener);
        resolve(undefined);
        return;
      }
      print();
    };

    process.stdin.on('keypress', listener);
  });
};
