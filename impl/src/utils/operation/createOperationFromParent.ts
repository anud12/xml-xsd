import {OperationQueryType} from "../JsonSchema";
import {createOperationFromQueryType} from "./createOperationFromQueryType";
import {JsonUtil} from "../util";
import {JsonQueryType} from "../../JsonQueryType";

export const createOperationFromParent = (
  readJson: JsonUtil,
  operationList: JsonQueryType<any, { operation: OperationQueryType }>,
  getExternalProperty: (key: string) => string = () => "0"
): (string: string) => string => {
  try {
    if(!operationList) {
      return (value: string) => value;
    }
    const result = operationList.queryAll("operation")
      .flatMap(operation => operation.childrenList)
      .reduce((acc, operation) => {
      const operationValue = createOperationFromQueryType(readJson, operation, getExternalProperty);
      return (value: string) => operationValue(acc((value)));
    }, (value: string) => value);

    return result;
  } catch (e:any)  {
    const newError = new Error(`createOperationFromParent failed for ${operationList?.getAttribute("name")}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }

}