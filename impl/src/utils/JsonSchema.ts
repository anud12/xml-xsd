import {JsonQueryType} from "../JsonQueryType";
import {
  type__action, type__node_graph__selection,
  type__person_selection, type__property_mutation,
  world_step
} from "../world_step.schema";


export type PropertyMutationQueryType = type__property_mutation
export type SelectPersonQueryType = type__person_selection

export type TriggerQueryType = JsonQueryType<{}, {
  person_action_used: JsonQueryType<{ action_rule_ref: string }>
}>

export type GlobalActionQueryType = JsonQueryType<{ id: string }, {}> & type__action;

export type JsonSchema = world_step;

export type SelectNodeGraphQueryType = type__node_graph__selection;
