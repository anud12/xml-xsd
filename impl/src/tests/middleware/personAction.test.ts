import {JsonUtil} from "../../utils";
import {JsonQuery} from "../../JSONQuery";
import {JsonSchema} from "../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {personAction} from "../../middleware/personAction";

describe("personAction" , () => {
  it("create cells based on vision and location manhattan distance", async () => {
    const query = JsonQuery.fromText<JsonSchema>(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:noNamespaceSchemaLocation="schema/world_step/world_step.xsd"
>
    <world_metadata>
        <next_world_step>./world_1</next_world_step>
        <randomization_table>
            <entry value="2"/>
        </randomization_table>
    </world_metadata>
    
    <property_metadata>
        <entry name="athletics" units="points">
            <default>
                <operation>
                    <add_dice value="6"/>
                </operation>
                <operation>
                    <add value="-1"/>
                </operation>
            </default>
        </entry>
        <entry name="strength" units="points">
            <default>
                <operation>
                    <add_dice value="12"/>
                </operation>
                <operation>
                    <add value="8"/>
                </operation>
            </default>
        </entry>
        <entry name="constitution" units="points">
            <default>
                <operation>
                    <add_dice value="12"/>
                </operation>
                <operation>
                    <add value="8"/>
                </operation>
            </default>
        </entry>
    </property_metadata>
    
    <race_metadata>
        <entry name="human">
            <vision value="20" inclusive="true"/>
            <movement value="5" inclusive="true"/>
            <property_bonus ref="strength">
                <operation>
                    <add_dice value="3"/>
                </operation>
                <operation>
                    <add value="-1"/>
                </operation>
            </property_bonus>
            <property_bonus ref="constitution">
                <operation>
                    <add_dice value="3"/>
                </operation>
                <operation>
                    <add value="-1"/>
                </operation>
            </property_bonus>
        </entry>
    </race_metadata>
    
    <action_metadata>
        <person_entry name="meleeAttack">
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

            <property_mutation name="health" target="target">
                <operation>
                    <add_dice value="6"/>
                </operation>
                <operation>
                    <add value="6"/>
                </operation>
                <operation>
                    <group>
                        <operation>
                            <add_property_value name="strength"/>
                        </operation>
                        <operation>
                            <add value="-10"/>
                        </operation>
                        <operation>
                            <divide value="2"/>
                        </operation>
                    </group>
                </operation>
            </property_mutation>
        </person_entry>
    </action_metadata>
    <people>
        <person name="Billy">
            <race name="human"/>
            <location x="10" y="10"/>
            <inventory>
                <item ref="Long sword" equipped="hand"/>
            </inventory>
            <command/>
        </person>
        <person name="Bob">
            <race name="human"/>
            <location x="10" y="10"/>
            <command></command>
        </person>
    </people>
    <action>
        <person_action ref="meleeAttack" name="Billy" target_name="Bob"/>
    </action>
</world_step>`);

    await personAction({
      util: new JsonUtil(query),
      json: query
    })({
      util: new JsonUtil(query),
      json: query
    });
/*    expect(query.serialize()).toBe(`
<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:noNamespaceSchemaLocation="schema/world_step/world_step.xsd"
>
    <world_metadata>
        <next_world_step>./world_1</next_world_step>
        <randomization_table>
            <entry value="2"/>
        </randomization_table>
    </world_metadata>

    <property_metadata>
        <entry name="athletics" default="0" value="0" max_value="5" inclusive="true"/>
        <entry name="strength" default="10" value="8" max_value="20" inclusive="true"/>
        <entry name="constitution" default="10" value="8" max_value="20" inclusive="true"/>
    </property_metadata>

    <race_metadata>
        <entry name="human">
            <vision value="20" inclusive="true"/>
            <movement value="5" inclusive="true"/>
            <property_bonus type="strength" value="0" max_value="2" inclusive="true"/>
            <property_bonus type="constitution" value="3" inclusive="true"/>
        </entry>
    </race_metadata>

    <action_metadata>
        <person_entry name="meleeAttack">
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

            <property_mutation name="health" target="target">
                <operation>
                    <add_dice value="6d"/>
                </operation>
                <operation>
                    <group>
                        <operation>
                            <add_property_value name="strength"/>
                        </operation>
                        <operation>
                            <add value="-10"/>
                        </operation>
                        <operation>
                            <divide value="2"/>
                        </operation>
                    </group>
                </operation>
            </property_mutation>
        </person_entry>
    </action_metadata>
    <people>
        <person name="Billy">
            <race name="human"/>
            <location x="10" y="10"/>
            <inventory>
                <item ref="Long sword" equipped="hand"/>
            </inventory>
            <command/>
        </person>
        <person name="Bob">
            <race name="human"/>
            <location x="10" y="10"/>
            <command></command>
        </person>
    </people>
</world_step>
`.split("\n").filter((_, index) => index !== 0).join("\n"));*/
  })
})
