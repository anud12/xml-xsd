import {personVision} from "../../middleware/personVision";
import {JsonUtil} from "../../utils/util";
import {JsonQuery} from "../../JSONQuery";
import {JsonSchema} from "../../utils/JsonSchema";
import {describe} from "@jest/globals";

describe("personVision", () => {
  it("create cells based on vision and location manhattan distance", async () => {
    const query = JsonQuery.fromText<JsonSchema>(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:noNamespaceSchemaLocation="../../../../schema/world_step/world_step.xsd"
>
  <world_metadata>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group>
    <locations_markov_chain>
      <location_markov_link type="type">
        <sibling location_ref="type" position="all"/>
      </location_markov_link>
    </locations_markov_chain>
    <race_metadata>
      <entry name="race_definition">
        <vision value="1"/>
      </entry>
    </race_metadata>
  </rule_group>
  <people>
    <person>
      <race race_ref="race_definition"/>
      <location x="4" y="4"/>
    </person>
  </people>
  <location_layer>
    <cell location_ref="type" x="-1" y="-1"/>
    <cell location_ref="type" x="-1" y="0"/>
    <cell location_ref="type" x="-1" y="1"/>
    <cell location_ref="type" x="0" y="-1"/>
    <cell location_ref="type" x="0" y="0"/>
    <cell location_ref="type" x="0" y="1"/>
    <cell location_ref="type" x="1" y="-1"/>
    <cell location_ref="type" x="1" y="0"/>
    <cell location_ref="type" x="1" y="1"/>
  </location_layer>
</world_step>`);


    const util = new JsonUtil(query);
    await personVision(util)(util);

    expect(query.serialize()).toBe(`
<world_step
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:noNamespaceSchemaLocation="../../../../schema/world_step/world_step.xsd"
>
  <world_metadata>
    <randomization_table>
      <entry value="2" />
    </randomization_table>
  </world_metadata>
  <rule_group>
    <locations_markov_chain>
      <location_markov_link type="type">
        <sibling location_ref="type" position="all" />
      </location_markov_link>
    </locations_markov_chain>
    <race_metadata>
      <entry name="race_definition">
        <vision value="1" />
      </entry>
    </race_metadata>
  </rule_group>
  <people>
    <person>
      <race race_ref="race_definition" />
      <location x="4" y="4" />
    </person>
  </people>
  <location_layer>
    <cell location_ref="type" x="-1" y="-1" />
    <cell location_ref="type" x="-1" y="0" />
    <cell location_ref="type" x="-1" y="1" />
    <cell location_ref="type" x="0" y="-1" />
    <cell location_ref="type" x="0" y="0" />
    <cell location_ref="type" x="0" y="1" />
    <cell location_ref="type" x="1" y="-1" />
    <cell location_ref="type" x="1" y="0" />
    <cell location_ref="type" x="1" y="1" />
    <cell location_ref="type" x="0" y="2" />
    <cell location_ref="type" x="1" y="2" />
    <cell location_ref="type" x="2" y="0" />
    <cell location_ref="type" x="2" y="1" />
    <cell location_ref="type" x="2" y="2" />
    <cell location_ref="type" x="1" y="3" />
    <cell location_ref="type" x="2" y="3" />
    <cell location_ref="type" x="3" y="1" />
    <cell location_ref="type" x="3" y="2" />
    <cell location_ref="type" x="3" y="3" />
    <cell location_ref="type" x="2" y="4" />
    <cell location_ref="type" x="3" y="4" />
    <cell location_ref="type" x="4" y="2" />
    <cell location_ref="type" x="4" y="3" />
    <cell location_ref="type" x="4" y="4" />
    <cell location_ref="type" x="3" y="5" />
    <cell location_ref="type" x="4" y="5" />
    <cell location_ref="type" x="5" y="3" />
    <cell location_ref="type" x="5" y="4" />
    <cell location_ref="type" x="5" y="5" />
  </location_layer>
</world_step>
`.split("\n").filter((_, index) => index !== 0).join("\n"));
  })


  it("create cells based on vision and location at 45 degree angle", async () => {
    const query = JsonQuery.fromText<JsonSchema>(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:noNamespaceSchemaLocation="../../../../schema/world_step/world_step.xsd"
>
  <world_metadata>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group>
    <locations_markov_chain>
      <location_markov_link type="type">
        <sibling location_ref="type" position="all"/>
      </location_markov_link>
    </locations_markov_chain>
    <race_metadata>
      <entry name="race_definition">
        <vision value="1"/>
      </entry>
    </race_metadata>
  </rule_group>
  <people>
    <person>
      <race race_ref="race_definition"/>
      <location x="4" y="8"/>
    </person>
  </people>
  <location_layer>
    <cell location_ref="type" x="-1" y="-1"/>
    <cell location_ref="type" x="-1" y="0"/>
    <cell location_ref="type" x="-1" y="1"/>
    <cell location_ref="type" x="0" y="-1"/>
    <cell location_ref="type" x="0" y="0"/>
    <cell location_ref="type" x="0" y="1"/>
    <cell location_ref="type" x="1" y="-1"/>
    <cell location_ref="type" x="1" y="0"/>
    <cell location_ref="type" x="1" y="1"/>
  </location_layer>
</world_step>`);


    const util = new JsonUtil(query);
    await personVision(util)(util);
    expect(query.serialize()).toBe(`
<world_step
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:noNamespaceSchemaLocation="../../../../schema/world_step/world_step.xsd"
>
  <world_metadata>
    <randomization_table>
      <entry value="2" />
    </randomization_table>
  </world_metadata>
  <rule_group>
    <locations_markov_chain>
      <location_markov_link type="type">
        <sibling location_ref="type" position="all" />
      </location_markov_link>
    </locations_markov_chain>
    <race_metadata>
      <entry name="race_definition">
        <vision value="1" />
      </entry>
    </race_metadata>
  </rule_group>
  <people>
    <person>
      <race race_ref="race_definition" />
      <location x="4" y="8" />
    </person>
  </people>
  <location_layer>
    <cell location_ref="type" x="-1" y="-1" />
    <cell location_ref="type" x="-1" y="0" />
    <cell location_ref="type" x="-1" y="1" />
    <cell location_ref="type" x="0" y="-1" />
    <cell location_ref="type" x="0" y="0" />
    <cell location_ref="type" x="0" y="1" />
    <cell location_ref="type" x="1" y="-1" />
    <cell location_ref="type" x="1" y="0" />
    <cell location_ref="type" x="1" y="1" />
    <cell location_ref="type" x="0" y="2" />
    <cell location_ref="type" x="1" y="2" />
    <cell location_ref="type" x="2" y="0" />
    <cell location_ref="type" x="2" y="1" />
    <cell location_ref="type" x="2" y="2" />
    <cell location_ref="type" x="1" y="3" />
    <cell location_ref="type" x="2" y="3" />
    <cell location_ref="type" x="3" y="1" />
    <cell location_ref="type" x="3" y="2" />
    <cell location_ref="type" x="3" y="3" />
    <cell location_ref="type" x="2" y="4" />
    <cell location_ref="type" x="3" y="4" />
    <cell location_ref="type" x="4" y="2" />
    <cell location_ref="type" x="4" y="3" />
    <cell location_ref="type" x="4" y="4" />
    <cell location_ref="type" x="3" y="5" />
    <cell location_ref="type" x="4" y="5" />
    <cell location_ref="type" x="5" y="3" />
    <cell location_ref="type" x="5" y="4" />
    <cell location_ref="type" x="5" y="5" />
    <cell location_ref="type" x="3" y="6" />
    <cell location_ref="type" x="4" y="6" />
    <cell location_ref="type" x="5" y="6" />
    <cell location_ref="type" x="3" y="7" />
    <cell location_ref="type" x="4" y="7" />
    <cell location_ref="type" x="5" y="7" />
    <cell location_ref="type" x="3" y="8" />
    <cell location_ref="type" x="4" y="8" />
    <cell location_ref="type" x="5" y="8" />
    <cell location_ref="type" x="3" y="9" />
    <cell location_ref="type" x="4" y="9" />
    <cell location_ref="type" x="5" y="9" />
  </location_layer>
</world_step>
`.split("\n").filter((_, index) => index !== 0).join("\n"));
  })
})
