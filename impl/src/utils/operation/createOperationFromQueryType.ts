import {group__operation__and, OperationQueryType} from "../JsonSchema";
import {JsonUtil} from "../util";
import {JsonQueryType} from "../../JsonQueryType";


export const createOperationFromQueryType = (
  readJson: JsonUtil,
  operationValue: group__operation__and,
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
        console.log(`${operationValue.tag}('${value}', '${operationValue.attributeMap.property_rule_ref}')`)
        const newValue = getExternalProperty(propertyRef);
        const result= String(Number(value) + Math.floor(Number(newValue)));
        console.log(`${operationValue.tag}('${value}', '${operationValue.attributeMap.property_rule_ref}') = '${result}', getExternalProperty = ${newValue}`)
        return result;
      })
    case "and":
      return wrapper(value => {
        switch (operationValue.attributeMap.do) {
          default: throw new Error(`Unknown attribute ${operationValue.attributeMap.do} for ${operationValue.tag} in ${operationValue.getPath()}`);
          case "add": {
            const result = String(Math.trunc(Number(value) + Number(operationValue.attributeMap.value)));
            console.log(`${operationValue.attributeMap.do}('${value}', '${operationValue.attributeMap.value}') = ${result}`)
            return result;
          }
          case "add_dice": {
            const randomValue = readJson.random() * Number(operationValue.attributeMap.value);
            const result = String(Math.trunc(Number(value) + Math.floor(randomValue)));
            console.log(`${operationValue.attributeMap.do}('${value}', '${operationValue.attributeMap.value}') = ${result}, randomValue:${randomValue}`)
            return result;
          }
          case "multiply": {
            const result= String(Math.trunc(Number(value) * Number(operationValue.attributeMap.value)))
            console.log(`${operationValue.attributeMap.do}('${value}', '${operationValue.attributeMap.value}') = ${result}`)
            return result;
          }
          case "multiply_dice": {
            const randomValue = readJson.random() * Number(operationValue.attributeMap.value);
            const result= String(Math.trunc(Number(value) * Math.floor(randomValue)))
            console.log(`${operationValue.attributeMap.do}('${value}', '${operationValue.attributeMap.value}') = ${result}, randomValue:${randomValue}`)
            return result;
          }
          case "divide": {
            const result= String(Math.trunc(Number(value) / Number(operationValue.attributeMap.value)))
            console.log(`${operationValue.attributeMap.do}('${value}', '${operationValue.attributeMap.value}') = ${result}`)
            return result;

          }
          case "divide_dice": {
            const randomValue = readJson.random() * Number(operationValue.attributeMap.value);
            const result= String(Math.trunc(Number(value) / Math.floor(randomValue)))
            console.log(`${operationValue.attributeMap.do}('${value}', '${operationValue.attributeMap.value}') = ${result}, randomValue:${randomValue}`)
            return result;
          }
          case "modulo": {
            const result= String(Math.trunc(Number(value) % Number(operationValue.attributeMap.value)))
            console.log(`${operationValue.attributeMap.do}('${value}', '${operationValue.attributeMap.value}') = ${result}`)
            return result;
          }
          case "modulo_dice": {
            const randomValue = readJson.random() * Number(operationValue.attributeMap.value);
            const result= String(Math.trunc(Number(value) % Math.floor(randomValue)))
            console.log(`${operationValue.attributeMap.do}('${value}', '${operationValue.attributeMap.value}') = ${result}, randomValue:${randomValue}`)
            return result;
          }
        }
      })

  }
}
