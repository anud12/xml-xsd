import {JsonQuery} from "../../JSONQuery";
import {JsonSchema} from "../../utils/JsonSchema";
import {describe} from "@jest/globals";
import {personRefValidator} from "../../validators/personRefValidator";
import {JsonUtil} from "../../utils";

describe("personRef.validator", () => {
  it("should throw 2 validation errors", async () => {
    const query = JsonQuery.fromText<JsonSchema>(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:noNamespaceSchemaLocation="../../../../schema/world_step/world_step.xsd"
>
  <people>
    <person id="definition"/>
  </people>
  <any_element person_ref="other_property"/>
  <any_element person_ref="unmapped_property"/>
</world_step>`);

    const result = await personRefValidator(new JsonUtil(query));
    expect(result.map(e => e.message).join("\n")).toBe([
        "ValidationError: other_property at //any_element[0]@person_ref not in [definition]",
        "ValidationError: unmapped_property at //any_element[1]@person_ref not in [definition]"
      ].join("\n")
    )
  })
});