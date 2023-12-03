import {Middleware, Unit} from "./_type";

export const offsetRandomisationTable:Middleware = _ => async writeUnit => {
  writeUnit.queryAll("world_metadata").flatMap(e => e.queryAll("randomization_table")).forEach(randomization_table => {
    const first = randomization_table.children.reverse().pop();
    randomization_table.children.reverse();
    randomization_table.children.push(first)
  })
}