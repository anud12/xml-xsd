import {DependantType} from "../typeToString";

export const dependantTypeGetFullQualifiedName = (dependantType:DependantType) => {

  let subNamespaces: string[] = [];
  let parentType = dependantType.parentType;
  while (parentType) {
    subNamespaces.push(parentType.name)
    parentType = parentType.parentType;
  }
  subNamespaces.reverse()

  if(dependantType.type === "element" || dependantType.type === "composition" || dependantType.type ==="union") {
    return `XSD${subNamespaces.map(e => `.N${e}`).join("")}.${dependantType.name}`
  }

  return dependantType.name;

}