import {JsonUtil} from "../../../utils/util";
import {JsonQuery} from "../../../JSONQuery";
import {JsonSchema} from "../../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {personMoveTowards} from "../../../middleware/personMoveTowards";

describe("personActionMoveTowardsReachedDestination" , () => {
  it("should compute and remove move action for Billy", async () => {
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
    </property_rule>
  
    <race_rule>
      <entry id="human">
        <vision value="20" inclusive="true"/>
        <movement value="100" inclusive="true"/>
      </entry>
    </race_rule>
  
    <action_rule>
    </action_rule>
  </rule_group>
  <people>
    <person id="Billy">
      <race race_rule_ref="human"/>
      <location x="0" y="0"/>
      <command/>
    </person>
  </people>
  <actions>
    <by person_ref="Billy">
      <move_towards x="70" y="70"/>
    </by>
  </actions>
</world_step>`);

    const util = new JsonUtil(query);
    await personMoveTowards(util)(util);

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
    <property_rule />
    <race_rule>
      <entry id="human">
        <vision value="20" inclusive="true" />
        <movement value="100" inclusive="true" />
      </entry>
    </race_rule>
    <action_rule />
  </rule_group>
  <people>
    <person id="Billy">
      <race race_rule_ref="human" />
      <location x="70" y="70" />
      <command />
    </person>
  </people>
  <actions />
</world_step>
`.split("\n").filter((_, index) => index !== 0).join("\n"));
  })
})
