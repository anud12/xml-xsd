import {Transition} from "../markovNext";
import {JsonUtil} from "../index";

export type LocationMatrix = Record<string, Transition<string>>;

export const locationMarkovChainMatrix = (json: JsonUtil, direction): LocationMatrix => {
  const ruleGroup = json.jsonQuery.query("rule_group");
  const matrix = ruleGroup.query("locations_markov_chain").queryAll("location_markov_link").reduce((previous, link) => {
    let next = link.queryAll("sibling")
      ?.filter(e => e.$position === direction || e.$position === "all")
      ?.flatMap(e => {
          const slots = new Array(Number(e.$quantity ?? 1));
          return slots.fill(e.$type);
        }
      );
    if (next?.length === undefined || next.length === 0) {
      next = link.queryAll("sibling")
        ?.filter(e => e.$position === "fill")
        ?.flatMap(e => {
            const slots = new Array(Number(e.$quantity ?? 1));
            return slots.fill(e.$type);
          }
        )
    }

    return {
      ...previous,
      [link.$type]: next ?? []
    }
  }, {} as any);
  return matrix;
}