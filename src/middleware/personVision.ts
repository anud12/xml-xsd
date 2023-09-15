import {Middleware} from "../utils/middleware";
import {newLocation} from "../utils/newLocation";

export const personVision: Middleware = async (readJson, writeJson) => {
  const persons = readJson.world_step.flatMap(e => e.people.flatMap(e => e.person));

  persons.map(e => {
    const {x, y} = e.location[0].$;
    const radius = readJson.world_step[0].status_definitions[0].property_definition.filter(e => e.$.name === "vision");

    const locations = new Array(Number(radius) * 2)
      .fill("")
      .map((_, index) => index - Number(radius))
      .map(e => e + Number(x))
      .flatMap(x => {
        return new Array(Number(radius) * 2)
          .fill("")
          .map((_, index) => index - Number(radius))
          .map(e => e + Number(y))
          .map(y => {
            return newLocation(readJson, x, y)
          })
      })
    writeJson.world_step[0].locations[0].cell.push(...locations)
  })
}