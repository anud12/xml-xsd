import {JsonUtil} from "../../../utils/util";
import {JsonQuery} from "../../../JSONQuery";
import {JsonSchema} from "../../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {eventsMetadata} from "../../../middleware/eventsMetadata";

describe("eventsMetadata create person with inventory", () => {
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
    <race_rule>
      <entry id="race_definition">
        <vision value="1"/>
      </entry>
    </race_rule>
    <item_rule>
      <entry id="item_definition">
        <name>
            <name_token prefix="item"/>
        </name>
        <weight_kg value="0.1"/>
      </entry>
    </item_rule>
    <events_rule>
      <entry id="spawn_human">
        <when>
          <person_action_used action_rule_ref="talk"/>
        </when>
        <then>
          <at origin="self">
            <radius>
              <operation>
                <and do="add" value="1"/>
              </operation>
            </radius>
          </at>
          <create_person>
            <inventory>
              <item item_rule_ref="item_definition">
                <quantity>
                  <operation>
                    <and do="add" value="2"/>
                  </operation>
                </quantity>
              </item>
            </inventory>
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
    <counter value="3" />
    <randomization_table>
      <entry value="2" />
    </randomization_table>
  </world_metadata>
  <rule_group>
    <race_rule>
      <entry id="race_definition">
        <vision value="1" />
      </entry>
    </race_rule>
    <item_rule>
      <entry id="item_definition">
        <name>
          <name_token prefix="item" />
        </name>
        <weight_kg value="0.1" />
      </entry>
    </item_rule>
    <events_rule>
      <entry id="spawn_human">
        <when>
          <person_action_used action_rule_ref="talk" />
        </when>
        <then>
          <at origin="self">
            <radius>
              <operation>
                <and do="add" value="1" />
              </operation>
            </radius>
          </at>
          <create_person>
            <inventory>
              <item item_rule_ref="item_definition">
                <quantity>
                  <operation>
                    <and do="add" value="2" />
                  </operation>
                </quantity>
              </item>
            </inventory>
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
    <person id="0.0">
      <location x="1" y="1" />
      <race race_rule_ref="race_definition" />
      <classifications />
      <inventory>
        <item id="0.1" name="item" />
        <item id="0.2" name="item" />
      </inventory>
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