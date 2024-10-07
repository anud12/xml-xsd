import {MutationMiddleware} from "./_type";
import { classifyPerson } from "../utils/person/classifyPerson";

// for person in people add a classifications
export const personAssignClassification: MutationMiddleware = (readJson) => {
  const personList = readJson.json.queryOptional("data").queryAllOptional("people").flatMap(e => e.queryAllOptional("person"));
  const classificationListByPersonId = personList.map(person => {
    const classificationList = classifyPerson(readJson, person);
    return {
      id: person.attributeMap.id,
      classificationList
    }
  })
  return async writeJson => {
    const personList = writeJson.json.queryOptional("data").queryAllOptional("people").flatMap(e => e.queryAllOptional("person"));
    classificationListByPersonId.forEach(({id, classificationList}) => {
      const person = personList.find(e => e.attributeMap.id === id);
      let classifications = person.queryOptional("classifications");
      if(!classifications) {
        classifications = person.appendChild("classifications");
      }
      classifications.childrenList = [] as unknown as any;
      classificationList.forEach(classification => {
        classifications.appendChild("classification", undefined, {
          classification_rule_ref: classification
        })
      })
    })
  }
}