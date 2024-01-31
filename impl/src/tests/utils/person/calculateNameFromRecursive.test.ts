import {describe} from "@jest/globals";
import {JsonQuery} from "../../../JSONQuery";
import {JsonSchema} from "../../../utils/JsonSchema";
import {JsonUtil} from "../../../utils/util";
import {calculateNameFromRefString} from "../../../utils/calculateName";

describe("calculateName from ref", () => {
  it("return token prefix value", () => {
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
    <name_rule>
      <entry id="name_metadata">
        <name_token prefix="bob">
          <one_of>
            <name_token prefix=" one of ">
              <one_of>
                <name_token prefix=" second of ">
                  <ref name_rule_ref="name_metadata_ref"/>
                </name_token>
              </one_of>
            </name_token>
          </one_of>
        </name_token>
      </entry>
      <entry id="name_metadata_ref">
        <ref prefix="ref"/>
      </entry>
    </name_rule>
  </rule_group>
</world_step>
`);
    const util: JsonUtil = new JsonUtil(query);
    const result = calculateNameFromRefString(util, "name_metadata");
    expect(result).toEqual("bob one of  second of ref");

  })
})