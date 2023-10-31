import {describe} from "@jest/globals";
import {JsonQuery} from "../../../JSONQuery";
import {JsonSchema} from "../../../utils/JsonSchema";
import {classifyPerson} from "../../../utils/person/classifyPerson";
import {JsonUtil} from "../../../utils";

describe("classifyPerson", () => {
  it("return classifications for person only if health is negative", () => {
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
            <has_positive_value>
                <operation>
                    <add_property_value name="health"/>
                </operation>
                <operation>
                    <multiply value="-1"/>
                </operation>
            </has_positive_value>
        </entry>
        <entry name="alive">
            <has_positive_value>
                <operation>
                    <add_property_value name="health"/>
                </operation>
            </has_positive_value>
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
            <command/>
        </person>
    </people>
</world_step>
`);
    const util: JsonUtil = new JsonUtil(query);
    const result = classifyPerson({util, json: query}, query.query("people").query("person"));
    expect(result).toEqual(["dead"]);

  })
})