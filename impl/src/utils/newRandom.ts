import {JsonSchema} from "./JsonSchema";

export const newRandom = (worldSchema: JsonSchema) => {
  let counter = 0;
  return () => {
    const entries = worldSchema.world_step.flatMap(value => value.world_metadata)
      .flatMap(value => value.randomization_table)
      .flatMap(value => value.entry)
      .map(value => Number(value.$.value));
    const max = entries.reduce((previousValue, currentValue) => {
      return previousValue > currentValue
        ? previousValue
        : currentValue
    }, 0)
    const index = counter % entries.length;
    counter += 1;
    return entries[index] / max;
  }
}