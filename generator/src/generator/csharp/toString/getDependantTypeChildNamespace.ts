import {DependantType} from "../typeToString";
import {getDependantTypeNamespace} from "./getDependantTypeNamespace";

export const getDependantTypeChildNamespace = (dependantType:DependantType):string => {
  return `${getDependantTypeNamespace(dependantType)}.N${dependantType.name}`;
}

