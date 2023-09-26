import {Attribute, Body} from "./middleware";

export type JsonSchema = Body<{
    "?xml": Attribute<{ version, standalone }>,

    world_step: Body<{

        world_metadata: Body<{
            next_world_step: string
        }>,

        property_metadata: Body<{
            entry: Attribute<{ name, default, value, max_value }>
        }>,
        race_metadata: Body<{
            entry: Attribute<{ name }> & Body<{
                vision: Attribute<{ value }>
                movement: Attribute<{ value }>
                property_bonus: Attribute<{ name, value, max_value }>
            }>
        }>
        item_metadata: Body<{
            entry: Attribute<{ name }> & Body<{
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
                race: Attribute<{ name }>,
                location: Attribute<{ x, y }>
                relations: Attribute<{ with }>,
                inventory: Body<{
                    item: Attribute<{ ref, equipped }>
                }>
            }>
        }>;

        location_layer: Attribute<{ name }> & Body<{
            cell: Attribute<{ type, x, y }>,
        }>,
    }>
}>
