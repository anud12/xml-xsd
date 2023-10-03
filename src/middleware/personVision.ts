import {Middleware} from "../utils/middleware";
import {fillNeighbours} from "../utils/location/fillNeighbours";
import {JsonUtil} from "../utils";

export const personVision: Middleware = (readJson) => async (writeJson) => {

  const persons = readJson.jsonSchema.world_step.flatMap(e => e.people.flatMap(e => e.person));

  await Promise.all(persons.map(async e => {
    const location = e.location[0].$;

    const {x, y} = location;
    const race = e.race[0].$.name;

    const radius = readJson.jsonSchema
      .world_step[0]
      .race_metadata[0]
      .entry
      .filter(e => e.$.name === race)?.[0]
      .vision[0]

    let writeJsonUtil = new JsonUtil(writeJson);
    await writeJsonUtil.location.create(Number(x), Number(y))(writeJson);
    writeJsonUtil = new JsonUtil(writeJson);
    fillNeighbours(readJson, writeJsonUtil, writeJsonUtil.location.grid()[x][y], Number(radius.$.value));

  }))
}