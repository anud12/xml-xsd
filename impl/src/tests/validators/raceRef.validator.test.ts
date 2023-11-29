import {JsonQuery} from "../../JSONQuery";
import {JsonSchema} from "../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {raceRefValidator} from "../../validators/raceRef.validator";

describe("raceReference.validator", () => {
  it("should throw 2 validation errors", async () => {
    const query = JsonQuery.fromText<JsonSchema>(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:noNamespaceSchemaLocation="../../../../schema/world_step/world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group>
    <race_metadata>
      <entry name="race_definition">
        <vision value="1"/>
      </entry>
    </race_metadata>
  </rule_group>
  <any_element race_ref="other_property"/>
  <any_element race_ref="unmapped_property"/>
</world_step>`);

    const result = await raceRefValidator(query);
    expect(result.map(e => e.message).join("\n")).toBe([
        "ValidationError: other_property at //any_element[0]@race_ref not in [race_definition]",
        "ValidationError: unmapped_property at //any_element[1]@race_ref not in [race_definition]"
      ].join("\n")
    )
  })
});