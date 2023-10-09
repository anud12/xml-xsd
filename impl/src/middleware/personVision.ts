import {Middleware} from "../utils/middleware";
import {fillNeighbours} from "../utils/location/fillNeighbours";

export const personVision: Middleware = (readJson) => async (writeJson) => {
    const json = readJson.json;

    const persons = readJson.json.query("people").queryAll("person");

    await Promise.all(persons.map(async e => {
        const location = e.query("location");

        const {$x, $y} = location;
        const race = e.query("race").$name;

        const radius = readJson.json
            .query("race_metadata")
            .queryAll("entry")
            .filter(e => e.$name === race)?.[0]
            .query("vision")
        await writeJson.util.location.create(Number($x), Number($y))(writeJson);
        fillNeighbours(readJson, writeJson, writeJson.util.location.grid()[Number($x)][Number($y)], Number(radius.$value));

    }))
}