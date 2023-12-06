import {JsonQuery} from "../../JSONQuery";
import {JsonSchema} from "../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {raceRefValidator} from "../../validators/raceRef.validator";
import {actionRefValidator} from "../../validators/actionRef.validator";
import {JsonUtil} from "../../utils/util";

describe("actionRef.validator", () => {
  it("should throw 2 validation errors", async () => {
    const query = JsonQuery.fromText<JsonSchema>(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:noNamespaceSchemaLocation="../../../../schema/world_step/world_step.xsd"
>
  <rule_group>
    <action_metadata>
      <person_to_person name="rule_definition">
      </person_to_person>
    </action_metadata>
  </rule_group>
  <rule_group>
    <action_metadata>
      <person_to_person name="second_rule_definition"/>
    </action_metadata>
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