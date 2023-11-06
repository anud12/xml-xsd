import {Render} from "./printer/render";

export const select2d = async <T>(
  render:Render,
  message: () => string,
  options: T[][],
  mapper: (t: T) => string = (t) => t as string
): Promise<T> => {
  return await new Promise<T>((resolve) => {
    let selectedRowIndex = 0;
    let selectedColIndex = 0;

    const numRows = options.length;
    const numCols = options[0].length;

    const print = () => {
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

      render.update(message() + '\n' + gridOptions.join('\n'));
    };

    print();

    const listener = (_, key) => {
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
        process.stdout.write('\b');
        resolve(options[selectedRowIndex][selectedColIndex]);
      }
      process.stdout.write("\b");
      process.stdout.write(" ");
      print();
    };

    process.stdin.on('keypress', listener);
  });
};
