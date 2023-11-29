import {JsonQuery} from "../../JSONQuery";
import {JsonSchema} from "../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {propertyRefValidator} from "../../validators/propertyRef.validator";

describe("propertyRef.validator", () => {
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
    <property_metadata>
      <entry name="athletics" units="points">
        <default>
          <operation>
            <add_dice value="6"/>
          </operation>
          <operation>
            <add value="-1"/>
          </operation>
        </default>
      </entry>
      </property_metadata>
  </rule_group>
  <any_element property_ref="other_property"/>
  <any_element property_ref="unmapped_property"/>
</world_step>`);

    const result = await propertyRefValidator(query);
    expect(result.map(e => e.message).join("\n")).toBe([
        "ValidationError: other_property at //any_element[0]@property_ref not in [athletics]",
        "ValidationError: unmapped_property at //any_element[1]@property_ref not in [athletics]"
      ].join("\n")
    )
  })
});