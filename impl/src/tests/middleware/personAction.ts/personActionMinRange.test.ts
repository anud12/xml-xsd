import {JsonUtil} from "../../../utils/util";
import {JsonQuery} from "../../../JSONQuery";
import {JsonSchema} from "../../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {personAction} from "../../../middleware/personAction";

describe("personAction" , () => {
  it("should not compute if under min range", async () => {
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
    <property_rule>
      <entry id="strength" units="points">
        <default>
          <operation>
            <and do="add" value="10"/>
          </operation>
        </default>
      </entry>
      <entry id="health" units="points">
        <default>
          <operation>
            <and do="add" value="10"/>
          </operation>
        </default>
      </entry>
    </property_rule>
  
    <race_rule>
      <entry id="human">
        <vision value="20" inclusive="true"/>
        <movement value="5" inclusive="true"/>
      </entry>
    </race_rule>
  
    <action_rule>
      <person_to_person id="meleeAttack">
        <max_range>
          <operation>
            <and do="add" value="5"/>
          </operation>
        </max_range>
        <min_range>
          <operation>
            <and do="add" value="3"/>
          </operation>
        </min_range>
        <test>
          <value target="self">
            <operation>
              <and do="add" value="3"/>
            </operation>
          </value>
          <expected target="target">
            <operation>
              <and do="add" value="3"/>
            </operation>
          </expected>
        </test>
  
        <property_mutation name="health" on="target">
          <from participant="self">
            <operation>
              <add_property property_rule_ref="strength"/>
            </operation>
            <operation>
              <and do="divide" value="2"/>
            </operation>
          </from>
        </property_mutation>
      </person_to_person>
    </action_rule>
  </rule_group>
  
  <people>
    <person id="Billy">
      <race race_rule_ref="human"/>
      <location x="10" y="10"/>
      <inventory>
        <item ref="Long sword" equipped="hand"/>
      </inventory>
      <properties/>
    </person>
    <person id="Bob">
      <race race_rule_ref="human"/>
      <location x="12" y="10"/>
      <properties/>
    </person>
  </people>
  <actions>
    <by person_ref="Billy">
      <do action_rule_ref="meleeAttack" person_ref="Bob"/>
    </by>
  </actions>
</world_step>`);

    const util = new JsonUtil(query);
    await personAction(util)(util);

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
    <property_rule>
      <entry id="strength" units="points">
        <default>
          <operation>
            <and do="add" value="10" />
          </operation>
        </default>
      </entry>
      <entry id="health" units="points">
        <default>
          <operation>
            <and do="add" value="10" />
          </operation>
        </default>
      </entry>
    </property_rule>
    <race_rule>
      <entry id="human">
        <vision value="20" inclusive="true" />
        <movement value="5" inclusive="true" />
      </entry>
    </race_rule>
    <action_rule>
      <person_to_person id="meleeAttack">
        <max_range>
          <operation>
            <and do="add" value="5" />
          </operation>
        </max_range>
        <min_range>
          <operation>
            <and do="add" value="3" />
          </operation>
        </min_range>
        <test>
          <value target="self">
            <operation>
              <and do="add" value="3" />
            </operation>
          </value>
          <expected target="target">
            <operation>
              <and do="add" value="3" />
            </operation>
          </expected>
        </test>
        <property_mutation name="health" on="target">
          <from participant="self">
            <operation>
              <add_property property_rule_ref="strength" />
            </operation>
            <operation>
              <and do="divide" value="2" />
            </operation>
          </from>
        </property_mutation>
      </person_to_person>
    </action_rule>
  </rule_group>
  <people>
    <person id="Billy">
      <race race_rule_ref="human" />
      <location x="10" y="10" />
      <inventory>
        <item ref="Long sword" equipped="hand" />
      </inventory>
      <properties />
    </person>
    <person id="Bob">
      <race race_rule_ref="human" />
      <location x="12" y="10" />
      <properties />
    </person>
  </people>
  <actions />
</world_step>
`.split("\n").filter((_, index) => index !== 0).join("\n"));
  })
})
