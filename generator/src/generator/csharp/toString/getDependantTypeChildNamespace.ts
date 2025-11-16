import {DependantType} from "../typeToString";
import {getDependantTypeNamespace} from "./getDependantTypeNamespace";
import {normalizeName} from "./normalizeName";

export const getDependantTypeChildNamespace = (dependantType:DependantType):string => {
  return `${getDependantTypeNamespace(dependantType)}.N${normalizeName(dependantType.name)}`;
}

