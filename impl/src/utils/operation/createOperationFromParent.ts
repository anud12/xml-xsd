
import {createOperationFromQueryType} from "./createOperationFromQueryType";
import {JsonUtil} from "../util";
import {type__math_operations} from "../../world_step.schema";

export const createOperationFromParent = (
  readJson: JsonUtil,
  operationList: type__math_operations,
  getExternalProperty: (key: string) => string = () => "0"
): string => {
  try {
    if(!operationList) {
      return "0";
    }

    console.log(`createOperationFromParent ${operationList.getPath()}`)
    const result = operationList.childrenList
      .reduce((acc, operation) => {
      const operationValue = createOperationFromQueryType(readJson, operation as any, getExternalProperty);

      return operationValue(acc)
    }, operationList.attributeMap.initial || "0");

    console.log(`createOperationFromParent ${operationList.getPath()} is '${result}'`)
    return result;
  } catch (e:any)  {
    const newError = new Error(`createOperationFromParent failed for ${operationList.getPath()}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }

}