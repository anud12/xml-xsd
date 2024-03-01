import {describe} from "@jest/globals";
import {JsonSchema} from "../../../../utils/JsonSchema";
import {JsonQuery} from "../../../../JSONQuery";
import {JsonUtil} from "../../../../utils/util";
import {selectPerson} from "../../../../utils/person/selectPerson";

describe("selectPerson_classificationEmpty", () => {
  it("return all persons when classification rules are set", () => {
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
    <classification_rule>
      <entry id="classification">
        <property property_rule_ref="property" is="equal">
          <operation initial="0"/>
        </property>
      </entry>
    </classification_rule>
    <events_rule>
      <entry id="event">
        <then>
          <at origin="self">
            <radius>
              <operation initial="10"/>
            </radius>
          </at>
          <select_person>
            <classification classification_rule_ref="classification"/>
          </select_person>
        </then>
      </entry>
    </events_rule>
  </rule_group>
  <people>
    <person id="0">
      <properties>
        <property property_rule_ref="property" value="0"/>
      </properties>
    </person>
    <person id="1">
      <properties>
        <property property_rule_ref="property" value="1"/>
      </properties>
    </person>
    <person id="2">
      <properties>
        <property property_rule_ref="property" value="2"/>
      </properties>
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
    expect(result.map(v => v.attributeMap.id)).toEqual(["0"]);

  })
})