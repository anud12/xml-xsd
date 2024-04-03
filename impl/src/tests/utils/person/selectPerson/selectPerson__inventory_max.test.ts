import {describe} from "@jest/globals";
import {JsonSchema} from "../../../../utils/JsonSchema";
import {JsonQuery} from "../../../../JSONQuery";
import {JsonUtil} from "../../../../utils/util";
import {selectPerson} from "../../../../utils/person/selectPerson";

it("selectPerson__inventory_max", () => {
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
    <events_rule>
      <entry id="event">
        <then>
          <select_person>
            <inventory>
              <item>
                <max initial="1"/>
              </item>
            </inventory>
          </select_person>
        </then>
      </entry>
    </events_rule>
  </rule_group>
  <people>
    <person id="0">
      <inventory>
      </inventory>
    </person>
    <person id="1">
      <inventory>
         <item/>
      </inventory>
    </person>
    <person id="2">
         <item/>
         <item/>
    </person>
  </people>
</world_step>
`);
  const util: JsonUtil = new JsonUtil(query);
  const result = selectPerson(util, query.query("rule_group")
    .query("events_rule")
    .query("entry")
    .query("then")
    .query("select_person"));
  expect(result.map(v => v.attributeMap.id)).toEqual(["0", "1"]);

})