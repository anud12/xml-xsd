import {Middleware, Unit} from "../utils/middleware";
import {OperationQueryType} from "../utils/JsonSchema";
import {InferJsonNodeBody, JsonQueryType} from "../JSONQuery";
import {read} from "fs";

type OperationTags = keyof InferJsonNodeBody<OperationQueryType>
type Operation = JsonQueryType<"value", {
  group: JsonQueryType<never, {
    operation: Operation
  }>
}>;

const operation = (readJson: Unit, operationArg: OperationQueryType): (value: string) => string => {
  const operationValue: Operation = operationArg as any;
  switch (operationValue.tag as OperationTags) {
    case "add":
      return value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        return String(Number(value) + Number(operationValue.$value))
      }
    case "add_dice":
      return value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        const randomValue = readJson.util.random() * Number(operationValue.$value.replace("d", ""));
        return String(Number(value) + Math.floor(randomValue))
      }
    case "multiply":
      return value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        return String(Number(value) * Number(operationValue.$value))
      }
    case "multiply_dice":
      return value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        const randomValue = readJson.util.random() * Number(operationValue.$value.replace("d", ""));
        return String(Number(value) * Math.floor(randomValue))
      }
    case "divide":
      return value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        return String(Number(value) / Number(operationValue.$value))
      }
    case "divide_dice":
      return value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        const randomValue = readJson.util.random() * Number(operationValue.$value.replace("d", ""));
        return String(Number(value) / Math.floor(randomValue))
      }
    case "modulo":
      return value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        return String(Number(value) % Number(operationValue.$value))
      }
    case "modulo_dice":
      return value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        const randomValue = readJson.util.random() * Number(operationValue.$value.replace("d", ""));
        return String(Number(value) % Math.floor(randomValue))
      }
    case "group" :
      return value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        return operationArg.children.reduce((acc, e) => operation(readJson, e.children[0])(acc), value)
      }
    default:
      return (value) => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        return value
      };
  }
}

export const personAction: Middleware = readJson => async writeJson => {
  const actionMetadata = readJson.json.queryAll("action_metadata")
    .flatMap(e => e.queryAll("person_entry"));

  const personList = readJson.json.queryAll("people").flatMap(e => e.queryAll("person"));

  readJson.json.queryAll("action").flatMap(e => e.queryAll("person_action"))
    .map(personAction => {
      const action = actionMetadata.find(e => e.$name === personAction.$ref);

      const mutations = action.queryAll("property_mutation")
      const result = mutations.flatMap(e => e.queryAll("operation"))
        .flatMap(e => e.children)
        .map(e => operation(readJson, e))
        .reduce((e, op) => op(e), "0")
      console.log("result", result);
      const person = personList.find(e => e.$name === personAction.$name);
      const targetPerson = personList.find(e => e.$name === personAction.$target_name);
    })
}