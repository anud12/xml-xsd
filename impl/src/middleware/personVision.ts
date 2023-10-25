import {Middleware} from "../utils/middleware";
import {fillNeighbours} from "../utils/location/fillNeighbours";

export const personVision: Middleware = (readJson) => {
    const persons = readJson.json.query("people").queryAll("person");
    persons.map(async e => {
        const location = e.query("location");

        const {$x, $y} = location;
        const race = e.query("race").$name;

        const radius = readJson.json
          .query("race_metadata")
          .queryAll("entry")
          .filter(e => e.$name === race)?.[0]
          .query("vision")
        readJson.util.location.create(Number($x), Number($y));
        fillNeighbours(readJson, readJson, readJson.util.location.grid()[Number($x)][Number($y)], Number(radius.$value));
    })

    return async () => {
    }
}