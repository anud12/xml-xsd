//create a function that takes 2 multi line strings and displays it top and bottom
export const topAndBottom = (str1: string, str2: string): string => {
  if (str1 === '' || str1 === undefined) return str2;
  if (str2 === '' || str2 === undefined) return str1;
  return `${str1}\n${str2}`;
}
