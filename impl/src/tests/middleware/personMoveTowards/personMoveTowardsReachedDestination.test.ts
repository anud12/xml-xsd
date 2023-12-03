import {JsonUtil} from "../../../utils";
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
    <property_metadata>
    </property_metadata>
  
    <race_metadata>
      <entry name="human">
        <vision value="20" inclusive="true"/>
        <movement value="100" inclusive="true"/>
      </entry>
    </race_metadata>
  
    <action_metadata>
    </action_metadata>
  </rule_group>
  <people>
    <person id="Billy">
      <race race_ref="human"/>
      <location x="0" y="0"/>
      <inventory>
        <item ref="Long sword" equipped="hand"/>
      </inventory>
      <command/>
    </person>
  </people>
  <actions>
    <by person="Billy">
      <move_towards x="70" y="70"/>
    </by>
  </actions>
</world_step>`);

    await personMoveTowards({
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
    <property_metadata />
    <race_metadata>
      <entry name="human">
        <vision value="20" inclusive="true" />
        <movement value="100" inclusive="true" />
      </entry>
    </race_metadata>
    <action_metadata />
  </rule_group>
  <people>
    <person id="Billy">
      <race race_ref="human" />
      <location x="70" y="70" />
      <inventory>
        <item ref="Long sword" equipped="hand" />
      </inventory>
      <command />
    </person>
  </people>
  <actions />
</world_step>
`.split("\n").filter((_, index) => index !== 0).join("\n"));
  })
})
