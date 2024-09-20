
import {JsonUtil} from "../util";
import {JsonQueryType} from "../../JsonQueryType";
import {group__operation__and} from "../../world_step.schema";


export const createOperationFromQueryType = (
  readJson: JsonUtil,
  operationValue: group__operation__and["childrenList"][number],
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
        throw new Error(`Unknown tag ${(andOperationValue as JsonQueryType).tag}`);
        return value;
      };
    case "add_property":
      return wrapper(value => {
        const addPropertyOpeartionValue = operationValue as group__operation__and["children"]["add_property"];
        const propertyRef = addPropertyOpeartionValue.attributeMap.property_rule_ref;
        if (propertyRef === undefined) {
          throw new Error(`Operation ${addPropertyOpeartionValue.getPath()} property is undefined`);
        }
        console.log(`${addPropertyOpeartionValue.tag}('${value}', '${addPropertyOpeartionValue.attributeMap.property_rule_ref}')`)
        const newValue = getExternalProperty(propertyRef);
        const result= String(Number(value) + Math.floor(Number(newValue)));
        console.log(`${addPropertyOpeartionValue.tag}('${value}', '${addPropertyOpeartionValue.attributeMap.property_rule_ref}') = '${result}', getExternalProperty = ${newValue}`)
        return result;
      })
    case "and":
      let andOperationValue = operationValue as group__operation__and["children"]["and"];
      return wrapper(value => {
        switch (andOperationValue.attributeMap.do) {
          default: throw new Error(`Unknown attribute ${andOperationValue.attributeMap.do} for ${andOperationValue.tag} in ${andOperationValue.getPath()}`);
          case "add": {
            const result = String(Math.trunc(Number(value) + Number(andOperationValue.attributeMap.value)));
            console.log(`${andOperationValue.attributeMap.do}('${value}', '${andOperationValue.attributeMap.value}') = ${result}`)
            return result;
          }
          case "add_dice": {
            const randomValue = readJson.random() * Number(andOperationValue.attributeMap.value);
            const result = String(Math.trunc(Number(value) + Math.floor(randomValue)));
            console.log(`${andOperationValue.attributeMap.do}('${value}', '${andOperationValue.attributeMap.value}') = ${result}, randomValue:${randomValue}`)
            return result;
          }
          case "multiply": {
            const result= String(Math.trunc(Number(value) * Number(andOperationValue.attributeMap.value)))
            console.log(`${andOperationValue.attributeMap.do}('${value}', '${andOperationValue.attributeMap.value}') = ${result}`)
            return result;
          }
          case "multiply_dice": {
            const randomValue = readJson.random() * Number(andOperationValue.attributeMap.value);
            const result= String(Math.trunc(Number(value) * Math.floor(randomValue)))
            console.log(`${andOperationValue.attributeMap.do}('${value}', '${andOperationValue.attributeMap.value}') = ${result}, randomValue:${randomValue}`)
            return result;
          }
          case "divide": {
            const result= String(Math.trunc(Number(value) / Number(andOperationValue.attributeMap.value)));
            console.log(`${andOperationValue.attributeMap.do}('${value}', '${andOperationValue.attributeMap.value}') = ${result}`)
            if(result === "Infinity") {
              return "0";
            }
            return result;

          }
          case "divide_dice": {
            const randomValue = readJson.random() * Number(andOperationValue.attributeMap.value);
            const result= String(Math.trunc(Number(value) / Math.floor(randomValue)))
            console.log(`${andOperationValue.attributeMap.do}('${value}', '${andOperationValue.attributeMap.value}') = ${result}, randomValue:${randomValue}`)
            if(result === "Infinity") {
              return "0";
            }
            return result;
          }
          case "modulo": {
            const result= String(Math.trunc(Number(value) % Number(andOperationValue.attributeMap.value)))
            console.log(`${andOperationValue.attributeMap.do}('${value}', '${andOperationValue.attributeMap.value}') = ${result}`)
            return result;
          }
          case "modulo_dice": {
            const randomValue = readJson.random() * Number(andOperationValue.attributeMap.value);
            const result= String(Math.trunc(Number(value) % Math.floor(randomValue)))
            console.log(`${andOperationValue.attributeMap.do}('${value}', '${andOperationValue.attributeMap.value}') = ${result}, randomValue:${randomValue}`)
            return result;
          }
        }
      })

  }
}
