import {JsonQuery} from "../../JSONQuery";
import {JsonSchema} from "../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {JsonUtil} from "../../utils/util";
import {nameRuleRefValidator} from "../../validators/nameRuleRef.validator";

describe("locationRef.validator", () => {
  it("should throw 2 validation errors", async () => {
    const query = JsonQuery.fromText<JsonSchema>(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:noNamespaceSchemaLocation="../../../../schema/world_step/world_step.xsd"
>
  <rule_group>
    <name_rule>
      <entry id="rule_definition"/>
    </name_rule>
  </rule_group>
  <rule_group>
    <name_rule>
      <entry id="second_rule_definition"/>
    </name_rule>
  </rule_group>
  <any_element name_rule_ref="other_property"/>
  <any_element name_rule_ref="unmapped_property"/>
</world_step>`);

    const result = await nameRuleRefValidator(new JsonUtil(query));
    expect(result.map(e => e.message).join("\n")).toBe([
        "ValidationError: other_property at //any_element[0]@name_ref not in [rule_definition, second_rule_definition]",
        "ValidationError: unmapped_property at //any_element[1]@name_ref not in [rule_definition, second_rule_definition]"
      ].join("\n")
    )
  })
});