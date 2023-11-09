export function addBorder(multilineString: string, focus:boolean = false): string {
  if(multilineString === undefined) return '';

  const lines = multilineString.split('\n');
  const maxLength = Math.max(...lines.map(line => line.length));

  if(focus) {
    const horizontalBorder = '─'.repeat(maxLength + 2);
    const border = `┌${horizontalBorder}┐`;
    const borderedLines = lines.map(line => `│ ${line}${' '.repeat(maxLength - line.length)} │`);
    return `${border}\n${borderedLines.join('\n')}\n└${horizontalBorder}┘`;
  }
  const horizontalBorder = ' '.repeat(maxLength + 2);
  const border = ` ${horizontalBorder} `;
  const borderedLines = lines.map(line => `  ${line}${' '.repeat(maxLength - line.length)}  `);
  return `${border}\n${borderedLines.join('\n')}\n ${horizontalBorder} `;
}