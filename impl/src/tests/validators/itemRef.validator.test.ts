import {JsonQuery} from "../../JSONQuery";
import {JsonSchema} from "../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {itemRefValidator} from "../../validators/itemRef.validator";
import {JsonUtil} from "../../utils/util";

describe("raceRef.validator", () => {
  it("should throw 2 validation errors", async () => {
    const query = JsonQuery.fromText<JsonSchema>(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:noNamespaceSchemaLocation="../../../../schema/world_step/world_step.xsd"
>
  <rule_group>
    <item_metadata>
      <entry name="rule_definition"/>
    </item_metadata>
  </rule_group>
  <rule_group>
    <item_metadata>
      <entry name="second_rule_definition"/>
    </item_metadata>
  </rule_group>
  <any_element item_ref="other_property"/>
  <any_element item_ref="unmapped_property"/>
</world_step>`);

    const result = await itemRefValidator(new JsonUtil(query));
    expect(result.map(e => e.message).join("\n")).toBe([
        "ValidationError: other_property at //any_element[0]@item_ref not in [rule_definition, second_rule_definition]",
        "ValidationError: unmapped_property at //any_element[1]@item_ref not in [rule_definition, second_rule_definition]"
      ].join("\n")
    )
  })
});