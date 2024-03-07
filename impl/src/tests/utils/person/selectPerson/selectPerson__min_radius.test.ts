import {JsonSchema} from "../../../../utils/JsonSchema";
import {JsonQuery} from "../../../../JSONQuery";
import {JsonUtil} from "../../../../utils/util";
import {selectPerson} from "../../../../utils/person/selectPerson";

it("selectPerson__min_empty", () => {
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
      <entry value="4"/>
      <entry value="5"/>
      <entry value="6"/>
    </randomization_table>
  </world_metadata>
  <rule_group>
    <race_rule>
      <entry id="race"/>    
    </race_rule>
    <events_rule>
      <entry id="event">
        <then>
          <select_person>
            <radius initial="100"/>
            <min initial="2"/>
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
    .query("select_person"), {x:"0", y:"0"});
  expect(result.map(v => v.serializeRaw())).toEqual([
    "<person id=\"0.0\"><location x=\"-16\" y=\"0\"/><race race_rule_ref=\"race\"/><classifications/></person>\n",
    "<person id=\"0.1\"><location x=\"33\" y=\"50\"/><race race_rule_ref=\"race\"/><classifications/></person>\n"
  ]);

})