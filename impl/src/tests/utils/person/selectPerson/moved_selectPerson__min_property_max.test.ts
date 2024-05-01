import {JsonSchema} from "../../../../utils/JsonSchema";
import {JsonQuery} from "../../../../JSONQuery";
import {JsonUtil} from "../../../../utils/util";
import {selectPerson} from "../../../../utils/person/selectPerson";

it("selectPerson__min_property_max", () => {
  // should compute property value for each person with value lesser than max
  const query = JsonQuery.fromText<JsonSchema>(`<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../schema/world_step/world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>
  <rule_group>
  
    <property_rule>
      <entry id="property">
        <person_default initial="0">
          <and do="add" value="10"/>
        </person_default>
      </entry>
    </property_rule>
    <race_rule>
      <entry id="race"/>    
    </race_rule>
    <events_rule>
      <entry id="event">
        <then>
          <select_person>
            <min initial="2"/>
            <property property_rule_ref="property">
              <max initial="0">
                <and do="add_dice" value="5"/>
              </max>
            </property>
          </select_person>
        </then>
      </entry>
    </events_rule>
  </rule_group>
  <people>
  </people>
</world_step>
`);
  const util: JsonUtil = new JsonUtil(query);
  const result = selectPerson(util, query.query("rule_group")
    .query("events_rule")
    .query("entry")
    .query("then")
    .query("select_person"));
  expect(result.map(v => v.serializeRaw())).toEqual([
    "<person id=\"0.0\"><race race_rule_ref=\"race\"/><location x=\"0\" y=\"0\"/><properties><property property_rule_ref=\"property\" value=\"3\"/></properties><inventory/><classifications/></person>\n",
    "<person id=\"0.1\"><race race_rule_ref=\"race\"/><location x=\"0\" y=\"0\"/><properties><property property_rule_ref=\"property\" value=\"1\"/></properties><inventory/><classifications/></person>\n"
  ]);

})