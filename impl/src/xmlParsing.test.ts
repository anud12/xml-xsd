import * as jsdom from "jsdom";
import {describe, test} from "@jest/globals";
import {JSONQuery, JsonQueryType} from "./JSONQuery";

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
    next_world_step: string,
    randomization_table: JsonQueryType<never, {
      entry: JsonQueryType<"value">,
      default: JsonQueryType<"value", {
        add: string
      }>
    }>
  }>
}>

describe("xml query", () => {

  test("invalid child", () => {
    const dom = new jsdom.JSDOM(file, {
      contentType: "application/xhtml+xml"
    });
    const query = new JSONQuery(dom) as Schema
    const body = query
      .query("other" as any)
    expect(body).toBe(undefined);
  })

  test("value of child of child", () => {
    const dom = new jsdom.JSDOM(file, {
      contentType: "application/xhtml+xml"
    });
    const query = new JSONQuery(dom) as Schema
    const body = query
      .query("world_metadata")
      .query("next_world_step");
    expect(body.getBody()).toBe("./world_1");
  })

  test("attribute of child", () => {
    const dom = new jsdom.JSDOM(file, {
      contentType: "application/xhtml+xml"
    });
    const query = new JSONQuery(dom) as Schema
    const navigation = query
      .query("world_metadata")
      .query("randomization_table")
      .query("entry");
    const body = navigation.getAttribute("value");
    expect(body).toBe("first");
  })


  test("attribute of child list", () => {
    const dom = new jsdom.JSDOM(file, {
      contentType: "application/xhtml+xml"
    });
    const query = new JSONQuery(dom) as Schema
    const navigation = query
      .query("world_metadata")
      .query("randomization_table")
      .queryAll("entry");
    const body = navigation.map(e => e.getAttribute("value")).join(", ");
    expect(body).toBe("first, second");
  })

  test("children", () => {
    const dom = new jsdom.JSDOM(file, {
      contentType: "application/xhtml+xml"
    });
    const query = new JSONQuery(dom) as Schema
    const navigation = query
      .query("world_metadata")
      .query("randomization_table")
      .children();
    const body = navigation.map(e => e.getAttribute("value")).join(", ");
    expect(body).toBe("first, default_value, second");
  })

  test("serialize", () => {
    const dom = new jsdom.JSDOM(file, {
      contentType: "application/xhtml+xml"
    });
    const query = new JSONQuery(dom) as Schema;
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
    const query = new JSONQuery(dom) as Schema;
    const element = query.query("world_metadata")
      .query("next_world_step");
    element.setBody("other")
    expect(query.query("world_metadata").serialize()).toBe(`<world_metadata>
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
    const query = new JSONQuery(dom) as Schema;
    query.query("world_metadata").query("next_world_step").setAttribute("name", "value");
    expect(query.query("world_metadata").query("next_world_step").serialize()).toBe(`<next_world_step name="value">./world_1</next_world_step>`)
  })
})
