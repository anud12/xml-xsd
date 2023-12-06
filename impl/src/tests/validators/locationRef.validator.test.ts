import {JsonQuery} from "../../JSONQuery";
import {JsonSchema} from "../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {raceRefValidator} from "../../validators/raceRef.validator";
import {locationRefValidator} from "../../validators/locationRef.validator";
import {JsonUtil} from "../../utils/util";

describe("locationRef.validator", () => {
  it("should throw 2 validation errors", async () => {
    const query = JsonQuery.fromText<JsonSchema>(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:noNamespaceSchemaLocation="../../../../schema/world_step/world_step.xsd"
>
  <rule_group>
    <locations_markov_chain>
      <location_markov_link type="rule_definition"/>
    </locations_markov_chain>
  </rule_group>
  <rule_group>
    <locations_markov_chain>
      <location_markov_link type="second_rule_definition"/>
    </locations_markov_chain>
  </rule_group>
  <any_element location_ref="other_property"/>
  <any_element location_ref="unmapped_property"/>
</world_step>`);

    const result = await locationRefValidator(new JsonUtil(query));
    expect(result.map(e => e.message).join("\n")).toBe([
        "ValidationError: other_property at //any_element[0]@location_ref not in [rule_definition, second_rule_definition]",
        "ValidationError: unmapped_property at //any_element[1]@location_ref not in [rule_definition, second_rule_definition]"
      ].join("\n")
    )
  })
});