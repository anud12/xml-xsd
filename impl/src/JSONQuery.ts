import * as jsdom from "jsdom";
import {JsonSchema} from "./utils/JsonSchema";

const prettier = require("prettier");

export type JsonNode = {
    body: string
    tag: string
}

export type InferJsonNodeBody<T> = T extends JsonQueryType<infer A, infer B>
    ? { [P in keyof B]: InferJsonNodeBody<B[P]> & JsonNodeAttribute<A> }
    : never;
export type InferJsonNodeAttribute<T> = T extends JsonQueryType<infer A> ? JsonNodeAttribute<A> : never;

export type JsonElement<A extends string> = JsonNode & JsonNodeAttribute<A>

export type JsonNodeAttribute<A extends string> = {
    [P in A as `$${P}`]?: string
}
export const nodeBodyType = Symbol()
export const nodeAttributes = Symbol()
export type JsonQueryType<
    A extends string = string,
    B extends Record<string, JsonQueryType<string, any> | JsonElement<string>> = Record<string, JsonQueryType<string, any>>
> = JsonElement<A>
    & {
    children: Array<B[keyof B]>;
    appendChild: <U extends keyof B>(key: keyof B, element: string | InferJsonNodeAttribute<B[U]>, attributes?: InferJsonNodeAttribute<B[U]>) => void
    query: <P extends keyof B> (p: P) => B[P] | undefined
    queryAll: <P extends keyof B> (p: P) => Array<B[P]>
    serialize: () => string
} & {
    [nodeBodyType]: {
        [P in keyof B]: B[P]
    }
}
    & {
    [nodeAttributes]: {
        [P in A as `$${P}`]?: string
    }
}

const innerSerialize = (dom: jsdom.JSDOM, query: JsonQueryType<any, any>): Element => {
    const rootElement = dom.window.document.createElementNS("", query.tag);
    Object.keys(query).forEach((key) => {
        if (key?.startsWith("$")) {
            const attributeKey = key.replace("$", "").replace(":", "__namespace__");
            rootElement.setAttribute(attributeKey, query[key])
        }
    })
    rootElement.innerHTML += query.body ?? "";
    query.children.forEach(value => {
        rootElement.appendChild(innerSerialize(dom, value));
    })
    return rootElement
}

//@ts-ignore TS2420
export class JsonQuery<A extends JsonQueryType> implements A {
    static fromText = <A>(file: string): A => {
        const root = new jsdom.JSDOM(file, {
            contentType: "text/xml"
        })
        return new JsonQuery(root, root.window.document.querySelector("*")) as unknown as A
    }

    [nodeBodyType]: any;
    [nodeAttributes]: any;

    body: string;
    children: Array<Record<string, JsonQueryType<string, any>>[keyof Record<string, JsonQueryType<string, any>>]>;
    tag: string;

    constructor(private root: jsdom.JSDOM, private element: Element) {
        this.tag = element.tagName;

        const children = [...element.children ?? []].map((e) => {
            const jsonQuery = new JsonQuery(root, e);
            // @ts-ignore
            jsonQuery.children = [...e.children].map(value => new JsonQuery(root, value))
            return jsonQuery;
        });
        this.children = children as any;
        [...element.getAttributeNames()].forEach((currentValue) => {
            this[`$${currentValue}`] = element.getAttribute(currentValue)
        })

        let cloneElement = element.cloneNode(true);
        [...cloneElement.childNodes]
            .filter(e => e.parentElement === cloneElement)
            .filter(e => e.nodeType !== element.TEXT_NODE)
            .map((element: ChildNode) => {
                cloneElement.removeChild(element)
            })
        this.body = cloneElement.textContent.trim();
    }

    appendChild = <U extends string>(key: string, body: string | JsonNodeAttribute<string>, attributesArg?: JsonNodeAttribute<string>): void => {
        let attributes = attributesArg;
        let element = this.root.window.document.createElementNS("", key);

        if (typeof body !== "string") {
            attributes = body;
        } else {
            element.textContent = body;
        }
        Object.entries(attributes).forEach(([key, value]) => {
            element.setAttribute(key.replace("$", ""), value);
        })
        this.children.push(new JsonQuery(this.root, element) as unknown as JsonQueryType);
    }
    query = <P extends string>(p: P): JsonQueryType<string, any> => {
        return this.queryAll(p)?.[0];
    }
    queryAll = <P extends string>(p: P): any[] => {
        return this.children.filter(e => e.tag === p)
    }

    serialize = () => {
        return prettier.format(innerSerialize(this.root, this as unknown as JsonQueryType).outerHTML, {
            parser: "babel"
        }).replaceAll("__namespace__", ":").split(";")[0] + "\n";
    }
}