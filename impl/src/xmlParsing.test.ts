import * as jsdom from "jsdom";
import {
    JsonQueryType,
    newJsonQuery,
    nodeAddChild,
    nodeAddSibling,
    nodeToString,
    nodeType,
    serialize
} from "./JSONQuery";

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
        const dom = new jsdom.JSDOM(file, {
            contentType: "text/xml"
        });
        const query = newJsonQuery<Schema>(dom);

        expect(serialize(dom, query)).toBe(`<world_step
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
        const dom = new jsdom.JSDOM(file, {
            contentType: "application/xhtml+xml"
        });
        const query = newJsonQuery<Schema>(dom);
        let body = query.world_metadata;
        expect(body.next_world_step[nodeToString]).toBe("./world_1");
    })

    test("value of mixed", () => {

        const file = `<?xml version="1.0" standalone="no"?>
<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:noNamespaceSchemaLocation="schema/world_step/world_step.xsd"
>
  <world_metadata>demo<childTag>hidden</childTag></world_metadata>
</world_step>
`

        const dom = new jsdom.JSDOM(file, {
            contentType: "application/xhtml+xml"
        });
        const query = newJsonQuery<Schema>(dom)


        let body = query.world_metadata;
        expect(body[nodeToString]).toBe("demo");
    })

    test("attribute of child", () => {
        const dom = new jsdom.JSDOM(file, {
            contentType: "application/xhtml+xml"
        });
        const query = newJsonQuery<Schema>(dom)
        const navigation = query
            .world_metadata
            .randomization_table
            .entry;
        const body = navigation.$value;
        expect(body).toBe("first");
    })


    test("attribute of child list", () => {
        const dom = new jsdom.JSDOM(file, {
            contentType: "application/xhtml+xml"
        });
        const query = newJsonQuery<Schema>(dom)


        const navigation = query
            .world_metadata
            .randomization_table.entry._all;
        const body = navigation.map(e => e.$value).join(", ");
        expect(body).toBe("first, second");
    })

    test("children", () => {
        const dom = new jsdom.JSDOM(file, {
            contentType: "application/xhtml+xml"
        });
        const query = newJsonQuery<Schema>(dom)
        const navigation = query
            .world_metadata
            .randomization_table
            .getChildren();
        const body = navigation.map(e => e.$value).join(", ");
        expect(body).toBe("first, default_value, second");
    })

    test("serialize", () => {
        const dom = new jsdom.JSDOM(file, {
            contentType: "application/xhtml+xml",
        });
        const query = newJsonQuery<Schema>(dom)
        expect(serialize(dom, query)).toBe(`<world_step
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
        const dom = new jsdom.JSDOM(file, {
            contentType: "application/xhtml+xml"
        });
        const query = newJsonQuery<JsonQueryType<never, {
            other: JsonQueryType
        }>>(dom)
        const body = query.other
        expect(body?.[nodeType]).toBe(undefined);
    })

    test("getTagName", () => {
        const dom = new jsdom.JSDOM(file, {
            contentType: "application/xhtml+xml"
        });
        const query = newJsonQuery<Schema>(dom)
        const element = query.world_metadata
        const tagList = element[nodeType];
        expect(tagList).toBe("world_metadata")
    });

    test("assignPrimitiveBody", () => {
        const dom = new jsdom.JSDOM(file, {
            contentType: "application/xhtml+xml"
        });
        const query = newJsonQuery<Schema>(dom)


        let body = query.world_metadata;
        body.randomization_table[nodeToString] = "helloWorld"
        expect(serialize(dom, query)).toBe(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="schema/world_step/world_step.xsd">
  <world_metadata>
    <next_world_step>./world_1</next_world_step>
    <randomization_table>helloWorld</randomization_table>
  </world_metadata>
</world_step>`);
    })


    test("assignPrimitiveBodyAndAttribute", () => {
        const dom = new jsdom.JSDOM(file, {
            contentType: "application/xhtml+xml"
        });
        const query = newJsonQuery<any>(dom)


        let body = query.world_metadata;
        body.randomization_table = "helloWorld"
        body.randomization_table.$name = "value";
        expect(query._serialize()).toBe(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="schema/world_step/world_step.xsd">
  <world_metadata>
    <next_world_step>./world_1</next_world_step>
    <randomization_table name="value">helloWorld</randomization_table>
  </world_metadata>
</world_step>`);
    })

    test("createElement", () => {
        const dom = new jsdom.JSDOM(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="schema/world_step/world_step.xsd">
  <world_metadata>
    <next_world_step>./world_1</next_world_step>
    <randomization_table name="value">helloWorld</randomization_table>
  </world_metadata>
</world_step>`, {
            contentType: "application/xhtml+xml"
        });

        const query = newJsonQuery<JsonQueryType<any>>(dom);
        query.world_metadata.randomization_table[nodeAddChild]("child", "body", {$name: "value"} as any);

        expect(serialize(dom, query)).toBe(`<world_step
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

    test("createElementToList", () => {
        const dom = new jsdom.JSDOM(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="schema/world_step/world_step.xsd">
  <world_metadata>
    <next_world_step>./world_1</next_world_step>
    <randomization_table name="value">helloWorld</randomization_table>
  <child name="value">body</child></world_metadata>
</world_step>`, {
            contentType: "application/xhtml+xml"
        });
        const query = newJsonQuery<any>(dom);
        query.world_metadata.child = "body";
        query.world_metadata.child[nodeAddSibling]("secondBody", {$name:"value"});
        expect(query._serialize()).toBe(`<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="schema/world_step/world_step.xsd">
  <world_metadata>
    <next_world_step>./world_1</next_world_step>
    <randomization_table name="value">helloWorld</randomization_table>
  <child name="value">body</child><child>secondBody</child></world_metadata>
</world_step>`);
    })
})
