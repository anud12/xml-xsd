import dedent from "ts-dedent";

/**
 * Processes a multiline string or template literal, stripping leading indentation,
 * replacing specific values with a placeholder, and removing consecutive empty lines.
 *
 * Edge cases:
 * - If a value in the template is `undefined`, an empty string, or `false`, it will be replaced with the placeholder `template.clearLine`.
 * - If a line in the resulting string is composed only of the placeholder `template.clearLine`, it will be removed from the final output.
 * - Consecutive empty lines in the input will be reduced to a single empty line in the output.
 * - Leading and trailing empty lines in the input will be trimmed in the output.
 * - Output will be aligned with the least indented line within the text block,
 *
 * Conditions for converting to template.clearLine:
 * - e === undefined
 * - e?.length === 0
 * - e === false
 *
 * @param {string} [indentation=''] - The string to use as the indentation level. If not provided, defaults to an empty string.
 * @returns {function} A function that takes a template literal or string, and values to process.
 *
 */
export const template = Object.assign((identation?: string) => (templates: string | TemplateStringsArray, ...values: any[]): string => {
  const filteredValues = values
    .map(e => e === undefined ? template.clearLine : e)
    .map(e => e?.length === 0 ? template.clearLine : e)
    .map(e => e === false ? template.clearLine : e);

  let result:string | string[] = dedent(templates, ...filteredValues)
  result = result.split("\n")
  result = result.map(string => string.trimEnd())
  result = result.join("\n")
  result = removeLeadingEmptyLines(result);
  result = removeTrailingEmptyLines(result);

  if (result.trim() === template.clearLine) {
    return undefined;
  }
  result = removeClearSymbol(result);

  result = result.replace(/\n\n\n/, "\n\n")
  result = result.split("\n").map(e => `${identation ?? ""}${e}`).join("\n");

  return result
}, {
  clearLine: "__clear__"
})


const removeClearSymbol = (result:string):string => {

  const regexLineContainingOnlyClear = /\s*__clear__\n/;
  while (result.search(regexLineContainingOnlyClear) !== -1) {
    result = result.replace(regexLineContainingOnlyClear, "\n")
  }
  while (result.search(template.clearLine) !== -1) {
    result = result.replace(template.clearLine, "")
  }
  return result;
}

const removeTrailingEmptyLines = (result:string):string => {
  let lines = result.split("\n")
  lines = lines.reverse();
  while(lines.length !== 0 && lines[0].length === 0) {
    lines.shift();
  }
  lines = lines.reverse();
  return lines.join("\n");
}
const removeLeadingEmptyLines = (result:string):string => {
  let lines = result.split("\n")
  while(lines.length !== 0 && lines[0].length === 0) {
    lines.shift();
  }
  return lines.join("\n");
}