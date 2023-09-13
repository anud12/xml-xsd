import {markovNext} from "./markov";

export const locationMarkov = (json, direction) => {
  console.log(json)
  const matrix = json.world_step[0].locations_markov_chain[0].location_markov_link.reduce((previous, link) => {
    console.log(link)
    const next = link.sibling
      .filter(e => e.$position[0] === direction || e.$position[0] === "all")
      ?.flatMap(e => {
          const slots = new Array(Number(e.$quantity?.[0] ?? 1));
          return slots.fill(e.$type[0]);
        }
      );


    return {
      ...previous,
      [link.$type]: next ?? []
    }
  }, {})
  console.log("locationMarkov", JSON.stringify(matrix));
  const d = new Array(30).fill("").reduce(([value, ...rest]) => {
    return [markovNext(matrix[value]), value, ...rest]
  }, ['grass'])
  d.reverse().map((e, index) => console.log(`${index}\t\t${e}`))
}