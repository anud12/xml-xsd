import {Middleware} from "../utils/middleware";
import {newLocation} from "../utils/newLocation";

export const personVision: Middleware = (readJson) => async (writeJson) => {
  const persons = readJson.jsonSchema.world_step.flatMap(e => e.people.flatMap(e => e.person));

  persons.map(e => {
    const {x, y} = e.location[0].$;
    const radius = readJson.jsonSchema.world_step[0].status_definitions[0].property_definition.filter(e => e.$.name === "vision");

    new Array(Number(radius) * 2)
      .fill("")
      .map((_, index) => index - Number(radius))
      .map(e => e + Number(x))
      .flatMap(x => {
        return new Array(Number(radius) * 2)
          .fill("")
          .map((_, index) => index - Number(radius))
          .map(e => e + Number(y))
          .map(y => {
            return newLocation(x, y)(readJson)(writeJson)
          })
      })
  })
}