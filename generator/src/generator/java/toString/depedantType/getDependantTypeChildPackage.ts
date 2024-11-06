import {DependantType} from "../../typeToString";
import {getDependantTypePackage} from "./getDependantTypePackage";
import {normalizeNameClass} from "../normalizeNameClass";

export const getDependantTypeChildPackage = (dependantType:DependantType):string => {
  return `${getDependantTypePackage(dependantType)}.${normalizeNameClass(dependantType.name)}`;
}

