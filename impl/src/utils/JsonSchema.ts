import {JsonQueryType} from "../JsonQueryType";

export type OperationQueryTypeB = JsonQueryType<{}, {
  add_property_value: JsonQueryType<{ property_rule_ref: string }>,
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

export type StringBoolean = "false" | "true";

export type OperationQueryTypeAndDoType = "add"
  | "add_dice"
  | "multiply"
  | "multiply_dice"
  | "divide"
  | "divide_dice"
  | "modulo"
  | "modulo_dice"

export type OperationQueryType = JsonQueryType<{ initial: string }, {
  add_property: JsonQueryType<{ property_rule_ref: string }>
  and: JsonQueryType<{ do: OperationQueryTypeAndDoType, value: string }>
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

export type ItemQueryType = JsonQueryType<{ id: string, name: string }, {
  weight_kg: JsonQueryType<{ value: string }>
  wearable: JsonQueryType<{ slot: string }>
}>


export type SelectPersonQueryType = JsonQueryType<{}, {
  list_size: OperationQueryType & JsonQueryType<{fill_missing: StringBoolean }>,
  property: JsonQueryType<{ property_rule_ref: string }, {
    min: OperationQueryType,
    max: OperationQueryType,
  }>,
  classification: JsonQueryType<{classification_rule_ref: string}, {}>,
  race: JsonQueryType<{race_rule_ref: string}, {}>,
}>;

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
    property_rule: JsonQueryType<{}, {
      entry: JsonQueryType<{ id: string, default: string, value: string, max_value: string }, {
        default: JsonQueryType<{}, {
          operation: OperationQueryType
        }>
      }>
    }>,
    classification_rule: JsonQueryType<{}, {
      entry: JsonQueryType<{ id: string }, {
        property: JsonQueryType<{ property_rule_ref: string, is: ClassificationOperationIs }, {
          operation: OperationQueryType,
        }>,
      }>
    }>
    name_rule: JsonQueryType<{}, {
      entry: JsonQueryType<{ id: string }, {
        name_token: JsonQueryType<{ prefix: string }, {
          ref: JsonQueryType<{ name_rule_ref: string }, {}>,
          one_of: JsonQueryType<{}, {
            name_token: JsonQueryType<{ prefix: string }, any>
          }>
        }>
      }>
    }>
    action_rule: JsonQueryType<{}, {
      person_to_person: JsonQueryType<{ id: string }, {
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
        property_mutation: JsonQueryType<{ property_rule_ref: string, on: string }, {
          from: JsonQueryType<{ participant: string }, {
            operation: OperationQueryType
          }>
        }>
      }>
    }>
    race_rule: JsonQueryType<{}, {
      entry: JsonQueryType<{ id: string }, {
        name: JsonQueryType<{ name_rule_ref: string }>,
        vision: JsonQueryType<{ value: string }>
        movement: JsonQueryType<{ value: string }>
        property_bonus: JsonQueryType<{ property_rule_ref: string, value: string, max_value: string }, {
          operation: OperationQueryType
        }>,
        icon: IconType
      }>
    }>,
    item_rule: JsonQueryType<{}, {
      entry: JsonQueryType<{ id: string }> & JsonQueryType<{}, {
        name: JsonQueryType<{ name_rule_ref: string }>,
        weight_kg: JsonQueryType<{ value: string }>,
        wearable: JsonQueryType<{ slot: string }>,
      }>
    }>,
    events_rule: JsonQueryType<{}, {
      entry: JsonQueryType<{ id: string }, {
        when: JsonQueryType<{}, {
          person_action_used: JsonQueryType<{ action_rule_ref: string }>
        }>,
        then: JsonQueryType<{}, {
          at: JsonQueryType<{ origin: string }, {
            radius: JsonQueryType<{}, {
              operation: OperationQueryType
            }>
            location: JsonQueryType<{ type: string, quantity: string }>
          }>,
          select_person?: SelectPersonQueryType
        }>
      }>
    }>,
    locations_markov_chain: JsonQueryType<{}, {
      location_markov_link: JsonQueryType<{ type: string }, {
        sibling: JsonQueryType<{ location_rule_ref: string, position: string, quantity: string }>,
        icon: IconType
      }>
    }>,
  }>

  people: JsonQueryType<{}, {
    person: JsonQueryType<{ id: string, name: string }, {
      race: JsonQueryType<{ race_rule_ref: string }>,
      location: JsonQueryType<{ x: string, y: string }>,
      relations: JsonQueryType<{ with: string }>,
      properties: JsonQueryType<{}, {
        property: JsonQueryType<{ property_rule_ref: string, value: string }>
      }>,
      inventory: JsonQueryType<{}, {
        item: ItemQueryType
      }>,
      classifications: JsonQueryType<{}, {
        classification: JsonQueryType<{ classification_rule_ref: string }>
      }>,
      icon: IconType
    }>
  }>;

  location_layer: JsonQueryType<{ name: string }, {
    cell: JsonQueryType<{ location_rule_ref: string, x: string, y: string }>,
  }>,

  actions: JsonQueryType<{}, {
    by: JsonQueryType<{ person_rule_ref: string }, {
      do: JsonQueryType<{ action_rule_ref: string, person_rule_ref: string }>,
      move_towards: JsonQueryType<{ x: string, y: string }>
    }>
  }>
}>