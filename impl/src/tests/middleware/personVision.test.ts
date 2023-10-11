import {personVision} from "../../middleware/personVision";
import {JsonUtil} from "../../utils";
import {JsonQuery} from "../../JSONQuery";
import {JsonSchema} from "../../utils/JsonSchema";
import {describe} from "@jest/globals";

describe("personVision", () => {
  it("create cells based on vision and location manhattan distance", async () => {
    const query = JsonQuery.fromText<JsonSchema>(`<world_step>
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
      <location x="4" y="4"/>
    </person>
  </people>
  <location_layer>
    <cell type="type" x="-1" y="-1"/>
    <cell type="type" x="-1" y="0"/>
    <cell type="type" x="-1" y="1"/>
    <cell type="type" x="0" y="-1"/>
    <cell type="type" x="0" y="0"/>
    <cell type="type" x="0" y="1"/>
    <cell type="type" x="1" y="-1"/>
    <cell type="type" x="1" y="0"/>
    <cell type="type" x="1" y="1"/>
  </location_layer>
</world_step>`);

    await personVision({
      util: new JsonUtil(query),
      json: query
    })({
      util: new JsonUtil(query),
      json: query
    });
    expect(query.serialize()).toBe(`
<world_step>
  <world_metadata>
    <randomization_table>
      <entry value="2" />
    </randomization_table>
  </world_metadata>
  <locations_markov_chain>
    <location_markov_link type="type">
      <sibling type="type" position="all" />
    </location_markov_link>
  </locations_markov_chain>
  <race_metadata>
    <entry name="race_definition">
      <vision value="1" />
    </entry>
  </race_metadata>
  <people>
    <person>
      <race name="race_definition" />
      <location x="4" y="4" />
    </person>
  </people>
  <location_layer>
    <cell type="type" x="-1" y="-1" />
    <cell type="type" x="-1" y="0" />
    <cell type="type" x="-1" y="1" />
    <cell type="type" x="0" y="-1" />
    <cell type="type" x="0" y="0" />
    <cell type="type" x="0" y="1" />
    <cell type="type" x="1" y="-1" />
    <cell type="type" x="1" y="0" />
    <cell type="type" x="1" y="1" />
    <cell type="type" x="0" y="2" />
    <cell type="type" x="1" y="2" />
    <cell type="type" x="2" y="0" />
    <cell type="type" x="2" y="1" />
    <cell type="type" x="2" y="2" />
    <cell type="type" x="1" y="3" />
    <cell type="type" x="2" y="3" />
    <cell type="type" x="3" y="1" />
    <cell type="type" x="3" y="2" />
    <cell type="type" x="3" y="3" />
    <cell type="type" x="2" y="4" />
    <cell type="type" x="3" y="4" />
    <cell type="type" x="4" y="2" />
    <cell type="type" x="4" y="3" />
    <cell type="type" x="4" y="4" />
    <cell type="type" x="3" y="5" />
    <cell type="type" x="4" y="5" />
    <cell type="type" x="5" y="3" />
    <cell type="type" x="5" y="4" />
    <cell type="type" x="5" y="5" />
  </location_layer>
</world_step>
`.split("\n").filter((_, index) => index !== 0).join("\n"));
  })


  it("create cells based on vision and location at 45 degree angle", async () => {
    const query = JsonQuery.fromText<JsonSchema>(`<world_step>
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
      <location x="4" y="8"/>
    </person>
  </people>
  <location_layer>
    <cell type="type" x="-1" y="-1"/>
    <cell type="type" x="-1" y="0"/>
    <cell type="type" x="-1" y="1"/>
    <cell type="type" x="0" y="-1"/>
    <cell type="type" x="0" y="0"/>
    <cell type="type" x="0" y="1"/>
    <cell type="type" x="1" y="-1"/>
    <cell type="type" x="1" y="0"/>
    <cell type="type" x="1" y="1"/>
  </location_layer>
</world_step>`);

    await personVision({
      util: new JsonUtil(query),
      json: query
    })({
      util: new JsonUtil(query),
      json: query
    });
    expect(query.serialize()).toBe(`
<world_step>
  <world_metadata>
    <randomization_table>
      <entry value="2" />
    </randomization_table>
  </world_metadata>
  <locations_markov_chain>
    <location_markov_link type="type">
      <sibling type="type" position="all" />
    </location_markov_link>
  </locations_markov_chain>
  <race_metadata>
    <entry name="race_definition">
      <vision value="1" />
    </entry>
  </race_metadata>
  <people>
    <person>
      <race name="race_definition" />
      <location x="4" y="8" />
    </person>
  </people>
  <location_layer>
    <cell type="type" x="-1" y="-1" />
    <cell type="type" x="-1" y="0" />
    <cell type="type" x="-1" y="1" />
    <cell type="type" x="0" y="-1" />
    <cell type="type" x="0" y="0" />
    <cell type="type" x="0" y="1" />
    <cell type="type" x="1" y="-1" />
    <cell type="type" x="1" y="0" />
    <cell type="type" x="1" y="1" />
    <cell type="type" x="0" y="2" />
    <cell type="type" x="1" y="2" />
    <cell type="type" x="2" y="0" />
    <cell type="type" x="2" y="1" />
    <cell type="type" x="2" y="2" />
    <cell type="type" x="1" y="3" />
    <cell type="type" x="2" y="3" />
    <cell type="type" x="3" y="1" />
    <cell type="type" x="3" y="2" />
    <cell type="type" x="3" y="3" />
    <cell type="type" x="2" y="4" />
    <cell type="type" x="3" y="4" />
    <cell type="type" x="4" y="2" />
    <cell type="type" x="4" y="3" />
    <cell type="type" x="4" y="4" />
    <cell type="type" x="3" y="5" />
    <cell type="type" x="4" y="5" />
    <cell type="type" x="5" y="3" />
    <cell type="type" x="5" y="4" />
    <cell type="type" x="5" y="5" />
    <cell type="type" x="3" y="6" />
    <cell type="type" x="4" y="6" />
    <cell type="type" x="5" y="6" />
    <cell type="type" x="3" y="7" />
    <cell type="type" x="4" y="7" />
    <cell type="type" x="5" y="7" />
    <cell type="type" x="3" y="8" />
    <cell type="type" x="4" y="8" />
    <cell type="type" x="5" y="8" />
    <cell type="type" x="3" y="9" />
    <cell type="type" x="4" y="9" />
    <cell type="type" x="5" y="9" />
  </location_layer>
</world_step>
`.split("\n").filter((_, index) => index !== 0).join("\n"));
  })
})
