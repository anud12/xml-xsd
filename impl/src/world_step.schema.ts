import {JsonQueryType} from "./JsonQueryType"
export type group__name_token = JsonQueryType<{}, {
  "name_token": JsonQueryType<{"prefix": string;}, {}> & JsonQueryType<{}, {
      "ref": JsonQueryType<{"name_rule_ref": string;}> & JsonQueryType<{}, {}>;
    }>
    & JsonQueryType<{}, {
      "one_of": group__name_token | any & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
}>
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
export type type__property_mutation_on = JsonQueryType<{"on": type_person_select;}>
  & type__property_mutation
export type type__property_mutation = JsonQueryType<{"property_rule_ref": string;}, {
  "from": JsonQueryType<{"participant": type_person_select;}, {
    "operation": type__math_operations & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
}>
export type type__person_selection = JsonQueryType<{}, {
  "radius": type__math_operations & JsonQueryType<{}, {}>;
  "min": type__math_operations & JsonQueryType<{}, {}>;
  "max": type__math_operations & JsonQueryType<{}, {}>;
  "property": JsonQueryType<{"property_rule_ref": string;}, {
    "min": type__math_operations & JsonQueryType<{}, {}>;
    "max": type__math_operations & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
  "classification": JsonQueryType<{"classification_rule_ref": string;}> & JsonQueryType<{}, {}>;
}>
export type type__trigger = JsonQueryType<{}, {
  "person_action_used": JsonQueryType<{"action_rule_ref": string;}> & JsonQueryType<{}, {}>;
}>
export type type__math_operations_and = JsonQueryType<{}, {
  "add_property": JsonQueryType<{"property_rule_ref": string;}> & JsonQueryType<{}, {}>;
  "and": JsonQueryType<{"do": type__group__operation__and;  "value": string;}>
    & type__math_operations_and | any & JsonQueryType<{}, {}>;
}>
export type type__math_operations = JsonQueryType<{"initial": string;}>
  & type__math_operations_and
export type type__name_token = JsonQueryType<{}, {
  "name_token": JsonQueryType<{"prefix": string;}, {}> & JsonQueryType<{}, {
      "ref": JsonQueryType<{"name_rule_ref": string;}> & JsonQueryType<{}, {}>;
    }>
    & JsonQueryType<{}, {
      "one_of": JsonQueryType<{}>
        & type__name_token | any & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
}>
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
export type type__node_graph__selection = JsonQueryType<{}, {
  "in__location_graph": JsonQueryType<{}, {
    "has__location_graph_id": JsonQueryType<{"location_graph_id_ref": string;}, {
      "or": JsonQueryType<{"location_graph_id_ref": string;}> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
  "has__node_graph_id": JsonQueryType<{"node_graph_id_ref": string;}, {
    "or": JsonQueryType<{"node_graph_id_ref": string;}> & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
}>
export type type__link_to__selection = JsonQueryType<{}, {
  "origin__node_graph__selection": type__node_graph__selection & JsonQueryType<{}, {}>;
  "destination__node_graph__selection": type__node_graph__selection & JsonQueryType<{}, {}>;
}>
export type type__link_group = JsonQueryType<{"id": string;  "angle": string;  "angleMax": string;  "limit": string;}, {
  "to_option": JsonQueryType<{"node_rule_ref": string;  "distance": string;  "maxDistance": string;  "adjacent_depth_limit": string;}, {
    "distance_to_progress_multiplier": type__math_operations & JsonQueryType<{}, {}>;
    "person_progress_property": type__math_operations & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
}>
export type world_step = JsonQueryType<{}, {
  "world_metadata": JsonQueryType<{}, {
    "previous_world_step": JsonQueryType<{"value": string;}> & JsonQueryType<{}, {}>;
    "next_world_step": JsonQueryType<{"value": string;}> & JsonQueryType<{}, {}>;
    "elapsed_time": JsonQueryType<{"value": string;}> & JsonQueryType<{}, {}>;
    "stepDuration": JsonQueryType<{"value": string;}> & JsonQueryType<{}, {}>;
    "counter": JsonQueryType<{"value": string;}> & JsonQueryType<{}, {}>;
    "randomization_table": JsonQueryType<{}, {
      "entry": JsonQueryType<{"value": string;}> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
  "rule_group": JsonQueryType<{"id": any;}, {
    "property_rule": JsonQueryType<{}, {
      "entry": JsonQueryType<{"id": string;  "units": string;}, {
        "person_default": JsonQueryType<{}>
          & type__math_operations & JsonQueryType<{}, {}>;
        "item_default": JsonQueryType<{}>
          & type__math_operations & JsonQueryType<{}, {}>;
        "property-threshold": JsonQueryType<{"name": string;  "min-value-inclusive": string;  "max-value-inclusive": string;}> & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
    "classification_rule": JsonQueryType<{}, {
      "entry": JsonQueryType<{"id": string;}, {
        "property": JsonQueryType<{"property_rule_ref": string;  "is": "lessThan" | "lessThanOrEqual" | "greaterThan" | "greaterThanOrEqual" | "equal";}, {
          "operation": type__math_operations & JsonQueryType<{}, {}>;
        }> & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
    "name_rule": JsonQueryType<{}, {
      "entry": JsonQueryType<{"id": string;}>
        & type__name_token & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
    "action_rule": JsonQueryType<{}, {
      "from_person": JsonQueryType<{"id": string;}, {
        "selection": type__person_selection & JsonQueryType<{}, {}>;
        "mutations": JsonQueryType<{}, {
          "property_mutation": type__property_mutation & JsonQueryType<{}, {}>;
        }> & JsonQueryType<{}, {}>;
        "on_person": JsonQueryType<{}, {
          "selection": JsonQueryType<{}, {
            "from_person_same_location_graph_node": JsonQueryType<{"value": string;}> & JsonQueryType<{}, {}>;
          }>
            & type__person_selection & JsonQueryType<{}, {}>;
          "mutations": JsonQueryType<{}, {
            "property_mutation": type__property_mutation & JsonQueryType<{}, {}>;
          }> & JsonQueryType<{}, {}>;
        }> & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
      "global": JsonQueryType<{}, {
        "entry": JsonQueryType<{"id": string;}>
          & type__action & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
    "events_rule": JsonQueryType<{}, {
      "entry": JsonQueryType<{"id": string;}, {
        "when": type__trigger & JsonQueryType<{}, {}>;
        "then": JsonQueryType<{}, {
          "select_person": JsonQueryType<{"origin": "target" | "self";}>
            & type__person_selection & JsonQueryType<{}, {}>;
          "property_mutation": JsonQueryType<{"property_rule_ref": string;}>
            & type__math_operations & JsonQueryType<{}, {}>;
        }> & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
    "link_group_rule_list": JsonQueryType<{}, {
      "link_group_rule": JsonQueryType<{}>
        & type__link_group & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
    "location_graph_rule": JsonQueryType<{"id": string;}, {
      "setup": JsonQueryType<{}, {
        "starting_node": JsonQueryType<{"node_rule_ref": string;}> & JsonQueryType<{}, {}>;
        "necessary_node": JsonQueryType<{"node_rule_ref": string;  "min": string;  "max": string;}, {
          "or": JsonQueryType<{"node_rule_ref": string;}> & JsonQueryType<{}, {}>;
        }> & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
      "node_rule": JsonQueryType<{"id": string;}, {
        "name": JsonQueryType<{"name_rule_ref": string;}> & JsonQueryType<{}, {}>;
        "classifications": JsonQueryType<{}, {
          "classification": JsonQueryType<{"location_classification_rule_ref": string;}> & JsonQueryType<{}, {}>;
        }> & JsonQueryType<{}, {}>;
        "link_group_list": JsonQueryType<{}, {
          "reference": JsonQueryType<{"link_group_rule_ref": string;}> & JsonQueryType<{}, {}>;
          "link_group": JsonQueryType<{}>
            & type__link_group & JsonQueryType<{}, {}>;
        }> & JsonQueryType<{}, {}>;
        "existing_person": JsonQueryType<{"min": string;  "max": string;}, {
          "person_selection": type__person_selection & JsonQueryType<{}, {}>;
        }> & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
    "location_classification_rule": JsonQueryType<{}, {
      "entry": JsonQueryType<{"id": string;}> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
  "data": JsonQueryType<{}, {
    "people": JsonQueryType<{}, {
      "person": JsonQueryType<{"id": string;  "name": string;}, {
        "properties": JsonQueryType<{}, {
          "property": JsonQueryType<{"property_rule_ref": string;  "value": string;}> & JsonQueryType<{}, {}>;
        }> & JsonQueryType<{}, {}>;
        "relations": JsonQueryType<{"with": any;}> & JsonQueryType<{}, {}>;
        "classifications": JsonQueryType<{}, {
          "classification": JsonQueryType<{"classification_rule_ref": string;}> & JsonQueryType<{}, {}>;
        }> & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
    "location": JsonQueryType<{}, {
      "location_graph": JsonQueryType<{"id": string;}, {
        "rule": JsonQueryType<{"location_graph_rule_ref": string;}> & JsonQueryType<{}, {}>;
        "node": JsonQueryType<{"node_rule_ref": string;  "id": string;}, {
          "name": JsonQueryType<{"value": string;}> & JsonQueryType<{}, {}>;
          "position": JsonQueryType<{"x": string;  "y": string;}> & JsonQueryType<{}, {}>;
          "classifications": JsonQueryType<{}, {
            "classification": JsonQueryType<{"location_classification_rule_ref": string;}> & JsonQueryType<{}, {}>;
          }> & JsonQueryType<{}, {}>;
          "links": JsonQueryType<{}, {
            "link_to": JsonQueryType<{"node_id_ref": string;  "total_progress": string;}, {
              "people": JsonQueryType<{}, {
                "person": JsonQueryType<{"person_id_ref": string;  "accumulated_progress": string;}> & JsonQueryType<{}, {}>;
              }> & JsonQueryType<{}, {}>;
              "person_progress_property": type__math_operations & JsonQueryType<{}, {}>;
            }> & JsonQueryType<{}, {}>;
          }> & JsonQueryType<{}, {}>;
          "people": JsonQueryType<{}, {
            "person": JsonQueryType<{"person_id_ref": string;}> & JsonQueryType<{}, {}>;
          }> & JsonQueryType<{}, {}>;
        }> & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
  "actions": JsonQueryType<{}, {
    "by": JsonQueryType<{"person_ref": string;}, {}> & JsonQueryType<{}, {
        "do": JsonQueryType<{"action_rule_ref": string;  "action_ref": string;  "person_ref": string;}> & JsonQueryType<{}, {}>;
      }>
      & JsonQueryType<{}, {
        "move_towards": JsonQueryType<{"layer": string;  "x": string;  "y": string;}> & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
    "location_graph.create": JsonQueryType<{"location_graph_rule_ref": string;}> & JsonQueryType<{}, {}>;
    "location_graph.node.create_adjacent": JsonQueryType<{"location_graph_id_ref": string;  "node_id_ref": string;}> & JsonQueryType<{}, {}>;
    "location_graph.node.add_classification": JsonQueryType<{}, {
      "node_graph_selection": type__node_graph__selection & JsonQueryType<{}, {}>;
      "to_be_added__classification": JsonQueryType<{"location_classification_rule_ref": string;}, {
        "and": JsonQueryType<{"location_classification_rule_ref": string;}> & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
    "person.teleport": JsonQueryType<{"person_id_ref": string;}, {}> & JsonQueryType<{}, {
        "location_graph": JsonQueryType<{"location_graph_id_ref": string;  "node_id_ref": string;}> & JsonQueryType<{}, {}>;
      }>
      & JsonQueryType<{}, {
        "link_to": JsonQueryType<{"accumulated_progress": string;}, {
          "selection": type__link_to__selection & JsonQueryType<{}, {}>;
        }> & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
    "person.on_person.property_mutation": JsonQueryType<{"person_id_ref": string;  "target_person_id_ref": string;  "action_property_mutation_rule_ref": string;}> & JsonQueryType<{}, {}>;
    "person.create": JsonQueryType<{}, {
      "node_graph__selection": type__node_graph__selection & JsonQueryType<{}, {}>;
      "person__selection": type__person_selection & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
    "person.move_to": JsonQueryType<{"person_id_ref": string;}, {
      "find_path_towards": type__node_graph__selection & JsonQueryType<{}, {}>;
      "path": JsonQueryType<{}, {
        "node": JsonQueryType<{"node_id_ref": string;}> & JsonQueryType<{}, {}>;
      }> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
    "from_person": JsonQueryType<{"person_id_ref": string;  "from_person_rule_ref": string;}, {
      "on_person": JsonQueryType<{"person_id_ref": string;}> & JsonQueryType<{}, {}>;
    }> & JsonQueryType<{}, {}>;
  }> & JsonQueryType<{}, {}>;
}>