import {JsonUtil} from "./index";

export const newRandom = (worldSchema: JsonUtil) => {
    let counter = 0;
    return () => {
        const entries = worldSchema.jsonQuery.query("world_metadata").query("randomization_table").queryAll("entry")
            .map(value => Number(value.$value));
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