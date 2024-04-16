import {OperationQueryType} from "../JsonSchema";
import {JsonUtil} from "../util";
import {JsonQueryType} from "../../JsonQueryType";


export const createOperationFromQueryType = (
  readJson: JsonUtil,
  operationValue: OperationQueryType["childrenList"][number],
  getExternalProperty: (key: string) => string = () => "0"
): (value: string) => string => {

  const wrapper = (func: (value: string) => string) => (value: string) => {
    if (isNaN(Number(value))) {
      throw new Error(`Operation ${operationValue.tag} with ${(operationValue as any).attributeMap.value} failed with value ${value}`);
    }
    if(!value) {
      return undefined;
    }
    return func(value);
  }

  switch (operationValue.tag) {
    default:
      return (value:string) => {
        throw new Error(`Unknown tag ${(operationValue as JsonQueryType).tag}`);
        return value;
      };
    case "add_property":
      return wrapper(value => {
        const propertyRef = operationValue.attributeMap.property_rule_ref;
        if (propertyRef === undefined) {
          throw new Error(`Operation ${operationValue.getPath()} property is undefined`);
        }
        const newValue = getExternalProperty(propertyRef);
        console.log(`${value} ${operationValue.tag} with ${newValue}`)
        return String(Number(value) + Math.floor(Number(newValue)));
      })
    case "and":
      return wrapper(value => {
        console.log(`${value} ${operationValue.tag} applying ${operationValue.attributeMap.do} with value ${operationValue.attributeMap.value}`)
        switch (operationValue.attributeMap.do) {
          default: throw new Error(`Unknown attribute ${operationValue.attributeMap.do} for ${operationValue.tag} in ${operationValue.getPath()}`);
          case "add": {
            return String(Math.trunc(Number(value) + Number(operationValue.attributeMap.value)))
          }
          case "add_dice": {
            const randomValue = readJson.random() * Number(operationValue.attributeMap.value);
            return String(Math.trunc(Number(value) + Math.floor(randomValue)))
          }
          case "multiply": {
            return String(Math.trunc(Number(value) * Number(operationValue.attributeMap.value)))
          }
          case "multiply_dice": {
            const randomValue = readJson.random() * Number(operationValue.attributeMap.value);
            return String(Math.trunc(Number(value) * Math.floor(randomValue)))
          }
          case "divide": {
            return String(Math.trunc(Number(value) / Number(operationValue.attributeMap.value)))
          }
          case "divide_dice": {
            const randomValue = readJson.random() * Number(operationValue.attributeMap.value);
            return String(Math.trunc(Number(value) / Math.floor(randomValue)))
          }
          case "modulo": {
            return String(Math.trunc(Number(value) % Number(operationValue.attributeMap.value)))
          }
          case "modulo_dice": {
            const randomValue = readJson.random() * Number(operationValue.attributeMap.value);
            return String(Math.trunc(Number(value) % Math.floor(randomValue)))
          }
        }
      })

  }
}
