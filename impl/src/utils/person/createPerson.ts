import {Unit} from "../middleware";
import {JsonUtil} from "../index";

export type CreatePersonArgs = {
  race?: string,
  location: {
    $x: string,
    $y: string
  }
}

export const createPerson = (jsonSchema: JsonUtil, args: CreatePersonArgs): (write: Unit) => void => {
  const raceNameList = jsonSchema.jsonQuery.queryAll("race_metadata")
    .flatMap(e => e.queryAll("entry"))
    .map(e => e.$name);

  const race = args.race || jsonSchema.randomFromArray(raceNameList)

  return write => {
    const people = write.json.query("people");
    if (!people) {
      const person = people.appendChild("person", {
        $name: new Date().toISOString(),
      });
      person.appendChild("location", args.location);
      person.appendChild("race", {$name: race})
    }
  }
}