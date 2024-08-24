import {JsonQuery} from "../../JSONQuery";
import {JsonSchema} from "../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {raceRefValidator} from "../../validators/raceRef.validator";
import {classificationRuleRefValidator} from "../../validators/classificationRuleRef.validator";
import {JsonUtil} from "../../utils/util";
import {locationClassificationRuleRefValidator} from "../../validators/locationClassificationRuleRefValidator";

describe("classificationRef.validator", () => {
  it("should throw 2 validation errors", async () => {
    const query = JsonQuery.fromText<JsonSchema>(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:noNamespaceSchemaLocation="../../../../schema/world_step/world_step.xsd"
>
  <rule_group>
    <location_classification_rule>
      <entry id="rule_definition"/>
    </location_classification_rule>
  </rule_group>
  <rule_group>
    <location_classification_rule>
      <entry id="second_rule_definition"/>
    </location_classification_rule>
  </rule_group>
  <any_element location_classification_rule="other_property"/>
  <any_element location_classification_rule="unmapped_property"/>
</world_step>`);

    const result = await locationClassificationRuleRefValidator(new JsonUtil(query));
    expect(result.map(e => e.message).join("\n")).toBe([
        "ValidationError: other_property at //any_element[0]@location_classification_rule not in [rule_definition, second_rule_definition]",
        "ValidationError: unmapped_property at //any_element[1]@location_classification_rule not in [rule_definition, second_rule_definition]"
      ].join("\n")
    )
  })
});