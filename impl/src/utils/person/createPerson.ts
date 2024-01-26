import {JsonUtil} from "../util";

export type CreatePersonArgs = {
  race?: string,
  location: {
    $x: string,
    $y: string
  },
  items?: Array<{
    $item_ref: string,
    $quantity: string,
  }>
}

export const createPerson = (jsonSchema: JsonUtil, args: CreatePersonArgs): void => {
  const ruleGroup = jsonSchema.getRuleGroups();

  const raceList = ruleGroup.flatMap(ruleGroup => ruleGroup.queryAllOptional("race_metadata"))
    .flatMap(e => e.queryAll("entry"));

  const time = jsonSchema.json.query("world_metadata").query("elapsed_time").attributeMap.value;


  const race = raceList.find(race => race.attributeMap.name === args.race)
    || jsonSchema.randomFromArray(raceList)

  const name = jsonSchema.calculateNameFromRefString(race.queryOptional("name")?.attributeMap?.name_ref);

  const people = jsonSchema.json.query("people");
  console.log("createPerson", args);
  const person = people.appendChild("person", {
    $id: `${time}.${jsonSchema.counterNext()}`,
  });
  if (name) {
    person.attributeMap.name = name;
  }
  person.appendChild("location", args.location);
  person.appendChild("race", {$race_ref: race.attributeMap.name});
  person.appendChild("classifications", {});

  if (args.items && args.items.length > 0) {
    const inventory = person.appendChild("inventory", {});
    args.items.forEach(item => {
      for (let i = 0; i < Number(item.$quantity); i++) {
        inventory.appendChild("item", {
          $item_ref: item.$item_ref,
        });
      }
    })
  }
}