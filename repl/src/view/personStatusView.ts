import {state} from "../index";
import {nodeBodyType} from "demo/src/JSONQuery";
import {JsonSchema} from "demo/src/utils/JsonSchema";
import {topAndBottom} from "../printer/topAndBottom";

const personSymbol = [
  "α", "β", "γ", "δ", "ε", "ζ", "η", "θ", "ι", "κ", "λ", "μ", "ν", "ξ", "ο", "π", "ρ", "σ", "τ", "υ", "φ", "χ", "ψ", "ω", "ё", "ж", "ц", "ч", "ш", "ъ", "ы", "ь", "э", "ю", "я", "ά", "έ", "ή", "ί"
]

type PersonQueryType = JsonSchema[typeof nodeBodyType]["people"][typeof nodeBodyType]["person"];

export const personNameToSymbol = (string: string) => {
  const codepointSum = string.split("").map(e => e.codePointAt(0)).reduce((a, b) => a + b, 0);
  return personSymbol[codepointSum % personSymbol.length];
}

function personStatus(person: PersonQueryType) {
  let string = "";
  const personId = person.$id;
  const personRace = person.query("race")
  const personName = person.$name ?? "";
  const race = state.jsonSchema.query("race_metadata").queryAll("entry")
    .find(e => e.$name === personRace.$name)
  string += `Name: ${personName} (${personNameToSymbol(personId)})\n`
  string += `Race: ${race.$name}\n`;
  string += `Location: X: ${person.query("location").$x}, Y: ${person.query("location").$y}\n`;
  string += `Movement: ${race.query("movement").$value}\n`
  string += 'Relations:\n'
  return string;
}

function personProperties(person: PersonQueryType) {
  let string = "";
  string += 'Properties:'
  var propertyString = person.query("properties").queryAllOptional("property")
    .map((property) => ` - ${property.$ref}: ${property.$value}`)
    .join("\n");

  if (propertyString === "") {
    return string;
  }
  return string + "\n" + propertyString;

}

function personClassifications(person: PersonQueryType) {
  let string = "";
  string += 'Classifications:'
  const classificationList = person.queryAllOptional("classifications")
    .flatMap(e => e.queryAllOptional("classification"))
    .map(classification => ` - ${classification.$name}`)
    .join("\n");
  if (classificationList === "") {
    return string;
  }
  return string + "\n" + classificationList;
}

export function personStatusView(personId: string) {
  let string = "";
  const person = state.jsonSchema.queryAll("people")
    .flatMap(e => e.queryAll("person"))
    .find(e => e.$id === personId);
  const status = personStatus(person);
  const properties = personProperties(person);
  const classifications = personClassifications(person);
  string += status;
  string += classifications;
  return topAndBottom(string, properties);
}