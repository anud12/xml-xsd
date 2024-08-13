import {MutationMiddleware} from "../_type";

export const personCreateAction: MutationMiddleware = readJson => {
  const actionList = readJson.json.queryAllOptional("actions")
    .flatMap(actionsElement => actionsElement.queryAllOptional("person.create"))
  return async (writeJson) => {
    if(actionList.length === 0) {
      return
    }
    writeJson.json.queryAllOptional("actions")
      .flatMap(actionsElement => actionsElement.queryAllOptional("person.create"))
      .flatMap(personCreateElement => personCreateElement.removeFromParent());

    await Promise.all(actionList.map(personCreateElement => writeJson.person.createPerson(personCreateElement)));
  }
}