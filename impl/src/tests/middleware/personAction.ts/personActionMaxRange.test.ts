import {JsonUtil} from "../../../utils";
import {JsonQuery} from "../../../JSONQuery";
import {JsonSchema} from "../../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {personAction} from "../../../middleware/personAction";

describe("personAction" , () => {
  it("should not compute action if over max range", async () => {
    const query = JsonQuery.fromText<JsonSchema>(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:noNamespaceSchemaLocation="../../../../schema/world_step/world_step.xsd"
>
  <world_metadata>
    <next_world_step>./world_1</next_world_step>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>

  <rule_group>
    <property_metadata>
      <entry name="strength" units="points">
        <default>
          <operation>
            <add value="10"/>
          </operation>
        </default>
      </entry>
      <entry name="health" units="points">
        <default>
          <operation>
            <add value="10"/>
          </operation>
        </default>
      </entry>
    </property_metadata>
  
    <race_metadata>
      <entry name="human">
        <vision value="20" inclusive="true"/>
        <movement value="5" inclusive="true"/>
      </entry>
    </race_metadata>
  
    <action_metadata>
      <person_to_person name="meleeAttack">
        <max_range>
          <operation>
            <add value="1"/>
          </operation>
        </max_range>
        <test>
          <value target="self">
            <operation>
              <add value="3"/>
            </operation>
          </value>
          <expected target="target">
            <operation>
              <add value="3"/>
            </operation>
          </expected>
        </test>
  
        <property_mutation name="health" on="target">
          <from participant="self">
            <operation>
              <add_property_value name="strength"/>
            </operation>
            <operation>
              <divide value="2"/>
            </operation>
          </from>
        </property_mutation>
      </person_to_person>
    </action_metadata>
  </rule_group>
  
  <people>
    <person id="Billy">
      <race race_ref="human"/>
      <location x="10" y="10"/>
      <inventory>
        <item ref="Long sword" equipped="hand"/>
      </inventory>
      <properties/>
    </person>
    <person id="Bob">
      <race race_ref="human"/>
      <location x="12" y="10"/>
      <properties/>
    </person>
  </people>
  <actions>
    <by person="Billy">
      <do action_ref="meleeAttack" to="Bob"/>
    </by>
  </actions>
</world_step>`);

    await personAction({
      util: new JsonUtil(query),
      json: query
    })(query);
    expect(query.serialize()).toBe(`
<world_step
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:noNamespaceSchemaLocation="../../../../schema/world_step/world_step.xsd"
>
  <world_metadata>
    <next_world_step>./world_1</next_world_step>
    <randomization_table>
      <entry value="2" />
    </randomization_table>
  </world_metadata>
  <rule_group>
    <property_metadata>
      <entry name="strength" units="points">
        <default>
          <operation>
            <add value="10" />
          </operation>
        </default>
      </entry>
      <entry name="health" units="points">
        <default>
          <operation>
            <add value="10" />
          </operation>
        </default>
      </entry>
    </property_metadata>
    <race_metadata>
      <entry name="human">
        <vision value="20" inclusive="true" />
        <movement value="5" inclusive="true" />
      </entry>
    </race_metadata>
    <action_metadata>
      <person_to_person name="meleeAttack">
        <max_range>
          <operation>
            <add value="1" />
          </operation>
        </max_range>
        <test>
          <value target="self">
            <operation>
              <add value="3" />
            </operation>
          </value>
          <expected target="target">
            <operation>
              <add value="3" />
            </operation>
          </expected>
        </test>
        <property_mutation name="health" on="target">
          <from participant="self">
            <operation>
              <add_property_value name="strength" />
            </operation>
            <operation>
              <divide value="2" />
            </operation>
          </from>
        </property_mutation>
      </person_to_person>
    </action_metadata>
  </rule_group>
  <people>
    <person id="Billy">
      <race race_ref="human" />
      <location x="10" y="10" />
      <inventory>
        <item ref="Long sword" equipped="hand" />
      </inventory>
      <properties />
    </person>
    <person id="Bob">
      <race race_ref="human" />
      <location x="12" y="10" />
      <properties />
    </person>
  </people>
  <actions />
</world_step>
`.split("\n").filter((_, index) => index !== 0).join("\n"));
  })
})
