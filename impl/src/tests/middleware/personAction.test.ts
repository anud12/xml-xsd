import {JsonUtil} from "../../utils";
import {JsonQuery} from "../../JSONQuery";
import {JsonSchema} from "../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {personAction} from "../../middleware/personAction";

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
            <range value="1" inclusive="true"/>
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
    <people>
        <person name="Billy">
            <race name="human"/>
            <location x="10" y="10"/>
            <inventory>
                <item ref="Long sword" equipped="hand"/>
            </inventory>
            <properties/>
        </person>
        <person name="Bob">
            <race name="human"/>
            <location x="10" y="10"/>
            <properties/>
        </person>
    </people>
    <actions>
        <by name="Billy">
            <do action="meleeAttack" to="Bob" />
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
      <range value="1" inclusive="true" />
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
  <people>
    <person name="Billy">
      <race name="human" />
      <location x="10" y="10" />
      <inventory>
        <item ref="Long sword" equipped="hand" />
      </inventory>
      <properties>
        <property ref="strength" value="10" />
      </properties>
    </person>
    <person name="Bob">
      <race name="human" />
      <location x="10" y="10" />
      <properties>
        <property ref="health" value="15" />
      </properties>
    </person>
  </people>
  <actions />
</world_step>
`.split("\n").filter((_, index) => index !== 0).join("\n"));
  })
})
