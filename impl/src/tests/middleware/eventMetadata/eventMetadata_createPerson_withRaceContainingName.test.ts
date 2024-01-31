import {JsonUtil} from "../../../utils/util";
import {JsonQuery} from "../../../JSONQuery";
import {JsonSchema} from "../../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {eventsMetadata} from "../../../middleware/eventsMetadata";

describe("eventsMetadata create person with race containing name", () => {
  it("react to person_action_used and create a person", async () => {
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
  <rule_group>
    <name_rule>
      <entry id="name_metadata">
        <token prefix="bob"/>
      </entry>
    </name_rule>
    <race_rule>
      <entry id="race_definition">
        <name name_rule_ref="name_metadata"/>
        <vision value="1"/>
      </entry>
    </race_rule>
    <events_rule>
      <entry id="spawn_human">
        <when>
          <person_action_used action_rule_ref="talk"/>
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
            <race race_rule_ref="race_definition" quantity="1"/>
          </create_person>
        </then>
      </entry>
    </events_rule>
  </rule_group>
  <people>
    <person name="person">
      <race race_rule_ref="race_definition"/>
      <location x="0" y="0"/>
    </person>
  </people>
  <location_layer>
    <cell x="-1" y="-1"/>
    <cell x="-1" y="0"/>
    <cell x="-1" y="1"/>
    <cell x="0" y="-1"/>
    <cell x="0" y="0"/>
    <cell x="0" y="1"/>
    <cell x="1" y="-1"/>
    <cell x="1" y="0"/>
    <cell x="1" y="1"/>
  </location_layer>
  <actions>
    <by name="person">
      <do action_rule_ref="talk" to="person"/>
    </by>
  </actions>
</world_step>`);

    const util = new JsonUtil(query);
    await eventsMetadata(util)(util);

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
  <rule_group>
    <name_rule>
      <entry id="name_metadata">
        <token prefix="bob" />
      </entry>
    </name_rule>
    <race_rule>
      <entry id="race_definition">
        <name name_rule_ref="name_metadata" />
        <vision value="1" />
      </entry>
    </race_rule>
    <events_rule>
      <entry id="spawn_human">
        <when>
          <person_action_used action_rule_ref="talk" />
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
            <race race_rule_ref="race_definition" quantity="1" />
          </create_person>
        </then>
      </entry>
    </events_rule>
  </rule_group>
  <people>
    <person name="person">
      <race race_rule_ref="race_definition" />
      <location x="0" y="0" />
    </person>
    <person id="0.0" name="bob">
      <location x="1" y="1" />
      <race race_rule_ref="race_definition" />
      <classifications />
    </person>
  </people>
  <location_layer>
    <cell x="-1" y="-1" />
    <cell x="-1" y="0" />
    <cell x="-1" y="1" />
    <cell x="0" y="-1" />
    <cell x="0" y="0" />
    <cell x="0" y="1" />
    <cell x="1" y="-1" />
    <cell x="1" y="0" />
    <cell x="1" y="1" />
  </location_layer>
  <actions>
    <by name="person">
      <do action_rule_ref="talk" to="person" />
    </by>
  </actions>
</world_step>
`.split("\n").filter((_, index) => index !== 0).join("\n"));
  })
})