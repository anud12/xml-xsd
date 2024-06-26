import {JsonUtil} from "../../../utils/util";
import {JsonQuery} from "../../../JSONQuery";
import {JsonSchema} from "../../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {personAction} from "../../../middleware/personAction";

describe("personAction" , () => {
  it("should initialize values from property metadata and compute", async () => {
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
      <person_default>
        <and do="add" value="10" />
      </person_default>
    </entry>
    <entry id="health" units="points">
      <person_default>
        <and do="add" value="10" />
      </person_default>
    </entry>
  </property_rule>
  
  <race_rule>
    <entry id="human">
      <movement value="5" inclusive="true"/>
    </entry>
  </race_rule>
  
  <action_rule>
    <person_to_person id="meleeAttack">
        <max_range>
          <operation>
            <and do="add" value="1"/>
          </operation>
      </max_range>
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
  
      <property_mutation property_rule_ref="health" on="target">
        <from participant="self">
          <operation>
            <add_property property_rule_ref="strength"/>
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
    <properties/>
  </person>
  <person id="Bob">
    <race race_rule_ref="human"/>
    <location x="10" y="10"/>
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
        <person_default>
          <and do="add" value="10" />
        </person_default>
      </entry>
      <entry id="health" units="points">
        <person_default>
          <and do="add" value="10" />
        </person_default>
      </entry>
    </property_rule>
    <race_rule>
      <entry id="human">
        <movement value="5" inclusive="true" />
      </entry>
    </race_rule>
    <action_rule>
      <person_to_person id="meleeAttack">
        <max_range>
          <operation>
            <and do="add" value="1" />
          </operation>
        </max_range>
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
        <property_mutation property_rule_ref="health" on="target">
          <from participant="self">
            <operation>
              <add_property property_rule_ref="strength" />
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
      <properties>
        <property property_rule_ref="strength" value="10" />
      </properties>
    </person>
    <person id="Bob">
      <race race_rule_ref="human" />
      <location x="10" y="10" />
      <properties>
        <property property_rule_ref="health" value="15" />
      </properties>
    </person>
  </people>
  <actions />
</world_step>
`.split("\n").filter((_, index) => index !== 0).join("\n"));
  })
})
