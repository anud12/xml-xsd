import {DependantType} from "../../typeToString";
import {normalizeNameClass} from "../normalizeNameClass";

export const basePackage = "ro.anud.xml_xsd.implementation.model";

export const getDependantTypePackage = (dependantType:DependantType):string => {
  let subNamespaces: string[] = [];
  let parentType = dependantType.parentType;
  while (parentType) {
    subNamespaces.push(normalizeNameClass(parentType.name))
    parentType = parentType.parentType;
  }
  subNamespaces.reverse()

  return `${basePackage}${subNamespaces.map(e => `.${e}`).join("")}.${normalizeNameClass(dependantType.name)}`;
}

