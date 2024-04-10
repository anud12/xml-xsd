import {MutationMiddleware} from "./_type";
import { classifyPerson } from "../utils/person/classifyPerson";

// for person in people add a classifications
export const personAssignClassification: MutationMiddleware = (readJson) => {
  const personList = readJson.json.queryAll("people").flatMap(e => e.queryAll("person"));
  const classificationListByPersonId = personList.map(person => {
    const classificationList = classifyPerson(readJson, person);
    return {
      id: person.attributeMap.id,
      classificationList
    }
  })
  return async writeJson => {
    const personList = writeJson.json.queryAll("people").flatMap(e => e.queryAll("person"));
    classificationListByPersonId.forEach(({id, classificationList}) => {
      const person = personList.find(e => e.attributeMap.id === id);
      const classifications = person.query("classifications");
      classifications.childrenList = [];
      classificationList.forEach(classification => {
        classifications.appendChild("classification", undefined, {
          classification_rule_ref: classification
        })
      })
    })
  }
}