import {JsonQueryType} from "../JSONQuery";


export type OperationQueryType = JsonQueryType<never, {
  add_property_value: JsonQueryType<"property_ref">,
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
    elapsed_time: JsonQueryType<"value">,
    counter: JsonQueryType<"value">,
    randomization_table: JsonQueryType<never, {
      entry: JsonQueryType<"value">
    }>
  }>,
  rule_group: JsonQueryType<never, {
    property_metadata: JsonQueryType<never, {
      entry: JsonQueryType<"name" | "default" | "value" | "max_value", {
        default: JsonQueryType<never, {
          operation: OperationQueryType
        }>
      }>
    }>,
    classification_metadata: JsonQueryType<never, {
      entry: JsonQueryType<"name", {
        property: JsonQueryType<"property_ref" | "is", {
          operation: OperationQueryType,
        }>,
      }>
    }>
    action_metadata: JsonQueryType<never, {
      person_to_person: JsonQueryType<"name", {
        max_range: JsonQueryType<never, {
          operation: OperationQueryType,
        }>,
        min_range: JsonQueryType<never, {
          operation: OperationQueryType,
        }>,
        test: JsonQueryType<never, {
          value: JsonQueryType<"target", {
            operation: OperationQueryType,
          }>,
          expected: JsonQueryType<"target", {
            operation: OperationQueryType,
          }>
        }>,
        property_mutation: JsonQueryType<"property_ref" | "on", {
          from: JsonQueryType<"participant", {
            operation: OperationQueryType
          }>
        }>
      }>
    }>
    race_metadata: JsonQueryType<never, {
      entry: JsonQueryType<"name", {
        vision: JsonQueryType<"value">
        movement: JsonQueryType<"value">
        property_bonus: JsonQueryType<"property_ref" | "value" | "max_value ", {
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
    events_metadata: JsonQueryType<never, {
      entry: JsonQueryType<"name", {
        when:JsonQueryType<never, {
          person_action_used: JsonQueryType<"action_ref">
        }>,
        then: JsonQueryType<never, {
          at: JsonQueryType<"origin", {
            radius: JsonQueryType<never, {
              operation: OperationQueryType
            }>
            location: JsonQueryType<"type" | "quantity">
          }>,
          create_person?: JsonQueryType<never, {
            race: JsonQueryType<"race_ref" | "quantity">,
            inventory: JsonQueryType<never, {
              item: JsonQueryType<"item_ref", {
                quantity: JsonQueryType<never, {
                  operation: OperationQueryType
                }>
              }>
            }>
          }>
        }>
      }>
    }>,
    locations_markov_chain: JsonQueryType<never, {
      location_markov_link: JsonQueryType<"type", {
        sibling: JsonQueryType<"location_ref" | "position" | "quantity">
      }>
    }>,
  }>

  people: JsonQueryType<never, {
    person: JsonQueryType<"name" | "id", {
      race: JsonQueryType<"race_ref">,
      location: JsonQueryType<"x" | "y">
      relations: JsonQueryType<"with">,
      properties: JsonQueryType<never, {
        property: JsonQueryType<"property_ref" | "value">
      }>,
      inventory: JsonQueryType<never, {
        item: JsonQueryType<"item_ref" | "equipped">
      }>,
      classifications: JsonQueryType<never, {
        classification: JsonQueryType<"classification_ref">
      }>,
    }>
  }>;

  location_layer: JsonQueryType<"name", {
    cell: JsonQueryType<"location_ref" | "x" | "y">,
  }>,

  actions: JsonQueryType<never, {
    by: JsonQueryType<"person_ref", {
      do: JsonQueryType<"action_ref" | "person_ref">,
      move_towards: JsonQueryType<"x" | "y">
    }>
  }>
}>
