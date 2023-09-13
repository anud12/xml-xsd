import {XMLParser} from "fast-xml-parser";
import {markovNext} from "./markov";

(async () => {
  const data = await new Promise<string>((res) => {
    process.stdin.setEncoding('utf8');
    process.stdin.on('data', function (data) {
      res(String(data));
    });
  })
  const json = new XMLParser({
    attributeNamePrefix: "$",
    ignoreAttributes: false,
    attributesGroupName: false,
    isArray: () => true

  }).parse(data, {})

  questMarkov(json)

})()


const questMarkov = (json) => {
  const questMatrix = json.world[0].quests_markov_chain[0].quest_markov_link.reduce((previous, quest) => {
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
  console.log("questMatrix", JSON.stringify(questMatrix));
  const d = new Array(10).fill("").reduce(([value, ...rest]) => {
    return [markovNext(questMatrix[value]), value, ...rest]
  }, ['talk-to'])
  console.log(d.reverse().join("->"));
}