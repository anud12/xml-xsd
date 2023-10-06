type Element = string | number | symbol

export type Transition<E extends Element = Element> = E[];

export const markovNext = <E extends Element>(transition: Transition<E> = [], nextRandom: () => number): E => {


  const options = transition.reduce<Map<E, number>>((map, key) => {
    const nextValue = (map.get(key) ?? 0) + 1
    map.set(key, nextValue);
    return map;
  }, new Map());

  const normalizedOptions: Map<E, number> = [...options.entries()].reduce((previousValue, [key, value]) => {
    previousValue.set(key, value / transition.length);
    return previousValue;
  }, new Map());
  const randomValue = nextRandom();
  let cumulativeProbability = 0;
  const keys = [...normalizedOptions.keys()];

  for (const nextState of keys) {
    cumulativeProbability += normalizedOptions.get(nextState);

    if (randomValue <= cumulativeProbability) {
      return nextState;
    }
  }

  // Fallback if no state is chosen (shouldn't happen if the probabilities sum to 1).
  return normalizedOptions.keys()[0];
};
