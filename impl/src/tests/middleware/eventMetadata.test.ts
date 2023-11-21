import {personVision} from "../../middleware/personVision";
import {JsonUtil} from "../../utils";
import {JsonQuery} from "../../JSONQuery";
import {JsonSchema} from "../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {eventsMetadata} from "../../middleware/eventsMetadata";

describe("eventsMetadata", () => {
  it("react to person_action_used abd create a person", async () => {
    const query = JsonQuery.fromText<JsonSchema>(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:noNamespaceSchemaLocation="../../../../schema/world_step/world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <events_metadata>
    <entry name="spawn_human">
      <when>
        <person_action_used type="talk"/>
      </when>
      <then>
        <at origin="self">
          <radius>
            <operation>
              <add value="1"/>
            </operation>
          </radius>
        </at>
        <create_person>
          <race name="race_definition" quantity="1"/>
        </create_person>
      </then>
    </entry>
    </events_metadata>
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
    <person name="person">
      <race name="race_definition"/>
      <location x="0" y="0"/>
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
  <actions>
    <by name="person">
      <do action="talk" to="person"/>
    </by>
  </actions>
</world_step>`);

    await eventsMetadata({
      util: new JsonUtil(query),
      json: query
    })(query);
    expect(query.serialize()).toBe(`
<world_step
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:noNamespaceSchemaLocation="../../../../schema/world_step/world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0" />
    <counter value="1" />
    <randomization_table>
      <entry value="2" />
    </randomization_table>
  </world_metadata>
  <events_metadata>
    <entry name="spawn_human">
      <when>
        <person_action_used type="talk" />
      </when>
      <then>
        <at origin="self">
          <radius>
            <operation>
              <add value="1" />
            </operation>
          </radius>
        </at>
        <create_person>
          <race name="race_definition" quantity="1" />
        </create_person>
      </then>
    </entry>
  </events_metadata>
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
    <person name="person">
      <race name="race_definition" />
      <location x="0" y="0" />
    </person>
    <person id="0.0">
      <location x="10" y="10" />
      <race name="race_definition" />
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
  </location_layer>
  <actions>
    <by name="person">
      <do action="talk" to="person" />
    </by>
  </actions>
</world_step>
`.split("\n").filter((_, index) => index !== 0).join("\n"));
  })
})