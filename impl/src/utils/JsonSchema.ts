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

// export type OperationQueryType = JsonQueryType<{ initial: string }, {
//   add_property: JsonQueryType<{ property_rule_ref: string }>
//   and: JsonQueryType<{ do: OperationQueryTypeAndDoType, value: string }>
// }>
export type OperationQueryType = type__math_operations

export type IconType = JsonQueryType<any, {
  svg: JsonQueryType<any, any>
}>;
export type ClassificationOperationIs = "lessThan"
  | "lessThanOrEqual"
  | "greaterThan"
  | "greaterThanOrEqual"
  | "equal"

export type PropertiesListQueryType = JsonQueryType<{}, {
  property: JsonQueryType<{property_rule_ref:string, value:string}>
}>

export type ClassificationsListQueryType = JsonQueryType<{}, {
    classification: JsonQueryType<{classification_rule_ref: string}, {}>
}>

export type PropertyMutationOnQueryType = JsonQueryType<{}, {}> & JsonQueryType<{ property_rule_ref: string, on: string }, {
  from: JsonQueryType<{ participant: string }, {
    operation: OperationQueryType
  }>
}>

// export type PropertyMutationQueryType = JsonQueryType<{}, {}> & JsonQueryType<{ property_rule_ref: string}, {
//   from: JsonQueryType<{ participant: "self" | "target" }, {
//     operation: OperationQueryType
//   }>
// }>
export type PropertyMutationQueryType = type__property_mutation

export type ItemDataQueryType = JsonQueryType<{}, {
  classifications: ClassificationsListQueryType,
  properties: PropertiesListQueryType,
}>

export type ItemQueryType = ItemDataQueryType & JsonQueryType<{ id: string, name: string }, {}>

// export type SelectItemQueryType = ItemDataQueryType & JsonQueryType<{}, {
//   min: OperationQueryType,
//   max: OperationQueryType,
// }>;
export type SelectItemQueryType = type__item_selection;
// export type SelectPersonQueryType = JsonQueryType<{}, {
//   radius: OperationQueryType,
//   min: OperationQueryType,
//   max: OperationQueryType,
//   property: JsonQueryType<{ property_rule_ref: string }, {
//     min: OperationQueryType,
//     max: OperationQueryType,
//   }>,
//   classification: JsonQueryType<{classification_rule_ref: string}, {}>,
//   race: JsonQueryType<{race_rule_ref: string}, {}>,
//   inventory: JsonQueryType<{}, {
//     item: SelectItemQueryType
//   }>,
// }>;
export type SelectPersonQueryType = type__person_selection

export type TriggerQueryType = JsonQueryType<{}, {
  person_action_used: JsonQueryType<{ action_rule_ref: string }>
}>

export type ActionQueryType = JsonQueryType<{}, {
  from: JsonQueryType<{}, {
    person: JsonQueryType<{}, {
      select: SelectPersonQueryType & JsonQueryType<{}, {}>,
      property_mutation: PropertyMutationQueryType & JsonQueryType<{}, {}>,
    }>
  }>
  on: JsonQueryType<{}, {
    person: JsonQueryType<{}, {
      select: SelectPersonQueryType & JsonQueryType<{}, {}>,
      property_mutation: PropertyMutationQueryType & JsonQueryType<{}, {}>,
    }>
  }>
}>

// export type GlobalActionQueryType = JsonQueryType<{ id: string }, {}> & ActionQueryType
export type GlobalActionQueryType = JsonQueryType<{ id: string }, {}> & type__action;

export type JsonSchema = world_step;
//
// export type JsonSchema = JsonQueryType<{}, {
//
//   world_metadata: JsonQueryType<{}, {
//     next_world_step: JsonQueryType<{}>,
//     elapsed_time: JsonQueryType<{ value: string }>,
//     counter: JsonQueryType<{ value: string }>,
//     randomization_table: JsonQueryType<{}, {
//       entry: JsonQueryType<{ value: string }>
//     }>
//   }>,
//   rule_group: JsonQueryType<{}, {
//     property_rule: JsonQueryType<{}, {
//       entry: JsonQueryType<{ id: string, default: string, value: string, max_value: string }, {
//         person_default: OperationQueryType
//         item_default: OperationQueryType
//       }>
//     }>,
//     classification_rule: JsonQueryType<{}, {
//       entry: JsonQueryType<{ id: string }, {
//         property: JsonQueryType<{ property_rule_ref: string, is: ClassificationOperationIs }, {
//           operation: OperationQueryType,
//         }>,
//       }>
//     }>
//     name_rule: JsonQueryType<{}, {
//       entry: JsonQueryType<{ id: string }, {
//         name_token: JsonQueryType<{ prefix: string }, {
//           ref: JsonQueryType<{ name_rule_ref: string }, {}>,
//           one_of: JsonQueryType<{}, {
//             name_token: JsonQueryType<{ prefix: string }, any>
//           }>
//         }>
//       }>
//     }>
//     action_rule: JsonQueryType<{}, {
//       global: JsonQueryType<{}, {
//         entry: GlobalActionQueryType
//       }>,
//       person_to_person: JsonQueryType<{ id: string }, {
//         max_range: JsonQueryType<{}, {
//           operation: OperationQueryType,
//         }>,
//         min_range: JsonQueryType<{}, {
//           operation: OperationQueryType,
//         }>,
//         test: JsonQueryType<{}, {
//           value: JsonQueryType<{ target: string }, {
//             operation: OperationQueryType,
//           }>,
//           expected: JsonQueryType<{ target: string }, {
//             operation: OperationQueryType,
//           }>
//         }>,
//         property_mutation: PropertyMutationOnQueryType
//       }>
//     }>
//     race_rule: JsonQueryType<{}, {
//       entry: JsonQueryType<{ id: string }, {
//         name: JsonQueryType<{ name_rule_ref: string }>,
//         vision: JsonQueryType<{ value: string }>
//         movement: JsonQueryType<{ value: string }>
//         property_bonus: JsonQueryType<{ property_rule_ref: string, value: string, max_value: string }, {
//           operation: OperationQueryType
//         }>,
//         icon: IconType
//       }>
//     }>,
//     item_rule: JsonQueryType<{}, {
//       entry: JsonQueryType<{ id: string }> & JsonQueryType<{}, {
//         name: JsonQueryType<{ name_rule_ref: string }>,
//         weight_kg: JsonQueryType<{ value: string }>,
//         wearable: JsonQueryType<{ slot: string }>,
//       }>
//     }>,
//     events_rule: JsonQueryType<{}, {
//       entry: JsonQueryType<{ id: string }, {
//         when: TriggerQueryType,
//         then: JsonQueryType<{}, {
//           select_person?: SelectPersonQueryType & JsonQueryType<{origin: "target" | "self"}>
//           select_item?: SelectItemQueryType & JsonQueryType<{origin: "target" | "self"}>
//           property_mutation: PropertyMutationOnQueryType & OperationQueryType,
//         }>
//       }>
//     }>,
//     locations_markov_chain: JsonQueryType<{}, {
//       location_markov_link: JsonQueryType<{ type: string }, {
//         sibling: JsonQueryType<{ location_rule_ref: string, position: string, quantity: string }>,
//         icon: IconType
//       }>
//     }>,
//   }>
//
//   items: JsonQueryType<{}, {
//     item: ItemQueryType,
//   }>,
//   people: JsonQueryType<{}, {
//     person: JsonQueryType<{ id: string, name: string }, {
//       race: JsonQueryType<{ race_rule_ref: string }>,
//       location: JsonQueryType<{ x: string, y: string }>,
//       relations: JsonQueryType<{ with: string }>,
//       properties: JsonQueryType<{}, {
//         property: JsonQueryType<{ property_rule_ref: string, value: string }>
//       }>,
//       inventory: JsonQueryType<{}, {
//         item: ItemQueryType
//       }>,
//       classifications: JsonQueryType<{}, {
//         classification: JsonQueryType<{ classification_rule_ref: string }>
//       }>,
//       icon: IconType
//     }>
//   }>;
//
//   location_layer: JsonQueryType<{ name: string }, {
//     cell: JsonQueryType<{ location_rule_ref: string, x: string, y: string }>,
//   }>,
//
//   actions: JsonQueryType<{}, {
//     by: JsonQueryType<{ person_ref: string }, {
//       do: JsonQueryType<{ action_rule_ref: string, action_ref: string, person_ref: string }>,
//       move_towards: JsonQueryType<{ x: string, y: string }>
//     }>
//   }>
// }>
export type attributeGroup_range = {"value": string;  "max_value": string;  "inclusive": string;}
export type group__item_data = JsonQueryType<{}, {
  "classifications": type__classification_list & JsonQueryType<{}, {}>;
  "properties": type__property_list & JsonQueryType<{}, {}>;
}>
export type group__operation__and = JsonQueryType<{}, {
  "add_property": JsonQueryType<{"property_rule_ref": string;}> & JsonQueryType<{}, {}>;
  "and": JsonQueryType<{"do": type__group__operation__and;  "value": string;}, {}> & group__operation__and | any & JsonQueryType<{}, {}>;
}>
export type group__math_operations = JsonQueryType<{}, {
  "operation": JsonQueryType<{"initial": string;}, {}> & group__operation__and & JsonQueryType<{}, {}>;
}>
export type group__name_token = JsonQueryType<{}, {
  "name_token": JsonQueryType<{"prefix": string;}, {}> & JsonQueryType<{}, {
    "ref": JsonQueryType<{"name_rule_ref": string;}> & JsonQueryType<{}, {}>;
  }>
    & JsonQueryType<{}, {
    "one_of": group__name_token | any & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
}>
export type item_slot = "hand"
  | "chest"
  | "legs"
export type type_direction = "north"
  | "east"
  | "south"
  | "west"
export type type_person_select = "self"
  | "target"
export type type__group__operation__and = "add"
  | "add_dice"
  | "multiply"
  | "multiply_dice"
  | "divide"
  | "divide_dice"
  | "modulo"
  | "modulo_dice"
export type type_range = JsonQueryType<attributeGroup_range>
export type type__property_mutation_on = JsonQueryType<{"on": type_person_select;}>
  & type__property_mutation
export type type__property_mutation = JsonQueryType<{"property_rule_ref": string;}, {
  "from": JsonQueryType<{"participant": type_person_select;}, {}> & group__math_operations & JsonQueryType<{}, {}>;
}>
export type type_icon = any
export type type__property_list = JsonQueryType<{}, {
  "property": JsonQueryType<{"property_rule_ref": string;  "value": string;}> & JsonQueryType<{}, {}>;
}>
export type type__classification_list = JsonQueryType<{}, {
  "classification": JsonQueryType<{"classification_rule_ref": string;}> & JsonQueryType<{}, {}>;
}>
export type type__item = JsonQueryType<{"id": any;  "name": any;}, {}> & group__item_data
export type type__item_selection = JsonQueryType<{}, {
  "min": type__math_operations & JsonQueryType<{}, {}>;
  "max": type__math_operations & JsonQueryType<{}, {}>;
}>
export type type_cell_ref = JsonQueryType<{"layer": any;  "x": string;  "y": string;}>
export type type__person_selection = JsonQueryType<{}, {
  "radius": type__math_operations & JsonQueryType<{}, {}>;
  "min": type__math_operations & JsonQueryType<{}, {}>;
  "max": type__math_operations & JsonQueryType<{}, {}>;
  "property": JsonQueryType<{"property_rule_ref": string;}, {
    "min": type__math_operations & JsonQueryType<{}, {}>;
    "max": type__math_operations & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
  "classification": JsonQueryType<{"classification_rule_ref": string;}> & JsonQueryType<{}, {}>;
  "race": JsonQueryType<{"race_rule_ref": any;}> & JsonQueryType<{}, {}>;
  "inventory": JsonQueryType<{}, {
    "item": type__item_selection & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
}>
export type type__trigger = JsonQueryType<{}, {
  "person_action_used": JsonQueryType<{"action_rule_ref": any;}> & JsonQueryType<{}, {}>;
}>
export type type__math_operations = JsonQueryType<{"initial": string;}, {}> & group__operation__and
export type type__action = JsonQueryType<{}, {
  "from": JsonQueryType<{}, {
    "person": JsonQueryType<{}, {
      "select": type__person_selection & JsonQueryType<{}, {}>;
      "property_mutation": type__property_mutation & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
  "on": JsonQueryType<{}, {
    "person": JsonQueryType<{}, {
      "select": type__person_selection & JsonQueryType<{}, {}>;
      "property_mutation": type__property_mutation & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
}>
export type world_step = JsonQueryType<{}, {
  "world_metadata": JsonQueryType<{}, {
    "previous_world_step": any & JsonQueryType<{}, {}>;
    "next_world_step": any & JsonQueryType<{}, {}>;
    "elapsed_time": JsonQueryType<{"value": string;}> & JsonQueryType<{}, {}>;
    "stepDuration": JsonQueryType<{"value": string;}> & JsonQueryType<{}, {}>;
    "counter": JsonQueryType<{"value": string;}> & JsonQueryType<{}, {}>;
    "randomization_table": JsonQueryType<{}, {
      "entry": JsonQueryType<{"value": string;}> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
  "rule_group": JsonQueryType<{"id": any;}, {
    "property_rule": JsonQueryType<{}, {
      "entry": JsonQueryType<{"id": any;  "units": any;}, {
        "person_default": JsonQueryType<{}>
          & type__math_operations & JsonQueryType<{}, {}>;
        "item_default": JsonQueryType<{}>
          & type__math_operations & JsonQueryType<{}, {}>;
        "property-threshold": JsonQueryType<{"name": string;  "min-value-inclusive": string;  "max-value-inclusive": string;}> & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
    "classification_rule": JsonQueryType<{}, {
      "entry": JsonQueryType<{"id": any;}, {
        "property": JsonQueryType<{"property_rule_ref": string;  "is": "lessThan" | "lessThanOrEqual" | "greaterThan" | "greaterThanOrEqual" | "equal";}, {}> & group__math_operations & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
    "name_rule": JsonQueryType<{}, {
      "entry": JsonQueryType<{"id": any;}, {}> & group__name_token & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
    "race_rule": JsonQueryType<{}, {
      "entry": JsonQueryType<{"id": string;}, {
        "vision": type_range & JsonQueryType<{}, {}>;
        "movement": type_range & JsonQueryType<{}, {}>;
        "name": JsonQueryType<{"name_rule_ref": string;}> & JsonQueryType<{}, {}>;
        "property_bonus": JsonQueryType<{"property_rule_ref": string;}, {}> & group__math_operations & JsonQueryType<{}, {}>;
        "icon": type_icon & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
    "action_rule": JsonQueryType<{}, {
      "global": JsonQueryType<{}, {
        "entry": JsonQueryType<{"id": any;}>
          & type__action & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
      "person_to_person": JsonQueryType<{"id": any;}, {
        "max_range": group__math_operations & JsonQueryType<{}, {}>;
        "min_range": group__math_operations & JsonQueryType<{}, {}>;
        "test": JsonQueryType<{}, {
          "value": JsonQueryType<{"target": type_person_select;}, {}> & group__math_operations & JsonQueryType<{}, {}>;
          "expected": JsonQueryType<{"target": type_person_select;}, {}> & group__math_operations & JsonQueryType<{}, {}>;
        }> & JsonQueryType<{}, {}>;
        "property_mutation": type__property_mutation_on & JsonQueryType<{}, {}>;
        "location_mutation": JsonQueryType<{"name": any;  "on": type_person_select;}, {
          "from": JsonQueryType<{"participant": type_person_select;}, {}> & group__math_operations & JsonQueryType<{}, {}>;
        }> & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
    "item_rule": JsonQueryType<{}, {
      "entry": JsonQueryType<{"id": any;}, {
        "name": group__name_token & JsonQueryType<{}, {}>;
        "weight-kg": JsonQueryType<{"value": any;}> & JsonQueryType<{}, {}>;
        "wearable": JsonQueryType<{"slot": item_slot;}> & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
    "events_rule": JsonQueryType<{}, {
      "entry": JsonQueryType<{"id": string;}, {
        "when": type__trigger & JsonQueryType<{}, {}>;
        "then": JsonQueryType<{}, {
          "select_person": JsonQueryType<{"origin": "target" | "self";}>
            & type__person_selection & JsonQueryType<{}, {}>;
          "select_item": JsonQueryType<{"origin": "target" | "self";}>
            & type__item_selection & JsonQueryType<{}, {}>;
          "property_mutation": JsonQueryType<{"property_rule_ref": string;}>
            & type__math_operations & JsonQueryType<{}, {}>;
        }> & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
    "locations_markov_chain": JsonQueryType<{}, {
      "location_markov_link": JsonQueryType<{"type": any;}, {
        "tag": JsonQueryType<{"name": any;}> & JsonQueryType<{}, {}>;
        "sibling": JsonQueryType<{"location_rule_ref": any;  "quantity": string;  "position": "all" | "fill" | "top" | "right" | "bottom" | "left";}> & JsonQueryType<{}, {}>;
        "icon": type_icon & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
  "items": JsonQueryType<{}, {
    "item": type__item & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
  "people": JsonQueryType<{}, {
    "person": JsonQueryType<{"id": any;  "name": any;}, {
      "race": JsonQueryType<{"race_rule_ref": any;}> & JsonQueryType<{}, {}>;
      "location": type_cell_ref & JsonQueryType<{}, {}>;
      "properties": JsonQueryType<{}, {
        "property": JsonQueryType<{"property_rule_ref": string;  "value": any;}> & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
      "relations": JsonQueryType<{"with": any;}> & JsonQueryType<{}, {}>;
      "inventory": JsonQueryType<{}, {
        "item": type__item & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
      "classifications": JsonQueryType<{}, {
        "classification": JsonQueryType<{"classification_rule_ref": string;}> & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
      "icon": type_icon & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
  "location_layer": JsonQueryType<{"name": any;}, {
    "cell": JsonQueryType<{"location_rule_ref": any;  "x": any;  "y": any;  "rotation": type_direction;}> & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
  "actions": JsonQueryType<{}, {
    "by": JsonQueryType<{"person_ref": any;}, {}> & JsonQueryType<{}, {
      "do": JsonQueryType<{"action_rule_ref": any;  "action_ref": any;  "person_ref": any;}> & JsonQueryType<{}, {}>;
    }>
      & JsonQueryType<{}, {
      "move_towards": JsonQueryType<{"layer": string;  "x": string;  "y": string;}> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
}>