export function normalizeNameClass(name: string) {
  if (name === "ref") {
    return "_ref";
  }
  if (name === "do") {
    return "DoElement";
  }

  let string = name?.replace(/-/g, "_")
    .replace(/\./g, "__");
  string = snakeToPascal(string);
  return string;

}


export function normalizeNameField(name:string) {
  const string = normalizeNameClass(name);
  return string.charAt(0).toLowerCase() + string.slice(1);
}

export function snakeToPascal(snake: string): string {
  return snake.replace(/(^\w|_\w)/g, (matches) => matches.replace('_', '').toUpperCase());
}