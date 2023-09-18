import {Middleware} from "../utils/middleware";
import {fillNeighbours} from "../utils/location/fillNeighbours";
import {JsonUtil} from "../utils";

export const personVision: Middleware = (readJson) => async (writeJson) => {
    const persons = readJson.jsonSchema.world_step.flatMap(e => e.people.flatMap(e => e.person));

    await Promise.all(persons.map(async e => {
        const {x, y} = e.location[0].$;
        const radius = readJson.jsonSchema.world_step[0].status_definitions[0].property_definition.filter(e => e.$.name === "vision")?.[0];
        let util = new JsonUtil(writeJson);
        await util.location.create(Number(x), Number(y))(writeJson);
        util = new JsonUtil(writeJson);
        fillNeighbours(util, util.location.grid()[x][y], Number(radius.$.min ?? radius.$.max));

    }))
}