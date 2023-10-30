import {state} from "../index";
import {personNameToSymbol} from "./personStatusView";

const unfilledCharacter = "?";
const walkableCharacter = "\u25CB";

export function personMapView(personName: string) {
  let string = "";
  const person = state.jsonSchema.query("people").queryAll("person").find(e => e.$name === personName)
  //get vision from person list of properties
  const vision = 5;

  const personLocation = person.query("location");
  const personX = Number(personLocation.$x);
  const personY = Number(personLocation.$y);

  const grid: Array<Array<string>> = new Array(vision).fill("")
  grid.forEach((e, x) => {
    grid[x] = new Array<string>(vision).fill(unfilledCharacter);
  })

  state.jsonSchema.query("location_layer").queryAll("cell").forEach(e => {
    const x = Number(e.$x);
    const y = Number(e.$y);
    const gridY = grid[y] ?? [];
    grid[y] = gridY;
    gridY[x] = walkableCharacter;
  })

  state.jsonSchema.query("people").queryAll("person").forEach(e => {
    const location = e.query("location");
    const x = Number(location.$x);
    const y = Number(location.$y);
    const gridY = grid[y] ?? [];
    grid[y] = gridY;
    gridY[x] = personNameToSymbol(e.$name);
  })
  let rows = [];
  for (let y = personY - vision; y < personY + vision; y++) {
    let row = "";
    for (let x = personX - vision; x < personX + vision; x++) {
      if (grid[y] && grid[y][x]) {
        row += ` ${grid[y][x]} `;
      } else {
        row += ` ${unfilledCharacter} `;
      }
    }
    rows.push(row);
  }
  string += rows.join("\n")
  return string;
}