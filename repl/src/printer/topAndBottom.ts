//create a function that takes 2 multi line strings and displays it top and bottom
export const topAndBottom = (str1: string, str2: string): string => {
  if (str1 === '' || str1 === undefined) return str2;
  if (str2 === '' || str2 === undefined) return str1;
  const str1Max = str1.split("\n").reduce((previousValue, currentValue) => {
    if(previousValue < currentValue.length) {
      return currentValue.length;
    }
    return previousValue;
  },0);
  const str2Max = str2.split("\n").reduce((previousValue, currentValue) => {
    if(previousValue < currentValue.length) {
      return currentValue.length;
    }
    return previousValue;
  },0);
  const max = Math.max(str1Max, str2Max);
  const delimiter = new Array(max - str1Max).fill("-").join("");
  return `${str1}\n${str2}`;
}
