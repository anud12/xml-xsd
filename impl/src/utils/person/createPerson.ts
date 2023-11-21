import {JsonUtil} from "../index";

export type CreatePersonArgs = {
  race?: string,
  location: {
    $x: string,
    $y: string
  }
}

export const createPerson = (jsonSchema: JsonUtil, args: CreatePersonArgs): void => {
  const raceNameList = jsonSchema.jsonQuery.queryAll("race_metadata")
    .flatMap(e => e.queryAll("entry"))
    .map(e => e.$name);

  const time = jsonSchema.jsonQuery.query("world_metadata").query("elapsed_time").$value;

  const race = args.race || jsonSchema.randomFromArray(raceNameList)

  const people = jsonSchema.jsonQuery.query("people");
  const person = people.appendChild("person", {
    $id: `${time}.${jsonSchema.counterNext()}`,
  });
  person.appendChild("location", args.location);
  person.appendChild("race", {$name: race});
}