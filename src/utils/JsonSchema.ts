import {Attribute, Body} from "./middleware";

export type JsonSchema = Body<{
  "?xml": Attribute<{ version, standalone }>,

  world_step: Body<{

    world_metadata: Body<{
      next_world_step: string
    }>,

    status_definitions: Body<{
      property_definition: Attribute<{ name, min, max }>
    }>,

    item_definitions: Body<{
      item: Body<{
        weight_kg: Attribute<{ value }>,
        wearable: Attribute<{ slot }>,
      }>
    }>,

    locations_markov_chain: Body<{
      location_markov_link: Attribute<{ type }> & Body<{
        sibling: Attribute<{ type, position, quantity }>
      }>
    }>,

    quests_markov_chain: Body<{
      quest_markov_link: Attribute<{ type }> & Body<{
        next: Attribute<{ type, quantity }>
        completeCondition: unknown
      }>
    }>,

    people: Body<{
      person: Attribute<{ name }> & Body<{
        location: Attribute<{ x, y }>
        relations: Attribute<{ with }>,
        inventory: Body<{
          item_ref: Attribute<{ type, equipped }>
        }>
      }>
    }>;

    locations: Body<{
      cell: Attribute<{ type, x, y }>,
      grid: unknown[]
    }>,
  }>
}>
