import {schema, type} from "./should_correctly_handle_recursive_types";

export const testCases = [
  require("./should_correctly_handle_primitive_types"),
  require("./should_correctly_handle_recursive_types"),
  require("./should_correctly_handle_recursive_types_with_mixed_levels_of_depth"),
  require("./should_handle_complexType_extending_complexType"),
]