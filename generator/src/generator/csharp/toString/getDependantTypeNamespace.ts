import {DependantType} from "../typeToString";
import {normalizeName} from "./normalizeName";

export const getDependantTypeNamespace = (dependantType:DependantType):string => {
  let subNamespaces: string[] = [];
  let parentType = dependantType.parentType;
  while (parentType) {
    subNamespaces.push(parentType.name)
    parentType = parentType.parentType;
  }
  subNamespaces.reverse()

  return `XSD${subNamespaces.map(e => `.N${normalizeName(e)}`).join("")}`;
}

