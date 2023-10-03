import {JsonAttribute, JsonBody} from "./middleware";

export type JsonSchema = JsonBody<{
  "?xml": JsonAttribute<"version" | "standalone">,

  world_step: JsonBody<{

    world_metadata: JsonBody<{
      next_world_step: string,
      randomization_table: JsonBody<{
        entry: JsonAttribute<"value">
      }>
    }>,

    property_metadata: JsonBody<{
      entry: JsonAttribute<"name" | "default" | "value" | "max_value">
    }>,

    race_metadata: JsonBody<{
      entry: JsonAttribute<"name"> & JsonBody<{
        vision: JsonAttribute<"value">
        movement: JsonAttribute<"value">
        property_bonus: JsonAttribute<"name" | "value" | "max_value ">
      }>
    }>,

    item_metadata: JsonBody<{
      entry: JsonAttribute<"name"> & JsonBody<{
        weight_kg: JsonAttribute<"value">,
        wearable: JsonAttribute<"slot">,
      }>
    }>,

    locations_markov_chain: JsonBody<{
      location_markov_link: JsonAttribute<"type"> & JsonBody<{
        sibling: JsonAttribute<"type" | "position" | "quantity">
      }>
    }>,

    quests_markov_chain: JsonBody<{
      quest_markov_link: JsonAttribute<"type"> & JsonBody<{
        next: JsonAttribute<"type" | "quantity">
        completeCondition: unknown
      }>
    }>,

    people: JsonBody<{
      person: JsonAttribute<"name"> & JsonBody<{
        race: JsonAttribute<"name">,
        location: JsonAttribute<"x" | "y">
        relations: JsonAttribute<"with">,
        inventory: JsonBody<{
          item: JsonAttribute<"ref" | "equipped">
        }>
      }>
    }>;

    location_layer: JsonAttribute<"name"> & JsonBody<{
      cell: JsonAttribute<"type" | "x" | "y">,
    }>,
  }>,
}>
