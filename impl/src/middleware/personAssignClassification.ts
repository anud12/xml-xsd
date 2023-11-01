import {Middleware} from "../utils/middleware";
import {classifyPerson} from "../utils/person/classifyPerson";

// for person in people add a classifications
export const personAssignClassification: Middleware = (readJson)  => {
  const personList = readJson.json.queryAll("people").flatMap(e => e.queryAll("person"));
  const classificationListByPersonName = personList.map(person => {
    const classificationList = classifyPerson(readJson, person);
    return {
      name: person.$name,
      classificationList
    }
  })
  return async writeJson => {
    const personList = writeJson.queryAll("people").flatMap(e => e.queryAll("person"));
    classificationListByPersonName.forEach(({name, classificationList}) => {
      const person = personList.find(e => e.$name === name);
      person.children = person.children.filter(e => e.tag !== "classification");
      classificationList.forEach(classification => {
        person.appendChild("classification", {
          $name: classification
        })
      })
    })
  }
}