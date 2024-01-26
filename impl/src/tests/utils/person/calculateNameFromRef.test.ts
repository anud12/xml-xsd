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
    <name_metadata>
      <entry name="name_metadata">
        <name_token prefix="bob">
          <ref name_ref="name_metadata_ref"/>
        </name_token>
      </entry>
      <entry name="name_metadata_ref">
        <ref prefix="ref"/>
      </entry>
    </name_metadata>
  </rule_group>
</world_step>
`);
    const util: JsonUtil = new JsonUtil(query);
    const result = calculateNameFromRefString(util, "name_metadata");
    expect(result).toEqual("bobref");

  })
})