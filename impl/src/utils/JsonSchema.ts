import {JsonQueryType} from "../JSONQuery";

export type JsonSchema = JsonQueryType<never, {
  "?xml": JsonQueryType<"version" | "standalone">,

  world_step: JsonQueryType<never, {

    world_metadata: JsonQueryType<never, {
      next_world_step: JsonQueryType,
      randomization_table: JsonQueryType<never, {
        entry: JsonQueryType<"value">
      }>
    }>,

    property_metadata: JsonQueryType<never, {
      entry: JsonQueryType<"name" | "default" | "value" | "max_value">
    }>,

    command_metadata: JsonQueryType<never, {
      entry: JsonQueryType<"name", {
        mutate_property: JsonQueryType<"name", {
          add_property_value: JsonQueryType<"name">,
          add: JsonQueryType<"value">,
          multiply_dice: JsonQueryType<"value">,
          multiply: JsonQueryType<"value">,
          divide_dice: JsonQueryType<"value">,
          divide: JsonQueryType<"value">,
          modulo_dice: JsonQueryType<"value">,
          modulo: JsonQueryType<"value">,
        }>
      }>
    }>

    race_metadata: JsonQueryType<never, {
      entry: JsonQueryType<"name", {
        vision: JsonQueryType<"value">
        movement: JsonQueryType<"value">
        property_bonus: JsonQueryType<"name" | "value" | "max_value ">
      }>
    }>,

    item_metadata: JsonQueryType<never, {
      entry: JsonQueryType<"name"> & JsonQueryType<never, {
        weight_kg: JsonQueryType<"value">,
        wearable: JsonQueryType<"slot">,
      }>
    }>,

    locations_markov_chain: JsonQueryType<never, {
      location_markov_link: JsonQueryType<"type", {
        sibling: JsonQueryType<"type" | "position" | "quantity">
      }>
    }>,

    quests_markov_chain: JsonQueryType<never, {
      quest_markov_link: JsonQueryType<"type", {
        next: JsonQueryType<"type" | "quantity">
        completeCondition: unknown
      }>
    }>,

    people: JsonQueryType<never, {
      person: JsonQueryType<"name", {
        race: JsonQueryType<"name">,
        location: JsonQueryType<"x" | "y">
        relations: JsonQueryType<"with">,
        inventory: JsonQueryType<never, {
          item: JsonQueryType<"ref" | "equipped">
        }>
      }>
    }>;

    location_layer: JsonQueryType<"name", {
      cell: JsonQueryType<"type" | "x" | "y">,
    }>,
  }>,
}>
