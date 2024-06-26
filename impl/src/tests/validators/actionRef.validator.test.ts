import {JsonQuery} from "../../JSONQuery";
import {JsonSchema} from "../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {JsonUtil} from "../../utils/util";
import {actionRefValidator} from "../../validators/actionRef.validator";

describe("actionRef.validator", () => {
  it("should throw 2 validation errors", async () => {
    const query = JsonQuery.fromText<JsonSchema>(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:noNamespaceSchemaLocation="../../../../schema/world_step/world_step.xsd"
>
  <rule_group>
    <action_rule>
      <global>
        <entry id="rule_definition"/>
      </global>
    </action_rule>
  </rule_group>
  <rule_group>
    <action_rule>
      <global>
        <entry id="second_rule_definition"/>
      </global>
    </action_rule>
  </rule_group>
  <any_element action_ref="other_property"/>
  <any_element action_ref="unmapped_property"/>
</world_step>`);

    const result = await actionRefValidator(new JsonUtil(query));
    expect(result.map(e => e.message).join("\n")).toBe([
        "ValidationError: other_property at //any_element[0]@action_ref not in [rule_definition, second_rule_definition]",
        "ValidationError: unmapped_property at //any_element[1]@action_ref not in [rule_definition, second_rule_definition]"
      ].join("\n")
    )
  })
});