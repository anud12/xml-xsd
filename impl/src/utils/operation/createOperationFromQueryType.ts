import {OperationQueryType} from "../JsonSchema";
import {JsonUtil} from "../util";
import {JsonQueryType} from "../../JsonQueryType";


export const createOperationFromQueryType = (
  readJson: JsonUtil,
  operationValue: OperationQueryType["childrenList"][number],
  getExternalProperty: (key: string) => string = () => "0"
): (value: string) => string => {
  // const operationValue: Operation = operationArg as any;

  const wrapper = (func: (value: string) => string) => (value: string) => {
    if (!value || isNaN(Number(value))) {
      throw new Error(`Operation ${operationValue.tag} with ${(operationValue as any).attributeMap.value} failed with value ${value}`);
    }
    return func(value);
  }

  switch (operationValue.tag) {
    case "add":
      return wrapper(value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.attributeMap.value}`)
        return String(Number(value) + Number(operationValue.attributeMap.value))
      })
    case "add_dice":
      return wrapper(value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.attributeMap.value}`)
        const randomValue = readJson.random() * Number(operationValue.attributeMap.value);
        return String(Number(value) + Math.floor(randomValue))
      })
    case "multiply":
      return wrapper(value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.attributeMap.value}`)
        return String(Number(value) * Number(operationValue.attributeMap.value))
      })
    case "multiply_dice":
      return value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.attributeMap.value}`)
        const randomValue = readJson.random() * Number(operationValue.attributeMap.value);
        return String(Number(value) * Math.floor(randomValue))
      }
    case "divide":
      return wrapper(value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.attributeMap.value}`)
        return String(Number(value) / Number(operationValue.attributeMap.value))
      })
    case "divide_dice":
      return wrapper(value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.attributeMap.value}`)
        const randomValue = readJson.random() * Number(operationValue.attributeMap.value);
        return String(Number(value) / Math.floor(randomValue))
      })
    case "modulo":
      return wrapper(value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.attributeMap.value}`)
        return String(Number(value) % Number(operationValue.attributeMap.value))
      })
    case "modulo_dice":
      return wrapper(value => {
        console.log(`${value} ${operationValue.tag} with ${operationValue.attributeMap.value}`)
        const randomValue = readJson.random() * Number(operationValue.attributeMap.value);
        return String(Number(value) % Math.floor(randomValue))
      })
    case "group" :
      return wrapper(value => {
        const operation = operationValue as unknown as OperationQueryType;
        console.log(`${value} ${operation.tag}`)
        return operation.childrenList.reduce((acc, e) => createOperationFromQueryType(readJson, e.childrenList[0] as OperationQueryType["childrenList"][number], getExternalProperty)(acc), value)
      })
    case "add_property_value":
      return wrapper(value => {
        const propertyRef = operationValue.attributeMap.property_ref;
        if (propertyRef === undefined) {
          throw new Error(`Operation ${operationValue.getPath()} property is undefined`);
        }
        const newValue = getExternalProperty(propertyRef);
        console.log(`${value} ${operationValue.tag} with ${newValue}`)
        return String(Number(value) + Math.floor(Number(newValue)));
      })
    default:
      return () => {
        throw new Error(`Unknown operation ${(operationValue as JsonQueryType).tag}`);
      };
  }
}
