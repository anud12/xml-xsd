import {MutationMiddleware} from "./_type";

export const offsetRandomisationTable:MutationMiddleware = _ => async writeUnit => {
  writeUnit.json.queryAll("world_metadata").flatMap(e => e.queryAll("randomization_table")).forEach(randomization_table => {
    const first = randomization_table.childrenList.reverse().pop();
    randomization_table.childrenList.reverse();
    randomization_table.childrenList.push(first)
  })
}