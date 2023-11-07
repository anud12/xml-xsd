import {state} from "../index";
import {personNameToSymbol} from "./personStatusView";

const unfilledCharacter = "?";
const walkableCharacter = "\u25CB";

export function personMapView(personName: string) {
  const person = state.jsonSchema.query("people").queryAll("person").find(e => e.$name === personName)
  const personRaceMetadata = state.jsonSchema.query("race_metadata")
  .queryAll("entry").find(e => e.$name === person.query("race").$name)
  //get vision from person list of properties
  const vision = Number(personRaceMetadata.query("vision").$value);

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
    if(e.$type === "plains"){
      gridY[x] = `\u25CB`;
      return;
    }
    if(e.$type === "forest"){
      gridY[x] = `\u25CD`;
      return;
    }
    if(e.$type === "hills"){
      gridY[x] = `\u25B3`;
      return;
    }
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
  for (let y = personY - vision; y <= personY + vision; y++) {
    let row = [];
    for (let x = personX - vision; x <= personX + vision; x++) {
      if (grid[y] && grid[y][x]) {
        row.push(grid[y][x]);
      } else {
        row.push(unfilledCharacter);
      }
    }
    rows.push(row.map(e => ` ${e} `).join(""));
  }
  return rows.join("\n");
}