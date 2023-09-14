import {Transition} from "./markov";

export type LocationMatrix = Record<string, Transition<string>>;

export const locationMarkovChainMatrix = (json, direction):LocationMatrix => {
  const matrix = json.world_step[0].locations_markov_chain[0].location_markov_link.reduce((previous, link) => {
    let next = link.sibling
      ?.filter(e => e.$.position === direction || e.$.position === "all")
      ?.flatMap(e => {
          const slots = new Array(Number(e.$.quantity ?? 1));
          return slots.fill(e.$.type);
        }
      );
    if (next?.length === undefined || next.length === 0) {
      next = link.sibling
        ?.filter(e => e.$.position === "fill")
        ?.flatMap(e => {
            const slots = new Array(Number(e.$.quantity ?? 1));
            return slots.fill(e.$.type);
          }
        )
    }

    return {
      ...previous,
      [link.$.type]: next ?? []
    }
  }, {});

  return matrix;
}