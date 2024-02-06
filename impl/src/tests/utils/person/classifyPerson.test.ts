import {describe} from "@jest/globals";
import {JsonQuery} from "../../../JSONQuery";
import {JsonSchema} from "../../../utils/JsonSchema";
import {classifyPerson} from "../../../utils/person/classifyPerson";
import {JsonUtil} from "../../../utils/util";

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
  <rule_group>
    <property_rule/>
    <classification_rule>
      <entry id="dead">
        <property property_rule_ref="health" is="lessThan" >
          <operation initial="0">
            <and do="add" value="0"/>
          </operation>
        </property>
      </entry>
      <entry id="alive">
        <property property_rule_ref="health" is="greaterThan">
         <operation initial="0">
            <and do="add" value="0"/>
          </operation>
        </property>
      </entry>
    </classification_rule>
    <race_rule>
      <entry id="human">
        <vision value="20" inclusive="true"/>
        <movement value="5" inclusive="true"/>
      </entry>
    </race_rule>
  </rule_group>
  <people>
    <person name="Billy">
      <race race_rule_ref="human"/>
      <location x="10" y="10"/>
      <properties>
        <property property_rule_ref="health" value="-1" />
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
    const result = classifyPerson(util, query.query("people").query("person"));
    expect(result).toEqual(["dead"]);

  })
})