import {state} from "../index";
import {personNameToSymbol} from "./personStatusView";

const unfilledCharacter = "?";
const walkableCharacter = "\u25CB";

type Cell = {
  x: number,
  y: number,
  character: string,
}
export const personMap = (personId: string): Array<Array<string>> => {
  const person = state.jsonSchema.query("people").queryAll("person").find(e => e.$id === personId)
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
    if (e.$type === "plains") {
      gridY[x] = `\u25CB`;
      return;
    }
    if (e.$type === "forest") {
      gridY[x] = `T`;
      return;
    }
    if (e.$type === "hills") {
      gridY[x] = `\u25B3`;
      return;
    }
    gridY[x] = walkableCharacter;
  })

  state.jsonSchema.query("people").queryAll("person").forEach(person => {
    const location = person.query("location");
    const x = Number(location.$x);
    const y = Number(location.$y);
    const gridY = grid[y] ?? [];
    grid[y] = gridY;
    gridY[x] = personNameToSymbol(person.$id);
  })
  let rows:Array<Array<string>> = [];
  for (let y = personY - vision; y <= personY + vision; y++) {
    let row = [];
    for (let x = personX - vision; x <= personX + vision; x++) {
      if (grid[y] && grid[y][x]) {
        row.push(grid[y][x]);
      } else {
        row.push(unfilledCharacter);
      }
    }
    rows.push(row);
  }
  return rows;
}


export function personMapView(personName: string) {
  const person = state.jsonSchema.query("people").queryAll("person").find(e => e.$id === personName)
  const personRaceMetadata = state.jsonSchema.query("race_metadata")
    .queryAll("entry").find(e => e.$name === person.query("race").$name)
  //get vision from person list of properties
  const vision = Number(personRaceMetadata.query("vision").$value);

  const personLocation = person.query("location");
  const personX = Number(personLocation.$x);
  const personY = Number(personLocation.$y);
  const grid = personMap(personName);


  return grid.map(e => e.map(e => ` ${e} `).join("")).join("\n");
}