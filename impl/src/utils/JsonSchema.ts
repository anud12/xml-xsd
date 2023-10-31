import {JsonQueryType} from "../JSONQuery";

export type OperationQueryType = JsonQueryType<never, {
  add_property_value: JsonQueryType<"name">,
  add: JsonQueryType<"value">,
  add_dice: JsonQueryType<"value">,
  multiply_dice: JsonQueryType<"value">,
  multiply: JsonQueryType<"value">,
  divide_dice: JsonQueryType<"value">,
  divide: JsonQueryType<"value">,
  modulo_dice: JsonQueryType<"value">,
  modulo: JsonQueryType<"value">,
  group: OperationQueryType,
}>

export type JsonSchema = JsonQueryType<never, {

  world_metadata: JsonQueryType<never, {
    next_world_step: JsonQueryType,
    randomization_table: JsonQueryType<never, {
      entry: JsonQueryType<"value">
    }>
  }>,

  property_metadata: JsonQueryType<never, {
    entry: JsonQueryType<"name" | "default" | "value" | "max_value", {
      default: JsonQueryType<never, {
        operation: OperationQueryType
      }>
    }>
  }>,

  classification_metadata: JsonQueryType<never, {
    entry: JsonQueryType<"name", {
      has_positive_value: JsonQueryType<never, {
        operation: OperationQueryType,
      }>,
    }>
  }>

  action_metadata: JsonQueryType<never, {
    person_to_person: JsonQueryType<"name", {
      range: JsonQueryType<"value" | "inclusive">,
      test: JsonQueryType<never, {
        value: JsonQueryType<"target", {
          operation: OperationQueryType,
        }>,
        expected: JsonQueryType<"target", {
          operation: OperationQueryType,
        }>
      }>,
      property_mutation: JsonQueryType<"name" | "on", {
        from: JsonQueryType<"partaker", {
          operation: OperationQueryType
        }>
      }>
    }>
  }>

  race_metadata: JsonQueryType<never, {
    entry: JsonQueryType<"name", {
      vision: JsonQueryType<"value">
      movement: JsonQueryType<"value">
      property_bonus: JsonQueryType<"ref" | "value" | "max_value ", {
        operation: OperationQueryType
      }>
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
      completeCondition: JsonQueryType
    }>
  }>,

  people: JsonQueryType<never, {
    person: JsonQueryType<"name", {
      race: JsonQueryType<"name">,
      location: JsonQueryType<"x" | "y">
      relations: JsonQueryType<"with">,
      properties: JsonQueryType<never, {
        property: JsonQueryType<"ref" | "value">
      }>,
      inventory: JsonQueryType<never, {
        item: JsonQueryType<"ref" | "equipped">
      }>
    }>
  }>;

  location_layer: JsonQueryType<"name", {
    cell: JsonQueryType<"type" | "x" | "y">,
  }>,

  actions: JsonQueryType<never, {
    by: JsonQueryType<"name", {
      do: JsonQueryType<"action" | "to">,
      move_towards: JsonQueryType<"x" | "y">
    }>
  }>
}>
