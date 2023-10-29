import {Command} from "./commandType";
import {jsonSchema} from "../";

export const map: Command<[string]> = {
  key: "map",
  action: async (personName: string) => {
    const person = jsonSchema.query("people").queryAll("person").find(e => e.$name === personName)
    //get vision from person list of properties
    const vision = 20;



    const grid:Array<Array<string>> = new Array(vision).fill("")
    grid.forEach((e, x) => {
      grid[x] = new Array<string>(vision).fill("\u2588");
    })
    jsonSchema.query("people").queryAll("person").forEach(e => {
      const location = e.query("location");
      const x = Number(location.$x);
      const y = Number(location.$y);
      if(grid[x] && grid[x][y]) {
        grid[x][y] = "P"
      }
    })
    grid.forEach(rows => {
      rows.forEach(y => {
        process.stdout.write(` ${y} `)
      })
      rows.forEach(() => {
        process.stdout.write(`   `)
      })
      process.stdout.write("\n")
    })

  }
}