export function addBorder(multilineString: string, title:string, focus:boolean = false): string {
  if(multilineString === undefined) return '';

  const lines = multilineString.split('\n');
  let maxLength = Math.max(...lines.map(line => line.length));
  if(title?.length > maxLength) {
    maxLength = title.length;
  }

  if(focus) {
    const topBorder = '═'.repeat(maxLength - (title?.length ?? 0) + 0);
    const bottomBorder = '═'.repeat(maxLength + 0);
    let box = "";
    box = `╔${title ?? ""}${topBorder}╗`;
    const borderedLines = lines.map(line => `║${line}${' '.repeat(maxLength - line.length)}║`);
    box += `\n${borderedLines.join('\n')}`;
    box += `\n╚${bottomBorder}╝`;
    return box;
  }
  // const horizontalBorder = '-'.repeat(maxLength + 0);
  const topBorder = '-'.repeat(maxLength - (title?.length ?? 0) + 0);
  const bottomBorder = '-'.repeat(maxLength + 0);
  let box = "";
  // box = `╭${horizontalBorder}╮`;
  box = `╭${title ?? ""}${topBorder}╮`;
  // const borderedLines = lines.map(line => `╎${line}${' '.repeat(maxLength - line.length)}╎`);
  const borderedLines = lines.map(line => `┆${line}${' '.repeat(maxLength - line.length)}┆`);
  box += `\n${borderedLines.join('\n')}`;
  box += `\n╰${bottomBorder}╯`;
  return box;
}