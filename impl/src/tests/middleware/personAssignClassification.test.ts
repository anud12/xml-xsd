import {JsonQuery} from "../../JSONQuery";
import {JsonSchema} from "../../utils/JsonSchema";
import {JsonUtil} from "../../utils";
import {personAssignClassification} from "../../middleware/personAssignClassification";

describe("personAssignClassification", () => {
  it("return classifications for person only if health is negative", async () => {
    const query = JsonQuery.fromText<JsonSchema>(`<world_step
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:noNamespaceSchemaLocation="../../../../../schema/world_step/world_step.xsd"
>
  <world_metadata>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
    <property_metadata/>
    <classification_metadata>
        <entry name="dead">
            <property name="health" is="lessThan" >
                <operation>
                    <add value="0"/>
                </operation>
            </property>
        </entry>
        <entry name="alive">
            <property name="health" is="greaterThan">
                <operation>
                    <add value="0"/>
                </operation>
            </property>
        </entry>
    </classification_metadata>
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
            <properties>
                <property ref="health" value="-1" />
            </properties>
            <inventory>
                <item ref="Long sword" equipped="hand"/>
            </inventory>
        </person>
    </people>
</world_step>
`);
    const util: JsonUtil = new JsonUtil(query);
    await personAssignClassification({util, json: query})
    (query);
    expect(query.serialize()).toEqual(`<world_step
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:noNamespaceSchemaLocation="../../../../../schema/world_step/world_step.xsd"
>
  <world_metadata>
    <randomization_table>
      <entry value="2" />
    </randomization_table>
  </world_metadata>
  <property_metadata />
  <classification_metadata>
    <entry name="dead">
      <property name="health" is="lessThan">
        <operation>
          <add value="0" />
        </operation>
      </property>
    </entry>
    <entry name="alive">
      <property name="health" is="greaterThan">
        <operation>
          <add value="0" />
        </operation>
      </property>
    </entry>
  </classification_metadata>
  <race_metadata>
    <entry name="human">
      <vision value="20" inclusive="true" />
      <movement value="5" inclusive="true" />
    </entry>
  </race_metadata>
  <people>
    <person name="Billy">
      <race name="human" />
      <location x="10" y="10" />
      <properties>
        <property ref="health" value="-1" />
      </properties>
      <inventory>
        <item ref="Long sword" equipped="hand" />
      </inventory>
      <classification name="dead" />
    </person>
  </people>
</world_step>
`);

  })
})