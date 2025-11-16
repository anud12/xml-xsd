export function normalizeName(name: string) {
  if (name === "ref") {
    return "_ref";
  }
  if (name === "do") {
    return "_do";
  }
  if (name === "is") {
    return "_is";
  }
  return name?.replace(/-/g, "_")
    .replace(/\./g, "__")
}