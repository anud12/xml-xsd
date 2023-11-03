import { consolePrint } from './print';

export const select2d = async <T>(
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

      consolePrint(message() + '\n' + gridOptions.join('\n'));
    };

    print();

    const listener = (_, key) => {
      if (key.name === 'up') {
        selectedRowIndex = Math.max(0, selectedRowIndex - 1);
      }
      if (key.name === 'down') {
        selectedRowIndex = Math.min(numRows - 1, selectedRowIndex + 1);
      }
      if (key.name === 'left') {
        selectedColIndex = Math.max(0, selectedColIndex - 1);
      }
      if (key.name === 'right') {
        selectedColIndex = Math.min(numCols - 1, selectedColIndex + 1);
      }
      if (key.name === 'return') {
        resolve(options[selectedRowIndex][selectedColIndex]);
        process.stdin.removeListener('keypress', listener);
      }
      print();
    };

    process.stdin.on('keypress', listener);
  });
};
