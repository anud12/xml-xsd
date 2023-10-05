import * as jsdom from "jsdom";
import {describe, test} from "@jest/globals";
import {JsonQueryType, newJsonQuery} from "./JSONQuery";

const file = `<?xml version="1.0" standalone="no"?>
<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:noNamespaceSchemaLocation="schema/world_step/world_step.xsd"
>
  <world_metadata>
    <next_world_step>./world_1</next_world_step>
    <randomization_table>
      <entry value="first"/>
      <default value="default_value"/>
      <entry value="second"/>
    </randomization_table>
  </world_metadata>
</world_step>
`

type Schema = JsonQueryType<never, {
  world_metadata: JsonQueryType<never, {
    next_world_step: JsonQueryType,
    randomization_table: JsonQueryType<never, {
      entry: JsonQueryType<"value">,
      default: JsonQueryType<"value", {
        add: JsonQueryType
      }>
    }>
  }>
}>

describe("xml query", () => {

  test("value of child of child", () => {
    const dom = new jsdom.JSDOM(file, {
      contentType: "application/xhtml+xml"
    });
    const query = newJsonQuery<Schema>(dom)
    const body = query
      .world_metadata[0]
      .next_world_step[0];
    expect(body.getBody()).toBe("./world_1");
  })

  test("attribute of child", () => {
    const dom = new jsdom.JSDOM(file, {
      contentType: "application/xhtml+xml"
    });
    const query = newJsonQuery<Schema>(dom)
    const navigation = query
      .world_metadata[0]
      .randomization_table[0]
      .entry[0];
    const body = navigation.getAttribute("value");
    expect(body).toBe("first");
  })


  test("attribute of child list", () => {
    const dom = new jsdom.JSDOM(file, {
      contentType: "application/xhtml+xml"
    });
    const query = newJsonQuery<Schema>(dom)
    const navigation = query
      .world_metadata[0]
      .randomization_table[0]
      .entry;
    const body = navigation.map(e => e.getAttribute("value")).join(", ");
    expect(body).toBe("first, second");
  })

  test("children", () => {
    const dom = new jsdom.JSDOM(file, {
      contentType: "application/xhtml+xml"
    });
    const query = newJsonQuery<Schema>(dom)
    const navigation = query
      .world_metadata[0]
      .randomization_table[0]
      .getChildren();
    const body = navigation.map(e => e.getAttribute("value")).join(", ");
    expect(body).toBe("first, default_value, second");
  })

  test("serialize", () => {
    const dom = new jsdom.JSDOM(file, {
      contentType: "application/xhtml+xml"
    });
    const query = newJsonQuery<Schema>(dom)
    expect(query.serialize()).toBe(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="schema/world_step/world_step.xsd">
  <world_metadata>
    <next_world_step>./world_1</next_world_step>
    <randomization_table>
      <entry value="first"/>
      <default value="default_value"/>
      <entry value="second"/>
    </randomization_table>
  </world_metadata>
</world_step>`)
  })

  test("mutation", () => {
    const dom = new jsdom.JSDOM(file, {
      contentType: "application/xhtml+xml"
    });
    const query = newJsonQuery<Schema>(dom);
    const element = query
      .world_metadata[0]
      .next_world_step[0];

    element.setBody("other")
    expect(query.world_metadata[0].serialize()).toBe(`<world_metadata>
    <next_world_step>other</next_world_step>
    <randomization_table>
      <entry value="first"/>
      <default value="default_value"/>
      <entry value="second"/>
    </randomization_table>
  </world_metadata>`)
  })

  test("set attribute", () => {
    const dom = new jsdom.JSDOM(file, {
      contentType: "application/xhtml+xml"
    });
    const query = newJsonQuery<Schema>(dom)
    query
      .world_metadata[0]
      .next_world_step[0]
      .setAttribute("name" as never, "value");
    expect(query
      .world_metadata[0]
      .next_world_step[0]
      .serialize()
    ).toBe(`<next_world_step name="value">./world_1</next_world_step>`)
  })

  test("invalid child", () => {
    const dom = new jsdom.JSDOM(file, {
      contentType: "application/xhtml+xml"
    });
    const query = newJsonQuery<any>(dom)
    const body = query.other
    expect(body).toStrictEqual([]);
  })

  test("getTagName", () => {
    const dom = new jsdom.JSDOM(file, {
      contentType: "application/xhtml+xml"
    });
    const query = newJsonQuery<Schema>(dom)
    const element = query.world_metadata[0]
    const tagList = element.getTagName();
    expect(tagList).toBe("world_metadata")

  });
})
