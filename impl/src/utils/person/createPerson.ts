import {JsonUtil} from "../util";

export type CreatePersonArgs = {
  race?: string,
  location: {
    x: string,
    y: string
  },
  items?: Array<{
    item_rule_ref: string,
    quantity: string,
  }>
}

export const createPerson = (jsonSchema: JsonUtil, args: CreatePersonArgs): void => {
  const ruleGroup = jsonSchema.getRuleGroups();

  const raceList = ruleGroup.flatMap(ruleGroup => ruleGroup.queryAllOptional("race_rule"))
    .flatMap(e => e.queryAll("entry"));

  const time = jsonSchema.json.query("world_metadata").query("elapsed_time").attributeMap.value;


  const race = raceList.find(race => race.attributeMap.id === args.race)
    || jsonSchema.randomFromArray(raceList)

  const name = jsonSchema.name.calculateNameFromRefString(race.queryOptional("name")?.attributeMap?.name_rule_ref);

  const people = jsonSchema.json.query("people");
  console.log("createPerson", args);
  const person = people.appendChild("person", undefined, {
    id: jsonSchema.getNextId()
  });
  if (name) {
    person.attributeMap.name = name;
  }
  person.appendChild("location", undefined, args.location);
  person.appendChild("race", undefined, {
    race_rule_ref: race.attributeMap.id
  });
  person.appendChild("classifications", undefined, {});

  if (args.items && args.items.length > 0) {
    const inventory = person.appendChild("inventory");
    args.items.forEach(item => {
      for (let i = 0; i < Number(item.quantity); i++) {
        jsonSchema.item.createItemAt({
          item_rule_ref: item.item_rule_ref,
          parentElement: inventory
        });
      }
    })
  }
}