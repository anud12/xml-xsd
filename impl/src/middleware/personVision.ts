import {Middleware} from "../utils/middleware";
import {fillNeighbours} from "../utils/location/fillNeighbours";

export const personVision: Middleware = (readJson) => async (writeJson) => {
  const json = readJson.json;

  const persons = readJson.json.people._all.flatMap(e => e.person._all);

  await Promise.all(persons.map(async e => {
    const location = e.location;

    const {$x, $y} = location;
    const race = e.race.$name;

    const radius = readJson.json
      .race_metadata
      .entry._all
      .filter(e => e.$name === race)?.[0]
      .vision
    await writeJson.util.location.create(Number($x), Number($y))(writeJson);
    fillNeighbours(readJson, writeJson, writeJson.util.location.grid()[Number($x)][Number($y)], Number(radius.$value));

  }))
}