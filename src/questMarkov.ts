import {markovNext} from "./markov";


export const questMarkov = (json) => {
  const questMatrix = json.world_step[0].quests_markov_chain[0].quest_markov_link.reduce((previous, quest) => {
    const next = quest.next
      ?.flatMap(e => {
          const slots = new Array(Number(e.$quantity?.[0] ?? 1));
          return slots.fill(e.$type[0]);
        }
      );


    return {
      ...previous,
      [quest.$type]: next ?? []
    }
  }, {})
  const d = new Array(10).fill("").reduce(([value, ...rest]) => {
    return [markovNext(questMatrix[value]), value, ...rest]
  }, ['talk-to'])
  console.log(d.reverse().join("->"));
}