export function addBorder(multilineString: string, focus:boolean = false): string {
  if(multilineString === undefined) return '';

  const lines = multilineString.split('\n');
  const maxLength = Math.max(...lines.map(line => line.length));

  if(focus) {
    const horizontalBorder = '─'.repeat(maxLength + 0);
    let box = "";
    box = `┌${horizontalBorder}┐`;
    const borderedLines = lines.map(line => `│${line}${' '.repeat(maxLength - line.length)}│`);
    box += `\n${borderedLines.join('\n')}`;
    box += `\n└${horizontalBorder}┘`;
    return box;
  }
  // const horizontalBorder = '-'.repeat(maxLength + 0);
  const horizontalBorder = ' '.repeat(maxLength + 0);
  let box = "";
  // box = `╭${horizontalBorder}╮`;
  box = ` ${horizontalBorder} `;
  // const borderedLines = lines.map(line => `╎${line}${' '.repeat(maxLength - line.length)}╎`);
  const borderedLines = lines.map(line => ` ${line}${' '.repeat(maxLength - line.length)} `);
  box += `\n${borderedLines.join('\n')}`;
  box += `\n ${horizontalBorder} `;
  return box;
}