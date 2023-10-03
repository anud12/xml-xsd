import {personVision} from "./personVision";
import {JsonSchema} from "../utils/JsonSchema";
import {JsonUtil} from "../utils";

const json: JsonSchema = {
  world_step: [{
    world_metadata: [{
      randomization_table: [{
        entry: [{
          $: {value: "2"}
        }]
      }]
    }],
    locations_markov_chain: [{
      location_markov_link: [{
        $: {type: "type"},
        sibling: [
          {$: {type: "type", position: "all"}}
        ]
      }]
    }],
    race_metadata: [{
      entry: [{
        $: {
          name: "race_definition"
        },
        vision: [{
          $: {value: "1"}
        }]
      }]
    }],
    people: [{
      person: [{
        race: [{
          $: {
            name: "race_definition"
          }
        }],
        location: [{
          $: {y: "4", x: "4"}
        }]
      }]
    }],
    location_layer: [{
      cell: [
        {
          $: {y: "-1", type: "type", x: "-1"},
        },
        {
          $: {y: "-1", type: "type", x: "0"},
        },
        {
          $: {y: "-1", type: "type", x: "1"},
        },
        {
          $: {y: "0", type: "type", x: "-1"},
        },
        {
          $: {y: "0", type: "type", x: "0"},
        },
        {
          $: {y: "0", type: "type", x: "1"},
        },
        {
          $: {y: "1", type: "type", x: "-1"},
        },
        {
          $: {y: "1", type: "type", x: "0"},
        },
        {
          $: {y: "1", type: "type", x: "1"},
        },
      ]
    }]
  }]
};
it("create cells based on vision and location", async () => {
  let result = json;
  await personVision(new JsonUtil(json))(result);
  expect(new JsonUtil(result).writeToString()).toBe(expectedResult);
})

const expectedResult = `
<world_step>
  <world_metadata>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <locations_markov_chain>
    <location_markov_link type="type">
      <sibling type="type" position="all"/>
    </location_markov_link>
  </locations_markov_chain>
  <race_metadata>
    <entry name="race_definition">
      <vision value="1"/>
    </entry>
  </race_metadata>
  <people>
    <person>
      <race name="race_definition"/>
      <location y="4" x="4"/>
    </person>
  </people>
  <location_layer>
    <cell y="-1" type="type" x="-1"/>
    <cell y="-1" type="type" x="0"/>
    <cell y="-1" type="type" x="1"/>
    <cell y="0" type="type" x="-1"/>
    <cell y="0" type="type" x="0"/>
    <cell y="0" type="type" x="1"/>
    <cell y="1" type="type" x="-1"/>
    <cell y="1" type="type" x="0"/>
    <cell y="1" type="type" x="1"/>
    <cell type="type" y="0" x="2"/>
    <cell type="type" y="1" x="2"/>
    <cell type="type" y="2" x="0"/>
    <cell type="type" y="2" x="1"/>
    <cell type="type" y="2" x="2"/>
    <cell type="type" y="1" x="3"/>
    <cell type="type" y="2" x="3"/>
    <cell type="type" y="3" x="1"/>
    <cell type="type" y="3" x="2"/>
    <cell type="type" y="3" x="3"/>
    <cell type="type" y="2" x="4"/>
    <cell type="type" y="3" x="4"/>
    <cell type="type" y="4" x="2"/>
    <cell type="type" y="4" x="3"/>
    <cell type="type" y="4" x="4"/>
    <cell type="type" y="3" x="5"/>
    <cell type="type" y="4" x="5"/>
    <cell type="type" y="5" x="3"/>
    <cell type="type" y="5" x="4"/>
    <cell type="type" y="5" x="5"/>
  </location_layer>
</world_step>
`.split("\n").filter((_, index) => index !== 0).join("\n")