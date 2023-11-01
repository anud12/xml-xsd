import {state} from "../index";
import {sideBySide} from "../sideBySide";

const personSymbol = [
  "α", "β", "γ", "δ", "ε", "ζ", "η", "θ", "ι", "κ", "λ", "μ", "ν", "ξ", "ο", "π", "ρ", "σ", "τ", "υ", "φ", "χ", "ψ", "ω", "ё", "ж", "ц", "ч", "ш", "ъ", "ы", "ь", "э", "ю", "я", "ά", "έ", "ή", "ί"
]

export const personNameToSymbol = (string:string) => {
  const codepointSum = string.split("").map(e => e.codePointAt(0)).reduce((a, b) => a + b, 0);
  return personSymbol[codepointSum % personSymbol.length];
}

function personStatus(person) {
  let string = "";
  const personName = person.$name;
  const personRace = person.query("race")
  const race = state.jsonSchema.query("race_metadata").queryAll("entry")
    .find(e => e.$name === personRace.$name)
  string += `Name: ${personName} (${personNameToSymbol(personName)})\n`
  string += `Race: ${race.$name}\n`;
  string += `Location: X: ${person.query("location").$x}, Y: ${person.query("location").$y}\n`;
  string += `Movement: ${race.query("movement").$value}\n`
  string += 'Relations:\n'
  return string;
}
function personProperties(person) {
  let string = "";
  string += 'Properties:\n'
  person.query("properties").queryAllOptional("property").forEach((property) => {
    string += ` - ${property.$ref}: ${property.$value}\n`;
  });
  return string;
}
function personClassifications(person) {
  let string = "";
  string += 'Classifications:\n'
  person.queryAllOptional("classification").forEach((classification) => {
    string += ` - ${classification.$name}\n`;
  });
  return string;
}
export function personStatusView(personName: string) {
  let string = "";
  const person = state.jsonSchema.queryAll("people")
    .flatMap(e => e.queryAll("person"))
    .find(e => e.$name === personName);
  const status = personStatus(person);
  const properties = personProperties(person);
  const classifications = personClassifications(person);
  string +=status;
  string +=classifications;

  return sideBySide(string, properties);
}