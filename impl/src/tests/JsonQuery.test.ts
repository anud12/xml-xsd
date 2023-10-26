import * as jsdom from "jsdom";
import {
  JsonQuery,
  JsonQueryType,
} from "../JSONQuery";

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
      default: JsonQueryType<"value">
    }>
  }>
}>

describe("xml query", () => {

  test("should parse", () => {
    const query = JsonQuery.fromText<Schema>(file);
    expect(query.serialize()).toBe(`<world_step
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:noNamespaceSchemaLocation="schema/world_step/world_step.xsd"
>
  <world_metadata>
    <next_world_step>./world_1</next_world_step>
    <randomization_table>
      <entry value="first" />
      <default value="default_value" />
      <entry value="second" />
    </randomization_table>
  </world_metadata>
</world_step>
`);

  })
  test("value of child of child", () => {
    const query = JsonQuery.fromText<Schema>(file);
    let body = query.query("world_metadata");
    expect(body.query("next_world_step").body).toBe("./world_1");
  })

  test("value of mixed", () => {

    const file = `<?xml version="1.0" standalone="no"?>
<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:noNamespaceSchemaLocation="schema/world_step/world_step.xsd"
>
  <world_metadata>demo<childTag>hidden</childTag></world_metadata>
</world_step>
`
    const query = JsonQuery.fromText<Schema>(file);
    let body = query.query("world_metadata");
    expect(body.body).toBe("demo");
  })

  test("attribute of child", () => {
    const query = JsonQuery.fromText<Schema>(file);
    const navigation = query
      .query("world_metadata")
      .query("randomization_table")
      .query("entry");
    const body = navigation.$value;
    expect(body).toBe("first");
  })


  test("attribute of child list", () => {
    const query = JsonQuery.fromText<Schema>(file);

    const navigation = query
      .query("world_metadata")
      .query("randomization_table")
      .queryAll("entry");
    const body = navigation.map(e => e.$value).join(", ");
    expect(body).toBe("first, second");
  })

  test("children", () => {
    const query = JsonQuery.fromText<Schema>(file);
    const navigation = query
      .query("world_metadata")
      .query("randomization_table")
      .children;
    const body = navigation.map(e => e.$value).join(", ");
    expect(body).toBe("first, default_value, second");
  })

  test("serialize", () => {
    const query = JsonQuery.fromText<Schema>(file);
    expect(query.serialize()).toBe(`<world_step
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:noNamespaceSchemaLocation="schema/world_step/world_step.xsd"
>
  <world_metadata>
    <next_world_step>./world_1</next_world_step>
    <randomization_table>
      <entry value="first" />
      <default value="default_value" />
      <entry value="second" />
    </randomization_table>
  </world_metadata>
</world_step>
`)
  })

  test("invalid child", () => {
    try {
      const dom = new jsdom.JSDOM(file, {
        contentType: "application/xhtml+xml"
      });
      const query = JsonQuery.fromText<JsonQueryType<never, any>>(file);
      const body = query.query("world_metadata").query("other")
      throw "Should throw";
    }
    catch (e:any) {
      expect(e.message).toBe("query from '//world_metadata[0]/other' returned undefined");
    }

  })

  test("getTagName", () => {
    const query = JsonQuery.fromText<Schema>(file);
    const element = query.query("world_metadata")
    const tagList = element.tag;
    expect(tagList).toBe("world_metadata")
  });

  test("assignPrimitiveBody", () => {
    const query = JsonQuery.fromText<Schema>(file);

    let body = query.query("world_metadata");
    body.query("randomization_table").body = "helloWorld"
    expect(query.serialize()).toBe(`<world_step
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:noNamespaceSchemaLocation="schema/world_step/world_step.xsd"
>
  <world_metadata>
    <next_world_step>./world_1</next_world_step>
    <randomization_table>
      helloWorld
      <entry value="first" />
      <default value="default_value" />
      <entry value="second" />
    </randomization_table>
  </world_metadata>
</world_step>
`);
  })


  test("assignPrimitiveBodyAndAttribute", () => {
    const query = JsonQuery.fromText<any>(file);


    let body = query.query("world_metadata");
    body.query("randomization_table").body = "helloWorld"
    body.query("randomization_table").$name = "value";
    expect(query.serialize()).toBe(`<world_step
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:noNamespaceSchemaLocation="schema/world_step/world_step.xsd"
>
  <world_metadata>
    <next_world_step>./world_1</next_world_step>
    <randomization_table name="value">
      helloWorld
      <entry value="first" />
      <default value="default_value" />
      <entry value="second" />
    </randomization_table>
  </world_metadata>
</world_step>
`);
  })

  test("createElement", () => {
    const query = JsonQuery.fromText<any>(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="schema/world_step/world_step.xsd">
  <world_metadata>
    <next_world_step>./world_1</next_world_step>
    <randomization_table name="value">helloWorld</randomization_table>
  </world_metadata>
</world_step>`);
    query.query("world_metadata").query("randomization_table").appendChild("child", "body", {$name: "value"} as any);

    expect(query.serialize()).toBe(`<world_step
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:noNamespaceSchemaLocation="schema/world_step/world_step.xsd"
>
  <world_metadata>
    <next_world_step>./world_1</next_world_step>
    <randomization_table name="value">
      helloWorld<child name="value">body</child>
    </randomization_table>
  </world_metadata>
</world_step>
`);
  })


  test("should preserve comments", () => {
    const query = JsonQuery.fromText<any>(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="schema/world_step/world_step.xsd">
  <world_metadata>
    <next_world_step>./world_1</next_world_step>
    <!-- Should be preserved -->
    <randomization_table name="value"/>
  </world_metadata>
</world_step>`);
    expect(query.serialize()).toBe(`<world_step
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:noNamespaceSchemaLocation="schema/world_step/world_step.xsd"
>
  <world_metadata>
    <next_world_step>./world_1</next_world_step>
    <!-- Should be preserved -->
    <randomization_table name="value" />
  </world_metadata>
</world_step>
`);
  })
})
