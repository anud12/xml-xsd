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

export type PropertyMutationQueryType = JsonQueryType<{}, {}> & JsonQueryType<{ property_rule_ref: string}, {
  from: JsonQueryType<{ participant: "self" | "target" }, {
    operation: OperationQueryType
  }>
}>

export type ItemDataQueryType = JsonQueryType<{}, {
  classifications: ClassificationsListQueryType,
  properties: PropertiesListQueryType,
}>

export type ItemQueryType = ItemDataQueryType & JsonQueryType<{ id: string, name: string }, {}>

export type SelectItemQueryType = ItemDataQueryType & JsonQueryType<{}, {
  min: OperationQueryType,
  max: OperationQueryType,
}>;

export type SelectPersonQueryType = JsonQueryType<{}, {
  radius: OperationQueryType,
  min: OperationQueryType,
  max: OperationQueryType,
  property: JsonQueryType<{ property_rule_ref: string }, {
    min: OperationQueryType,
    max: OperationQueryType,
  }>,
  classification: JsonQueryType<{classification_rule_ref: string}, {}>,
  race: JsonQueryType<{race_rule_ref: string}, {}>,
  inventory: JsonQueryType<{}, {
    item: SelectItemQueryType
  }>,
}>;

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

export type GlobalActionQueryType = JsonQueryType<{ id: string }, {}> & ActionQueryType
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
type attributeGroup_range = JsonQueryType<{
  "value": number;
  "max_value": number;
  "inclusive": boolean;
}, {

}>
type group__item_data = JsonQueryType<{}, {
  "classifications": type__classification_list;
  "properties": type__property_list;
}>

type group__math_operations = JsonQueryType<{}, {
  "operation": JsonQueryType<{
    "initial": number;
  }, {

  }>;
}>

type item_slot = "hand"
  | "chest"
  | "legs"
type type_direction = "north"
  | "east"
  | "south"
  | "west"
type type_person_select = "self"
  | "target"
type type__group__operation__and = "add"
  | "add_dice"
  | "multiply"
  | "multiply_dice"
  | "divide"
  | "divide_dice"
  | "modulo"
  | "modulo_dice"
type type_range = JsonQueryType<attributeGroup_range, {

}>
type type__property_mutation_on = JsonQueryType<{
    "on": type_person_select;
  }, {

  }>
  & type__property_mutation
type type__property_mutation = JsonQueryType<{
  "property_rule_ref": string;
}, {
  "from": JsonQueryType<{
    "participant": type_person_select;
  }, {

  }>;
}>
type type_icon = any
type type__property_list = JsonQueryType<{}, {
  "property": JsonQueryType<{
    "property_rule_ref": string;
    "value": number;
  }, {

  }>;
}>
type type__classification_list = JsonQueryType<{}, {
  "classification": JsonQueryType<{
    "classification_rule_ref": string;
  }, {

  }>;
}>
type type__item = JsonQueryType<{}, {

}>
type type__item_selection = JsonQueryType<{}, {
  "min": type__math_operations;
  "max": type__math_operations;
}>
type type_cell_ref = JsonQueryType<{
  "x": number;
  "y": number;
}, {

}>
type type__person_selection = JsonQueryType<{}, {
  "radius": type__math_operations;
  "min": type__math_operations;
  "max": type__math_operations;
  "property": JsonQueryType<{}, {
    "min": type__math_operations;
    "max": type__math_operations;
  }>;
  "classification": JsonQueryType<{
    "classification_rule_ref": string;
  }, {

  }>;
  "race": JsonQueryType<{}, {

  }>;
  "inventory": JsonQueryType<{}, {
    "item": type__item_selection;
  }>;
}>
type type__trigger = JsonQueryType<{}, {
  "person_action_used": JsonQueryType<{}, {

  }>;
}>
type type__math_operations = JsonQueryType<{
  "initial": number;
}, {

}>
type type__action = JsonQueryType<{}, {
  "from": JsonQueryType<{}, {
    "person": JsonQueryType<{}, {
      "select": type__person_selection & JsonQueryType;
      "property_mutation": type__property_mutation & JsonQueryType;
    }>;
  }>;
  "on": JsonQueryType<{}, {
    "person": JsonQueryType<{}, {
      "select": type__person_selection & JsonQueryType;
      "property_mutation": type__property_mutation & JsonQueryType;
    }>;
  }>;
}>
export type JsonSchema = JsonQueryType<{}, {
  "world_metadata": JsonQueryType<{}, {
    "previous_world_step": any;
    "next_world_step": any;
    "elapsed_time": JsonQueryType<{
      "value": number;
    }, {

    }>;
    "stepDuration": JsonQueryType<{
      "value": number;
    }, {

    }>;
    "counter": JsonQueryType<{
      "value": number;
    }, {

    }>;
    "randomization_table": JsonQueryType<{}, {
      "entry": JsonQueryType<{
        "value": number;
      }, {

      }>;
    }>;
  }>;
  "rule_group": JsonQueryType<{}, {
    "property_rule": JsonQueryType<{}, {
      "entry": JsonQueryType<{}, {
        "person_default": JsonQueryType<{}, {

          }>
          & type__math_operations;
        "item_default": JsonQueryType<{}, {

          }>
          & type__math_operations;
        "property-threshold": JsonQueryType<{
          "name": string;
          "min-value-inclusive": number;
          "max-value-inclusive": number;
        }, {

        }>;
      }>;
    }>;
    "classification_rule": JsonQueryType<{}, {
      "entry": JsonQueryType<{}, {
        "property": group__math_operations;
      }>;
    }>;
    "name_rule": JsonQueryType<{}, {
      "entry": JsonQueryType<{}, {

      }>;
    }>;
    "race_rule": JsonQueryType<{}, {
      "entry": JsonQueryType<{
        "id": string;
      }, {
        "vision": type_range;
        "movement": type_range;
        "name": JsonQueryType<{
          "name_rule_ref": string;
        }, {

        }>;
        "property_bonus": JsonQueryType<{
          "property_rule_ref": string;
        }, {

        }>;
        "icon": type_icon;
      }>;
    }>;
    "action_rule": JsonQueryType<{}, {
      "global": JsonQueryType<{}, {
        "entry": JsonQueryType<{}, {

          }>
          & type__action;
      }>;
      "person_to_person": JsonQueryType<{}, {
        "max_range": JsonQueryType<{}, {

        }>;
        "min_range": JsonQueryType<{}, {

        }>;
        "test": JsonQueryType<{}, {
          "value": JsonQueryType<{
            "target": type_person_select;
          }, {

          }>;
          "expected": JsonQueryType<{
            "target": type_person_select;
          }, {

          }>;
        }>;
        "property_mutation": type__property_mutation_on;
        "location_mutation": JsonQueryType<{
          "on": type_person_select;
        }, {
          "from": JsonQueryType<{
            "participant": type_person_select;
          }, {

          }>;
        }>;
      }>;
    }>;
    "item_rule": JsonQueryType<{}, {
      "entry": JsonQueryType<{}, {
        "name": JsonQueryType<{}, {

        }>;
        "weight-kg": JsonQueryType<{}, {

        }>;
        "wearable": JsonQueryType<{
          "slot": item_slot;
        }, {

        }>;
      }>;
    }>;
    "events_rule": JsonQueryType<{}, {
      "entry": JsonQueryType<{
        "id": string;
      }, {
        "when": type__trigger;
        "then": JsonQueryType<{}, {
          "select_person": JsonQueryType<{
              "origin": "target"
                | "self";
            }, {

            }>
            & type__person_selection;
          "select_item": JsonQueryType<{
              "origin": "target"
                | "self";
            }, {

            }>
            & type__item_selection;
          "property_mutation": JsonQueryType<{
              "property_rule_ref": string;
            }, {

            }>
            & type__math_operations;
        }>;
      }>;
    }>;
    "locations_markov_chain": JsonQueryType<{}, {
      "location_markov_link": JsonQueryType<{}, {
        "tag": JsonQueryType<{}, {

        }>;
        "sibling": JsonQueryType<{
          "quantity": number;
          "position": "all"
            | "fill"
            | "top"
            | "right"
            | "bottom"
            | "left";
        }, {

        }>;
        "icon": type_icon;
      }>;
    }>;
  }>;
  "items": JsonQueryType<{}, {
    "item": type__item;
  }>;
  "people": JsonQueryType<{}, {
    "person": JsonQueryType<{}, {
      "race": JsonQueryType<{}, {

      }>;
      "location": type_cell_ref;
      "properties": JsonQueryType<{}, {
        "property": JsonQueryType<{
          "property_rule_ref": string;
        }, {

        }>;
      }>;
      "relations": JsonQueryType<{}, {

      }>;
      "inventory": JsonQueryType<{}, {
        "item": type__item;
      }>;
      "classifications": JsonQueryType<{}, {
        "classification": JsonQueryType<{
          "classification_rule_ref": string;
        }, {

        }>;
      }>;
      "icon": type_icon;
    }>;
  }>;
  "location_layer": JsonQueryType<{}, {
    "cell": JsonQueryType<{
      "rotation": type_direction;
    }, {

    }>;
  }>;
  "actions": JsonQueryType<{}, {
    "by":
      | JsonQueryType<{}, {

    }>
      | JsonQueryType<{
      "layer": string;
      "x": number;
      "y": number;
    }, {

    }>;
  }>;
}>