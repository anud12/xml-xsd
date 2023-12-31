import {Middleware} from "./_type";
import { classifyPerson } from "../utils/person/classifyPerson";

// for person in people add a classifications
export const personAssignClassification: Middleware = (readJson) => {
  const personList = readJson.json.queryAll("people").flatMap(e => e.queryAll("person"));
  const classificationListByPersonName = personList.map(person => {
    const classificationList = classifyPerson(readJson, person);
    return {
      name: person.attributeMap.name,
      classificationList
    }
  })
  return async writeJson => {
    const personList = writeJson.json.queryAll("people").flatMap(e => e.queryAll("person"));
    classificationListByPersonName.forEach(({name, classificationList}) => {
      const person = personList.find(e => e.attributeMap.name === name);
      const classifications = person.query("classifications");
      classifications.childrenList = [];
      classificationList.forEach(classification => {
        classifications.appendChild("classification", {
          $classification_ref: classification
        })
      })
    })
  }
}