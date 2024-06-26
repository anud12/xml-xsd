import {describe, expect} from "@jest/globals";
import {JsonQuery} from "../../../JSONQuery";
import {JsonSchema} from "../../../utils/JsonSchema";
import {getPersonProperty} from "../../../utils/person/getPersonProperty";
import {JsonUtil} from "../../../utils/util";

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
  <rule_group>
    <property_rule>
      <entry id="constitution" units="points">
        <person_default initial="0">
          <and do="add" value="8" />
        </person_default>
      </entry>
    </property_rule>
    <race_rule>
      <entry id="human">
        <vision value="20" inclusive="true"/>
        <movement value="5" inclusive="true"/>
        <property_bonus property_rule_ref="constitution">
          <operation>
            <and do="add_dice" value="3"/>
            <and do="add" value="-1"/>
          </operation>
        </property_bonus>
        <property_bonus property_rule_ref="health">
          <operation>
            <add_property property_rule_ref="constitution"/>
            <and do="multiply" value="2"/>
          </operation>
        </property_bonus>
      </entry>
    </race_rule>
  </rule_group>
  <people>
    <person name="Billy">
      <race race_rule_ref="human"/>
      <location x="10" y="10"/>
      <properties/>
      <inventory>
        <item ref="Long sword" equipped="hand"/>
      </inventory>
      <command/>
    </person>
  </people>
</world_step>`);

    const util = new JsonUtil(query);
    const value = getPersonProperty(util,
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
  <rule_group>
    <property_rule>
      <entry id="constitution" units="points">
        <person_default initial="0">
          <and do="add" value="8" />
        </person_default>
      </entry>
    </property_rule>
    <race_rule>
      <entry id="human">
        <vision value="20" inclusive="true" />
        <movement value="5" inclusive="true" />
        <property_bonus property_rule_ref="constitution">
          <operation>
            <and do="add_dice" value="3" />
            <and do="add" value="-1" />
          </operation>
        </property_bonus>
        <property_bonus property_rule_ref="health">
          <operation>
            <add_property property_rule_ref="constitution" />
            <and do="multiply" value="2" />
          </operation>
        </property_bonus>
      </entry>
    </race_rule>
  </rule_group>
  <people>
    <person name="Billy">
      <race race_rule_ref="human" />
      <location x="10" y="10" />
      <properties>
        <property property_rule_ref="constitution" value="10" />
        <property property_rule_ref="health" value="20" />
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
    <property_rule>
    </property_rule>
  <race_rule>
      <entry id="human">
          <vision value="20" inclusive="true"/>
          <movement value="5" inclusive="true"/>
      </entry>
  </race_rule>
  <people>
    <person name="Billy">
      <race race_rule_ref="human"/>
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
      const util = new JsonUtil(query);
      getPersonProperty(util,
        query.query("people").query("person"),
        "health"
      );
      throw new Error("")
    } catch (e:any)  {
      expect(e.message).toBe("getProperty of health failed for //people[0]/person[0]\n" +
        "query '//rule_group' returned undefined")
    }
  })
})
