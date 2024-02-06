import {OperationQueryType} from "../JsonSchema";
import {createOperationFromQueryType} from "./createOperationFromQueryType";
import {JsonUtil} from "../util";
import {JsonQueryType} from "../../JsonQueryType";

export const createOperationFromParent = (
  readJson: JsonUtil,
  operationList: OperationQueryType,
  getExternalProperty: (key: string) => string = () => "0"
): string => {
  try {
    if(!operationList) {
      return "0";
    }


    const result = operationList.childrenList
      .flatMap(operation => operation.childrenList)
      .reduce((acc, operation) => {
      const operationValue = createOperationFromQueryType(readJson, operation, getExternalProperty);
      return (value: string) => operationValue(acc((value)));
    }, (value: string) => value);

    return result(operationList.attributeMap.initial || "0");
  } catch (e:any)  {
    const newError = new Error(`createOperationFromParent failed for ${operationList.getPath()}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }

}