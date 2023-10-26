import {describe, expect} from "@jest/globals";
import {JsonQuery} from "../../../JSONQuery";
import {JsonSchema} from "../../../utils/JsonSchema";
import {getProperty} from "../../../utils/person/getProperty";
import {JsonUtil} from "../../../utils";

describe("getProperty", () => {
  it("add unset property that depends on another property", async () => {
    const query = JsonQuery.fromText<JsonSchema>(`<world_step
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:noNamespaceSchemaLocation="../../../../../schema/world_step/world_step.xsd"
>
  <world_metadata>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
    <property_metadata>
        <entry name="constitution" units="points">
            <default>
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
            <property_bonus ref="constitution">
                <operation>
                    <add_dice value="3"/>
                </operation>
                <operation>
                    <add value="-1"/>
                </operation>
            </property_bonus>
            <property_bonus ref="health">
                <operation>
                    <add_property_value name="constitution"/>
                </operation>
                <operation>
                    <multiply value="2"/>
                </operation>
            </property_bonus>
        </entry>
    </race_metadata>
    <people>
        <person name="Billy">
            <race name="human"/>
            <location x="10" y="10"/>
            <properties/>
            <inventory>
                <item ref="Long sword" equipped="hand"/>
            </inventory>
            <command/>
        </person>
    </people>
</world_step>`);

    const value = getProperty({
        util: new JsonUtil(query),
        json: query
      },
      query.query("people").query("person"),
      "health"
    );
    expect(value).toBe("20");
    expect(query.serialize()).toBe(`
<world_step
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:noNamespaceSchemaLocation="../../../../../schema/world_step/world_step.xsd"
>
  <world_metadata>
    <randomization_table>
      <entry value="2" />
    </randomization_table>
  </world_metadata>
  <property_metadata>
    <entry name="constitution" units="points">
      <default>
        <operation>
          <add value="8" />
        </operation>
      </default>
    </entry>
  </property_metadata>
  <race_metadata>
    <entry name="human">
      <vision value="20" inclusive="true" />
      <movement value="5" inclusive="true" />
      <property_bonus ref="constitution">
        <operation>
          <add_dice value="3" />
        </operation>
        <operation>
          <add value="-1" />
        </operation>
      </property_bonus>
      <property_bonus ref="health">
        <operation>
          <add_property_value name="constitution" />
        </operation>
        <operation>
          <multiply value="2" />
        </operation>
      </property_bonus>
    </entry>
  </race_metadata>
  <people>
    <person name="Billy">
      <race name="human" />
      <location x="10" y="10" />
      <properties>
        <property ref="constitution" value="10" />
        <property ref="health" value="20" />
      </properties>
      <inventory>
        <item ref="Long sword" equipped="hand" />
      </inventory>
      <command />
    </person>
  </people>
</world_step>
`.split("\n").filter((_, index) => index !== 0).join("\n"));
  })


  it("fails when no property is found", async () => {
    const query = JsonQuery.fromText<JsonSchema>(`<world_step
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:noNamespaceSchemaLocation="../../../../../schema/world_step/world_step.xsd"
>
  <world_metadata>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
    <property_metadata>
    </property_metadata>
  <race_metadata>
      <entry name="human">
          <vision value="20" inclusive="true"/>
          <movement value="5" inclusive="true"/>
      </entry>
  </race_metadata>
  <people>
    <person name="Billy">
      <race name="human"/>
      <location x="10" y="10"/>
      <properties/>
      <inventory>
          <item ref="Long sword" equipped="hand"/>
      </inventory>
      <command/>
    </person>
  </people>
</world_step>`);

    try {
      getProperty({
          util: new JsonUtil(query),
          json: query
        },
        query.query("people").query("person"),
        "health"
      );
      throw new Error("")
    } catch (e) {
      expect(e.message).toBe("getProperty of health failed for //people[0]/person[0]")
    }
  })
})
