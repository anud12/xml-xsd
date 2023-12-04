import {JsonUtil} from "../../../utils";
import {JsonQuery} from "../../../JSONQuery";
import {JsonSchema} from "../../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {personMoveTowards} from "../../../middleware/personMoveTowards";
import {personAction} from "../../../middleware/personAction";

describe("personActionMoveTowards" , () => {
  it("should compute", async () => {
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
    <person name="Billy">
      <race race_ref="human"/>
      <location x="0" y="0"/>
      <inventory>
        <item ref="Long sword" equipped="hand"/>
      </inventory>
      <command/>
    </person>
  </people>
  <actions>
    <by name="Billy">
      <move_towards x="1000" y="1000"/>
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
    <person name="Billy">
      <race race_ref="human" />
      <location x="70" y="70" />
      <inventory>
        <item ref="Long sword" equipped="hand" />
      </inventory>
      <command />
    </person>
  </people>
  <actions>
    <by name="Billy">
      <move_towards x="1000" y="1000" />
    </by>
  </actions>
</world_step>
`.split("\n").filter((_, index) => index !== 0).join("\n"));
  })
})
