import {Transition} from "../markovNext";
import {JsonUtil} from "../util";

export type LocationMatrix = Record<string, Transition<string>>;

export const locationMarkovChainMatrix = (json: JsonUtil, direction): LocationMatrix => {
  const ruleGroup = json.getRuleGroups();
  const locationMarkovLinkList = ruleGroup.flatMap(ruleGroup => ruleGroup.queryAllOptional("locations_markov_chain"))
    .flatMap(e => e.queryAll("location_markov_link"));
  const matrix = locationMarkovLinkList.reduce((previous, link) => {
    let next = link.queryAll("sibling")
      ?.filter(e => e.$position === direction || e.$position === "all")
      ?.flatMap(e => {
          const slots = new Array(Number(e.$quantity ?? 1));
          return slots.fill(e.$location_ref);
        }
      );
    if (next?.length === undefined || next.length === 0) {
      next = link.queryAll("sibling")
        ?.filter(e => e.$position === "fill")
        ?.flatMap(e => {
            const slots = new Array(Number(e.$quantity ?? 1));
            return slots.fill(e.$location_ref);
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