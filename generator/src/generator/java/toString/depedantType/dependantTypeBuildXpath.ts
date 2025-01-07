import {DependantType} from "../../typeToString";

export const dependantTypeBuildXpath = (dependantType: DependantType): string | undefined => {
  if(!dependantType) {
    return "";
  }
  const name = dependantType.name;

  return dependantTypeBuildXpath(dependantType.parentType) + "/" + name;

}