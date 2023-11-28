import {JsonQuery} from "../../JSONQuery";
import {JsonSchema} from "../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {raceValidator} from "../../validators/race.validator";

describe("raceReference.validator", () => {
  it("should fail when race race_ref attribute value does not have race_definition", async () => {
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
  <people>
    <person name="person">
      <race race_ref="human"/>
      <location x="0" y="0"/>
    </person>
    <person name="person">
      <race race_ref="elf"/>
      <location x="0" y="0"/>
    </person>
  </people>
</world_step>`);

    const result = await raceValidator(query);
    expect(result.map(e => e.message).join("\n")).toBe([
        "ValidationError: human at //people[0]/person[0]/race[0]@race_ref not in [race_definition]",
        "ValidationError: elf at //people[0]/person[1]/race[0]@race_ref not in [race_definition]"
      ].join("\n")
    )
  })
});