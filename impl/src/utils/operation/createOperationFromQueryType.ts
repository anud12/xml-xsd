import {InferJsonNodeBody, JsonQueryType, nodeBodyType} from "../../JSONQuery";
import {OperationQueryType} from "../JsonSchema";
import {Unit} from "../../middleware/_type";

type OperationTags = keyof InferJsonNodeBody<OperationQueryType>
type Operation = JsonQueryType<"value" | "property_ref", {
  group: JsonQueryType<never, {
    operation: Operation
  }>
}>;

export const createOperationFromQueryType = (
  readJson: Unit,
  operationArg: OperationQueryType,
  getExternalProperty: (key:string) => string = () => "0"
): (value: string) => string => {
  const operationValue: Operation = operationArg as any;

  const wrapper = (func:(value:string) => string) => (value: string) => {
    if(!value || isNaN(Number(value))) {
      throw new Error(`Operation ${operationValue.tag} with ${operationValue.$value} failed with value ${value}`);
    }
    return func(value);
  }

  switch (operationValue.tag as OperationTags) {
    case "add":
      return wrapper(value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        return String(Number(value) + Number(operationValue.$value))
      })
    case "add_dice":
      return wrapper(value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        const randomValue = readJson.util.random() * Number(operationValue.$value);
        return String(Number(value) + Math.floor(randomValue))
      })
    case "multiply":
      return wrapper(value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        return String(Number(value) * Number(operationValue.$value))
      })
    case "multiply_dice":
      return value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        const randomValue = readJson.util.random() * Number(operationValue.$value);
        return String(Number(value) * Math.floor(randomValue))
      }
    case "divide":
      return wrapper(value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        return String(Number(value) / Number(operationValue.$value))
      })
    case "divide_dice":
      return wrapper(value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        const randomValue = readJson.util.random() * Number(operationValue.$value);
        return String(Number(value) / Math.floor(randomValue))
      })
    case "modulo":
      return wrapper(value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        return String(Number(value) % Number(operationValue.$value))
      })
    case "modulo_dice":
      return wrapper(value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        const randomValue = readJson.util.random() * Number(operationValue.$value);
        return String(Number(value) % Math.floor(randomValue))
      })
    case "group" :
      return wrapper(value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.$value}`)
        return operationArg.children.reduce((acc, e) => createOperationFromQueryType(readJson, e.children[0], getExternalProperty)(acc), value)
      })
    case "add_property_value": return wrapper(value => {
      const propertyRef = operationValue.$property_ref;
      if(propertyRef === undefined) {
        throw new Error(`Operation ${operationValue.getPath()} property is undefined`);
      }
      const newValue = getExternalProperty(propertyRef);
      console.log(`${value} ${operationValue.tag} with ${newValue}`)
      return String(Number(value) + Math.floor(Number(newValue)));
    })
    default:
      return () => {
        throw new Error(`Unknown operation ${operationValue.tag}`);
      };
  }
}
