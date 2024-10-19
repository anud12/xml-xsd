import {JsonUtil} from "./util";

let counter = 0;
/**
 * Returns a function that returns a random number between 0 and 1
 * @param worldSchema
 */
export const newRandom = (worldSchema: JsonUtil) => {
    return () => {
        const entries = worldSchema.json.query("world_metadata").query("randomization_table").queryAll("entry")
            .map(value => Number(value.attributeMap.value));
        const max = entries.reduce((previousValue, currentValue) => {
            return previousValue > currentValue
                ? previousValue
                : currentValue
        }, entries[0])
        const index = counter % entries.length;
        counter += 1;
        const result = entries[index] / max;
        console.log(`random: value=${entries[index]} result=${result}, max=${max}, `)
        return result;
    }
}