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

    await Promise.all(actionList.map(personCreateElement => {
      const locationSelector = personCreateElement.queryOptional("node_graph__selection")
      if(!locationSelector) {
        return;
      }
      const locationElementList = writeJson.locationGraph.selectNodeGraph(locationSelector);
      const locationElement = writeJson.randomFromArray(locationElementList);
      if(!locationElement) {
        return;
      }

      const personSelectionElement = personCreateElement.queryOptional("person__selection");
      const personElement = writeJson.person.createPerson(personSelectionElement);

      let peopleElement = locationElement.queryOptional("people");
      if(!peopleElement) {
        peopleElement = locationElement.appendChild("people");
      }
      peopleElement.appendChild("person", undefined, {
        person_id_ref: personElement.attributeMap.id
      });
    }));
  }
}