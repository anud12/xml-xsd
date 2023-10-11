import {InferJsonNodeBody, JsonQueryType} from "../../JSONQuery";
import {OperationQueryType} from "../JsonSchema";
import {Unit} from "../middleware";

type OperationTags = keyof InferJsonNodeBody<OperationQueryType>
type Operation = JsonQueryType<"value", {
  group: JsonQueryType<never, {
    operation: Operation
  }>
}>;

export const computeOperation = (
  readJson: Unit,
  operationArg: OperationQueryType
): (value: string) => string => {
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
        const randomValue = readJson.util.random() * Number(operationValue.$value);
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
        const randomValue = readJson.util.random() * Number(operationValue.$value);
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
        const randomValue = readJson.util.random() * Number(operationValue.$value);
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
        const randomValue = readJson.util.random() * Number(operationValue.$value);
        return String(Number(value) % Math.floor(randomValue))
      }
    case "group" :
      return value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        return operationArg.children.reduce((acc, e) => computeOperation(readJson, e.children[0])(acc), value)
      }
    default:
      return (value) => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        return value
      };
  }
}
