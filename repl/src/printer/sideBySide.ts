//create a function that takes 2 multi line strings and merges togheter line by line
export const sideBySide = (str1: string, str2: string): string => {
  if (str1 === '' || str1 === undefined) return str2;
  if (str2 === '' || str2 === undefined) return str1;

  const lines1 = str1.split('\n');
  const lines2 = str2.split('\n');
  const maxLength = Math.max(lines1.length, lines2.length);
  const maxLineSize = lines1.reduce((previousValue, currentValue) => {
    if(previousValue < currentValue.length) {
      return currentValue.length;
    }
    return previousValue;
  }, 0);
  let mergedString = '';

  for (let i = 0; i < maxLength; i++) {
    const line1 = lines1[i] || '';
    const line2 = i < lines2.length ? ' '.repeat(maxLineSize - line1.length) + lines2[i] : ''; // Add padding to the second window
    mergedString += line1  + line2 + '\n';
  }

  return mergedString;
}
