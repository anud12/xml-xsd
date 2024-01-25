import {JsonQueryType} from "../JsonQueryType";

export type OperationQueryType = JsonQueryType<{}, {
  add_property_value: JsonQueryType<{ property_ref: string }>,
  add: JsonQueryType<{ value: string }>,
  add_dice: JsonQueryType<{ value: string }>,
  multiply_dice: JsonQueryType<{ value: string }>,
  multiply: JsonQueryType<{ value: string }>,
  divide_dice: JsonQueryType<{ value: string }>,
  divide: JsonQueryType<{ value: string }>,
  modulo_dice: JsonQueryType<{ value: string }>,
  modulo: JsonQueryType<{ value: string }>,
  group: JsonQueryType
}>

export type IconType = JsonQueryType<any, {
  svg: JsonQueryType<any, any>
}>;
export type ClassificationOperationIs = "lessThan"
  | "lessThanOrEqual"
  | "greaterThan"
  | "greaterThanOrEqual"
  | "equal"
  | "notEqual"
export type JsonSchema = JsonQueryType<{}, {

  world_metadata: JsonQueryType<{}, {
    next_world_step: JsonQueryType<{}>,
    elapsed_time: JsonQueryType<{ value: string }>,
    counter: JsonQueryType<{ value: string }>,
    randomization_table: JsonQueryType<{}, {
      entry: JsonQueryType<{ value: string }>
    }>
  }>,
  rule_group: JsonQueryType<{}, {
    property_metadata: JsonQueryType<{}, {
      entry: JsonQueryType<{ name: string, default: string, value: string, max_value: string }, {
        default: JsonQueryType<{}, {
          operation: OperationQueryType
        }>
      }>
    }>,
    classification_metadata: JsonQueryType<{}, {
      entry: JsonQueryType<{ name: string }, {
        property: JsonQueryType<{ property_ref: string, is: ClassificationOperationIs }, {
          operation: OperationQueryType,
        }>,
      }>
    }>
    action_metadata: JsonQueryType<{}, {
      person_to_person: JsonQueryType<{ name: string }, {
        max_range: JsonQueryType<{}, {
          operation: OperationQueryType,
        }>,
        min_range: JsonQueryType<{}, {
          operation: OperationQueryType,
        }>,
        test: JsonQueryType<{}, {
          value: JsonQueryType<{ target: string }, {
            operation: OperationQueryType,
          }>,
          expected: JsonQueryType<{ target: string }, {
            operation: OperationQueryType,
          }>
        }>,
        property_mutation: JsonQueryType<{ property_ref: string, on: string }, {
          from: JsonQueryType<{ participant: string }, {
            operation: OperationQueryType
          }>
        }>
      }>
    }>
    race_metadata: JsonQueryType<{}, {
      entry: JsonQueryType<{ name: string }, {
        vision: JsonQueryType<{ value: string }>
        movement: JsonQueryType<{ value: string }>
        property_bonus: JsonQueryType<{ property_ref: string, value: string, max_value: string }, {
          operation: OperationQueryType
        }>,
        icon: IconType
      }>
    }>,
    item_metadata: JsonQueryType<{}, {
      entry: JsonQueryType<{ name: string }> & JsonQueryType<{}, {
        weight_kg: JsonQueryType<{ value: string }>,
        wearable: JsonQueryType<{ slot: string }>,
      }>
    }>,
    events_metadata: JsonQueryType<{}, {
      entry: JsonQueryType<{ name: string }, {
        when: JsonQueryType<{}, {
          person_action_used: JsonQueryType<{ action_ref: string }>
        }>,
        then: JsonQueryType<{}, {
          at: JsonQueryType<{ origin: string }, {
            radius: JsonQueryType<{}, {
              operation: OperationQueryType
            }>
            location: JsonQueryType<{ type: string, quantity: string }>
          }>,
          create_person?: JsonQueryType<{}, {
            race: JsonQueryType<{ race_ref: string, quantity: string }>,
            inventory: JsonQueryType<{}, {
              item: JsonQueryType<{ item_ref: string }, {
                quantity: JsonQueryType<{}, {
                  operation: OperationQueryType
                }>
              }>
            }>
          }>
        }>
      }>
    }>,
    locations_markov_chain: JsonQueryType<{}, {
      location_markov_link: JsonQueryType<{ type: string }, {
        sibling: JsonQueryType<{ location_ref: string, position: string, quantity: string }>,
        icon: IconType
      }>
    }>,
  }>

  people: JsonQueryType<{}, {
    person: JsonQueryType<{ name: string, id: string }, {
      race: JsonQueryType<{ race_ref: string }>,
      location: JsonQueryType<{ x: string, y: string }>,
      relations: JsonQueryType<{ with: string }>,
      properties: JsonQueryType<{}, {
        property: JsonQueryType<{ property_ref: string, value: string }>
      }>,
      inventory: JsonQueryType<{}, {
        item: JsonQueryType<{ item_ref: string, equipped: string }>
      }>,
      classifications: JsonQueryType<{}, {
        classification: JsonQueryType<{ classification_ref: string }>
      }>,
      icon: IconType
    }>
  }>;

  location_layer: JsonQueryType<{ name: string }, {
    cell: JsonQueryType<{ location_ref: string, x: string, y: string }>,
  }>,

  actions: JsonQueryType<{}, {
    by: JsonQueryType<{ person_ref: string }, {
      do: JsonQueryType<{ action_ref: string, person_ref: string }>,
      move_towards: JsonQueryType<{ x: string, y: string }>
    }>
  }>
}>