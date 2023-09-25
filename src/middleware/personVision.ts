import {Middleware} from "../utils/middleware";
import {fillNeighbours} from "../utils/location/fillNeighbours";
import {JsonUtil} from "../utils";

export const personVision: Middleware = (readJson) => async (writeJson) => {
  const persons = readJson.jsonSchema.world_step.flatMap(e => e.people.flatMap(e => e.person));

  await Promise.all(persons.map(async e => {
    const {x, y} = e.location[0].$;
    const race = e.race[0].$.name;

    const radius = readJson.jsonSchema
      .world_step[0]
      .race_metadata[0]
      .entry
      .filter(e => e.$.name === race)?.[0]
      .vision[0]

    let util = new JsonUtil(writeJson);
    await util.location.create(Number(x), Number(y))(writeJson);
    util = new JsonUtil(writeJson);
    fillNeighbours(util, util.location.grid()[x][y], Number(radius.$.value));

  }))
}