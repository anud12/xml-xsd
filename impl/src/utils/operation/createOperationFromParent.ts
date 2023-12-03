import {Unit} from "../../middleware/_type";
import {OperationQueryType} from "../JsonSchema";
import {JsonQueryType} from "../../JSONQuery";
import {createOperationFromQueryType} from "./createOperationFromQueryType";

export const createOperationFromParent = (
  readJson: Unit,
  operationList: JsonQueryType<any, { operation: OperationQueryType }>,
  getExternalProperty: (key: string) => string = () => "0"
): (string: string) => string => {
  try {
    const result = operationList.queryAll("operation")
      .flatMap(operation => operation.children).reduce((acc, operation) => {
      const operationValue = createOperationFromQueryType(readJson, operation, getExternalProperty);
      return (value: string) => operationValue(acc((value)));
    }, (value: string) => value);

    return result;
  } catch (e) {
    const newError = new Error(`createOperationFromParent failed for ${operationList.$name}`);
    newError.stack += '\nCaused by: ' + e.stack;
    throw newError;
  }

}