import {Transition} from "./markov";

export type LocationMatrix = Record<string, Transition<string>>;

export const locationMarkovChainMatrix = (json, direction):LocationMatrix => {
  const matrix = json.world_step[0].locations_markov_chain[0].location_markov_link.reduce((previous, link) => {
    let next = link.sibling
      ?.filter(e => e.$position[0] === direction || e.$position[0] === "all")
      ?.flatMap(e => {
          const slots = new Array(Number(e.$quantity?.[0] ?? 1));
          return slots.fill(e.$type[0]);
        }
      );
    if (next?.length === undefined || next.length === 0) {
      next = link.sibling
        ?.filter(e => e.$position[0] === "fill")
        ?.flatMap(e => {
            const slots = new Array(Number(e.$quantity?.[0] ?? 1));
            return slots.fill(e.$type[0]);
          }
        )
    }

    return {
      ...previous,
      [link.$type]: next ?? []
    }
  }, {});

  return matrix;
}