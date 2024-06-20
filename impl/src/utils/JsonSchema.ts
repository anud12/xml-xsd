import {JsonQueryType} from "../JsonQueryType";
import {
  group__item_data,
  type__action,
  type__item,
  type__item_selection,
  type__person_selection, type__property_mutation,
  world_step
} from "../world_step.schema";


export type PropertyMutationQueryType = type__property_mutation

export type ItemDataQueryType = group__item_data;

export type ItemQueryType = type__item;

export type SelectItemQueryType = type__item_selection;
export type SelectPersonQueryType = type__person_selection

export type TriggerQueryType = JsonQueryType<{}, {
  person_action_used: JsonQueryType<{ action_rule_ref: string }>
}>

export type GlobalActionQueryType = JsonQueryType<{ id: string }, {}> & type__action;

export type JsonSchema = world_step;